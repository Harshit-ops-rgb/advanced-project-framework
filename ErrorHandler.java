/**
 * Error Handler & Robustness
 * Manages error handling and system failures without crashes
 */
public class ErrorHandler {
    
    private static final String ERROR_LOG_FORMAT = "[ERROR] %s: %s";
    private int errorCount;
    private StringBuilder errorLog;
    
    /**
     * Constructor to initialize ErrorHandler
     */
    public ErrorHandler() {
        this.errorCount = 0;
        this.errorLog = new StringBuilder();
    }
    
    /**
     * Handles exceptions gracefully
     * @param exception The exception to handle
     * @param context Description of where error occurred
     */
    public void handleException(Exception exception, String context) {
        errorCount++;
        String errorMessage = String.format(ERROR_LOG_FORMAT, context, exception.getMessage());
        errorLog.append(errorMessage).append("\n");
        System.err.println(errorMessage);
    }
    
    /**
     * Validates input and returns null if invalid
     * @param input The input to validate
     * @return true if valid, false otherwise
     */
    public boolean validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            handleException(new IllegalArgumentException("Input is null or empty"), "Input Validation");
            return false;
        }
        return true;
    }
    
    /**
     * Gets total error count
     * @return Number of errors encountered
     */
    public int getErrorCount() {
        return errorCount;
    }
    
    /**
     * Gets complete error log
     * @return String containing all logged errors
     */
    public String getErrorLog() {
        return errorLog.toString();
    }
    
    /**
     * Clears the error log
     */
    public void clearErrorLog() {
        errorLog = new StringBuilder();
        errorCount = 0;
        System.out.println("Error log cleared.");
    }
}
