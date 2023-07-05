package org.gcube.datanalysis.covid;

import density.Maxent;
import density.Project;

public class TestMaxEntProjection {
	
	
	public static void main(String[] args) throws Exception{
		
		String lambdaPath = "./maxentoutput/gp.lambdas";
		String gridsFolder = "./ascfiles/";
		String outputMaxEntRepro = "./repro.asc";
		String filePath = "./covid_prod_diff_highrateMEP_it_london.csv";
		Maxent me = new Maxent(filePath,"./ascfiles/","./maxentoutput/", 1000, 0.5, -9999);
		
		Project pr = new Project(me.getParams());
		pr.doProject(lambdaPath, gridsFolder, outputMaxEntRepro);
				
		
	}
}
