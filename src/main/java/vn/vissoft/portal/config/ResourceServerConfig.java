package vn.vissoft.portal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import vn.vissoft.portal.entities.Object;
import vn.vissoft.portal.services.impl.ObjectServiceImpl;

import java.util.List;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${security.oath2.resource-id}")
    private String RESOURCE_ID;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Autowired
    ObjectServiceImpl obsv;


    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new RestAuthenticationFailureHandler();
    }

    @Bean
    RestAccessDeniedHandler accessDeniedHandler() {
        return new RestAccessDeniedHandler();
    }

    @Bean
    RestAuthenticationEntryPoint authenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        List<Object> lst = obsv.getAllObjectnene();

        http.anonymous().disable()
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint());
        for (int i = 0; i < lst.size(); i++) {
            http.anonymous().disable()
                    .authorizeRequests()
                    .antMatchers(lst.get(i).getObjectUrl()).access("hasRole('" + lst.get(i).getObjectCode() + "')")
                    .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                    .authenticationEntryPoint(authenticationEntryPoint());
        }

        http.anonymous().disable()
                .authorizeRequests()
                .antMatchers("/leave/**").authenticated()

                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint());

        http.anonymous().disable()
                .authorizeRequests()
                .antMatchers("/personal/**").authenticated()

                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint());


    }
}
