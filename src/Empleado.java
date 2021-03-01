public class Empleado extends Persona{

    private final double salario;

    public Empleado(int id, String nombre, String apellido, double salario) {
        super(id, nombre, apellido);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString() + " Salario=" + salario;
    }
}
