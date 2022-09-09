public class main {

  public static void main(String[] args) {
    Mongo miBaseMongo = new Mongo();
    Postgres miBasePostgres = new Postgres();
    Oracle miBaseOracle = new Oracle();

    miBaseMongo.conectar();
    miBaseMongo.consultar();
    miBaseMongo.insertar();
    miBaseMongo.eliminar();
    System.out.println("<--------------------------->");
    miBasePostgres.conectar();
    miBasePostgres.consultar();
    miBasePostgres.insertar();
    miBasePostgres.eliminar();
    System.out.println("<--------------------------->");
    miBaseOracle.conectar();
    miBaseOracle.consultar();
    miBaseOracle.insertar();
    miBaseOracle.eliminar();
    System.out.println("<--------------------------->");
  }
}
