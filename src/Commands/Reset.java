package Commands;

import Main.Engine;

/**
 * Paquete commands clase reset
 * @author User
 *
 */
public class Reset extends Command{

	/**
	 * Resetea el programa
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.resetProgram();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 1 || !s[0].equalsIgnoreCase("RESET")) return null;
		else return new Reset();
	}

	@Override
	public String textHelp() {
		return "  RESET : Vacia el programa actual  ";
	}
	
	public String toString(){
		return "RESET";
	}
}
