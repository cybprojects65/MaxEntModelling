package org.gcube.datanalysis.ecomod;

import density.Maxent;
import density.Project;

public class TestMaxEntENMAll_SOfficinalis {
	
	public static void main(String[] args) throws Exception{
		String species="Sepia officinalis";
		String sp = species.replace(" ", "_");
		
		String gridsA = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\ASCEnvironmentalParametersForMaxEnt\\diva05\\ensembleSO\\";
		String outputA = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\MaxEntModels\\ensemblediva05SO\\";
		
		String occurrenceRecords = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\OccurrenceRecordsForMaxEnt\\"+species+"_all_occ.csv.filtered.csv";
		String gridsB = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\ASCEnvironmentalParametersForMaxEnt\\diva05\\2020 CNR\\";
		String gridsB1 = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\ASCEnvironmentalParametersForMaxEnt\\diva05\\2019\\";
		//call MaxEnt
		Maxent me = new Maxent(occurrenceRecords,gridsA,outputA, 1000, 0.5, -9999);
		me.executeMaxEnt();
		
		System.out.println("MaxEnt: OK MaxEnt!");
		try{
			System.out.println("MaxEnt: Result: "+me.getResult());
		}catch(Exception e){
			System.out.println("MaxEnt: error in retrieving the result "+e.getLocalizedMessage());
		}
		String lambdaPath = outputA+sp+".lambdas";
		
		
		String outputB = outputA+sp+"_2020.asc";
		Project pr = new Project(me.getParams());
		pr.doProject(lambdaPath, gridsB, outputB);
		
		
		
		String outputB1 = outputA+sp+"_2019.asc";
		
		Project pr1 = new Project(me.getParams());
		pr1.doProject(lambdaPath, gridsB1, outputB1);

	}
}
