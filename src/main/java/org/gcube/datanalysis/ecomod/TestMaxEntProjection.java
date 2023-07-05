package org.gcube.datanalysis.ecomod;

import java.io.File;

import density.Maxent;
import density.Project;

public class TestMaxEntProjection {
	
	public static void main(String[] args) throws Exception{
		File basePath = new File ("D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea\\");
		
		String lambdaPath = new File(basePath,"/MaxEntModels\\Maxent result on Ensemble 2015-17 env data\\Squilla mantis\\Squilla_mantis.lambdas").getAbsolutePath();
		
		//String gridsFolder = new File(basePath,"//ASCEnvironmentalParametersForMaxEnt\\2019\\Normal\\").getAbsolutePath();
		//File outputMaxEntReproFile = new File(basePath,"/MaxEntModels\\MaxEnt results on reprojections\\Squilla mantis\\Squilla_mantis_reprojection_2019.asc");
		
		//String gridsFolder = new File(basePath,"//ASCEnvironmentalParametersForMaxEnt\\2020\\Normal\\ASC 2020\\").getAbsolutePath();
		//File outputMaxEntReproFile = new File(basePath,"/MaxEntModels\\MaxEnt results on reprojections\\Squilla mantis\\Squilla_mantis_reprojection_2020.asc");
		
		String gridsFolder = new File(basePath,"//ASCEnvironmentalParametersForMaxEnt\\2020\\Normal\\ASC 2020 Argo-CNR\\").getAbsolutePath();
		File outputMaxEntReproFile = new File(basePath,"/MaxEntModels\\MaxEnt results on reprojections\\Squilla mantis\\Squilla_mantis_reprojection_2020_argo_cnr.asc");
		
		String outputMaxEntRepro = outputMaxEntReproFile.getAbsolutePath();
		String outputMaxEntReproFolder = outputMaxEntReproFile.getParent();
		
		String filePath = new File(basePath,"/OccurrenceRecordsForMaxEnt\\Squilla mantis_all_occ.csv.filtered.csv").getAbsolutePath();
		
		Maxent me = new Maxent(filePath,gridsFolder,outputMaxEntReproFolder, 1000, 0.5, -9999);
		Project pr = new Project(me.getParams());
		pr.doProject(lambdaPath, gridsFolder, outputMaxEntRepro);
	}
}
