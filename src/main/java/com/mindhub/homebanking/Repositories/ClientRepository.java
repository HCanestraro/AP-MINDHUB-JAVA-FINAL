//╔═══════════════════════════════════════════════════════════╗
//║					CHE - HOMEBANKING						  ║
//╚═══════════════════════════════════════════════════════════╝
package com.mindhub.homebanking.Repositories;

import com.mindhub.homebanking.Models.Card;
import com.mindhub.homebanking.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
	//Optional<Client> findByEmail(String email);
	Client findByEmail (String email);
	Client findByCards (Card card);
}
