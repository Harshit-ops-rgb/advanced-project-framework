# How to Run the Advanced Project Framework Code

## Overview
This guide provides comprehensive instructions on how to compile, run, and test all components of the Advanced Project Framework including the integrated Fraud Detection System.

## Prerequisites

### System Requirements
- **Java Development Kit (JDK):** Java 8 or higher
- **Operating System:** Windows, macOS, or Linux
- **RAM:** Minimum 2GB (4GB recommended)
- **Disk Space:** At least 500MB for project and dependencies

### Installation Steps

#### 1. Install Java JDK

**Windows:**
```bash
# Download from oracle.com and run installer
# Or use Chocolatey
choco install openjdk
```

**macOS:**
```bash
# Using Homebrew
brew install openjdk
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt-get update
sudo apt-get install openjdk-11-jdk
```

#### 2. Verify Java Installation
```bash
java -version
javac -version
```

Both commands should display the Java version without errors.

---

## Project Structure

```
advanced-project-framework/
├── CoreFeatures.java
├── DataValidator.java
├── ErrorHandler.java
├── EventHandler.java
├── RUN_INSTRUCTIONS.md (this file)
├── IMPLEMENTATION_GUIDE.md
├── FRAUD_DETECTION_INTEGRATION.md
├── README.md
└── fraud-detection/
    ├── Database.java
    ├── FraudDetector.java
    ├── FraudDetectorBase.java
    ├── Transaction.java
    └── User.java
```

---

## Quick Start - Step by Step

### Step 1: Clone the Repository

```bash
# Clone from GitHub
git clone https://github.com/Harshit-ops-rgb/advanced-project-framework.git

# Navigate to project directory
cd advanced-project-framework
```

### Step 2: Create a Project Directory Structure

```bash
# Create bin directory for compiled classes
mkdir -p bin

# Create lib directory (for libraries if needed)
mkdir -p lib
```

### Step 3: Compile Framework Components

```bash
# Compile all framework core files
javac -d bin *.java

# Or compile individually:
javac -d bin CoreFeatures.java
javac -d bin DataValidator.java
javac -d bin ErrorHandler.java
javac -d bin EventHandler.java
```

### Step 4: Compile Fraud Detection System

```bash
# Compile fraud detection module
javac -d bin fraud-detection/*.java

# Or compile individually:
javac -d bin fraud-detection/Database.java
javac -d bin fraud-detection/Transaction.java
javac -d bin fraud-detection/User.java
javac -d bin fraud-detection/FraudDetectorBase.java
javac -d bin fraud-detection/FraudDetector.java
```

### Step 5: Run Individual Components

#### Test CoreFeatures

```bash
# Create a simple test class
cat > TestCoreFeatures.java << 'EOF'
public class TestCoreFeatures {
    public static void main(String[] args) {
        CoreFeatures feature = new CoreFeatures("PaymentProcessing", 1);
        feature.activateFeature();
        System.out.println("Feature: " + feature.getFeatureName());
        System.out.println("Is Active: " + feature.isFeatureActive());
        System.out.println("Priority: " + feature.getPriority());
    }
}
EOF

# Compile and run
javac -d bin -cp bin TestCoreFeatures.java
java -cp bin TestCoreFeatures
```

#### Test DataValidator

```bash
# Create a test class
cat > TestDataValidator.java << 'EOF'
public class TestDataValidator {
    public static void main(String[] args) {
        // Test email validation
        String email = "user@example.com";
        boolean validEmail = DataValidator.validateEmail(email);
        System.out.println("Email '" + email + "' is valid: " + validEmail);
        
        // Test phone number validation
        String phone = "9876543210";
        boolean validPhone = DataValidator.validatePhoneNumber(phone);
        System.out.println("Phone '" + phone + "' is valid: " + validPhone);
        
        // Test password validation
        String password = "SecurePass123";
        boolean validPassword = DataValidator.validatePassword(password);
        System.out.println("Password is valid: " + validPassword);
    }
}
EOF

# Compile and run
javac -d bin -cp bin TestDataValidator.java
java -cp bin TestDataValidator
```

#### Test ErrorHandler

```bash
# Create a test class
cat > TestErrorHandler.java << 'EOF'
public class TestErrorHandler {
    public static void main(String[] args) {
        ErrorHandler handler = new ErrorHandler();
        
        try {
            // Simulate an error
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            handler.handleException(e, "Division Operation");
        }
        
        System.out.println("Total Errors: " + handler.getErrorCount());
        System.out.println("Error Log:\n" + handler.getErrorLog());
    }
}
EOF

# Compile and run
javac -d bin -cp bin TestErrorHandler.java
java -cp bin TestErrorHandler
```

#### Test EventHandler

```bash
# Create a test class
cat > TestEventHandler.java << 'EOF'
public class TestEventHandler {
    public static void main(String[] args) {
        EventHandler handler = new EventHandler();
        
        // Register a listener
        handler.registerListener(event -> {
            System.out.println("Event Received: " + event.getEventType());
            System.out.println("Timestamp: " + event.getTimestamp());
        });
        
        // Publish events
        handler.publishEvent(new EventHandler.Event("USER_LOGIN"));
        handler.publishEvent(new EventHandler.Event("TRANSACTION_COMPLETED"));
        
        System.out.println("Total Listeners: " + handler.getListenerCount());
    }
}
EOF

# Compile and run
javac -d bin -cp bin TestEventHandler.java
java -cp bin TestEventHandler
```

#### Test Fraud Detection System

```bash
# Create a test class
cat > TestFraudDetection.java << 'EOF'
public class TestFraudDetection {
    public static void main(String[] args) {
        // Create test objects
        User user = new User(1, "John Doe", "john@example.com", "9876543210");
        Transaction transaction = new Transaction(
            1001, 
            1, 
            5000.0, 
            "Electronics Store", 
            "2026-01-09 15:30:00", 
            "Mumbai, India"
        );
        
        System.out.println("=== Fraud Detection Test ===");
        System.out.println("User: " + user);
        System.out.println("Transaction: " + transaction);
        
        // Note: FraudDetector requires database connection
        // Demonstrate it without actual database
        System.out.println("\nFraud Detection would analyze:");
        System.out.println("- Transaction amount: " + transaction.getAmount());
        System.out.println("- User fraud history: " + user.getFraudCount());
        System.out.println("- Location: " + transaction.getLocation());
    }
}
EOF

# Compile and run
javac -d bin -cp bin TestFraudDetection.java
java -cp bin TestFraudDetection
```

---

## Batch Compilation & Running

### Compile All Files at Once

```bash
# Windows
javac -d bin *.java fraud-detection\*.java

# Linux/macOS
javac -d bin *.java fraud-detection/*.java
```

### Run with Classpath

```bash
# Windows
java -cp bin Test ClassName

# Linux/macOS
java -cp bin TestClassName
```

---

## Advanced Compilation Options

### With Verbose Output

```bash
javac -verbose -d bin *.java
```

### With Debugging Information

```bash
javac -g -d bin *.java
```

### With Strict Warnings

```bash
javac -Xlint:all -d bin *.java
```

---

## Running with Build Tool (Maven/Gradle)

### Using Maven (if pom.xml exists)

```bash
# Compile
mvn clean compile

# Run
mvn exec:java -Dexec.mainClass="ClassName"
```

### Using Gradle (if build.gradle exists)

```bash
# Compile
./gradlew build

# Run
./gradlew run
```

---

## Testing Framework Integration

### Creating a Master Test Class

```java
public class IntegrationTest {
    public static void main(String[] args) {
        System.out.println("=== Advanced Framework Integration Test ===");
        
        // Initialize components
        ErrorHandler errorHandler = new ErrorHandler();
        EventHandler eventHandler = new EventHandler();
        CoreFeatures feature = new CoreFeatures("FraudDetection", 1);
        
        feature.activateFeature();
        
        // Register event listener
        eventHandler.registerListener(event -> {
            System.out.println("[Event] " + event.getEventType() + " at " + event.getTimestamp());
        });
        
        // Publish events
        eventHandler.publishEvent(new EventHandler.Event("SYSTEM_STARTED"));
        eventHandler.publishEvent(new EventHandler.Event("FRAUD_CHECK_INITIATED"));
        
        System.out.println("\nIntegration Test Completed Successfully!");
    }
}
```

Compile and run:
```bash
javac -d bin -cp bin IntegrationTest.java
java -cp bin IntegrationTest
```

---

## Troubleshooting

### Error: "Command not found: javac"
- **Solution:** Java JDK not installed or not in system PATH
- **Fix:** Install JDK and add JAVA_HOME to environment variables

### Error: "Cannot find symbol"
- **Solution:** Missing imports or compilation order issue
- **Fix:** Compile all dependencies first using proper classpath

### Error: "ClassNotFoundException"
- **Solution:** Class not found in classpath
- **Fix:** Ensure -cp bin is specified when running

### Error: "Exception in thread main"
- **Solution:** Runtime error during execution
- **Fix:** Check error messages and verify input data

---

## Performance Tips

1. **Use -cp (classpath) for faster execution**
2. **Compile to a separate 'bin' directory** to keep source clean
3. **Use wildcard compilation** for faster builds
4. **Enable parallel compilation** in IDEs

---

## IDE Setup (Optional)

### IntelliJ IDEA
1. Open project
2. Right-click on project → Mark Directory as → Sources Root
3. Right-click on fraud-detection folder → Mark Directory as → Sources Root
4. Run → Run 'TestClassName'

### Eclipse
1. File → New → Java Project
2. Link source folders
3. Configure build path
4. Run as → Java Application

### VS Code
1. Install Extension Pack for Java
2. Open project folder
3. Press F5 to start debugging
4. Select Java configuration

---

## Next Steps

After successfully running the basic tests:
1. Review the IMPLEMENTATION_GUIDE.md for detailed feature documentation
2. Check FRAUD_DETECTION_INTEGRATION.md for fraud detection specifics
3. Examine source code comments and JavaDoc
4. Create custom test classes for your use cases
5. Integrate components into your own projects

---

## Additional Resources

- **Java Documentation:** https://docs.oracle.com/en/java/
- **Framework GitHub:** https://github.com/Harshit-ops-rgb/advanced-project-framework
- **Fraud Detection Source:** https://github.com/soravpatel10/Ai-based-fraud-detection-system

---

**Happy Coding!** 🚀
