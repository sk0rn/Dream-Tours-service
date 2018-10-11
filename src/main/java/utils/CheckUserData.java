package utils;

public class CheckUserData {

    private CheckUserData(){}

    public static boolean checkPassword(String password,
                                        int passLength,
                                        int lowerCharMin,
                                        int upperCharMin,
                                        int digMin) {

        if (password.length() < passLength) return false;

        int lowerCharCount = 0;
        int upperCharCount = 0;
        int digCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char c = password.charAt(i);

            if (idDigit(c)) digCount++;
            else if (isLowercaseLetter(c)) lowerCharCount++;
            else if (isUppercaseLetter(c)) upperCharCount++;
            else return false;
        }
        return (lowerCharCount >= lowerCharMin
                && upperCharCount >= upperCharMin
                && digCount >= digMin);
    }

    public static boolean checkPhone(String number, int digits) {
        return number.matches(("(\\+?)\\d{"+digits+"}"));
    }

    private static boolean isLowercaseLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }

    private static boolean isUppercaseLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }


    private static boolean idDigit(char c) {
        return (c >= '0' && c <= '9');
    }
}
