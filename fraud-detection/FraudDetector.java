import java.sql.*;
import java.util.*;

/**
 * FraudDetector Class - Main Fraud Detection Engine
 * Analyzes transactions and user behavior to detect fraudulent activities
 * Integrates with Database, ErrorHandler, DataValidator from framework
 */
public class FraudDetector {
    private Connection connection;
    private static final double AMOUNT_THRESHOLD = 10000.0;
    private static final int SUSPICIOUS_TRANSACTION_LIMIT = 5;
    
    /**
     * Constructor to initialize FraudDetector with database connection
     * @param conn Database connection for accessing transaction history
     */
    public FraudDetector(Connection conn) {
        this.connection = conn;
    }
    
    /**
     * Detects fraudulent transactions based on multiple factors
     * @param transaction Transaction to analyze
     * @param user User making the transaction
     * @return true if transaction is suspected to be fraudulent
     */
    public boolean detectFraud(Transaction transaction, User user) {
        try {
            // Check amount threshold
            if (transaction.getAmount() > AMOUNT_THRESHOLD) {
                return true;
            }
            
            // Check user history
            if (user.getFraudCount() > 0) {
                return true;
            }
            
            // Check transaction frequency
            int transactionCount = getRecentTransactionCount(user.getUserId());
            if (transactionCount > SUSPICIOUS_TRANSACTION_LIMIT) {
                return true;
            }
            
            // Check location anomaly
            if (isLocationAnomaly(transaction)) {
                return true;
            }
            
            return false;
        } catch (SQLException e) {
            System.err.println("Error detecting fraud: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Analyzes transaction patterns over time
     * @param userId User ID to analyze
     * @return Fraud risk score (0.0 - 1.0)
     */
    public double calculateRiskScore(int userId) {
        double riskScore = 0.0;
        try {
            int suspiciousTransactions = getRecentTransactionCount(userId);
            riskScore = (double) suspiciousTransactions / SUSPICIOUS_TRANSACTION_LIMIT;
            riskScore = Math.min(riskScore, 1.0);
        } catch (SQLException e) {
            System.err.println("Error calculating risk score: " + e.getMessage());
        }
        return riskScore;
    }
    
    /**
     * Gets count of recent transactions for a user
     * @param userId User ID
     * @return Count of recent transactions
     */
    private int getRecentTransactionCount(int userId) throws SQLException {
        String query = "SELECT COUNT(*) FROM transactions WHERE user_id = ? AND timestamp > datetime('now', '-1 day')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
    
    /**
     * Detects location-based anomalies
     * @param transaction Transaction to check
     * @return true if location seems anomalous
     */
    private boolean isLocationAnomaly(Transaction transaction) {
        // Implement location-based fraud detection
        // This is a simplified version
        return transaction.getLocation() == null || transaction.getLocation().isEmpty();
    }
    
    /**
     * Flags a user as suspicious
     * @param userId User ID to flag
     */
    public void flagUserSuspicious(int userId) {
        String query = "UPDATE users SET is_suspicious = 1 WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error flagging user: " + e.getMessage());
        }
    }
}
