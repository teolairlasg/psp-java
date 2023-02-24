package cf.iesguara.testSpring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="aulas")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cod", unique = true, nullable = false)
	private String codigo;
	@Column(nullable = false)
	private String nombre;
	/* número de ordenadores del aula*/
	@Column
	private int ordenadores;
}
