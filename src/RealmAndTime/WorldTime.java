package RealmAndTime;

/**
 * The type World time.
 */
public class WorldTime {
    private long totalMinutes;

    /**
     * Instantiates a new World time.
     */
    public WorldTime(){
        totalMinutes = 0;
    }

    /**
     * Add minutes to this instance of time.
     *
     * @param minutes the minutes
     */
    public void addMinutes(long minutes){
        if (minutes < 0){
            // should throw error
            return;
        }
        totalMinutes+= minutes;
    }

    /**
     * Returns the total number of days passed.
     *
     * @return minutes passed
     */
    public long toDays(){
        return totalMinutes / 1440;
    }

    /**
     * Returns the total number of hours passed.
     *
     * @return hours passed
     */
    public long toHours(){
        return totalMinutes / 60;
    }

    /**
     * Get minutes in the hour
     *
     * @return long 0-59
     */
    public long getMinutes(){
        return totalMinutes % 60;
    }
    /**
     * Get hour of the day. Assumes 24 hour date
     *
     * @return long 0-23
     */
    public long getHours(){
        return (totalMinutes / 60) % 24;
    }

}
