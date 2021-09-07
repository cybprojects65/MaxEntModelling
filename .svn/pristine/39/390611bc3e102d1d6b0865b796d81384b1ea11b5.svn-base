package org.gcube.datanalysis.ecomod;

import java.io.File;

import density.Maxent;
import density.Project;

public class TestMaxEntProjectionENM {
	
	public static void main(String[] args) throws Exception{
		
		String lambdaPath = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\MaxEntModels\\Output ensemble 2015-2018 - most infl\\Squilla mantis\\Squilla_mantis.lambdas";
		
		String grids = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\ASCEnvironmentalParametersForMaxEnt\\FromDIVANotebook\\Squilla Mantis\\2020\\";
		
		String output = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\MaxEntModels\\Output ensemble 2015-2018 - most infl\\Squilla mantis\\Squilla_mantis_2020.asc";
		
		String occurrenceRecords = "D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\OccurrenceRecordsForMaxEnt\\Squilla mantis_all_occ.csv.filtered.csv";
		
		Maxent me = new Maxent(occurrenceRecords,grids,output, 1000, 0.5, -9999);
		Project pr = new Project(me.getParams());
		pr.doProject(lambdaPath, grids, output,false);
	}
}
