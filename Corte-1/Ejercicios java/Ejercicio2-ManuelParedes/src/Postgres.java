public class Postgres extends BDatos {

  public void conectar() {
    System.out.println("La base de datos POSTGRES está conectada...");
  }

  public void insertar() {
    System.out.println("La base de datos POSTGRES Se actualizó...");
  }

  public void consultar() {
    System.out.println("Info de la base de datos POSTGRES...");
  }

  public void eliminar() {
    System.out.println(
      "Un elemento se ha eliminado de la base de datos POSTGRES..."
    );
  }
}
