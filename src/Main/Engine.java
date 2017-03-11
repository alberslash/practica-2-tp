package Main;
import java.util.Scanner;
import Commands.Command;
import Commands.CommandParser;
import Bytecode.ByteCodeParser;
import Bytecode.ByteCode;
import CPU.CPU;

/**
 * Paquete MAIN, clase Engine
 */
public class Engine {
	
  private ByteCodeProgram program;
  private boolean end;
  private static Scanner in = new Scanner(System.in);
  private CPU cpu;
  /** 
   * Constructoras
   */
  public Engine(){
    this.program =new ByteCodeProgram();
    this.cpu = new CPU(this.program);
    this.end =false;  
  }
  
  /**
   * La funcion start inicia la maquina virtual, comprueba
   * los bytecode introducidos por el usuario. 
   */
  public void start(){ 
    this.end=false;
    while(!end){
	    String line = " ";
		Command comando = null;
		System.out.print("> ");
		line = in.nextLine();
		comando = CommandParser.parse(line);
		if(!(comando == null)){
			System.out.println("Comienza la ejecución de " + comando );
			if (!comando.execute(this))	System.out.println("Error: Ejecucion incorrecta del comando");
			if (program.getNumberOfByteCode() != 0){
				System.out.println("Programa almacenado: " + System.getProperty("line.separator") + this.program);
			}
		}
		else System.out.println("Comando incorrecto");
    }
	System.out.println("Fin de la ejecucion....");
	in.close();
  }
/**
 * accede a la clase run para ejecutarlo
 */
  public boolean executeCommandRun(){
	 return cpu.run();
	}
  
  /**
   * Fin de la ejecucion, cuando
   * el usuario introduce end se finalizan los bytecodes
   */
  public boolean endExecution(){ 
	  return this.end=true;
	  }
  
  /**
   * @param bc le entra un bytecode
   * @return end, devuelve si la instruccion es correcto
   */
  public boolean addByteCodeInstruction(ByteCode bc){ //Se puede quitar
	  System.out.println("Programa almacenado: ");
	  program.addBCInstruction(bc);
	  System.out.println(program.toString()) ;
	return end;
	}
 
  /**
   * Resetea el programa
   * @return
   */
  public boolean resetProgram(){ 
	  cpu.inicializa();
	  program.reset();
	return true;
	}
  /**
   * Ayuda de la aplicacion, informa de cada comando.
   */
  public boolean showHelp(){ 
	  CommandParser.ShowHelp();
      return true;

  }
  /**
   * remplaza  la instruccion que le entra por parametro por la
   * nueva instruccion que introduce el usuario
   */
  public boolean replaceByteCode(int replace){
	  System.out.print("Nueva instruccion: ");
	  String s1 = in.nextLine();
	  ByteCode instr = null;
	  instr = ByteCodeParser.parse(s1); 
	  if (instr!=null && replace < program.getNumberOfByteCode()) {
		  program.replace(replace, instr);
		  return true;
	  }
	  else return false;
	}

  /**
   * Comprueba las instrucciones que el usuario ha metido una a una y cuando
   * es end finaliza de leerlas
   */
  public boolean readByteCodeProgram(){
	 // program.reset();
	  System.out.println("Introduce un bytecode, una instruccion por linea");  
	  String line= in.nextLine();
	  boolean fin= true;
	  while(!line.equalsIgnoreCase("END")&& fin){
		 ByteCode bc = ByteCodeParser.parse(line);
		 if(bc==null) System.out.println("Instruccion Bytecode incorrecta");
		 else fin= program.addBCInstruction(bc);
		 line= in.nextLine();
	  }
	 if(!fin)  program.reset();
	 if(line.equalsIgnoreCase("END")) fin = true;
	  
	 return fin; 
}

}
  
