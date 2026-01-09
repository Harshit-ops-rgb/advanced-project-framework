import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Event Handler & Processing
 * Optimizes event listeners and delegation for efficient performance
 */
public class EventHandler {
    
    private List<EventListener> listeners;
    private Queue<Event> eventQueue;
    private boolean isProcessing;
    
    /**
     * Constructor to initialize EventHandler
     */
    public EventHandler() {
        this.listeners = new CopyOnWriteArrayList<>();
        this.eventQueue = new LinkedList<>();
        this.isProcessing = false;
    }
    
    /**
     * Registers an event listener
     * @param listener The listener to register
     */
    public void registerListener(EventListener listener) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener);
            System.out.println("Listener registered: " + listener.getClass().getSimpleName());
        }
    }
    
    /**
     * Unregisters an event listener
     * @param listener The listener to unregister
     */
    public void unregisterListener(EventListener listener) {
        if (listeners.remove(listener)) {
            System.out.println("Listener unregistered: " + listener.getClass().getSimpleName());
        }
    }
    
    /**
     * Publishes an event to all registered listeners
     * @param event The event to publish
     */
    public void publishEvent(Event event) {
        eventQueue.add(event);
        processEvents();
    }
    
    /**
     * Processes all queued events
     */
    private void processEvents() {
        if (isProcessing) return;
        isProcessing = true;
        
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            notifyListeners(event);
        }
        
        isProcessing = false;
    }
    
    /**
     * Notifies all listeners about an event
     * @param event The event to notify about
     */
    private void notifyListeners(Event event) {
        for (EventListener listener : listeners) {
            try {
                listener.onEventReceived(event);
            } catch (Exception e) {
                System.err.println("Error notifying listener: " + e.getMessage());
            }
        }
    }
    
    /**
     * Gets the number of registered listeners
     * @return Number of listeners
     */
    public int getListenerCount() {
        return listeners.size();
    }
    
    /**
     * Clears all listeners
     */
    public void clearListeners() {
        listeners.clear();
        System.out.println("All listeners cleared.");
    }
    
    /**
     * Interface for event listeners
     */
    public interface EventListener {
        void onEventReceived(Event event);
    }
    
    /**
     * Simple Event class
     */
    public static class Event {
        private String eventType;
        private long timestamp;
        
        public Event(String eventType) {
            this.eventType = eventType;
            this.timestamp = System.currentTimeMillis();
        }
        
        public String getEventType() { return eventType; }
        public long getTimestamp() { return timestamp; }
    }
}
