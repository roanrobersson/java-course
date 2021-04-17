package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Infome o caminho completo do arquivo de votos");
		System.out.println("Ex: C:/files/votingRecords.txt");
		String path = sc.nextLine();
		
		File file = new File(path);
		Scanner fileReader = null;
		
		try {
			 fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}

		List<String> lines = new ArrayList<String>();
		while(fileReader.hasNextLine()) {
			lines.add(fileReader.nextLine());
		}
		
		Map<String, Integer> candidatesVotes = new HashMap<>();
		
		for (String line : lines) {
			String[] values = line.split(",");
			String name = values[0];
			Integer votes = Integer.parseInt(values[1]);
			if (candidatesVotes.containsKey(name)) {
				int v = candidatesVotes.get(name) + votes;
				candidatesVotes.put(name, v);
			} else {
				candidatesVotes.put(name, votes);
			}
		}
		Program.printResult(candidatesVotes);
		sc.close();
		fileReader.close();
	}
	
	
	private static void printResult(Map<String, Integer> candidatesVotes) {
		System.out.println("Resultado da contabilização de votos:");
		for (String key : candidatesVotes.keySet()) {
			System.out.println(key + ": " + candidatesVotes.get(key));
		}
	}
}
