package Models;

import java.util.HashMap;

public class Expense {
    private String paidUser;
    private Double amount;
    private int noOfOwedUsers;
    HashMap<String, Double> userOwedAmounts;
    private String ExpenseType;

    public HashMap<String, Double> getuserOwedAmounts() {
        return userOwedAmounts;
    }

    public void getuserOwedAmounts(HashMap<String, Double> userOwedAmounts) {
        this.userOwedAmounts = userOwedAmounts;
    }

    /**
     * @return the paidUser
     */
    public String getPaidUser() {
        return paidUser;
    }

    /**
     * @return the expenseType
     */
    public String getExpenseType() {
        return ExpenseType;
    }

    /**
     * @param expenseType the expenseType to set
     */
    public void setExpenseType(String expenseType) {
        this.ExpenseType = expenseType;
    }

    /**
     * @return the noOfOwedUsers
     */
    public int getNoOfOwedUsers() {
        return noOfOwedUsers;
    }

    /**
     * @param noOfOwedUsers the noOfOwedUsers to set
     */
    public void setNoOfOwedUsers(int noOfOwedUsers) {
        this.noOfOwedUsers = noOfOwedUsers;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @param paidUser the paidUser to set
     */
    public void setPaidUser(String paidUser) {
        this.paidUser = paidUser;
    }

}
