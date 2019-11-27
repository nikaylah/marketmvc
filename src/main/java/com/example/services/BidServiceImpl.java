package com.example.services;

import com.example.domain.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.domain.Bid;
import com.example.domain.DomainObject;
import java.math.BigInteger;
import com.example.domain.Project;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
@Service
public class BidServiceImpl extends AbstractMapService implements BidService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

//    public List<DomainObject> showMin(){
//        Comparator<Bid> comparator = Comparator.comparing( Bid::getBidAmount);
//        Bid minObject = bid.stream().min(comparator).get();
//        return minObject.getById(id);
//    }

    @Override
    public Bid getById(Integer id) {
        return (Bid) super.getById(id);
    }

    @Override
    public Bid saveOrUpdate(Bid domainObject) {
        return (Bid) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }



    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

        Bid bid1 = new Bid();
        bid1.setId(1);
        bid1.setName("Bid One");
        bid1.setBidAmount(new BigInteger("100"));


        domainMap.put(1, (DomainObject) bid1);



    }
}
