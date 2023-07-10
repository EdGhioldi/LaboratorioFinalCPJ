package pelicula.datos;

import domain.Pelicula;
import excepciones.*;
import java.util.List;
public interface AccesoDatos {
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
     void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscribirDatosEx;
    String buscar(String nombreRecurso, String buscar)throws LecturaDatosEx;
    void crear(String nombreRecurso) throws AccesoDatosEx;
    void borrar(String nommbreRecurso) throws AccesoDatosEx;

}
