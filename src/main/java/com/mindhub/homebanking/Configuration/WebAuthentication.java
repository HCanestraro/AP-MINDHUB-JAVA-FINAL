package com.mindhub.homebanking.Configuration;

import com.mindhub.homebanking.Models.Client;
import com.mindhub.homebanking.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Autowired
	ClientRepository clientRepository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inputName -> {
			Client client = clientRepository.findByEmail(inputName);
			// .orElse(null);

			if (client != null) {
				if (client.getEmail().equals("admin@admin.com")) {
					//return new User(client.getEmail(), client.getPassword(), AuthorityUtils.createAuthorityList(client.getEmail().equals("admin@mindhub.com") ? "ADMIN" : "CLIENT"));
					return new User(client.getEmail(), client.getPassword(),
							AuthorityUtils.createAuthorityList("ADMIN"));
				}
				return new User(client.getEmail(), client.getPassword(),
						AuthorityUtils.createAuthorityList("USER"));

			} else {
				throw new UsernameNotFoundException("Unknown user: " + inputName);
			}
		});
	}
}