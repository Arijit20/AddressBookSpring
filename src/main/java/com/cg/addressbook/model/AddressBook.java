package com.cg.addressbook.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "addressbook_table")
public class AddressBook implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String firstName;
	private String lastNmae;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNo;
	private String email;
	
	public AddressBook() {}
	
	public AddressBook(String firstName, String lastName, String address, String city, 
			           String state, String zip, String phoneNo, String email) {
		this.firstName = firstName;
		this.lastNmae = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.email = email;
	}

}
