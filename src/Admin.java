public class Admin {
    private String adminGmail;
    private String password;

    public String getAdminGmail() {
        return adminGmail;
    }

    public void setAdminGmail(String adminGmail) {
        this.adminGmail = adminGmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin() {

    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminGmail='" + adminGmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
