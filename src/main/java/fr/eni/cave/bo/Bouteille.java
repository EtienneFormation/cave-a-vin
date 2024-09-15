package fr.eni.cave.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor

@Entity @Table(name = "CAV_BOTTLE")
public class Bouteille {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOTTLE_ID")
	private Integer id;
	
	@Column(name = "NAME", length = 250, unique = true, nullable = false)
	private String nom;
	
	@Column(name = "SPARKLING")
	private boolean petillant;
	
	@Column(name = "VINTAGE", length = 250)
	private String millesime;
	
	@Column(name = "QUANTITY")
	private int quantite;
	
	@Column(name = "PRICE", precision = 2)
	private float prix;
	
	@ManyToOne
	@JoinColumn(name = "COULEUR_ID")
	@EqualsAndHashCode.Exclude
	private Couleur couleur;
	
	@ManyToOne
	@JoinColumn(name = "REGION_ID")
	@EqualsAndHashCode.Exclude
	private Region region;
}
