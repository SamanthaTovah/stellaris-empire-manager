package io.github.samanthatovah.stellaris.empiremanager.domain.empire;

public class EmpireException extends RuntimeException {

    public EmpireException() {
        super();
    }

    public EmpireException(String message) {
        super(message);
    }

    public EmpireException(Throwable cause) {
        super(cause);
    }

    public EmpireException(String message, Throwable cause) {
        super(message, cause);
    }

}
