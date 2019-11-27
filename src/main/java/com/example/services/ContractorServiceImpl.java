package com.example.services;

import com.example.domain.Contractor;
import com.example.domain.DomainObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ContractorServiceImpl extends AbstractMapService implements ContractorService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Contractor getById(Integer id) {
        return (Contractor) super.getById(id);
    }

    @Override
    public Contractor saveOrUpdate(Contractor domainObject) {
        return (Contractor) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

        Contractor contractor1 = new Contractor();
        contractor1.setId(1);
        contractor1.setFirstName("Micheal");
        contractor1.setLastName("Weston");
        contractor1.setAddressLine1("1 Main St");
        contractor1.setCity("Miami");
        contractor1.setState("Florida");
        contractor1.setZipCode("33101");
        contractor1.setEmail("micheal@burnnotice.com");
        contractor1.setPhoneNumber("305.333.0101");

        Contractor contractor2 = new Contractor();
        contractor2.setId(2);
        contractor2.setFirstName("Fiona");
        contractor2.setLastName("Glenanne");
        contractor2.setAddressLine1("1 Key Biscane Ave");
        contractor2.setCity("Miami");
        contractor2.setState("Florida");
        contractor2.setZipCode("33101");
        contractor2.setEmail("fiona@burnnotice.com");
        contractor2.setPhoneNumber("305.323.0233");

        Contractor contractor3 = new Contractor();
        contractor3.setId(3);
        contractor3.setFirstName("Sam");
        contractor3.setLastName("Axe");
        contractor3.setAddressLine1("1 Little Cuba Road");
        contractor3.setCity("Miami");
        contractor3.setState("Florida");
        contractor3.setZipCode("33101");
        contractor3.setEmail("sam@burnnotice.com");
        contractor3.setPhoneNumber("305.426.9832");

        domainMap.put(1, contractor1);
        domainMap.put(2, contractor2);
        domainMap.put(3, contractor3);
    }
}
