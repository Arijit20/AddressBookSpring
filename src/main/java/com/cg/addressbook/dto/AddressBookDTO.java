package com.cg.addressbook.dto;

import com.cg.addressbook.model.AddressBook;

import lombok.Data;

@Data
public class AddressBookDTO {
	
	 private Long id;
		private String firstName;
		private String lastNmae;
		private String address;
		private String city;
		private String state;
		private String zip;
		private String phoneNo;
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
