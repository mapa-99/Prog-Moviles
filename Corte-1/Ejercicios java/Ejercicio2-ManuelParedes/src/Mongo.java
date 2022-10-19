public class Mongo extends BDatos {

  public void conectar() {
    System.out.println("La base de datos MONGO está conectada...");
  }

  public void insertar() {
    System.out.println("La base de datos MONGO Se actualizó...");
  }

  public void consultar() {
    System.out.println("Info de la base de datos MONGO...");
  }

  public void eliminar() {
    System.out.println(
      "Un elemento se ha eliminado de la base de datos MONGO..."
    );
  }
}
