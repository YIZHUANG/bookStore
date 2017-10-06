package fi.haagahelia.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class Websecurity extends WebSecurityConfigurerAdapter {
@Override
protected void configure(HttpSecurity http) throws Exception{
	http
	.authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
    .and()
    .authorizeRequests()
	.antMatchers("/","/AddBook","/BookList","/editBook","delete/{id}").permitAll()
	.anyRequest()
	.authenticated()
	.and()
	.formLogin()
	.loginPage("/login")
	.defaultSuccessUrl("/BookList")
	.permitAll()
	.and()
	.logout()
	.permitAll();}

@Autowired
public void configuration(AuthenticationManagerBuilder auth) throws  Exception{
	auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
	.withUser("admin").password("password").roles("USER","ADMIN");
	
	
}
}
