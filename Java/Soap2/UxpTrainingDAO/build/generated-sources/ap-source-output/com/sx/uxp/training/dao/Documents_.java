package com.sx.uxp.training.dao;

import com.sx.uxp.training.dao.People;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-05T08:43:16")
@StaticMetamodel(Documents.class)
public class Documents_ { 

    public static volatile SingularAttribute<Documents, String> fileName;
    public static volatile SingularAttribute<Documents, byte[]> data;
    public static volatile SingularAttribute<Documents, People> pId;
    public static volatile SingularAttribute<Documents, Integer> id;

}