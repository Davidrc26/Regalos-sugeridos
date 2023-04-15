package control;

import org.json.JSONArray;
import org.json.JSONObject;

import interfaces.IFabricado;
import modelos.Producto;
import modelos.Proveedor;

public class FabricaProductos implements IFabricado<Producto> {

    @Override
    public Producto[] crearArray(JSONArray objetosJSON) {
        Producto productos[] = new Producto[objetosJSON.length()];
        for (int i = 0; i < objetosJSON.length(); i++) {
            if (!objetosJSON.get(i).equals(null)) {
                JSONObject objetoJson = objetosJSON.getJSONObject(i);
                productos[i] = crearObjeto(objetoJson);
            }
        }
        return productos;
    }

    @Override
    public Producto crearObjeto(JSONObject objetoJSON) {
        // ArchivadorProveedorJSON archivador = new ArchivadorProveedorJSON();
        // Proveedor proveedor=
        // archivador.consultarPorNombre(objetoJSON.getString("proveedor"));
        return new Producto(objetoJSON.getString("nombre"),
                objetoJSON.getInt("edad"),
                objetoJSON.getDouble("precio"),
                new Proveedor(objetoJSON.getString("proveedor"), 0));
    }

}
