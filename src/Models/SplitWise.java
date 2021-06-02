package Models;

import java.util.HashMap;

public class SplitWise {
    private HashMap<String, User> splitWiseUsers;

    /**
     * @return the splitWiseUsers
     */
    public HashMap<String, User> getSplitWiseUsers() {
        return splitWiseUsers;
    }

    /**
     * @param splitWiseUsers the splitWiseUsers to set
     */
    public void setSplitWiseUsers(HashMap<String, User> splitWiseUsers) {
        this.splitWiseUsers = splitWiseUsers;
    }

}
