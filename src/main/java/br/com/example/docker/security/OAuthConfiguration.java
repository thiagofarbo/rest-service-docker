package br.com.example.docker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import br.com.example.docker.service.CustomerDetailsService;

@Configuration
@EnableResourceServer
public class OAuthConfiguration extends ResourceServerConfigurerAdapter{
	
	public static final String RESOURCE_ID = "restservice";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID);
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) {
		try {
			httpSecurity.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.and().authorizeRequests()
			.anyRequest().fullyAuthenticated()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Configuration
	@EnableAuthorizationServer
	public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
		
		private TokenStore tokenStore = new InMemoryTokenStore();
		
		
		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private CustomerDetailsService customerDetailsService;
		
		@Autowired
		private PasswordEncoder passwordEncoder;
		
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
			endpoints.tokenStore(this.tokenStore)
			.authenticationManager(this.authenticationManager)
			.userDetailsService(customerDetailsService);
		}
		
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) {
			try {
				clients.inMemory()
				.withClient("client")
				.authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("all")
				.refreshTokenValiditySeconds(30000)
				.resourceIds(RESOURCE_ID)
				.secret(passwordEncoder.encode("123"))
				.accessTokenValiditySeconds(50000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Bean
		@Primary
		public DefaultTokenServices tokenService() {
			
			DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
			defaultTokenServices.setSupportRefreshToken(true);
			defaultTokenServices.setTokenStore(this.tokenStore);
			
			return defaultTokenServices;
		}
	}
}