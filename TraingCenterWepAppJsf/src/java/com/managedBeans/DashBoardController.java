/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;

import com.entites.Admins;
import com.hibernate.config.HibernateConnectionManager;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author hussein
 */
@ManagedBean
@ApplicationScoped
public class DashBoardController {

    private Admins admin;

    
    @PostConstruct
    public void init() {
        admin = new Admins();
        try {
            HibernateConnectionManager.setConfigFile("hibernate.cfg.xml");
          
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Hibernate couldn't startup.."));
        }
    }
    
    
    public DashBoardController() {
    }

    public Admins getAdmin() {
        return admin;
    }

    public void setAdmin(Admins admin) {
        this.admin = admin;
    }

    

    public String authorize() {
        if (admin.getName().equals("Hussein") && admin.getPassword().equals("123")) {
            return "dashboard?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("You are not admin, sorry Un authorized"));
            return "index";
        }
    }
    
    
    public String logOut()
    {
        return "index?faces-redirect=true";
    }

}
