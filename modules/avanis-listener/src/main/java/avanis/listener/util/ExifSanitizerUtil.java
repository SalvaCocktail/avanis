package avanis.listener.util;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppHelperLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.store.DLStoreRequest;
import com.liferay.document.library.kernel.store.DLStoreUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PropsUtil;
import org.osgi.service.component.annotations.Component;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

@Component(
        immediate = true,
        service = ExifSanitizerUtil.class
)
public class ExifSanitizerUtil {

    private static final Log _log = LogFactoryUtil.getLog(ExifSanitizerUtil.class);

    public void sanitizeExif(DLFileEntry fileEntry) {
        _log.info("[ExifSanitizer] Procesando archivo: " + fileEntry.getFileName());

        try (InputStream originalStream = DLFileEntryLocalServiceUtil.getFileAsStream(
                fileEntry.getFileEntryId(), fileEntry.getVersion(), false)) {

            byte[] originalBytes = originalStream.readAllBytes();

            byte[] cleanImageBytes = clean(originalBytes, fileEntry.getFileName());

            DLStoreRequest dlStoreRequest = DLStoreRequest.builder(
                    fileEntry.getCompanyId(),
                    fileEntry.getRepositoryId(),
                    fileEntry.getName()
            ).build();

            DLStoreUtil.updateFile(dlStoreRequest, new ByteArrayInputStream(cleanImageBytes));

            // Forzamos una nueva versión (update con incremento menor)
            ServiceContext serviceContext = new ServiceContext();
            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(true);

            DLFileEntryLocalServiceUtil.updateFileEntry(
                    fileEntry.getUserId(),
                    fileEntry.getFileEntryId(),
                    fileEntry.getFileName(),
                    fileEntry.getMimeType(),
                    fileEntry.getTitle(),
                    fileEntry.getTitle(),
                    fileEntry.getDescription(),
                    "EXIF sanitized",
                    DLVersionNumberIncrease.MINOR,
                    fileEntry.getFileEntryTypeId(),
                    null,
                    null,
                    new ByteArrayInputStream(cleanImageBytes),
                    cleanImageBytes.length,
                    null,
                    null,
                    serviceContext
            );

            DLFileEntry updatedFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntry.getFileEntryId());
            FileEntry fileEntryGeneric = DLAppLocalServiceUtil.getFileEntry(fileEntry.getFileEntryId());
            FileVersion latestVersion = fileEntryGeneric.getFileVersion();

            DLAppHelperLocalServiceUtil.updateAsset(
                    fileEntryGeneric.getUserId(),
                    fileEntryGeneric,
                    latestVersion,
                    serviceContext
            );

        } catch (Exception e) {
            _log.error("[ExifSanitizer] Error durante la sanitización del archivo: " + fileEntry.getFileName(), e);
        }
    }

    byte[] clean(byte[] originalBytes, String fileName) throws Exception {
        String formatName = getFormatName(fileName);
        if (formatName == null) {
            throw new Exception("Formato no soportado para el archivo: " + fileName);
        }

        if (formatName.equals("jpg")) {
            return removeExifViaExifTool(originalBytes);
        } else {
            return recodeImage(new ByteArrayInputStream(originalBytes), formatName);
        }
    }

    private byte[] removeExifViaExifTool(byte[] imageBytes) throws Exception {
        File input = File.createTempFile("exif_input", ".jpg");

        try (FileOutputStream fos = new FileOutputStream(input)) {
            fos.write(imageBytes);
        }

        String exiftoolPath = PropsUtil.get("exiftool.path");

        if (exiftoolPath == null || exiftoolPath.isEmpty()) {
            exiftoolPath = "exiftool";
        }

        ProcessBuilder pb = new ProcessBuilder(
                exiftoolPath, "-overwrite_original_in_place", "-all=", input.getAbsolutePath()
        );

        pb.redirectErrorStream(true);
        Process process = pb.start();

        StringBuilder outputLog = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                outputLog.append(line).append("\n");
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("[ExifSanitizer] Error ejecutando exiftool. Código de salida: " + exitCode + "\nSalida:\n" + outputLog);
        }

        _log.info("[ExifSanitizer] ExifTool completado correctamente.");

        return java.nio.file.Files.readAllBytes(input.toPath());
    }

    private byte[] recodeImage(InputStream input, String formatName) throws Exception {
        _log.info("[ExifSanitizer] Reprocesando imagen no-JPEG: " + formatName);

        BufferedImage bufferedImage = ImageIO.read(input);
        if (bufferedImage == null) {
            throw new Exception("No se pudo leer la imagen de tipo: " + formatName);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(formatName);

        if (!writers.hasNext()) {
            throw new IllegalStateException("No se encontró ImageWriter para el formato: " + formatName);
        }

        ImageWriter writer = writers.next();
        ImageWriteParam param = writer.getDefaultWriteParam();

        if (param.canWriteCompressed()) {
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.9f);
        }

        try (ImageOutputStream ios = ImageIO.createImageOutputStream(outputStream)) {
            writer.setOutput(ios);
            writer.write(null, new IIOImage(bufferedImage, null, null), param);
        } finally {
            writer.dispose();
        }

        _log.info("[ExifSanitizer] Imagen " + formatName + " reprocesada.");
        return outputStream.toByteArray();
    }

    private String getFormatName(String fileName) {
        String lower = fileName.toLowerCase();

        if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) return "jpg";
        if (lower.endsWith(".png")) return "png";
        if (lower.endsWith(".bmp")) return "bmp";
        if (lower.endsWith(".gif")) return "gif";

        return null;
    }

    public boolean isImage(String fileName) {
        return getFormatName(fileName) != null;
    }

}
