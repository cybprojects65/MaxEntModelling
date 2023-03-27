package org.gcube.datanalysis.ecomod;

import java.io.IOException;

import density.Maxent;
import density.Project;

public class MainProjecting {

	
	public static void main(String[] args) throws IOException {
		
		String occurrences =args[0];
		String environmental =args[1];
		String outputfolder =args[2];
		
		String lambdaPath = args[3];
		String environmental_proj = args[4];
		String outputfile =args[5];
		
		//call MaxEnt
		Maxent me = new Maxent(occurrences,environmental,outputfolder, 1000, 0.5, -9999);
				
		Project pr = new Project(me.getParams());
		pr.doProject(lambdaPath, environmental_proj, outputfile, false);
		
		try{
			System.out.println("MaxEnt: Result: "+me.getResult());
			System.out.println("MaxEnt: OK MaxEnt!");
		}catch(Exception e){
			System.out.println("MaxEnt: error in retrieving the result "+e.getLocalizedMessage());
			System.out.println("MaxEnt: KO!");
		}
		
	}
	
	
}