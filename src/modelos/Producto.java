package modelos;


public class Producto {
    private String nombre;
    private int edadRecomendada;
    private double precioBase;
    private Proveedor proveedor;

    public Producto(String nombre, int edadRecomendada, double precioBase, Proveedor proveedor) {
        this.nombre = nombre;
        this.edadRecomendada = edadRecomendada;
        this.precioBase = precioBase;
        this.proveedor = proveedor;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }
    public String getNombreProveedor() {
        return this.proveedor.getNombre();
    }

    public double getPrecioEnvio(){
        return this.proveedor.getPrecioEnvio();
    }

    public double getPrecioTotal() {
        return this.proveedor.getPrecioEnvio()+ this.precioBase;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}
