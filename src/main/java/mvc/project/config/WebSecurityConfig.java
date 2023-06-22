package mvc.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/auth")
                        .permitAll()
                        .defaultSuccessUrl("/admin/home", true)
                        .failureUrl("/auth?error")

                )
                .logout((logout) -> logout
                        .logoutUrl("/auth?logout").permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService adminDetailsService() {
        UserDetails admin =
                User.builder()
                        .username("adm")
                        .password("{bcrypt}$2a$12$0pSesoQ5L8aKCmSvmd8GLOazeV17nAsdBNSHPdTZKtDtesAmTq9gW")//pass
                        .roles("ADMIN")
                        .build();
        UserDetails user =
                User.builder()
                        .username("us")
                        .password("{bcrypt}$2a$12$0pSesoQ5L8aKCmSvmd8GLOazeV17nAsdBNSHPdTZKtDtesAmTq9gW")//pass
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
