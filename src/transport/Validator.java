package transport;

public class Validator {
    public static String validateString(String stringValidation) {
        return stringValidation == null
                || stringValidation.isEmpty()
                || stringValidation.isBlank() ? "default" : stringValidation;
    }
    public static Boolean validateBoolean (Boolean value) {
        return value != null && value;
    }
}
