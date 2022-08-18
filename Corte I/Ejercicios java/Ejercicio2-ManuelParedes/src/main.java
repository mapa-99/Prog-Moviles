import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		String op = "";
		do {
			op = JOptionPane.showInputDialog(
					"Bienvenido, Menú de inicio\n 1. Conectar Base de Datos\n 2. Consultar Base de Datos\n 3. Insertar valor en Base de Datos\n 4. Eliminar valor en Base de Datos");

			if (op.equals("1")) {
				JOptionPane.showMessageDialog(null, "Hola.");
			} else if (op.equals("2")) {
				JOptionPane.showMessageDialog(null, "Como estas?.");
			} else if (op.equals("3")) {
				JOptionPane.showMessageDialog(null, "Adios.");
			} else if (op.equals("4")) {
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
			}
		} while (!op.equals("d"));
	}

}
