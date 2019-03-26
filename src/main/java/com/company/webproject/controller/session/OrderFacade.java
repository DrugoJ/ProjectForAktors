/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.webproject.controller.session;

import com.company.webproject.entites.Order;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GoD
 */
@Stateless
public class OrderFacade extends AbstractFacade<Order> {

    @PersistenceContext(unitName = "com.company_webproject_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderFacade() {
        super(Order.class);
    }
    
}
