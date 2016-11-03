package br.univel.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class ArquivoController implements Callable<List<String>> {

	private String criterio;
	private String path;

	public ArquivoController(final String criterio, final String path) {
		this.criterio = criterio;
		this.path = path;

	}

	List<String> arquivosEncontrados = new ArrayList<String>();

	public List<String> call() throws Exception {

		File location = new File(path);

		File[] arqs = location.listFiles();

		for (int i = 0; i < arqs.length; i++) {

			File file = arqs[i];

			System.out.println(file.getName());
			FileReader fReader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fReader);

			String linha = buffer.readLine();

			while (linha != null) {

				int vezes = linha.lastIndexOf(criterio);

				if (vezes >= 0) {
					arquivosEncontrados.add(arqs[i].toString());
				}

				linha = buffer.readLine();
			}

			buffer.close();
			fReader.close();

		}

		return arquivosEncontrados;
	}

}
