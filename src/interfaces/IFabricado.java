package interfaces;

import org.json.JSONArray;
import org.json.JSONObject;

public interface IFabricado<E> {
    /**
     * Crea un array de objetos de tipo E a partir de un JSONArray
     * @param objetosJSON JSONArray de objetos JSON
     * @return Array de objetos de tipo E
     */
    public E[] crearArray(JSONArray objetosJSON);


    /**
     * Crea un objeto de tipo E a partir de un JSONObject
     * @param objetoJSON Objeto JSON
     * @return Objeto de tipo E
     */
    public E crearObjeto(JSONObject objetoJSON);
    
}
