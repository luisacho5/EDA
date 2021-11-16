package examenparcial;

/**
 *
 * @author mayte
 */
class DNI {

    private final long number;
    private final char letter;

    public DNI(long number, char letter) {
        this.number = number;
        this.letter = letter;
    }

    public long getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.number ^ (this.number >>> 32));
        hash = 79 * hash + this.letter;
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
        final DNI other = (DNI) obj;
        if (this.number != other.number) {
            return false;
        }
        if (this.letter != other.letter) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + number + "-" + letter ;
    }
    
}
