/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.webproject.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GoD
 */
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barCode;
    private String name;
    private int basePrice;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;

    public Product() {
    }

    public Product(Long barCode, String name, int basePrice, String description, Date releaseDate) {
        this.barCode = barCode;
        this.name = name;
        this.basePrice = basePrice;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public Long getBarCode() {
        return barCode;
    }

    public void setBarCode(Long barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.barCode);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.basePrice;
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.releaseDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.basePrice != other.basePrice) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.barCode, other.barCode)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "barCode=" + barCode + ", name=" + name + ", basePrice=" + basePrice + ", description=" + description + ", releaseDate=" + releaseDate + '}';
    }

    
    
}
