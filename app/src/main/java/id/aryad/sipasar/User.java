package id.aryad.sipasar;

public class User {
    int id_admin;
    int id_pegawai;
    String username;
    String password;
    AdminRole role;
    // 1 aktif, 0 nonaktif
    int status;

    public User(int id_admin, int id_pegawai, String username, String password, AdminRole role, int status) {
        this.id_admin = id_admin;
        this.id_pegawai = id_pegawai;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public AdminRole getRole() {
        return role;
    }

    public int getStatus() {
        return status;
    }
}
