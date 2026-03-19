package RealmAndTime;

/**
 * The type World time.
 */
public class WorldTime implements Comparable<WorldTime>{
    private long totalMinutes;

    /**
     * Instantiates a new World time.
     */
    public WorldTime(int mins, int hours, int days){
        if (mins < 0 || hours < 0 || days < 0 ||
                mins > 59 || hours > 23){
            throw new NumberFormatException("numbers must be within the correct bounds");
        }
        totalMinutes = mins+hours*60 + days*1440L;
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

    @Override
    public int compareTo(WorldTime w) {
        return Long.compare(totalMinutes, w.totalMinutes);
    }

    @Override
    public String toString(){
        return "Day: %2d Time: %2d:%2d".formatted(toDays(), getHours(), getMinutes());
    }
}
