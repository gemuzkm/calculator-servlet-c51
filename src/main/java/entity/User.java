package entity;

public class User {
    private String name;
    private String login;
    private String password;
    private String sessionID;
    private int role = 1; //default Role = USER

    public User() {
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password, String sessionID) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.sessionID = sessionID;
    }

    public User(String name, String login, String password, int role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String name, String login, String password, String sessionID, int role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.sessionID = sessionID;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
