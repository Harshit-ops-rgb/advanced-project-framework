import java.sql.Connection;

/**
 * FraudDetectorBase - Abstract Base Class for Fraud Detection Strategies
 * Provides common interface for different fraud detection algorithms
 * Implements Strategy Pattern for extensibility
 */
public abstract class FraudDetectorBase {
    
    protected Connection connection;
    protected String strategyName;
    
    /**
     * Constructor for FraudDetectorBase
     * @param conn Database connection
     * @param strategyName Name of the fraud detection strategy
     */
    public FraudDetectorBase(Connection conn, String strategyName) {
        this.connection = conn;
        this.strategyName = strategyName;
    }
    
    /**
     * Abstract method for fraud detection
     * Implementations should define their own fraud detection logic
     * @param transaction Transaction to analyze
     * @param user User making the transaction
     * @return Risk score (0.0 - 1.0) indicating probability of fraud
     */
    public abstract double calculateFraudRisk(Transaction transaction, User user);
    
    /**
     * Abstract method for threshold determination
     * Implementations should define their own threshold logic
     * @return Threshold value for fraud classification
     */
    public abstract double getThreshold();
    
    /**
     * Determines if a transaction is fraudulent based on risk score
     * @param transaction Transaction to analyze
     * @param user User making the transaction
     * @return true if fraud risk exceeds threshold
     */
    public boolean isFraudulent(Transaction transaction, User user) {
        double riskScore = calculateFraudRisk(transaction, user);
        return riskScore >= getThreshold();
    }
    
    /**
     * Gets the name of this fraud detection strategy
     * @return Strategy name
     */
    public String getStrategyName() {
        return strategyName;
    }
    
    /**
     * Gets the database connection
     * @return Database connection
     */
    protected Connection getConnection() {
        return connection;
    }
}
