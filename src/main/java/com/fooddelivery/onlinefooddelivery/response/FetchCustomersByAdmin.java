package com.fooddelivery.onlinefooddelivery.response;

import java.util.List;
import org.hibernate.grammars.hql.HqlParser.NakedIdentifierContext;

import com.fooddelivery.onlinefooddelivery.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FetchCustomersByAdmin {

	private String masg;
	List<String> names;
	public String getMasg() {
		return masg;
	}
	public void setMasg(String masg) {
		this.masg = masg;
	}
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	
	
	
	

}
