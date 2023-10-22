package contact_service;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
	private List<Contact> contacts;
	
	public ContactService() {
		this.contacts = new ArrayList<>();
	}
	
	// add a contact with a unique ID
	public void addContact(Contact contact) {
		// check if the contact ID is already in use
		if (getContactByID(contact.getContactID()) != null) {
			throw new IllegalArgumentException("Contact ID must be unique.");
		}
		
		// add the contact to the list
		contacts.add(contact);
	}
	
	// delete contact by ID
	public void deleteContact(String contactID) {
		// find the contact by ID
		Contact contactToRemove = getContactByID(contactID);
		
		// check if the contact exists
		if (contactToRemove == null) {
			throw new IllegalArgumentException("Contact not found.");
		}
		
		// remove the contact from the list
		contacts.remove(contactToRemove);
	}
	
	// update contact fields by contact ID
	public void updateContact(String contactID, String newFirstName, String newLastName, String newPhone, String newAddress) {
		// find the contact by ID
		Contact contactToUpdate = getContactByID(contactID);
		
		// check if the contact exists
		if (contactToUpdate == null) {
			throw new IllegalArgumentException("Contact not found.");
		}
		
		// update the contact fields if provided
		if (newFirstName != null) {
			contactToUpdate.setFirstName(newFirstName);
		}
		if (newLastName != null) {
			contactToUpdate.setLastName(newLastName);
		}
		if (newPhone != null) {
			contactToUpdate.setPhone(newPhone);
		}
		if (newAddress != null) {
			contactToUpdate.setAddress(newAddress);
		}
	}
	
	// helper method to find contact by ID
	Contact getContactByID(String contactID) {
		for (Contact contact : contacts) {
			if (contact.getContactID().equals(contactID)) {
				return contact;
			}
		}
		return null; // contact not found
	}
	
	// getter to access list of contacts
	public List<Contact> getContacts() {
		return contacts;
	}
}
