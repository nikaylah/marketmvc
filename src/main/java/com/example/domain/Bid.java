package com.example.domain;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Version;
import java.math.BigInteger;
import com.example.domain.Contractor;

@Entity
public class Bid implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String name;
    private BigInteger bidAmount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigInteger bidAmount) {
        this.bidAmount = bidAmount;
    }
}
