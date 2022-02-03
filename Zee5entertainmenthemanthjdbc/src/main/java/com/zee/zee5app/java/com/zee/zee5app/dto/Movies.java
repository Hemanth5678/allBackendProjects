package com.zee.zee5app.dto;

import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Movies implements Comparable<Movies>{
		//@Setter(value = AccessLevel.NONE)
		private String id;
		//@Setter(value = AccessLevel.NONE)
		private String Name;
		//@Setter(value = AccessLevel.NONE)
		private String agelimit;
		private String cast;
		private String genre;
		private String length;
		//private String Releasedate;
		private String trailer;
		private String Releasedate;
		private String language;
		private String Location;
		//private String agelimit;,genere
		
		public Movies(String id, String Name, String agelimit, String cast ,String genre, String length, String trailer, String Releasedate, String language) throws InvalidNameException, InvalidIdLengthException, LocationNotFoundException {
			super();
			this.setId(id);
			this.setName(Name);
			this.setAgelimit(agelimit);
			this.cast = cast;
			this.genre = genre;
			this.length = length;
			this.trailer = trailer;
			this.Releasedate = Releasedate;
			this.language = language;
		}
		
		public Movies() {
			// TODO Auto-generated constructor stub
		}	
		
		public void setName(String Name) throws InvalidNameException {
			// TODO Auto-generated method stub
			if(Name==null || Name=="" ) {
				throw new InvalidNameException("Name not valid");
			}
			this.Name = Name;
			
		}
		public void setId(String Id) throws InvalidIdLengthException {
			// TODO Auto-generated method stub
			if(Id.length()<6) {
				
				throw new InvalidIdLengthException("id length is less than or equal to 6");
			}
			this.id=Id;
			
		}
		
		public void setLocation(String Location) throws LocationNotFoundException {
			// TODO Auto-generated method stub
			if(Location==null || Location=="" ) {
				throw new LocationNotFoundException("Location not found");
			}
			this.Location = Location;
			
		}
		
		@Override
		public int compareTo(Movies o) {
			// TODO Auto-generated method stub
			return this.id.compareTo(o.getId());
		}

}
