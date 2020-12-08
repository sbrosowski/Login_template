package com.pma.demo.services.Impl.DTO;

public class LoginDTO {
    private String user;

    private String password;

    private String resultMessage = "";

    private boolean successful;

    public LoginDTO() {

    }

    public LoginDTO(String user, String password) {
        this.user = user;
        this.password = password;
    }


    public LoginDTO(String resultMessage, boolean successful) {
        this.resultMessage = resultMessage;
        this.successful = successful;
    }


    public boolean isSuccessful() {
        return successful;
    }


    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o instanceof LoginDTO) {
            return isEqual((LoginDTO) o);
        }

        return false;
    }

    private boolean isEqual(LoginDTO o) {
        return this.password.equals(o.getPassword()) &&
                this.user.equals(o.getUser()) &&
                this.resultMessage.equals(o.getResultMessage()) && this.successful == o.isSuccessful();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
