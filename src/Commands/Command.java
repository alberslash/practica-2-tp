package Commands;

import Main.Engine;

/**
 * Paquete command clase command
 * @author User
 *
 */
abstract public class Command {
		
	/**
	 * clase abstracta
	 * Llama a los metodos abstractos de la clase addbytecodeprogram
	 * 
	 */
	abstract public boolean execute(Engine engine);	
	abstract public Command parse(String [] s);	
	abstract public String textHelp();
	
}
	
