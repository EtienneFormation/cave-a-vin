package fr.eni.cave.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Entity @Table(name = "CAV_SHOPPING_CART")
public class Panier {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SHOPPING_CART_ID")
	private Integer id;
	
	@Column(name = "ORDER_NUMBER", length = 200)
	private String numCommande;
	
	@Column(name = "TOTAL_PRICE", precision = 2)
	private float prixTotal;
	
	@Column(name = "PAID")
	private boolean paye;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "SHOPPING_CART_ID")
	@Builder.Default
	private List<LignePanier> lignes = new ArrayList();
	
	// Association avec Client
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

}
