package com.pma.demo.Services.Impl.DTO;

public class UserRegistrationDTO {
    String firstName;
    String lastName;
    String username;
    String password;
    String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                this.lastName.equals(o.getLastName()) &&
                this.email == o.getEmail() &&
                this.username == o.getUsername();
    }
}
