package excepciones;

public class ArchivoInexistente extends RuntimeException {
    public ArchivoInexistente(String mensaje){
        super(mensaje);
    }
}
