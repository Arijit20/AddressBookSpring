package com.cg.addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.cg.addressbook.model.AddressBook;

import lombok.Data;

@Data
public class AddressBookDTO {
	
	    private Long id;
	    
	    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Incorrect First Name")
		private String firstName;
	    
	    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Incorrect Last Name")
		private String lastNmae;
	    
	    @NotEmpty(message = "Address cant be empty")
		private String address;
	    
	    @NotEmpty(message = "City cant be empty")
		private String city;
	    
	    @NotEmpty(message = "state cant be empty")
		private String state;
		
		@Pattern(regexp = "^([0-9]*){6}$", message = "Incorrect zip")
		private String zip;
		
		@Pattern(regexp = "^\\d{2} [1-9]\\d{9}$", message = "Incorrect Phone no")
		private String phoneNo;
		
		@Pattern(regexp = "^([a-z]){1,}[a-z0-9]*([.+_-]){0,1}[0-9a-z]+(@){1}([0-9a-z]+)(\\.([a-z]){2,}){1}(\\.[a-z]{2,})?$", message = "Incorrect Email ID")
		private String email;
		
		public AddressBookDTO() {}
		
		public AddressBookDTO(AddressBook addressBook) {
			this.id = addressBook.getId();
			this.firstName = addressBook.getFirstName();
			this.lastNmae = addressBook.getLastNmae();
			this.address = addressBook.getAddress();
			this.city = addressBook.getCity();
			this.state = addressBook.getState();
			this.zip = addressBook.getZip();
			this.phoneNo = addressBook.getPhoneNo();
			this.email = addressBook.getEmail();
		}

}
