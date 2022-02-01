package web.validator;

public class OperationValidator {
    public boolean supportedOperation(String inputOperation) {

        if (inputOperation.equals("sum")) {
            return true;
        } else if (inputOperation.equals("dif")) {
            return true;
        } else if (inputOperation.equals("div")) {
            return true;
        } else if (inputOperation.equals("mult")) {
            return true;
        } else {
            return false;
        }
    }
}
