package avanis.carga.masiva.helper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.osgi.service.component.annotations.Component;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component(immediate=true, service= CargaMasivaHelper.class)
public class CargaMasivaHelper {
    private static final Log _log = LogFactoryUtil.getLog(CargaMasivaHelper.class);

    public List<String[]> leerCSV(File archivo) throws IOException {
        List<String[]> data;

        try (Reader reader = new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withCSVParser(new CSVParserBuilder().withSeparator(';').build()) // Configurar separador correcto
                     .build()) {

            data = csvReader.readAll();

        } catch (CsvException e) {
            _log.error("Error al leer el archivo CSV: " + e.getMessage(), e);
            data = List.of();
        }

        return data;
    }

    public void verificarEncoding(File archivo) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivo))) {
            byte[] buffer = new byte[4096];
            bis.read(buffer);
        }
    }

    public File convertirAUTF8(File archivo) throws IOException {
        File archivoUTF8 = new File(archivo.getAbsolutePath() + "_utf8.csv");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "ISO-8859-1"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoUTF8), StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }
        }

        return archivoUTF8;
    }
}
