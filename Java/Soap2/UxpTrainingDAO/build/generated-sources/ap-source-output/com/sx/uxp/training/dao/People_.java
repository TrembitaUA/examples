package com.sx.uxp.training.dao;

import com.sx.uxp.training.dao.Documents;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-04T18:31:05")
@StaticMetamodel(People.class)
public class People_ { 

    public static volatile CollectionAttribute<People, Documents> documentsCollection;
    public static volatile SingularAttribute<People, String> firstname;
    public static volatile SingularAttribute<People, String> patronymic;
    public static volatile SingularAttribute<People, Date> birthdate;
    public static volatile SingularAttribute<People, String> passportNum;
    public static volatile SingularAttribute<People, String> surname;
    public static volatile SingularAttribute<People, String> inn;
    public static volatile SingularAttribute<People, String> passportSer;
    public static volatile SingularAttribute<People, Integer> id;

}