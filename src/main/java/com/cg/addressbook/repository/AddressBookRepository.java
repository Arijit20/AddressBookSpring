package com.cg.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.addressbook.model.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long>{

}
