package com.saini.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListClass {

private List<Products> list = new ArrayList<Products>();
	
	{
		Products m1=new Products(101, "Classicla", "Guitar", 200, 4, "My guitar", "resources/images/products/guitar.jpg");
		Products m2=new Products(102, "Classicla", "Guitar", 200, 4, "My guitar", "resources/images/products/guitar.jpg");
		Products m3=new Products(1010, "Classicla", "Guitar", 200, 4, "My guitar", "resources/images/products/secong.jpg");
		Products m4=new Products(1290, "Classicla", "Guitar", 200, 4, "My guitar", "resources/images/products/third.jpg");
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		
		
	}
	
	public List<Products> getlist()
	{
		return list;
	}

}
