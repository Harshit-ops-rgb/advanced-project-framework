/**
 * Transaction Class
 * Represents a financial transaction for fraud detection
 */
public class Transaction {
    private int transactionId;
    private int userId;
    private double amount;
    private String merchant;
    private String timestamp;
    private String location;
    private boolean flagged;
    
    /**
     * Constructor for Transaction
     * @param transactionId Unique transaction identifier
     * @param userId User who made the transaction
     * @param amount Transaction amount
     * @param merchant Merchant name
     * @param timestamp Transaction time
     * @param location Transaction location
     */
    public Transaction(int transactionId, int userId, double amount, 
                      String merchant, String timestamp, String location) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.merchant = merchant;
        this.timestamp = timestamp;
        this.location = location;
        this.flagged = false;
    }
    
    // Getters
    public int getTransactionId() { return transactionId; }
    public int getUserId() { return userId; }
    public double getAmount() { return amount; }
    public String getMerchant() { return merchant; }
    public String getTimestamp() { return timestamp; }
    public String getLocation() { return location; }
    public boolean isFlagged() { return flagged; }
    
    // Setters
    public void setFlagged(boolean flagged) { this.flagged = flagged; }
    
    @Override
    public String toString() {
        return String.format("Transaction[ID=%d, User=%d, Amount=%.2f, Merchant=%s, Time=%s, Location=%s, Flagged=%b]",
                transactionId, userId, amount, merchant, timestamp, location, flagged);
    }
}
