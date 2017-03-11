package Bytecode;
import CPU.CPU;

/**
 * Clase bytecode paquete bytecode
 * clase abstracta
 * @author User
 *
 */

abstract public class ByteCode {
	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[] words);
}
