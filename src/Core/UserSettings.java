package Core;


import RealmAndTime.Realm;
import ViewsAndTimelines.TimeDisplayMode;
import VisibilityAndSharing.ThemeType;

public class UserSettings {
    private Realm currentRealm;
    private ThemeType theme;
    private TimeDisplayMode timeDisplayMode;
    public UserSettings(Realm realm, ThemeType theme, TimeDisplayMode timeDisplayMode){
        currentRealm = realm;
        this.theme  = theme;
        this.timeDisplayMode = timeDisplayMode;
    }
    public void updateTheme(ThemeType theme){
        this.theme = theme;
    }
    public void updateTimeDisplay(TimeDisplayMode mode){
        this.timeDisplayMode = mode;
    }
    public void updateCurrentRealm(Realm realm){
        this.currentRealm = realm;
    }
}
