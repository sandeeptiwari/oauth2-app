package io.jzheaux.springsecurity.resolutions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //step -3
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a.mvcMatchers(HttpMethod.GET, "/resolutions", "/resolution/**")
                        .hasAuthority("READ")
                        .anyRequest().hasAuthority("WRITE")
                ).httpBasic();

        http.csrf().disable();
    }

    /* Step -1  @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder()
                        .username("sandeep")
                        .password("sandi")
                        .roles("USER")
                        .build()
        );
    }*/

   /* Step - 2 @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource) {

            @Override
            protected List<GrantedAuthority> loadUserAuthorities(String username) {
                return AuthorityUtils.createAuthorityList("ROLE_USER");
            }
        };

    }*/

    //Step - 3
    /*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
