package com.company.webproject.entites;

import com.company.webproject.entites.Client;
import com.company.webproject.entites.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-26T16:08:05")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Date> date;
    public static volatile SingularAttribute<Order, Product> product;
    public static volatile SingularAttribute<Order, Client> client;
    public static volatile SingularAttribute<Order, Long> id;
    public static volatile SingularAttribute<Order, Integer> productprice;

}