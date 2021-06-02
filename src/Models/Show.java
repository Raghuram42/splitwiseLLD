package Models;

public class Show {
    private String user;
    private boolean showAllUsers;

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the showAllUsers
     */
    public boolean isShowAllUsers() {
        return showAllUsers;
    }

    /**
     * @param showAllUsers the showAllUsers to set
     */
    public void setShowAllUsers(boolean showAllUsers) {
        this.showAllUsers = showAllUsers;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.showAllUsers = false;
        this.user = user;
    }

    public Show() {
        this.showAllUsers = true;
    }

}
