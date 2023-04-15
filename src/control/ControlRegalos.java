package control;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import excepciones.ProductosNoEncontrados;
import interfaces.IFabricado;
import manejo_archivo.Lector;
import modelos.Producto;
import modelos.Proveedor;

public class ControlRegalos {
    private final String ARCHIVO_PRODUCTO = "src/data/productos.json";
    private final String ARCHIVO_PROVEEDOR = "src/data/proveedores.json";
    private Lector lector;
    private ArrayList<Producto> regalos;

    public ControlRegalos(Lector lector) {
        this.lector = lector;
        this.regalos = new ArrayList<>();
    }
    /**
     * Busca los productos que se pueden regalar a una persona de una edad dada y que no superen el precio maximo
     * @param edad edad de la persona a la que se le va a regalar
     * @param precioMaximo precio maximo que se puede pagar por el regalo
     * @return ArrayList con los productos que cumplen con los requisitos
     * @throws ProductosNoEncontrados si no se encuentran productos que cumplan con los requisitos
     * @throws IOException si no se puede leer el archivo
     */
    public ArrayList<Producto> buscarInformacion(int edad, double precioMaximo)
            throws ProductosNoEncontrados, IOException {
        ArrayList<Producto> respuesta = new ArrayList<>();
        this.obtenerDatos(edad);
        for (Producto producto : regalos) {
            if (producto.getPrecioTotal() < precioMaximo) {
                respuesta.add(producto);
            }
        }
        if (respuesta.size() == 0) {
            throw new ProductosNoEncontrados("No se tienen productos para esa edad o precio");
        }
        return respuesta;

    }

    /**
     * Obtiene los datos de los archivos y los convierte en objetos
     * @param edad edad de la persona a la que se le va a regalar
     * @throws IOException si no se puede leer el archivo
     */
    private void obtenerDatos(int edad) throws IOException {
        JSONArray proveedoresJSON = this.lector.leer(ARCHIVO_PROVEEDOR);
        JSONArray productosJSON = this.lector.leer(ARCHIVO_PRODUCTO);
        this.construirObjetos(productosJSON, proveedoresJSON, edad);
    }


    /**
     * Construye los objetos de los productos y proveedores y los asocia
     * @param productos objeto json con los productos
     * @param proveedores objeto json con los proveedores
     * @param edad edad de la persona a la que se le va a regalar
     */
    private void construirObjetos(JSONArray productos, JSONArray proveedores, int edad) {
        IFabricado<Producto> fabProducto = new FabricaProductos();
        IFabricado<Proveedor> fabProveedor = new FabricaProveedores();
        Producto[] pdctos = fabProducto.crearArray(productos);
        Proveedor[] aprovisionadores = fabProveedor.crearArray(proveedores);

        for (Producto producto : pdctos) {
            if (producto.getEdadRecomendada() == edad) {
                this.asociar(producto, aprovisionadores);
                this.regalos.add(producto);
            }

        }
    }


    /**
     * Asocia un producto con su proveedor
     * @param producto producto a asociar
     * @param proveedores arreglo de proveedores
     */
    private void asociar(Producto producto, Proveedor[] proveedores) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getNombre().equals(producto.getNombreProveedor())) {
                producto.setProveedor(proveedor);
            }
        }
    }

    /**
     * Muestra los productos que cumplen con los requisitos
     * @param regalos ArrayList con los productos que cumplen con los requisitos
     * @return String con los productos que cumplen con los requisitos
     */
    public String mostrar(ArrayList<Producto> regalos) {
        String cadena = "Regalos recomendados: \n";
        for (Producto producto : regalos) {
            cadena += producto.getNombre() + " - precio base: $" + producto.getPrecioBase() + " - precio envio: $"
                    + producto.getPrecioEnvio() + " - precio total: $" + producto.getPrecioTotal() + "\n";
        }
        return cadena;
    }

    
}
