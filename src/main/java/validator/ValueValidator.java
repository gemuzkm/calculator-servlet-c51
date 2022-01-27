package validator;

public class ValueValidator {

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

    public boolean isStringEmpty(String inputString) {
        if (inputString.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
