package com.example.services;

import com.example.domain.DomainObject;
import com.example.domain.Project;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService implements ProjectService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Project getById(Integer id) {
        return (Project) super.getById(id);
    }

    @Override
    public Project saveOrUpdate(Project domainObject) {
        return (Project) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    protected void loadDomainObjects(){
        domainMap = new HashMap<>();

        Project project1 = new Project();
        project1.setId(1);
        project1.setName("Business Logo");
        project1.setDescription(" Project 1 description");
        project1.setMaxBudget(new BigInteger("150"));
        project1.setExpires("2019-02-03 10:08");
        project1.setImageUrl("http://example.com/project1");

        domainMap.put(1, project1);

        Project project2 = new Project();
        project2.setId(2);
        project2.setName("E-commmerce site");
        project2.setDescription("Project 2 description");
        project2.setMaxBudget(new BigInteger("50"));
        project2.setExpires("2020-02-03 05:30");
        project2.setImageUrl("http://example.com/project2");

        domainMap.put(2, project2);

        Project project3 = new Project();
        project3.setId(3);
        project3.setName("Graphic design");
        project3.setDescription("Project 3 description");
        project3.setMaxBudget(new BigInteger("250"));
        project3.setExpires("2019-12-25 10:08");
        project3.setImageUrl("http://example.com/project3");

        domainMap.put(3, project3);

        Project project4 = new Project();
        project4.setId(4);
        project4.setName("Recreate Background");
        project4.setDescription("Project 4 description");
        project4.setMaxBudget(new BigInteger("300"));
        project4.setExpires("2020-02-03 06:08");
        project4.setImageUrl("http://example.com/project4");

        domainMap.put(4, project4);

        Project project5 = new Project();
        project5.setId(5);
        project5.setName("Ad for new brand");
        project5.setDescription("Project 5 description");
        project5.setMaxBudget(new BigInteger("100"));
        project5.setExpires("2020-10-03 10:40");
        project5.setImageUrl("http://example.com/project5");

        domainMap.put(5, project5);
    }
}