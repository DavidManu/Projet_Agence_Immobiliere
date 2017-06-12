/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue(value="visites")

/**
 * @author INTI-0366
 *
 */
public class Visite implements Serializable {
	
	//-----Attributs-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_visite")
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dateVisite;
	
	//-----Associations-----//
	
	@ManyToMany(mappedBy="listeVisites")
	private List<Client> listeClients;
	
	@ManyToMany(mappedBy="listeVisites")
	private List<Bien> listeBiens;
	
	@ManyToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id_conseiller")
	private Conseiller conseiller;
	
	//-----Constructeurs-----//

	/**
	 * 
	 */
	public Visite() {
		super();
	}

	/**
	 * @param dateVisite
	 */
	public Visite(Date dateVisite) {
		super();
		this.dateVisite = dateVisite;
	}

	/**
	 * @param id
	 * @param dateVisite
	 */
	public Visite(int id, Date dateVisite) {
		super();
		this.id = id;
		this.dateVisite = dateVisite;
	}
	
	//-----Getters et Setters-----//

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dateVisite
	 */
	public Date getDateVisite() {
		return dateVisite;
	}

	/**
	 * @param dateVisite the dateVisite to set
	 */
	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	/**
	 * @return the listeClients
	 */
	public List<Client> getListeClients() {
		return listeClients;
	}

	/**
	 * @param listeClients the listeClients to set
	 */
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	/**
	 * @return the listeBiens
	 */
	public List<Bien> getListeBiens() {
		return listeBiens;
	}

	/**
	 * @param listeBiens the listeBiens to set
	 */
	public void setListeBiens(List<Bien> listeBiens) {
		this.listeBiens = listeBiens;
	}

	/**
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	//-----Methode String-----//

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Visite [id=" + id + ", dateVisite=" + dateVisite + "]";
	}

}