package co.edu.umb.guiatalleruno.negocio.constantes;

public enum EMensajes {

    // Construccion de una constante enumerada. (Definiendo las constantes)
    ERROR_LOGIN(-1, "No es posible autenticar su usuario en este momento, intente mas tarde"),
    AUTENTICADO(1, "Has ingresado a la plataforma, bienvenido"),
    NO_AUTENTICADO(-1,"Su usuario no se encuentra en la lista de autorizadas, no puede entrar a la aplicación");

    private int codigo;
    private String mensaje;

    private EMensajes(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
