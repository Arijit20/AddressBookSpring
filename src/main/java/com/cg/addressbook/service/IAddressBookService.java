package com.cg.addressbook.service;

import java.util.List;

import com.cg.addressbook.dto.AddressBookDTO;

public interface IAddressBookService {
	
	List<AddressBookDTO> getAllContacts();
	
	AddressBookDTO getContactById(Long id);
	
	AddressBookDTO createContact(AddressBookDTO addressBookDTO);
	
	AddressBookDTO updateContact(AddressBookDTO addressBookDTO);
	
	AddressBookDTO deleteContact(Long id);

}
