import java.util.ArrayList;
import java.util.Scanner;
import control.ControlRegalos;
import manejo_archivo.Lector;
import modelos.Producto;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese la edad:");
        int edad = lector.nextInt();
        System.out.println("Ingrese el valor maximo para el regalo:");
        double precioMaximo = lector.nextDouble();

        ControlRegalos control = new ControlRegalos(new Lector());
        try {
            ArrayList<Producto> respuesta = control.buscarInformacion(edad, precioMaximo);
            System.out.println(control.mostrar(respuesta));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lector.close();
        }

    }
}
