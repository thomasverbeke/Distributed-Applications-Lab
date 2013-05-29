/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopapplication1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author thomasverbeke
 */
@Entity
@Table(name = "jt_deelnemers", catalog = "a11_SD111", schema = "db_owner")
@NamedQueries({
    @NamedQuery(name = "JtDeelnemers.findAll", query = "SELECT j FROM JtDeelnemers j"),
    @NamedQuery(name = "JtDeelnemers.findById", query = "SELECT j FROM JtDeelnemers j WHERE j.id = :id"),
    @NamedQuery(name = "JtDeelnemers.findByNaam", query = "SELECT j FROM JtDeelnemers j WHERE j.naam = :naam"),
    @NamedQuery(name = "JtDeelnemers.findByVoornaam", query = "SELECT j FROM JtDeelnemers j WHERE j.voornaam = :voornaam"),
    @NamedQuery(name = "JtDeelnemers.findByGeboortedatum", query = "SELECT j FROM JtDeelnemers j WHERE j.geboortedatum = :geboortedatum"),
    @NamedQuery(name = "JtDeelnemers.findByNationaliteit", query = "SELECT j FROM JtDeelnemers j WHERE j.nationaliteit = :nationaliteit")})
public class JtDeelnemers implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Naam")
    private String naam;
    @Column(name = "Voornaam")
    private String voornaam;
    @Column(name = "Geboortedatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date geboortedatum;
    @Column(name = "Nationaliteit")
    private String nationaliteit;

    public JtDeelnemers() {
    }

    public JtDeelnemers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        String oldNaam = this.naam;
        this.naam = naam;
        changeSupport.firePropertyChange("naam", oldNaam, naam);
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        String oldVoornaam = this.voornaam;
        this.voornaam = voornaam;
        changeSupport.firePropertyChange("voornaam", oldVoornaam, voornaam);
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        Date oldGeboortedatum = this.geboortedatum;
        this.geboortedatum = geboortedatum;
        changeSupport.firePropertyChange("geboortedatum", oldGeboortedatum, geboortedatum);
    }

    public String getNationaliteit() {
        return nationaliteit;
    }

    public void setNationaliteit(String nationaliteit) {
        String oldNationaliteit = this.nationaliteit;
        this.nationaliteit = nationaliteit;
        changeSupport.firePropertyChange("nationaliteit", oldNationaliteit, nationaliteit);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JtDeelnemers)) {
            return false;
        }
        JtDeelnemers other = (JtDeelnemers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktopapplication1.JtDeelnemers[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
