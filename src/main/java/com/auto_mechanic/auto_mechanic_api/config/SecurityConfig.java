package com.auto_mechanic.auto_mechanic_api.config;

import com.auto_mechanic.auto_mechanic_api.security.jwt.AuthEntryPointJwt;
import com.auto_mechanic.auto_mechanic_api.security.jwt.AuthTokenFilter;
import com.auto_mechanic.auto_mechanic_api.security.auth.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsServiceImpl userDetailsService;

	private final AuthEntryPointJwt unauthorizedHandler;

	@Autowired
	public SecurityConfig(UserDetailsServiceImpl userDetailsService, AuthEntryPointJwt unauthorizedHandler) {
		super();
		this.userDetailsService = userDetailsService;
		this.unauthorizedHandler = unauthorizedHandler;
	}

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests()
				.antMatchers(HttpMethod.GET ,"/api/repair_booking/view/**").permitAll()
				.antMatchers(HttpMethod.GET ,"/api/**").authenticated()
				.antMatchers(HttpMethod.POST ,"/api/**").authenticated()
				.antMatchers(HttpMethod.DELETE ,"/api/**").authenticated()
				.antMatchers(HttpMethod.PUT ,"/api/**").authenticated()
				.antMatchers(HttpMethod.GET ,"/user/**").authenticated()
				.antMatchers(HttpMethod.POST ,"/user/**").authenticated()
				.antMatchers(HttpMethod.DELETE ,"/user/**").authenticated()
				.antMatchers(HttpMethod.PUT ,"/user/**").authenticated()
				.antMatchers(HttpMethod.GET ,"/image/**").authenticated()
				.antMatchers(HttpMethod.POST ,"/image/**").authenticated()
				.antMatchers(HttpMethod.DELETE ,"/image/**").authenticated()
				.antMatchers(HttpMethod.PUT ,"/image/**").authenticated()
				.antMatchers("/auth/**").permitAll()
				.anyRequest().permitAll();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}