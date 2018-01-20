/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sampath1421
 */
@Entity
@Table(name = "GALLERYINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Galleryinfo.findAll", query = "SELECT g FROM Galleryinfo g")
    , @NamedQuery(name = "Galleryinfo.findByDescription", query = "SELECT g FROM Galleryinfo g WHERE g.description = :description")})
public class Galleryinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESCRIPTION")
    private String description;
    @Lob
    @Column(name = "PHOTO")
    private Serializable photo;

    public Galleryinfo() {
    }

    public Galleryinfo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Serializable getPhoto() {
        return photo;
    }

    public void setPhoto(Serializable photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (description != null ? description.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Galleryinfo)) {
            return false;
        }
        Galleryinfo other = (Galleryinfo) object;
        if ((this.description == null && other.description != null) || (this.description != null && !this.description.equals(other.description))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Galleryinfo[ description=" + description + " ]";
    }
    
}
