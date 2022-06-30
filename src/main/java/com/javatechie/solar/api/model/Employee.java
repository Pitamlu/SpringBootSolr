package com.javatechie.solar.api.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "TestAPI")
public class Employee {
	@Id
	@Field
	private int id;
	@Field
	private String name;
	@Field
	private String adress;
	@Field
	private String telephon;
	@Field
	private String fecha_nac;
	@Field
	private String category;
	@Field
	private String estudios;

}
