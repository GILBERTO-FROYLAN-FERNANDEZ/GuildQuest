package ViewsAndTimelines;

import Core.Campaign;

/**
 * The type Timeline view.
 */
public abstract class TimelineView {
    private Campaign campaign;

    /**
     * interpret time ranges in World Clock units
     */
    abstract public void display();
}
