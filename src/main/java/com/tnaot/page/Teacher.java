package com.tnaot.page;

/**
 * @author Susanna
 * @date 2020/8/28 8:56
 */
public class Teacher {
    @Override
    public String toString() {
        return "Teacher{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    /**
     * userName : oven
     * userId : 1234567
     */

    private String userName;
    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
