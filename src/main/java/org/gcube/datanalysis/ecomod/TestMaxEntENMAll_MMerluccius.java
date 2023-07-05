package org.gcube.datanalysis.ecomod;

import java.io.File;

import density.Maxent;
import density.Project;

public class TestMaxEntENMAll_MMerluccius {
	
	public static void main(String[] args) throws Exception{
		
		String occurrenceRecords = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\OccurrenceRecordsForMaxEnt\\Merluccius merluccius_all_occ.csv.filtered.csv";
		
		String gridsA = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\ASCEnvironmentalParametersForMaxEnt\\diva05\\ensembleMM\\";
		
		String outputA = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\MaxEntModels\\ensemblediva05MM\\";
		
		//call MaxEnt
		Maxent me = new Maxent(occurrenceRecords,gridsA,outputA, 1000, 0.5, -9999);
		me.executeMaxEnt();
		
		System.out.println("MaxEnt: OK MaxEnt!");
		try{
			System.out.println("MaxEnt: Result: "+me.getResult());
		}catch(Exception e){
			System.out.println("MaxEnt: error in retrieving the result "+e.getLocalizedMessage());
		}
		String lambdaPath = outputA+"Merluccius_merluccius.lambdas";
		
		String gridsB = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\ASCEnvironmentalParametersForMaxEnt\\diva05\\2020 CNR\\";
		String outputB = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\MaxEntModels\\ensemblediva05MM\\Merluccius_merluccius_2020.asc";
		Project pr = new Project(me.getParams());
		pr.doProject(lambdaPath, gridsB, outputB);
		
		
		String gridsB1 = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\ASCEnvironmentalParametersForMaxEnt\\diva05\\2019\\";
		String outputB1 = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\MaxEntModels\\ensemblediva05MM\\Merluccius_merluccius_2019.asc";
		
		Project pr1 = new Project(me.getParams());
		pr1.doProject(lambdaPath, gridsB1, outputB1);

	}
}
