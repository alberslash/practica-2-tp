package Commands;

import Main.Engine;

/**
 * Clase run paquete command
 * @author User
 *
 */
public class Run extends Command{
	/**
	 * Ejecuta el bytecode akmacenado
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.executeCommandRun();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 1 || !s[0].equalsIgnoreCase("RUN")) return null;
		else return new Run();
	}

	@Override
	public String textHelp() {
		return "  RUN : Ejecuta las instrucciones ByteCode almacenadas  ";
	}
	
	public String toString(){
		return "RUN ";
	}
}
