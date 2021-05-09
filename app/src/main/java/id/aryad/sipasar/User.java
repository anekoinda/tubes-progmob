package id.aryad.sipasar;

public class User {
    int idUser;
    String Username="", Password="";
    boolean Valid;

    public User(){}
    public User(int idUser, String username, String password) {
        this.idUser = idUser;
        Username = username;
        Password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isValid() {
        return Valid;
    }

    public void setValid(boolean valid) {
        Valid = valid;
    }
}
