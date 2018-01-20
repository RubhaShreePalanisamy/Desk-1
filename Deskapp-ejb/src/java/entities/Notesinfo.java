/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sampath1421
 */
@Entity
@Table(name = "NOTESINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notesinfo.findAll", query = "SELECT n FROM Notesinfo n")
    , @NamedQuery(name = "Notesinfo.findByTitle", query = "SELECT n FROM Notesinfo n WHERE n.title = :title")
    , @NamedQuery(name = "Notesinfo.findByDescription", query = "SELECT n FROM Notesinfo n WHERE n.description = :description")
    , @NamedQuery(name = "Notesinfo.findByPriority", query = "SELECT n FROM Notesinfo n WHERE n.priority = :priority")
    , @NamedQuery(name = "Notesinfo.findByCreateon", query = "SELECT n FROM Notesinfo n WHERE n.createon = :createon")})
public class Notesinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 30)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 30)
    @Column(name = "PRIORITY")
    private String priority;
    @Column(name = "CREATEON")
    @Temporal(TemporalType.DATE)
    private Date createon;

    public Notesinfo() {
    }

    public Notesinfo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getCreateon() {
        return createon;
    }

    public void setCreateon(Date createon) {
        this.createon = createon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (title != null ? title.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notesinfo)) {
            return false;
        }
        Notesinfo other = (Notesinfo) object;
        if ((this.title == null && other.title != null) || (this.title != null && !this.title.equals(other.title))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Notesinfo[ title=" + title + " ]";
    }
    
}
