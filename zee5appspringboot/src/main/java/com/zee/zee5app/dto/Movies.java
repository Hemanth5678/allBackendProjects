package com.zee.zee5app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "Name")}, name = "mov")
@AllArgsConstructor
@NoArgsConstructor
public class Movies implements Comparable<Movies>{
	
		@Id	//it will consider this coln as PK.
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "movId")
		private String id;
		
		@Size(max=50)
		@NotBlank
		//@Setter(value = AccessLevel.NONE)
		private String name;
		//@Setter(value = AccessLevel.NONE)
		
		@Max(value=70)
		@NotNull
		private int agelimit;
		
		@NotBlank
		private String cast;
		
		@NotBlank
		private String genre;
		
		
//		@Lob  //Lob: Last object binary
//		private byte[] trailer;
		private String trailer;
		
		//@NotNull
		private String Releasedate;
		
		@NotBlank
		private String language;
		//private String agelimit;,genere
		
//		public Movies(String id, String Name, String agelimit, String cast ,String genre, String length, String trailer, Date Releasedate, String language) throws InvalidNameException, InvalidIdLengthException, LocationNotFoundException {
//			super();
//			this.setId(id);
//			this.setName(Name);
//			this.setAgelimit(agelimit);
//			this.cast = cast;
//			this.genre = genre;
//			this.length = length;
//			this.trailer = trailer;
//			this.Releasedate = Releasedate;
//			this.language = language;
//		}
//		
//		public Movies() {
//			// TODO Auto-generated constructor stub
//		}	
//		
//		public void setName(String Name) throws InvalidNameException {
//			// TODO Auto-generated method stub
//			if(Name==null || Name=="" ) {
//				throw new InvalidNameException("Name not valid");
//			}
//			this.Name = Name;
//			
//		}
//		public void setId(String Id) throws InvalidIdLengthException {
//			// TODO Auto-generated method stub
//			if(Id.length()<6) {
//				
//				throw new InvalidIdLengthException("id length is less than or equal to 6");
//			}
//			this.id=Id;
//			
//		}
//		
//		public void setLocation(String Location) throws LocationNotFoundException {
//			// TODO Auto-generated method stub
//			if(Location==null || Location=="" ) {
//				throw new LocationNotFoundException("Location not found");
//			}
//			this.Location = Location;
//			
//		}
		
		@Override
		public int compareTo(Movies o) {
			// TODO Auto-generated method stub
			return this.id.compareTo(o.getId());
		}

}
