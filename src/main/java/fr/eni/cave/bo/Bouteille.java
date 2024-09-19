package fr.eni.cave.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@NotBlank(message = "{bouteille.nom.notblank}")
	@Size(max = 250, message = "{bouteille.nom.size}")
	private String nom;
	
	@Column(name = "SPARKLING")
	private boolean petillant;
	
	@Column(name = "VINTAGE", length = 250)
	@Size(max = 250, message = "{bouteille.millesime.size}")
	private String millesime;
	
	@Column(name = "QUANTITY")
	@Min(value = 1, message = "{bouteille.quantite.min}")
	private int quantite;
	
	@Column(name = "PRICE", precision = 2)
	@Min(value = 1, message = "{bouteille.prix.min}")
	private float prix;
	
	@ManyToOne
	@JoinColumn(name = "COULEUR_ID")
	@NotNull(message = "{bouteille.couleur.notnull}")
	@EqualsAndHashCode.Exclude
	private Couleur couleur;
	
	@ManyToOne
	@JoinColumn(name = "REGION_ID")
	@NotNull(message = "{bouteille.region.notnull}")
	@EqualsAndHashCode.Exclude
	private Region region;
}
