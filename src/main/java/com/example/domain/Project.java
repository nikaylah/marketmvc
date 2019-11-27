package com.example.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//jdbc:h2:mem:testdb
@Entity
public class Project implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version //helpful for not losing updates, great practice
    private Integer version; //optimisic blocking

    private String name;
    private String description;
    private BigInteger maxBudget;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String expires;
    private String imageUrl;


    //Alt insert
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public BigInteger getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(BigInteger maxBudget) {
        this.maxBudget = maxBudget;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
