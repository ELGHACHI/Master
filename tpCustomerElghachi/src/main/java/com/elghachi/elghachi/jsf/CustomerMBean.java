package com.elghachi.elghachi.jsf;

import com.elghachi.elghachi.entities.Customer;
import com.elghachi.elghachi.session.CustomerManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author grin
 */
@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {
  private List<Customer> customerList;  

  @EJB
  private CustomerManager customerManager;  
        
  public CustomerMBean() {  }  
        
  /** 
   * Retourne la liste des clients pour affichage dans une DataTable 
   * @return 
   */  
  public List<Customer> getCustomers() {
    if (customerList == null) {
      customerList = customerManager.getAllCustomers();
    }
    return customerList;
  }  
}
