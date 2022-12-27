package kdv.spring.di.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("di")  // find properties with di.  and bind them to fields based on names
public class DiConfiguration {

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
        return "DiConfiguration: {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jdbcurl='" + jdbcurl + '\'' +
                '}';
    }
}
