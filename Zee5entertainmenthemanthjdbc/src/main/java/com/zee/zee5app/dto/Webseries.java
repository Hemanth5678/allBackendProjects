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
public class Webseries implements Comparable<Webseries>{
	//@Setter(value = AccessLevel.NONE)
			private String id;
			//@Setter(value = AccessLevel.NONE)
			private String Name;
			//@Setter(value = AccessLevel.NONE)
			private String cast;
			private String Releasedate;
			private String trailer;
			private String language;
			private String length;
			private String Location;
			//noofepisodes
			public Webseries(String id, String Name, String cast, String Releasedate, String trailer, String language, String length, String Location) throws InvalidNameException, InvalidIdLengthException, LocationNotFoundException {
				super();
				this.setId(id);
				this.setName(Name);
				this.cast = cast;
				this.Releasedate = Releasedate;
				this.trailer = trailer;
				this.language = language;
				this.length = length;
				this.setLocation(Location);
			}
			
			public Webseries() {
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
					throw new LocationNotFoundException("Location not valid");
				}
				this.Location = Location;
				
			}

			@Override
			public int compareTo(Webseries o) {
				// TODO Auto-generated method stub
				return this.id.compareTo(o.getId());
			}
}
