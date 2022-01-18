package validator;

public class InputOperatorNumberValidation {

    public boolean isNumber(String inputParamert) {
        try {
            Double.parseDouble(inputParamert);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
