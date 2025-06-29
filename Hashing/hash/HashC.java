package hash;

public class HashC {	//REPRESENTA LA TABLA HASH CERRADA CON SONDEO LINEAL
    private static class Element {
        Register register;		//REGISTRO GUARDADO
        boolean isAvailable;	//INDICA SI LA CELDA ESTA DISPONIBLE

        public Element() {
            this.register = null;
            this.isAvailable = true;
        }
    }

    private Element[] table;	//ARREGLO DE ELEMENTOS DE LA TABLA HASH
    private int size;			//TAMAÑO DE LA TABLA

    public HashC(int size) {
        this.size = size;
        this.table = new Element[size]; 	//CREA UN ELEMENTO E INICIALIZA CON CELDAS VACIAS
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    private int hash(int key) {	//CALCULA POSICION EN LA TABLA
        return key % size;
    }

    public void insert(Register reg) {
        int index = hash(reg.getKey());	//INICIA CALCULANDO EL INDICE HASH
        int originalIndex = index;
        boolean inserted = false;

        for (int i = 0; i < size; i++) {	//SONDEO LINEAL(BUSCA POSICION LIBRE)
            int currentIndex = (index + i) % size;
            if (table[currentIndex].isAvailable || table[currentIndex].register == null) {
                table[currentIndex].register = reg;
                table[currentIndex].isAvailable = false;
                inserted = true;
                break;
            }
        }

        if (!inserted) {
            System.out.println("Error: La tabla está llena. No se pudo insertar " + reg);
        }
    }

    public Register search(int key) {
        int index = hash(key);
        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            Element elem = table[currentIndex];

            if (!elem.isAvailable && elem.register != null && elem.register.getKey() == key) {
                return elem.register;
            } else if (elem.register == null && elem.isAvailable) {
                return null; 
            }
        }
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            Element elem = table[currentIndex];

            if (!elem.isAvailable && elem.register != null && elem.register.getKey() == key) {
                elem.isAvailable = true;	 //ELIMINACIÓN LÓGICA
                System.out.println("Registro con clave " + key + " eliminado.");
                return;
            }
        }
        System.out.println("Clave " + key + " no encontrada para eliminar.");
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            if (table[i].register != null && !table[i].isAvailable) {
                System.out.println(table[i].register);
            } else {
                System.out.println("vacío");
            }
        }
    }
}
