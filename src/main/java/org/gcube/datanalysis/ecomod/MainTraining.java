package org.gcube.datanalysis.ecomod;

import density.Maxent;

public class MainTraining {

	
	public static void main(String[] args) {
		
		String occurrences =args[0];
		String environmental =args[1];
		String outputfolder =args[2];
		
		//call MaxEnt
		Maxent me = new Maxent(occurrences,environmental,outputfolder, 1000, 0.5, -9999);
		me.executeMaxEnt();
		try{
			System.out.println("MaxEnt: Result: "+me.getResult());
			System.out.println("MaxEnt: OK MaxEnt!");
		}catch(Exception e){
			System.out.println("MaxEnt: error in retrieving the result "+e.getLocalizedMessage());
			System.out.println("MaxEnt: KO!");
		}
		
	}
	
	
}
