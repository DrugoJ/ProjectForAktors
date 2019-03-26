package com.company.webproject.entites;

import com.company.webproject.entites.Client;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-26T16:08:05")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Client> client;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> login;

}