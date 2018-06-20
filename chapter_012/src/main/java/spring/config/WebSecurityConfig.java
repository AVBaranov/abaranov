package spring.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
         .withUser("user").password("1").roles("USER")
         .and()
         .withUser("admin").password("1").roles("ADMIN");
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .and()
              .httpBasic()
              .and()
              .csrf().disable();
   }
}
