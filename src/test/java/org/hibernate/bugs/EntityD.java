package org.hibernate.bugs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTITY_D")
public class EntityD {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;

	@JoinColumn(name = "ENTITY_E")
	@ManyToOne
	@Fetch(FetchMode.SELECT)
	EntityE entityE;

	@JoinColumn(name = "OPENING_B")
	@ManyToOne
	EntityB openingB;

	@JoinColumn(name = "CLOSING_B")
	@ManyToOne
	EntityB closingB;

	@OneToMany(mappedBy = "entityD")
	List<EntityB> listOfEntitiesB = new ArrayList<>();
}