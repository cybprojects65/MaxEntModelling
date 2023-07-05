package org.gcube.datanalysis.ecomod;

import density.Maxent;
import density.Params;

public class MainTraining {

	
	public static void main(String[] args) {
		
		String occurrences =args[0];
		String environmental =args[1];
		String outputfolder =args[2];
		
		double prevalence = 0.5d;
		
		try {
			prevalence = Double.parseDouble(args[3]);
		}catch(Exception e) {
			System.out.println("Prevalence not provided - defaulting to 0.5");
		}
		
		//call MaxEnt
		Maxent me = new Maxent(occurrences,environmental,outputfolder, 1000, prevalence, -9999);
		Params p = Maxent.getDefaultParameters();

		p.setResponsecurves(false);
		p.setPictures(false);
		p.setJackknife(false);
		p.setRandomseed(true);
		p.setLogscale(true);
		p.setReplicatetype("Crossvalidate");
		p.setAutofeature(true);
		p.setDoclamp(true);
		p.setOutputgrids(true);
		p.setPlots(false);
		p.setAppendtoresultsfile(false);
		p.setSamplesfile(me.samplesFilePath);
		p.setEnvironmentallayers(me.environmentalLayersLocation);
		p.setOutputdirectory(me.outputDirectory);
		p.setMaximumiterations(me.maxIterations);
		p.setDefaultprevalence(prevalence);
		p.setNodata(me.noDataValue);
		
		me.executeMaxEnt(p);
		try{
			System.out.println("MaxEnt: Result: "+me.getResult());
			System.out.println("MaxEnt: OK MaxEnt!");
		}catch(Exception e){
			System.out.println("MaxEnt: error in retrieving the result "+e.getLocalizedMessage());
			System.out.println("MaxEnt: KO!");
		}
		
	}
	
	
}
