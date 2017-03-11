package Commands;

import Main.Engine;

/**
 * Paquete commands, clase AddByteCodeProgram
 * @author User
 *
 */

public class AddByteCodeProgram extends Command{

	/**
	 * Clase abstracta que hereda de command
	 * utiliza metodos abstractos
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.readByteCodeProgram();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 1 || !s[0].equalsIgnoreCase("BYTECODE")) return null;
		else return new AddByteCodeProgram();
	}

	@Override
	public String textHelp() {
		return "  BYTECODE: Permite introducir  un programa " +
				System.getProperty("line separator");
	}
	
	public String toString(){
		return "BYTECODE";
	}
}
