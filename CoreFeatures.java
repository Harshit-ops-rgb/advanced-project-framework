/**
 * Core Features Implementation
 * Implements all core functionalities as per project requirements
 */
public class CoreFeatures {
    
    private String featureName;
    private boolean isActive;
    private int priority;
    
    /**
     * Constructor to initialize core feature
     * @param featureName Name of the feature
     * @param priority Priority level of the feature
     */
    public CoreFeatures(String featureName, int priority) {
        this.featureName = featureName;
        this.priority = priority;
        this.isActive = true;
    }
    
    /**
     * Activates the core feature
     */
    public void activateFeature() {
        this.isActive = true;
        System.out.println("Feature " + featureName + " activated successfully.");
    }
    
    /**
     * Deactivates the core feature
     */
    public void deactivateFeature() {
        this.isActive = false;
        System.out.println("Feature " + featureName + " deactivated.");
    }
    
    /**
     * Gets the feature status
     * @return true if feature is active, false otherwise
     */
    public boolean isFeatureActive() {
        return isActive;
    }
    
    /**
     * Gets the feature name
     * @return Feature name
     */
    public String getFeatureName() {
        return featureName;
    }
    
    /**
     * Gets the feature priority
     * @return Feature priority level
     */
    public int getPriority() {
        return priority;
    }
}
