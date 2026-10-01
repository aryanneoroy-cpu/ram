public class Ram {
    private final byte[] memory;

    public Ram(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("RAM capacity can not be negative");

        }
        this.memory = new byte[capacity];

    }
    public byte read(int addr){
        validateAddress(addr);
        return memory[addr];

    }
    public void write(int addr, byte value){
        validateAddress(addr);
        memory[addr] = value;
    }
    private void validateAddress(int addr){
        if (addr < 0 || addr >= memory.length){
            throw new IndexOutOfBoundsException(
                    String.format("Segmentation fault: Address %d is out of bounds for RAM size %d", addr, memory.length)

            );
        }
    }
    public static void main(String[] args){
        Ram ram = new Ram(10);
        ram.write(0, (byte) 7);
        System.out.println(ram.read(0));
    }

}