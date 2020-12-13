package com.cg.addressbook.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.addressbook.dto.AddressBookDTO;
import com.cg.addressbook.exception.AddressBookException;
import com.cg.addressbook.model.AddressBook;
import com.cg.addressbook.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService{
	
	@Autowired
	private AddressBookRepository addressBookRepository;

	@Override
	public List<AddressBookDTO> getAllContacts() {
		return (List<AddressBookDTO>) addressBookRepository.findAll().stream().map(contact -> new AddressBookDTO(contact)).collect(Collectors.toList());
	}

	@Override
	public AddressBookDTO getContactById(Long id) {
		return addressBookRepository.findById(id).map(contact -> {
			return new AddressBookDTO(contact);
		}).orElseThrow(() -> new AddressBookException("Contact not found"));
	}

	@Override
	public AddressBookDTO createContact(AddressBookDTO addressBookDTO) {
		if(Objects.nonNull(addressBookDTO.getFirstName())) {
		AddressBook addressBook = new AddressBook(addressBookDTO.getFirstName(), addressBookDTO.getLastNmae(),
				  addressBookDTO.getAddress(), addressBookDTO.getCity(), addressBookDTO.getState(),
				  addressBookDTO.getZip(), addressBookDTO.getPhoneNo(), addressBookDTO.getEmail());
		return new AddressBookDTO(addressBookRepository.save(addressBook));
		}
		throw new AddressBookException("Invalid data");
	}

	@Override
	public AddressBookDTO updateContact(AddressBookDTO addressBookDTO) {
		return addressBookRepository.findById(addressBookDTO.getId()).map(contact -> {
			if(Objects.nonNull(addressBookDTO.getFirstName())) {
				contact.setFirstName(addressBookDTO.getFirstName());
			}if(Objects.nonNull(addressBookDTO.getLastNmae())) {
				contact.setLastNmae(addressBookDTO.getLastNmae());
			}if(Objects.nonNull(addressBookDTO.getAddress())) {
				contact.setAddress(addressBookDTO.getAddress());
			}if(Objects.nonNull(addressBookDTO.getCity())) {
				contact.setCity(addressBookDTO.getCity());
			}if(Objects.nonNull(addressBookDTO.getState())) {
				contact.setState(addressBookDTO.getState());
			}if(Objects.nonNull(addressBookDTO.getZip())) {
				contact.setZip(addressBookDTO.getZip());
			}if(Objects.nonNull(addressBookDTO.getPhoneNo())) {
				contact.setPhoneNo(addressBookDTO.getPhoneNo());
			}if(Objects.nonNull(addressBookDTO.getEmail())) {
				contact.setEmail(addressBookDTO.getEmail());
			}
			return new AddressBookDTO(addressBookRepository.save(contact));
		}).orElseThrow(() -> new AddressBookException("Contact not found"));
	}

	@Override
	public AddressBookDTO deleteContact(Long id) {
		return addressBookRepository.findById(id)
				.map(contact -> {addressBookRepository.deleteById(contact.getId());
				return new AddressBookDTO(contact);
		}).orElseThrow(() -> new AddressBookException("Contact not found"));
	}

}
