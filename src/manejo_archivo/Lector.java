package manejo_archivo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.JSONArray;
import excepciones.ArchivoInexistente;

public class Lector {
    /**
     * Lee un archivo y lo convierte en un JSONArray
     * 
     * @param rutaArchivo ruta del archivo a leer
     * @return JSONArray con los datos del archivo
     * @throws IOException si no se puede leer el archivo
     */
    public JSONArray leer(String rutaArchivo) throws IOException {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            Path ruta = Paths.get(rutaArchivo);
            String cadena = Files.readString(ruta);
            JSONArray arregloPersonasJSN = new JSONArray(cadena);
            return arregloPersonasJSN;
        } else {
            throw new ArchivoInexistente("El archivo con nombre: " + rutaArchivo + " no existe");
        }

    }
}
