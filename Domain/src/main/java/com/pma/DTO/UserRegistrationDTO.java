package com.pma.DTO;

public class UserRegistrationDTO {
    String firstName;
    String surname;
    String username;
    String password;
    String passwordConfirmation;
    String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o instanceof UserRegistrationDTO) {
            return isEqual((UserRegistrationDTO) o);
        }

        return false;
    }

    private boolean isEqual(UserRegistrationDTO o) {
        return this.password.equals(o.getPassword()) &&
                this.firstName.equals(o.getFirstName()) &&
                this.surname.equals(o.getSurname()) &&
                this.email.equals(o.getEmail()) &&
                this.username.equals(o.getUsername()) &&
                this.passwordConfirmation.equals(o.getPasswordConfirmation());
    }
}
