package mvc.project.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "datasource.mentoring")
public class MentoringDataConfig extends HikariConfig {
    @Bean
    @FlywayDataSource
    public DataSource mentoringDataSource(){
        return new HikariDataSource(this);
    }
}
