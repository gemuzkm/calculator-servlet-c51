package validator;

public class ValueValidation {

    public boolean isNumber(String inputValue) {
        try {
            Double.parseDouble(inputValue);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isNull(String inputValue) {
        if (inputValue == null) {
            return true;
        } else {
            return false;
        }
    }
}
