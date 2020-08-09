package co.edu.umb.guiatalleruno.negocio.servicios;

import co.edu.umb.guiatalleruno.modelo.Usuario;
import co.edu.umb.guiatalleruno.modelo.UsuarioDao;
import co.edu.umb.guiatalleruno.negocio.excepciones.GuiaUnoException;

import java.util.ArrayList;

public class UsuarioServicio {

    public boolean validarLogin(Usuario usuario) throws GuiaUnoException {
        ArrayList<Usuario> lista = new UsuarioDao().leer();
        for (Usuario usuarioActual : lista) { // 3
            if (usuarioActual.getNombre().equals(usuario.getNombre())
                    && usuarioActual.getContrasena().equals(usuario.getContrasena()))
                return true;
        }
        return false;
    }

}
