package com.devfactory.tpmis.auth.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableOAuth2Sso
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and().authorizeRequests().antMatchers("/**").authenticated().anyRequest().authenticated()
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
        .logoutSuccessUrl("/").deleteCookies("JSESSIONID").invalidateHttpSession(true);
  }
}
