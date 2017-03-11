package Commands;
/**
 * Paquete command, clase commandParser
 * @author User
 *
 */
public class CommandParser {
	
	private final static Command[] commands = {new Help(), new Quit(), new Reset(), new Replace(),
			   new Run(), new AddByteCodeProgram()};
	
	/**
	 * Parsea los comandos
	 */
	public static Command parse(String line){
		line = line.trim();
		String []words = line.split(" +");
		boolean found = false;
		int i = 0;
		Command c =null;
		while(i < commands.length && !found){
			c = commands[i].parse(words);
			if (c != null) found = true;
			else i++;
		}
		return c;
	}
	/**
	 * Muestra la ayudaa asociada al conjunto de comandos
	 */
	public static void ShowHelp(){
		for(int i = 0; i < commands.length; i++){
			System.out.println(CommandParser.commands[i].textHelp());
		}
	}
}


