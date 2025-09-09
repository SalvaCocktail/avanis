package avanis.listener.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

public class ExifSanitizerUtilTest {

    private ExifSanitizerUtil sanitizer;

    @Before
    public void setUp() {
        sanitizer = new ExifSanitizerUtil();
    }

    @Test
    public void testCleanRemovesGpsMetadata() throws Exception {
        File inputFile = new File("src/test/resources/test_exif_gps.jpg");
        Assert.assertTrue("La imagen de prueba no existe: " + inputFile.getAbsolutePath(), inputFile.exists());

        byte[] originalBytes = Files.readAllBytes(inputFile.toPath());

        byte[] cleanedBytes = sanitizer.clean(originalBytes, inputFile.getName());

        File outputFile = new File(
                "/Users/noemizarco/IdeaProjects/avanis-liferay/modules/avanis-listener/src/test/resources/sanitized_output.jpg"
        );
        Files.write(outputFile.toPath(), cleanedBytes);
        System.out.println("🧼 Imagen limpiada guardada en: " + outputFile.getAbsolutePath());

        // Verificar que no tiene metadatos GPS
        ProcessBuilder pb = new ProcessBuilder("exiftool", outputFile.getAbsolutePath());
        pb.redirectErrorStream(true);
        Process process = pb.start();

        boolean gpsFound = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("gps latitude") || line.toLowerCase().contains("gps longitude")) {
                    gpsFound = true;
                    System.out.println("❌ Metadata GPS encontrada: " + line);
                }
            }
        }

        int exitCode = process.waitFor();
        Assert.assertEquals("Exiftool falló al ejecutarse", 0, exitCode);

        Assert.assertFalse("❌ La imagen aún contiene metadatos GPS", gpsFound);
        System.out.println("✅ Imagen limpiada correctamente sin metadatos GPS");
    }
}
