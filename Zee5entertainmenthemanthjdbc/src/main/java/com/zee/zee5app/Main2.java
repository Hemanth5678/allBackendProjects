package com.zee.zee5app;

import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Register;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Register register = new Register("hemu001","Hemanth","Hemanth","Hemu@gmail.com","iforgotit");
			
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println("hash code"+register.hashCode());
			
			Register register2 = new Register("hemu002","Hemanth","Hemanth","Hemu2@gmail.com","iforgotit");
			System.out.println(register2);
			System.out.println(register2.toString());
			System.out.println(register2.hashCode());
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			System.out.println("equals method call"+register.equals(register2));
			
		} catch (InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
