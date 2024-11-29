package fit.se.iuh.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import fit.se.iuh.service.impl.CustomUserDetailService;

@Configuration
public class SecurityConfig {

    private final GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;
    private final CustomUserDetailService customUserDetailService;

    public SecurityConfig(GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler, 
                          CustomUserDetailService customUserDetailService) {
        this.googleOAuth2SuccessHandler = googleOAuth2SuccessHandler;
        this.customUserDetailService = customUserDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/shop/**", "/forgotpassword", "/register", "/login","/cart", "/addToCart/**","cart/**").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/users/**").hasRole("USER")
            .requestMatchers("/resources/**", "/static/**", "/images/**", "/productImages/**", "/css/**", "/js/**").permitAll()
            .anyRequest().authenticated()
        )

            // Google authentication
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/login")
                .successHandler(googleOAuth2SuccessHandler)
            )
            // Check login
            .formLogin(form -> form
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/",true)
                .failureUrl("/login?error=true")
            )
            // Logout configuration
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
            )
            // Exception handling
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/403")
            )
            // Disable CSRF (for Thymeleaf)
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions().disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
