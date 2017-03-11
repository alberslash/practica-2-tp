package Commands;

import Main.Engine;

/**
 * clase replace paquete command
 * @author User
 *
 */
public class Replace extends Command{

	/**
	 * Reemplaza las instrucciones bytecode
	 */
	public Replace() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int param;
	public Replace(int parseInt) {
		this.param = parseInt;
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.replaceByteCode(this.param);
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 2 || !s[0].equalsIgnoreCase("REPLACE")) return null;
		else return new Replace(Integer.parseInt(s[1]));
	}

	@Override
	public String textHelp() {
		return "  REPLACE : Remplaza el Bytecode numero N por otra instruccion ByteCode  ";
	}
	
	public String toString(){
		return "REPLACE";
	}
}
