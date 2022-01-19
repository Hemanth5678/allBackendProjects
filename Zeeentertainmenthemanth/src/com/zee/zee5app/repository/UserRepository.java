package com.zee.zee5app.repository;
import com.zee.zee5app.dto.Register;

public class UserRepository {

		private Register[] registers = new Register[10];
		private static int count = -1;
		private UserRepository() {
			
		}
		//registers=array, register= data entry.
		public Register[] getUsers(){
			return registers;
		}
		
		public Register getUserById(String Id) {
			
			for (Register register : registers) {
				if(register!=null && register.getId().equals(Id)) {
					return register;
				}
			}
			return null;
		}
		
		private static int count2=0;
		public String deleteUser(String id) {
			
			for (Register register1 : registers) {
				if(register1!=null && register1.getId().equals(id)) {
					while(count2<count)
					{
						registers[count2]=registers[count2+1];
						count2++;
					}
					registers[count]=null;
					return "Deleted "+register1.getId()+" successfully";
				}
				++count2;
				}
			return "not found";
		}// assignment
		
		//assignment
		private static int count1=0;
		public String updateUser(String id, Register register) {     //assignment
			for (Register register1 : registers) {
				if(register1!=null && register1.getId().equals(id)) {
					registers[count1]=register;
					return "Updated "+register1.getId() +" successfully";
				}
				++count1;
				}
			return "couldnt update";
		}
		//assignment//
		
		public String addUser(Register register) {
			if(count==registers.length-1) {
				Register temp[] = new Register[registers.length*2];
				System.arraycopy(registers, 0, temp, 0, registers.length);
				registers=temp;
				registers[++count]=register;
				return "successssssssss";
			}
			registers[++count]= register;
			return "success";
		}
		
		private static UserRepository userRepository;
		public static UserRepository getInstance() {
			if(userRepository==null)
				userRepository = new UserRepository();
			return userRepository;
		}
}
