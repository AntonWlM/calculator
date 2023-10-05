public class Calculator {

    private final Validator validator = new Validator();

    public void calculate(String scline) throws RuntimeException {
        validator.validate(scline);
        String[] ords = scline.split("\" ", 0);
        if (ords.length < 1 || ords.length > 2) {
            throw new RuntimeException("недопустимое число операндов");
        }
        String a = ords[0];
        String b = ords[1];
        if (a.length() > 11) {
            throw new RuntimeException("слова не могут быть больше 10 символов");
        }
        a = a.replaceAll("\"", "");
        if (b.contains("+")) {
            b = b.substring(2).replaceAll("\"", "");
            System.out.println(a + b);
        } else if (b.contains("-")) {
            b = b.substring(2).replaceAll("\"", "");
            if (!a.contains(b)) {
                System.out.println("\"" + a + "\"");
            } else {
                String c = a.replace(b, "");
                System.out.println("\"" + c + "\"");
            }
        } else if (b.contains("/")) {
            b = b.substring(2);
            int b1 = Integer.parseInt(b);
            if (b1 < 1 || b1 > 10) {
                throw new RuntimeException("Введенное число вне диапазона от 1 до 10");
            }
            int x = a.length() / b1;
            System.out.println(a.substring(0, x));
        } else if (b.contains("*")) {
            b = b.substring(2);
            StringBuilder a1 = new StringBuilder(a);
            int b1 = Integer.parseInt(b);
            if (b1 < 1 || b1 > 10) {
                throw new RuntimeException("Введенное число вне диапазона от 1 до 10");
            }
            a1.append(a.repeat(b1 - 1));
            if (a1.length() >= 40) {
                a1 = new StringBuilder(a1.substring(0, 40));
                System.out.println(a1 + "...");
            } else {
                System.out.println("\"" + a1 + "\"");
            }
        } else {
            throw new RuntimeException("строка не является допустимой операцией");
        }
    }
}
