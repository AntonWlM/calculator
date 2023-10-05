public class Validator {

    public void validate(String scline) throws RuntimeException {
        if (scline.isEmpty()) {
            throw new RuntimeException("введена пустая строка");
        }
        if (!scline.startsWith("\"")) {
            throw new RuntimeException(("операция должна начинаться со строки"));
        }
        if ((scline.contains("*") || scline.contains("/")) && scline.endsWith("\"")) {
            throw new RuntimeException("нельзя делить или умножать на строку");
        }
    }
}
