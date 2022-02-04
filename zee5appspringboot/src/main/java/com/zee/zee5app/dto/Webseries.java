package com.zee.zee5app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

@Entity  //entity class is used for ORM
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "Name")}, name = "web")
@AllArgsConstructor
@NoArgsConstructor
public class Webseries implements Comparable<Webseries>{
	
			@Id	//it will consider this coln as PK.
			@Column(name = "webId")
			@Setter(value = AccessLevel.NONE)
			private String id;
			
			@Size(max=50)
			@NotBlank
			private String Name;
			
			@Max(value=70)
			@NotNull
			private int agelimit;
			
			@NotBlank
			private String cast;
			
			@NotBlank
			private String genre;
			
			
			@NotBlank
			private String trailer;
			
			@NotBlank
			private String Releasedate;
			
			@Size(max=50)
			@NotBlank
			private String language;
			
			@Min(value=1)
			private int noofepisodes;
			//private String Location;
			//noofepisodes
//			public Webseries(String id, String Name, int agelimit, String cast ,String genre, String trailer, Date Releasedate, String language,int noofepisodes) throws InvalidNameException, InvalidIdLengthException{
//				super();
//				this.setId(id);
//				this.setName(Name);
//				this.setAgelimit(agelimit);
//				this.cast = cast;
//				this.genre = genre;
//				//this.length = length;
//				this.trailer = trailer;
//				this.Releasedate = Releasedate;
//				this.language = language;
//				this.noofepisodes = noofepisodes;
//			}
			
//			public Webseries() {
//				// TODO Auto-generated constructor stub
//			}
//
//			public void setName(String Name) throws InvalidNameException {
//				// TODO Auto-generated method stub
//				if(Name==null || Name=="" ) {
//					throw new InvalidNameException("Name not valid");
//				}
//				this.Name = Name;
//				
//			}
//
//			public void setId(String Id) throws InvalidIdLengthException {
//				// TODO Auto-generated method stub
//				if(Id.length()<6) {
//					
//					throw new InvalidIdLengthException("id length is less than or equal to 6");
//				}
//				this.id=Id;
//				
//			}
//			


			@Override
			public int compareTo(Webseries o) {
				// TODO Auto-generated method stub
				return this.id.compareTo(o.getId());
			}
			
			@OneToMany(mappedBy = "series", cascade = CascadeType.ALL)
			private List<Episodes> episodes = new ArrayList<>();
}
