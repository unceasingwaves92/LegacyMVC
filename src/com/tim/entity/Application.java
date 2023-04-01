package com.tim.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity

@Table(name="APPLICATION_TBL1")
public class Application implements Serializable {
    public static final Long serialVersionUID = 342343l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_gen")
    @SequenceGenerator(name = "application_gen", sequenceName = "APPLICATION_TBL1_SEQ",allocationSize = 1)
    @Column(name = "application_id")
    private long applicationId;

    private String description;

    @Column(name = "application_name")
    private String applicationName;

    private String owner;

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

   // @OneToMany(mappedBy = "application")
   // private Set<Ticket> ticket;


}
