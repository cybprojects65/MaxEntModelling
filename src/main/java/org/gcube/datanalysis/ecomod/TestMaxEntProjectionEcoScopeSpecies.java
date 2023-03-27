package org.gcube.datanalysis.ecomod;

import java.io.File;

import density.Maxent;
import density.Project;

public class TestMaxEntProjectionEcoScopeSpecies {

	public static void main1(String[] args) throws Exception {

		String species = "Acipenser_gueldenstaedtii";

		String scenario = "RCP 26";
		String year = "2100";

		String basepath = "C:\\Users\\Utente\\Downloads\\SDMfix\\MaxEnt2019\\" + species + "\\" + species + "\\";
		String basepathSpp = "C:\\Users\\Utente\\Downloads\\SDMfix\\Presence\\";
		String grids = "C:\\Users\\Utente\\Downloads\\SDMfix\\Environmental Parameters\\" + scenario + "\\" + year
				+ "\\";

		String lambdaPath = basepath + species + ".lambdas";
		String output = basepath + species + "-" + scenario + "_" + year + ".asc";
		String occurrenceRecords = basepathSpp + "Presence_" + species + ".csv";
		System.out.println((new File(lambdaPath)).exists());
		System.out.println((new File(occurrenceRecords)).exists());
		System.out.println((new File(grids)).exists());
		System.out.println((new File(basepathSpp)).exists());
		System.out.println((new File(basepath)).exists());

		if ((new File(lambdaPath)).exists() && (new File(occurrenceRecords)).exists() && (new File(grids)).exists()
				&& (new File(basepathSpp)).exists() && (new File(basepath)).exists()) {
			Maxent me = new Maxent(occurrenceRecords, grids, output, 1000, 0.5, -9999);
			Project pr = new Project(me.getParams());
			pr.doProject(lambdaPath, grids, output, false);
		} else {
			System.out.println("some file does not exist");
		}
	}

	public static void main(String[] args) throws Exception {

		String allSpecies[] = { "Acipenser_gueldenstaedtii", "Alosa_caspia_nordmani", "Huso_huso", "Leptometra_celtica",
				"Mullus_barbatus", "Saurida_lessepsianus", "Squilla_mantis" };
		for (String species : allSpecies) {
			// String species = "Acipenser_gueldenstaedtii";
			// String species = ;
			// String species = "Alosa_caspia_nordmani";

			String scenarios[] = { "RCP 26", "RCP 45", "RCP 85" };
			String years[] = { "2050", "2100" };

			for (String scenario : scenarios) {
				// String scenario = "RCP 26";

				for (String year : years) {
					// String year = "2100";
					System.out.println(species+"->"+scenario + "->" + year);
					String basepath = "C:\\Users\\Utente\\Downloads\\SDMfix\\MaxEnt2019\\" + species + "\\" + species
							+ "\\";
					String basepathSpp = "C:\\Users\\Utente\\Downloads\\SDMfix\\Presence\\";
					String grids = "C:\\Users\\Utente\\Downloads\\SDMfix\\Environmental Parameters\\" + scenario + "\\"
							+ year + "\\";

					String basepathoutput = "C:\\Users\\Utente\\Downloads\\SDMfix\\MaxEnt2019\\Projections\\";
					String lambdaPath = basepath + species + ".lambdas";
					String outputbp = basepathoutput + "\\" + scenario + "_" + year + "\\";
					File outputbpF = new File(outputbp);
					if (!outputbpF.exists())
						outputbpF.mkdir();

					String output = outputbp + species + ".asc";
					String occurrenceRecords = basepathSpp + "Presence_" + species + ".csv";
					System.out.println((new File(lambdaPath)).exists());
					System.out.println((new File(occurrenceRecords)).exists());
					System.out.println((new File(grids)).exists());
					System.out.println((new File(basepathSpp)).exists());
					System.out.println((new File(basepath)).exists());

					if ((new File(lambdaPath)).exists() && (new File(occurrenceRecords)).exists()
							&& (new File(grids)).exists() && (new File(basepathSpp)).exists()
							&& (new File(basepath)).exists()) {
						Maxent me = new Maxent(occurrenceRecords, grids, output, 1000, 0.5, -9999);
						Project pr = new Project(me.getParams());
						pr.doProject(lambdaPath, grids, output, false);
					} else {
						System.out.println("some file does not exist");
					}
				}
			}
		}

	}

}
