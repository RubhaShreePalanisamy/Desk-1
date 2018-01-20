/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Notesinfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sampath1421
 */
@Stateless
public class NotesinfoFacade extends AbstractFacade<Notesinfo> {

    @PersistenceContext(unitName = "DeskEjb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotesinfoFacade() {
        super(Notesinfo.class);
    }
    
}
