import java.util.regex.Pattern;

/**
 * Data Validation Module
 * Implements client-side and server-side validation
 */
public class DataValidator {
    
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{10}$");
    private static final int MIN_PASSWORD_LENGTH = 8;
    
    /**
     * Validates email format
     * @param email The email address to validate
     * @return true if email is valid, false otherwise
     */
    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }
    
    /**
     * Validates phone number format
     * @param phone The phone number to validate
     * @return true if phone is valid, false otherwise
     */
    public static boolean validatePhoneNumber(String phone) {
        if (phone == null || phone.isEmpty()) return false;
        return PHONE_PATTERN.matcher(phone).matches();
    }
    
    /**
     * Validates password strength
     * @param password The password to validate
     * @return true if password meets criteria, false otherwise
     */
    public static boolean validatePassword(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) return false;
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        return hasUpper && hasLower && hasDigit;
    }
    
    /**
     * Validates if string is numeric
     * @param str The string to validate
     * @return true if string contains only numbers, false otherwise
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        return str.matches("^[0-9]+$");
    }
    
    /**
     * Validates if string length is within range
     * @param str The string to validate
     * @param minLength Minimum required length
     * @param maxLength Maximum allowed length
     * @return true if length is within range, false otherwise
     */
    public static boolean validateStringLength(String str, int minLength, int maxLength) {
        if (str == null) return false;
        int length = str.length();
        return length >= minLength && length <= maxLength;
    }
}
