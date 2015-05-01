package models;

import java.sql.Date;

/**
 * Created by Szymon on 2015-04-26.
 */
public class RegisterRequest {

    private String username;
    private String password;
    private boolean male;
    private Date dateOfBirth;
    private int weight;
    private int height;

    public RegisterRequest() {

    }

    public RegisterRequest(String username, String password, boolean male, Date dateOfBirth, int weight, int height) {
        this.username = username;
        this.password = password;
        this.male = male;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
