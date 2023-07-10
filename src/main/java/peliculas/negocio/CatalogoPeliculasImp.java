package peliculas.negocio;

import domain.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;
import pelicula.datos.AccesoDatos;
import pelicula.datos.AccesoDatosImp;

public class CatalogoPeliculasImp implements CatalogoPeliculas{

    private final AccesoDatos datos;

    public CatalogoPeliculasImp(){
        this.datos = new AccesoDatosImp();
    }
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar  = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de Acceso de Datos");
            ex.printStackTrace(System.out);
        }
    }
    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(var pelicula: peliculas){
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado = null;
        try{
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        }catch(AccesoDatosEx ex){
            System.out.println("Error de Acceso de Datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado = " + resultado);
    }
    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de Acceso de Datos");
            ex.printStackTrace(System.out);
        }
    }
}
