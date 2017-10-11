/**
 * 
 */
package org.umutt.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UMUTT_HEALTH")
public class Health {

	@Id
	@Column(name="NAME")
	private String name;
	@Column(name="VERSION")
	private String version;
	
	public Health() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public String getVersion() {
		return version;
	}
}
