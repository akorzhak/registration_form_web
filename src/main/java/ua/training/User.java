/*
 * User
 *
 * Description: This source file is a part of the
 * web app, that provides registration form, takes input,
 * checks it for validity and records to database.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/03/22
 *
 * Updated: 2018/03/25
 */
package ua.training;

public class User {

    private String name, age, email, login, password;

    public User(String name, String age, String email, String login, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    boolean isValidName(){
        System.out.println(name);
        return name.matches("^[A-Z]{1}[a-z]+");
    }

    boolean isValidAge(){
        return age.matches("[0-9]{2}");
    }

    boolean isValidEmail(){
        return email.matches("^[\\w-_.+]*[\\w-_.]" +
                "@([\\w]+.)+[\\w]+[\\w]$");
    }

    boolean isValidLogin(){
        return login.matches("^[^\\d_][a-z\\d_]{3,10}");
    }

    boolean isValidPassword(){
        return password.matches(".{4,}");
    }

    /**
     * isValidUser method
     * Checks input data for validity.
     * @return true - if valid, false - if invalid.
     */
    boolean isValidUser() {
        return (isValidName() && isValidAge() && isValidEmail()
            && isValidLogin() && isValidPassword());
    }
}
