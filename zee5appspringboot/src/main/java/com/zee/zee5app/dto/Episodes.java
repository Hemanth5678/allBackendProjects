package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
//@EqualsAndHashCode
//@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "episodeName")}, name = "episodes")
public class Episodes implements Comparable<Movies> {
	
	@Id
	@Column(name = "id")
	@Length(min = 4)
	private String id;
	
	@NotBlank
	private String episodeName;
	private int length;
	
	private String trailer;

	@Override
	public int compareTo(Movies o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	
	@ManyToOne
	//this episode table should have a FK
	@JoinColumn(name = "webId")
	private Webseries series; //this should take seriesId and that should act as foreign key
	

}