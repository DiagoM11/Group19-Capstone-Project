package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService implements IService<Contact,String>{
    
    @Autowired
    private ContactRepository contactRepository;
    private String contactId;

    ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }
    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public String read(String s) {
        return String.valueOf(contactRepository.findById(contactId));
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public void delete(String contactId) {

    }

    @Override
    public List<Address> getAll() {
        return null;
    }
}