package fr.eni.cave.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "pseudo" })
@ToString(of = { "pseudo", "nom", "prenom" })
@SuperBuilder

@Entity
@Table(name = "CAV_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
	@Id
	@Column(name = "LOGIN", nullable = false, length = 255)
	private String pseudo;
	
	@Column(name = "PASSWORD", nullable = false, length = 68)
	private String password;
	
	@Column(name = "LAST_NAME", nullable = false, length = 90)
	private String nom;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 150)
	private String prenom;

	@Column(name = "AUTHORITY", nullable = false, length = 15)
	private String authority;
}
