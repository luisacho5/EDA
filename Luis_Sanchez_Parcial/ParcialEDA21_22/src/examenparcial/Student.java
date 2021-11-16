package examenparcial;

/**
 *
 * @author mayte
 */
public class Student {

    private final String name;
    private final String lastname;
    private final DNI dni;

    public Student(String name, String lastname, DNI dni) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public DNI getDni() {
        return dni;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.dni.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!this.name.equals(other.name)) {
            return false;
        }
        if (!this.lastname.equals(other.lastname)) {
            return false;
        }
        if (!this.dni.equals(other.dni)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student: " + "name=" + name + ", lastname=" + lastname + ", dni=" + dni.toString() ;
    }    
    
    
}
