/**
 * 
 */
package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Collaborateur;


public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	/** Methods
	 * @param nom
	 * @return
	 */
	Collaborateur findByNom(String nom);

}
