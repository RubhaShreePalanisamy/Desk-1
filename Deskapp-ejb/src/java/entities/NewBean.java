/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prema
 */
@Stateless

public class NewBean {

    public String Messagedisp(String msg) {
        return "result of the opertaion:"+msg;
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
