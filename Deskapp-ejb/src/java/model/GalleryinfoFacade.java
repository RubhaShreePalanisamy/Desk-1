/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Galleryinfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sampath1421
 */
@Stateless
public class GalleryinfoFacade extends AbstractFacade<Galleryinfo> {

    @PersistenceContext(unitName = "DeskEjb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GalleryinfoFacade() {
        super(Galleryinfo.class);
    }
    
}
