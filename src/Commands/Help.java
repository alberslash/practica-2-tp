package Commands;

import Main.Engine;
/**
 * Clase help paquete main
 * @author User
 *
 */

public class Help extends Command{
	
	/**
	 * Clase help, muestra la ayuda de los comandos
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.showHelp();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 1 || !s[0].equalsIgnoreCase("HELP")) return null;
		else return new Help();
	}

	@Override
	public String textHelp() {
		return "  HELP: Muestra la ayuda  ";
	}
	
	public String toString(){
		return "HELP";
	}
}
