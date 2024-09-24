package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="detalle_compra")
public class DetalleCompra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_detalle_compra")
	private Long idDetalleCompra;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="precio_unitario")
	private Double precioUnitario;
	
	// RELACIONES
	
	// Un Detalle Compra va a ser generado por una Compra
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_compra")
	private Compra compra;
	
	// Muchos Productos van a tener un Detalle Compra
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "fk_producto")
	private Producto producto;

	
}
