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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@EqualsAndHashCode(of = "id")
@Builder
@Entity @Table(name = "CAV_LINE")
public class LignePanier {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LINE_ID")
	private int id;
	
	@Column(name = "QUANTITY")
	private int qte_commande;
	
	@Column(name = "PRICE", precision = 2)
	private float prix;
	
	@ManyToOne
	@JoinColumn(name = "BOTTLE_ID")
	private Bouteille bouteille;
}
