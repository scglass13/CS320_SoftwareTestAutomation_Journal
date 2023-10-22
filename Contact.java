package contact_service;

public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public String getContactID() {
		return contactID;
	}
	
	public void setContactID(String contactID) {
		// Check if contactID is null or longer than 10 characters
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID must not be null and should not exceed 10 characters.");
		}
		this.contactID = contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		// check if firstName is null or longer than 10 characters
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name must not be null and should not exceed 10 characters.");
		}
		this.firstName = firstName;
	}
	
	public String getLastName() {
        return lastName;
    }
	
	public void setLastName(String lastName) {
        // Check if lastName is null or longer than 10 characters
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must not be null and should not exceed 10 characters.");
        }
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        // Check if phone is exactly 10 digits
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits and should not be null.");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        // Check if address is null or longer than 30 characters
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and should not exceed 30 characters.");
        }
        this.address = address;
    }

}
