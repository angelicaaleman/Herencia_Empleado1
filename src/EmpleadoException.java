public class EmpleadoException extends RuntimeException{

    private final String errorMessage;

    public EmpleadoException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}


