package co.edu.umb.guiatalleruno.negocio.excepciones;

import co.edu.umb.guiatalleruno.negocio.constantes.EMensajes;

public class GuiaUnoException extends Exception{

    private int codigo;
    private String descripcion;

    public GuiaUnoException(EMensajes mensaje){
        this.codigo = mensaje.getCodigo();
        this.descripcion = mensaje.getMensaje();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
