package com.hastatakip.aut;
import com.hastatakip.utils.GeneralTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private GeneralTools generalTools;
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    private UserDetailService userDetailsService;

    @Autowired
    public  void configurePasswordEncoder(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailsService).passwordEncoder(getBcrpytPaswordEncoder());
    }
    @Bean
    BCryptPasswordEncoder getBcrpytPaswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    AuthenticationManager getAuthenticationManager() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .authorizeRequests().antMatchers("/login/**","/UserAuthority/**").permitAll()
                .antMatchers("/Patient/save","/Doctor/**").hasAnyAuthority(generalTools.yetki("s"))
                .antMatchers(
                        "/Patient/**",
                        "/PatientDocument/**",
                        "/PatientExamination/**",
                        "/PatientNote/**",
                        "/StockPayment/**",
                        "/PageAdmin/**",
                        "/UserAuthority/**"
                ).hasAnyAuthority("Patients")
                .antMatchers("/Meeting/**").hasAnyAuthority("Meeting")
                .antMatchers("/Stock/save","/StockBrand/stockBrandCompanyGetAll/{id}","/StockModel/getAll").hasAnyAuthority("StockAdd")
                .antMatchers("/Stock/getAll","/Stock/stockGetAllCompanyId/{id}").hasAnyAuthority("StockList")
                .antMatchers("/StockBrand/**","/StockModel/**").hasAnyAuthority("DeviceOperations")
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
                /*
                //bu adres haricindekilere giriş yapılması zorunludur
                .authorizeRequests().antMatchers("/login").authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
                 */
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
