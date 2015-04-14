
package com.aysidisi.worldofdayum.building.model;

import java.math.BigInteger;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Building
{
	@Id
	@GeneratedValue
	private BigInteger id;
	
}
