package hash;
 
public class Register { // REPRESENTA UN REGISTRO CON UNA CLAVE Y UN NOMBRE 
    private int key;		//CLAVE QUE SE USARA COMO INDICE EN LA TABLA
    private String name;	//NOMBRE DEL REGISTRO

    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "(" + key + ", " + name + ")";
    }
}
