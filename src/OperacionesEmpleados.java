import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
public class OperacionesEmpleados {

    public final List<Empleado> empleados;
    private final Scanner scanner = new Scanner(System.in);

    public OperacionesEmpleados(){
        empleados = new ArrayList<Empleado>(){
            {

            }
        };

    }

    public void agregar(){
        System.out.println("Ingrese la cédula");
        int cedula = obtenerCedula();
        existeCedula(cedula);
        System.out.println("Ingrese el nombre");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el salario");
        double salario = obtenerSalario();

        empleados.add(
                new Empleado(cedula, nombre, apellido, salario)
        );
    }

    private int obtenerCedula(){

        try{
            int cedula = scanner.nextInt();
            scanner.nextLine();
            return cedula;
        } catch (InputMismatchException ex) {
            scanner.nextLine();
            throw new EmpleadoException("Cédula con formato no válido");
        }
    }

    private void existeCedula(int cedula) {

        for(Empleado empleado : empleados){
            if(empleado.getId() == cedula){
                throw new EmpleadoException("Cédula " + cedula + " ya existe");
            }
        }
    }

    private boolean noExisteCedula(int cedula){

        try{
            existeCedula(cedula);
            return true;
        } catch (EmpleadoException ex){
            return false;
        }
    }

    private double obtenerSalario() {

        try{
            double salario = scanner.nextDouble();
            scanner.nextLine();
            return salario;
        } catch (InputMismatchException ex) {
            scanner.nextLine();
            throw new EmpleadoException("Salario con formato no válido");
        }
    }

    public void eliminar(){

        System.out.println("Ingrese la cédula que quiere eliminar");
        int cedula = obtenerCedula();
        if(!noExisteCedula(cedula)) {
            for (Empleado empleado : empleados) {
                if (empleado.getId() == cedula) {
                    System.out.println("Se ha eliminado al empleado " + empleado);
                    empleados.remove(empleado);
                }
            }
        } else {
            throw new EmpleadoException("La cédula " + cedula + " no existe");
        }
    }

    public void actualizar(){

        System.out.println("Ingrese la cédula que quiere actualizar");
        int cedula = obtenerCedula();
        if(!noExisteCedula(cedula)){
            int opcion = 0;
            do {
                mostrarMenuActualizar();
                try {
                    opcion = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    opcion = -1;
                }
                scanner.nextLine();
                actualizarEmpleado(cedula, opcion);
            } while(opcion != 4);
        } else {
            throw new EmpleadoException("La cédula " + cedula + " no existe");
        }
    }

    private void mostrarMenuActualizar(){
        System.out.println("Elija una opción:");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Salario");
        System.out.println("4. Salir");
    }

    private void actualizarEmpleado(int cedula, int opcion){

        Empleado empleadoViejo = obtenerEmpleado(cedula);
        Empleado nuevoEmpleado = null;
        if(null != empleadoViejo){
            elegirOpcionDeActualizacion(opcion, empleadoViejo, nuevoEmpleado);
        } else {
            throw new EmpleadoException("La cédula " + cedula + " no existe");
        }
    }

    private void elegirOpcionDeActualizacion(int opcion, Empleado empleadoViejo, Empleado nuevoEmpleado){

        switch (opcion){
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                String nuevoNombre = scanner.nextLine();
                nuevoEmpleado = new Empleado(empleadoViejo.getId(), nuevoNombre, empleadoViejo.getApellido(), empleadoViejo.getSalario());
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido");
                String nuevoApellido = scanner.nextLine();
                nuevoEmpleado = new Empleado(empleadoViejo.getId(), empleadoViejo.getNombre(), nuevoApellido, empleadoViejo.getSalario());
                break;
            case 3:
                System.out.println("Ingrese el nuevo salario");
                double nuevoSalario = obtenerSalario();
                nuevoEmpleado = new Empleado(empleadoViejo.getId(), empleadoViejo.getNombre(), empleadoViejo.getApellido(), nuevoSalario);
                break;
            case 4:
                break;
            default:
                System.out.println("Opción no válida");
        }

        if(opcion >= 1 && opcion <= 3){
            empleados.remove(empleadoViejo);
            empleados.add(nuevoEmpleado);
        }
    }

    public void mostrar(){
        for(Empleado empleado : empleados){
            System.out.println(empleado);

        }
    }

    private Empleado obtenerEmpleado(int cedula){

        for(Empleado empleado : empleados){
            if(cedula == empleado.getId()){
                return empleado;
            }
        }

        return null;
    }


    public void mayor(){
        double mayor=0;
        Empleado empleado1 = null;
        for(Empleado empleado : empleados){

            if(empleado.getSalario() > mayor)
            {
                mayor=empleado.getSalario();
                empleado1 = empleado;
            }

        }
        System.out.println("El empleado con mayor salario es:  "+empleado1);

    }
    public void menor(){
        double menor;
        Empleado empleado1 = null;
        for(Empleado empleado : empleados){
            menor=empleado.getSalario();
            empleado1 = empleado;

            if(empleado.getSalario() < menor)
            {
                menor=empleado.getSalario();
                empleado1 = empleado;
            }

        }
        System.out.println("El empleado con menor salario es:  "+empleado1);


    }
 /*   public void mostrarOrden(){

        Collections.sort();
        for(Empleado empleado : empleados){

            System.out.println(empleado);
        }
    }*/

    public void suma(){

        double mayor=0;
        Empleado empleado1 = null;
        for(Empleado empleado : empleados){

            if(empleado.getSalario() > 700000) {
                mayor = empleado.getSalario()+mayor;

            }
        }
        System.out.println("El total de los salarios mayores a 700.000 es:  "+mayor);

    }

    public void mayores(){
        int i=0;
        System.out.println("estos son los 5 empleados con mayor salario");
        while(i<5) {


            double mayor = 0;
            Empleado empleado1 = null;

            for (Empleado empleado : empleados) {

                if (empleado.getSalario() > mayor) {
                    mayor = empleado.getSalario();
                    empleado1 = empleado;
                }

            }
            System.out.println(empleado1);
            empleados.remove(empleado1);
            i++;
        }

 }


    public void cantidad() {
        int i=0;
        String comparar ="A";
        for(Empleado empleado : empleados){
            char codigo;
            codigo =empleado.getApellido().charAt(0);

            String dato = Character.toString(codigo);
            System.out.println(dato);


            if( dato == comparar )
            {
                i++;
            }
        }

System.out.println("la cantidad de empleados que inicia el apellido por la letra a o A es: " +i);

    }



}
