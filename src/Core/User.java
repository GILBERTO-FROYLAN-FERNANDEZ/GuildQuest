package Core;

import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Campaign> campaigns;
    private List<RPGDomain.Character> characters;
    private UserSettings config;
    // add GUI stuff
    User(String username, String password, UserSettings config){
        this.username = username;
        this.password = password;
        this.config = config;
    }
}
