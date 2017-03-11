package Commands;

import Main.Engine;

/**
 * Clase quit, paquete command
 * @author User
 *
 */
public class Quit extends Command{

	/**
	 * Cierra la aplicacion
	 */
	
	@Override
	public boolean execute(Engine engine) {
		return engine.endExecution();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 1 || !s[0].equalsIgnoreCase("QUIT")) return null;
		else return new Quit();
	}

	@Override
	public String textHelp() {
		return "  QUIT : Cierra la aplicacion  ";
	}
	
	public String toString(){
		return "QUIT";
	}
}
