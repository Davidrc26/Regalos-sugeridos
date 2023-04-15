package control;

import org.json.JSONArray;
import org.json.JSONObject;

import interfaces.IFabricado;
import modelos.Proveedor;

public class FabricaProveedores implements IFabricado<Proveedor> {

    @Override
    public Proveedor[] crearArray(JSONArray objetosJSON) {
        Proveedor[] proveedores = new Proveedor[objetosJSON.length()];
        for (int i = 0; i < objetosJSON.length(); i++) {
            if (!objetosJSON.get(i).equals(null)) {
                JSONObject proveedorJson = objetosJSON.getJSONObject(i);
                proveedores[i] = crearObjeto(proveedorJson);
            }

        }
        return proveedores;
    }

    @Override
    public Proveedor crearObjeto(JSONObject objetoJSON) {
        String nombre = objetoJSON.getString("nombre");
        double precioEnvio = objetoJSON.getDouble("precioEnvio");
        return new Proveedor(nombre, precioEnvio);
    }

}
