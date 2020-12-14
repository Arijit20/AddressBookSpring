package com.cg.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.addressbook.dto.AddressBookDTO;
import com.cg.addressbook.exception.AddressBookException;
import com.cg.addressbook.service.IAddressBookService;

@RestController
public class AddressBookController {
	
	@Autowired
	private IAddressBookService addressBookService;
	
	@GetMapping("/get")
	public ResponseEntity<List<AddressBookDTO>> getAllContacts(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(addressBookService.getAllContacts());
		}catch(AddressBookException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AddressBookDTO> getUserById(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(addressBookService.getContactById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<AddressBookDTO> createContact(@Valid @RequestBody AddressBookDTO addressBookDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(addressBookService.createContact(addressBookDTO));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<AddressBookDTO> updateContact(@Valid @RequestBody AddressBookDTO addressBookDTO){
		return ResponseEntity.status(HttpStatus.OK).body(addressBookService.updateContact(addressBookDTO));
	}
 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AddressBookDTO> deleteContact(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(addressBookService.deleteContact(id));
	}
}
