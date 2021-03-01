import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final OperacionesEmpleados operacionesEmpleados = new OperacionesEmpleados();

    private void mostrarMenu(){

        System.out.println("\nPor favor elija una opción");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Eliminar empleado");
        System.out.println("3. Actualizar empleado");
        System.out.println("4. Mostrar empleados");
        System.out.println("5. Empleado con mayor salario");
        System.out.println("6. Empleado con menor salario");
        System.out.println("7. Empleados en orden");
        System.out.println("8. Suma salarios mayores a 700000");
        System.out.println("9. Cantidad de empleados con apellido que inicia por A ó a");
        System.out.println("10.Mostrar los 5 primeros empleados con mas sueldo");


        System.out.println("11. Salir");
    }

    private void eligirOpcion(int opcion){

        switch(opcion){
            case 1:
                System.out.println("Agregando");
                operacionesEmpleados.agregar();
                break;
            case 2:
                System.out.println("Eliminando");
                operacionesEmpleados.eliminar();
                break;
            case 3:
                System.out.println("Actualizando");
                operacionesEmpleados.actualizar();
                break;
            case 4:
                System.out.println("Mostrando");
                operacionesEmpleados.mostrar();
                break;
            case 5:
                System.out.println("Mostrando");
                operacionesEmpleados.mayor();
                break;
            case 6:
                System.out.println("Mostrando");
                operacionesEmpleados.menor();
                break;
            case 7:
                System.out.println("Actualizando");
                operacionesEmpleados.actualizar();
                break;
            case 8:
                System.out.println("Mostrando");
                operacionesEmpleados.suma();
                break;

            case 9:
                System.out.println("Mostrando");
                operacionesEmpleados.cantidad();
                break;
            case 10:
                System.out.println("Mostrando");
                operacionesEmpleados.mayores();
                break;
            default:
                otrasOpciones(opcion);
        }
    }

    public void otrasOpciones(int opcion){

        switch (opcion){
            case 11:
                System.out.println("Adiós");
                break;
            default:
                System.out.println("La opción no es válida");
        }
    }

    public void repetirMenu() {

        int opcion = 0;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            try {
                eligirOpcion(opcion);
            }catch (EmpleadoException ex){
                System.out.println(ex.getErrorMessage());
            }
        }while(opcion != 5);
    }

    private int obtenerOpcion(){

        try {
            return scanner.nextInt();
        } catch(InputMismatchException ex) {
            scanner.nextLine();
            return -1;
        }
    }
}
