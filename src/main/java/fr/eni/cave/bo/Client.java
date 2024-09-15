package fr.eni.cave.bo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString(of = {"pseudo", "nom", "prenom"})
@EqualsAndHashCode(of = "pseudo")
@Entity
@Table(name = "CAV_CLIENT")
@Builder
public class Client {
	@Id
	@Column(name = "LOGIN", nullable = false, length = 255)
	private String pseudo;
	
	@Column(name = "PASSWORD", nullable = false, length = 68)
	private String password;
	
	@Column(name = "LAST_NAME", nullable = false, length = 98)
	private String nom;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 150)
	private String prenom;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Adresse adresse;
}
