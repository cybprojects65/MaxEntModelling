package org.gcube.datanalysis.ecomod;

import density.Maxent;

public class TestMaxEntENM {
	
	public static void main(String[] args) throws Exception{
		
		
		String occurrenceRecords = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\OccurrenceRecordsForMaxEnt\\Squilla mantis_all_occ.csv.filtered.csv";
	
		//String grids = "D:/WorkFolder/Experiments/ENM in Adriatic Sea/ASCEnvironmentalParametersForMaxEnt/FromDIVANotebook/Squilla Mantis/ensemble/";
		String grids = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\ASCEnvironmentalParametersForMaxEnt\\diva05\\ensemble";
		
		String output = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\MaxEntModels\\ensemblediva05\\";
		
		//call MaxEnt
		Maxent me = new Maxent(occurrenceRecords,grids,output, 1000, 0.5, -9999);
		me.executeMaxEnt();
		
		System.out.println("MaxEnt: OK MaxEnt!");
		try{
			System.out.println("MaxEnt: Result: "+me.getResult());
		}catch(Exception e){
			System.out.println("MaxEnt: error in retrieving the result "+e.getLocalizedMessage());
		}
		
		
		
	}
}
