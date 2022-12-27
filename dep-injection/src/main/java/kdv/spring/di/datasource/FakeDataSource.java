package kdv.spring.di.datasource;

/**
 *  Just to demo setting up properties
 */
public class FakeDataSource {

    private String username;

    private String password;

    private String jdbcurl;

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

    public String getJdbcurl() {
        return jdbcurl;
    }

    public void setJdbcurl(String jdbcurl) {
        this.jdbcurl = jdbcurl;
    }

    @Override
    // this is just for demo - never output a password!
    public String toString() {
        return "FakeDataSource: {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jdbcurl='" + jdbcurl + '\'' +
                '}';
    }
}
