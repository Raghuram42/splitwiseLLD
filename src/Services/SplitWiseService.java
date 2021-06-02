package Services;

import java.util.HashMap;

import Models.SplitWise;
import Models.User;
import Utitlity.Round;

public class SplitWiseService {
    private SplitWise splitwise;

    /**
     * @return the splitwise
     */
    public SplitWise getSplitwise() {
        return splitwise;
    }

    /**
     * @param splitwise the splitwise to set
     */
    public void setSplitwise(SplitWise splitwise) {
        this.splitwise = splitwise;
    }

    public SplitWiseService() {
        setSplitwise(new SplitWise());
        this.splitwise.setSplitWiseUsers(new HashMap<String, User>());
    }

    public void setUsers(HashMap<String, User> splitWiseUsers) {
        this.splitwise.setSplitWiseUsers(splitWiseUsers);
    }

    public void expense(String paidUser, HashMap<String, Double> owedUsers) {
        expenseMadeWithSplitType(paidUser, owedUsers);

    }

    public void expenseMadeWithSplitType(String paidUser, HashMap<String, Double> owedUsers) {

        HashMap<String, User> splitWiseUsers = this.splitwise.getSplitWiseUsers();
        if (!splitWiseUsers.containsKey(paidUser))
            splitWiseUsers.put(paidUser, new User(paidUser));
        for (String ownedUser : owedUsers.keySet()) {
            if (!splitWiseUsers.containsKey(ownedUser))
                splitWiseUsers.put(ownedUser, new User(ownedUser));
            if (splitWiseUsers.get(ownedUser).getOwedUsers().containsKey(paidUser)) {
                Double amountLeftover = splitWiseUsers.get(ownedUser).getOwedUsers().get(paidUser).getTotalbalance()
                        - owedUsers.get(ownedUser);

                if (amountLeftover < 0) {
                    splitWiseUsers.get(ownedUser).getOwedUsers().remove(paidUser);
                    updateAmountLeftOverOfOwnedUser(paidUser, ownedUser, -amountLeftover);
                } else {
                    updateAmountLeftOverOfOwnedUser(ownedUser, paidUser, -owedUsers.get(ownedUser));
                }
            } else if (!paidUser.equals(ownedUser)) {
                updateAmountLeftOverOfOwnedUser(paidUser, ownedUser, owedUsers.get(ownedUser));
            }
        }
        // System.out.print(paidUser + " " + owedUsers);
    }

    public void updateAmountLeftOverOfOwnedUser(String paiduser, String owedUser, Double amount) {
        HashMap<String, User> splitWiseUsers = this.splitwise.getSplitWiseUsers();
        if (!splitWiseUsers.get(paiduser).getOwedUsers().containsKey(owedUser))
            splitWiseUsers.get(paiduser).getOwedUsers().put(owedUser, new User(owedUser));
        Double currBalance = splitWiseUsers.get(paiduser).getOwedUsers().get(owedUser).getTotalbalance();
        splitWiseUsers.get(paiduser).getOwedUsers().get(owedUser).setTotalbalance(Round.round(amount + currBalance));
    }

    public void show(String user) {
        boolean hasBalance = false;
        HashMap<String, User> splitWiseUsers = this.splitwise.getSplitWiseUsers();
        if (user == null) {
            for (String u : splitWiseUsers.keySet()) {
                User currUser = splitWiseUsers.get(u);
                // System.out.print(u + " " + currUser.getOwedUsers().keySet());
                for (String owedUser : currUser.getOwedUsers().keySet()) {
                    System.out.println(
                            owedUser + " owes " + u + " " + currUser.getOwedUsers().get(owedUser).getTotalbalance());
                    hasBalance = true;
                }
            }
        } else if (splitWiseUsers.containsKey(user)) {
            for (String owedUser : splitWiseUsers.get(user).getOwedUsers().keySet()) {
                System.out.println(owedUser + " owes " + user + " "
                        + splitWiseUsers.get(user).getOwedUsers().get(owedUser).getTotalbalance());
                hasBalance = true;
            }
        }
        if (!hasBalance)
            System.out.println("no balances");
    }
}
/// Done upto paid user