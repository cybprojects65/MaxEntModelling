package org.gcube.datanalysis.ecomod.batch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import density.Maxent;
import density.Project;

public class ProduceMaxEnt_Projections_AllSpecies_Full {
	
	static List<String> getSpecies (File folder){
		List<String> s = new ArrayList<String>();
		
		File[]allfiles = folder.listFiles();
		
		for (File f:allfiles) {
			
			if (f.getName().contains("filtered")) {
				
				String species = f.getName().substring(0,f.getName().indexOf("_")); 
				s.add(species);
				
			}
			
		}
		
		
		return s;
	} 
	
	public static void main(String[] args) throws Exception{
		
		
		File gridsFolder1st = new File("D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea v2\\Step 3 - Produce ASC\\ascAdriatic_per_year\\2015-2018\\");
		File gridsFolder2st = new File("D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea v2\\Step 3 - Produce ASC\\ascAdriatic_per_year\\2019\\");
		File gridsFolder3st = new File("D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea v2\\Step 3 - Produce ASC\\ascAdriatic_per_year\\2020\\");
		File inputFolder = new File("D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea v2\\Step 4 - Occurrence Records from OBIS\\occurrenceRecords-Adriatic\\");
		File outputFolder = new File("D:\\WorkFolder\\Experiments\\ENM in Adriatic Sea v2\\Step 5 - MaxEnt\\");
		
		
		List<String> allSpp = getSpecies(inputFolder);
		System.out.println(">"+allSpp.size());
		System.out.println(allSpp);
		
		
		for (String species:allSpp) {
			System.out.println("Species: "+species);
			String occurrenceRecords = new File(inputFolder,species+"_all_occ.csv.filtered.csv").getAbsolutePath();
			String grids1st = gridsFolder1st.getAbsolutePath();
			String grids2st = gridsFolder2st.getAbsolutePath();
			String grids3st = gridsFolder3st.getAbsolutePath();
			File outputFolderSpp = new File(outputFolder,species);
			if (!outputFolderSpp.exists())
				outputFolderSpp.mkdir();
			else
				continue;
			
			String outputFolderSppPath = outputFolderSpp.getAbsolutePath();

			//call MaxEnt
			Maxent me = new Maxent(occurrenceRecords,grids1st,outputFolderSppPath, 1000, 0.5, -9999);
			me.executeMaxEnt();
			
			String lambdaPath = outputFolderSppPath+"/sp.lambdas";
			String ensemblePath = outputFolderSppPath+"/sp.asc";
			new File(ensemblePath).renameTo(new File(outputFolderSppPath,species+"_2015-2018.asc"));
			
			String output2st = outputFolderSppPath+"/"+species+"_2019.asc";
			String output3st = outputFolderSppPath+"/"+species+"_2020.asc";
			
			Project pr2019 = new Project(me.getParams());
			pr2019.doProject(lambdaPath, grids2st, output2st);
			
			Project pr2020 = new Project(me.getParams());
			pr2020.doProject(lambdaPath, grids3st, output3st);

		}
				
		System.out.println("MaxEnt: OK MaxEnt!");
		

	}
}
