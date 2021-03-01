public class Persona  {

    private final int id;
    private final String nombre;
    private final String apellido;

    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Id=" + id +
                " Nombre=" + nombre +
                " Apellido=" + apellido;
    }
}
