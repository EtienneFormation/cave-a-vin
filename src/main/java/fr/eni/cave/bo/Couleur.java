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

@Entity @Table(name = "CAV_COLOR")
public class Couleur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COLOR_ID")
	private Integer id;
	
	@Column(name = "NAME", nullable = false, length = 250, unique = true)
	private String nom;
}
