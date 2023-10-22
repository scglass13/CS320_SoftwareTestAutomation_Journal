package contact_service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	ContactService contactService;
	Contact contact;
	
	@BeforeEach
	void setUp() {
		contactService = new ContactService();
		contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Drive");
		
	}

	@Test
	public void testAddContact() {
		// positive case: add contact with valid data
		contactService.addContact(contact);
		assertTrue(contactService.getContacts().contains(contact));
	}
	
	@Test
	public void testDeleteContact() {
		// add a contact first
		contactService.addContact(contact);
		
		// positive case: delete an existing contact
		contactService.deleteContact(contact.getContactID());
		assertFalse(contactService.getContacts().contains(contact));
		
		// negative case: deleting a non-existent contact should throw an exception
		assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("nonexistent ID"));
	}
	
	@Test
	public void testUpdateContact() {
		// add a contact first
		contactService.addContact(contact);;
		
		// positive case: Update contact fields
		contactService.updateContact(contact.getContactID(), "Jane", "Smith", "9876543210", "456 Elm St");
		Contact updatedContact = contactService.getContacts().get(0);
		assertEquals("Jane", updatedContact.getFirstName());
		assertEquals("Smith", updatedContact.getLastName());
		assertEquals("9876543210", updatedContact.getPhone());
		assertEquals("456 Elm St", updatedContact.getAddress());
	
		// negative case: updating a non-existing contact should throw an exception
		assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("nonexistent ID", "Jane", "Smith", "9876543210", "456 Elm St"));
	}
}
