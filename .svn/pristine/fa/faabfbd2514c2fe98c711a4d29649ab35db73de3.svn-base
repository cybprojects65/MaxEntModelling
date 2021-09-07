package org.gcube.datanalysis.covid;

import density.Maxent;

public class TestMaxEntCovid {
	
	public static void main(String[] args) throws Exception{
		
		
		//String filePath = "D:\\WorkFolder\\Experiments\\Covid-19\\covid_prod_diff_highrateMEP_italy_additional_world_countries.csv";
		//String filePath = "D:\\WorkFolder\\Experiments\\Covid-19\\covid_prod_diff_highrateMEP_it_london.csv";
		String filePath = "./covid_prod_diff_highrateMEP_it_london.csv";
	
		//call MaxEnt
		Maxent me = new Maxent(filePath,"./ascfiles/","./maxentoutput/", 1000, 0.5, -9999);
		me.executeMaxEnt();
		
		System.out.println("MaxEnt: OK MaxEnt!");
		try{
			System.out.println("MaxEnt: Result: "+me.getResult());
		}catch(Exception e){
			System.out.println("MaxEnt: error in retrieving the result "+e.getLocalizedMessage());
		}
		
		
		
	}
}
