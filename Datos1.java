import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Datos1 {

    public static void main(String[] args) {
        //Ruta del archivo
        String rutaArchivo = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\codigos_postales_hmo.csv";

        // Estructura de datos para almacenar: CP es la cantidad de asentamientos
        Map<String, Integer> contadorAsentamientos = new HashMap<>();

        // 1. Leer el archivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // 2. Separar por coma
                String[] datos = linea.split(",");

                // Asegurarse de que hay al menos 2 columnas: asentamiento y código postal
                if (datos.length >= 2) {
                    String asentamiento = datos[1].trim();
                    String codigoPostal = datos[0].trim();

                    // 3. Contar asentamientos por código postal
                    contadorAsentamientos.put(
                        codigoPostal,
                        contadorAsentamientos.getOrDefault(codigoPostal, 0) + 1
                    );
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        // 4. Mostrar resultados
        for (Map.Entry<String, Integer> entrada : contadorAsentamientos.entrySet()) {
            System.out.println("Código postal: " + entrada.getKey() +
                               " - Número de asentamientos: " + entrada.getValue());
        }

        //tiempo (3 horas)
        //La verdad me tomo algo de tiempo encontrar como hacerle para acomodar los datos del asentamiento y cp
        //pero al final me sirvió un poco algunos tutoriales y proyectos de semestres pasados y
        //aprendí a usar el HashMap y el Map que nunca habia usado
    }
    }