/**
 * User Class
 * Represents a user in the fraud detection system
 */
public class User {
    private int userId;
    private String name;
    private String email;
    private String phone;
    private boolean isSuspicious;
    private int fraudCount;
    
    /**
     * Constructor for User
     * @param userId Unique user identifier
     * @param name User's full name
     * @param email User's email address
     * @param phone User's phone number
     */
    public User(int userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isSuspicious = false;
        this.fraudCount = 0;
    }
    
    // Getters
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public boolean isSuspicious() { return isSuspicious; }
    public int getFraudCount() { return fraudCount; }
    
    // Setters
    public void setIsSuspicious(boolean suspicious) { this.isSuspicious = suspicious; }
    public void incrementFraudCount() { this.fraudCount++; }
    
    @Override
    public String toString() {
        return String.format("User[ID=%d, Name=%s, Email=%s, Phone=%s, Suspicious=%b, FraudCount=%d]",
                userId, name, email, phone, isSuspicious, fraudCount);
    }
}
