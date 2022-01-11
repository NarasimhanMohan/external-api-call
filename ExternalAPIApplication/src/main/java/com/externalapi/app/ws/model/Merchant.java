package com.externalapi.app.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Merchant {

@Id
@Column
private int id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

}
