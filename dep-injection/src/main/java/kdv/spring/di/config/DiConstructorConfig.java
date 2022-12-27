package kdv.spring.di.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("di")
public class DiConstructorConfig {

    private final String username;
    private final String password;
    private final String jdbcurl;

    public DiConstructorConfig(String username, String password, String jdbcurl) {
        this.username = username;
        this.password = password;
        this.jdbcurl = jdbcurl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }

    @Override
    // this is just for demo - never output a password!
    public String toString() {
        return "DiConstructorConfig: {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jdbcurl='" + jdbcurl + '\'' +
                '}';
    }
}
