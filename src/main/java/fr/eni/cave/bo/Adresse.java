package fr.eni.cave.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "CAV_ADDRESS")
public class Adresse {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private int id;
	
	@Column(name = "STREET", nullable = false, length = 250)
	private String rue;
	
	@Column(name = "POSTAL_CODE", nullable = false, length = 5)
	private String codePostal;
	
	@Column(name = "CITY", nullable = false, length = 150)
	private String ville;
}
