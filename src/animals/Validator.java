package animals;

public class Validator {
    public static String validateString(String stringValidation) {
        return stringValidation == null
                || stringValidation.isEmpty()
                || stringValidation.isBlank() ? "incorrect input" : stringValidation;
    }
    public static Integer validateInteger(Integer integer) {
        return integer < 0 ? Math.abs(integer): integer;
    }
}
