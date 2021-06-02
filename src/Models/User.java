package Models;

import java.util.HashMap;

public class User {
    private String userName;

    private Double totalbalance;
    private HashMap<String, User> owedUsers;

    /**
     * @param userName
     */
    public User(String userName) {
        this.userName = userName;
        setOwedUsers(new HashMap<String, User>());
        this.totalbalance = 0d;
    }

    /**
     * @return the owedUsers
     */
    public HashMap<String, User> getOwedUsers() {
        return owedUsers;
    }

    /**
     * @param owedUsers the owedUsers to set
     */
    public void setOwedUsers(HashMap<String, User> owedUsers) {
        this.owedUsers = owedUsers;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the totalbalance
     */
    public Double getTotalbalance() {
        return totalbalance;
    }

    /**
     * @param totalbalance the totalbalance to set
     */
    public void setTotalbalance(Double totalbalance) {
        this.totalbalance = totalbalance;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
