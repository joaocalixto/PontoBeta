package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileControler {

	public static boolean escreverArquivo(String dataHora) {

		File arquivo = new File("horarios.txt");

		System.out.println(arquivo.getAbsolutePath());
		try {

			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			// escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(dataHora);
			bw.newLine();

			bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean escreverArquivo(String dataHora, String origem) {

		File arquivo = new File(origem + File.separator + "horarios.txt");

		System.out.println(arquivo.getAbsolutePath());
		try {

			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			// escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(dataHora);
			bw.newLine();

			bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public static void lerArquivo(String origem) {

		try {
			File arquivo = new File(origem + File.separator + "horarios.txt");
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {
				String linha = br.readLine();

				System.out.println(linha);
			}

			br.close();
			fr.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
