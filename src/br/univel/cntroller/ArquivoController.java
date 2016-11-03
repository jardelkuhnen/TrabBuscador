package br.univel.cntroller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ArquivoController implements Callable {

	private String criterio;
	private String path;

	public ArquivoController(final String criterio, final String path) {
		this.criterio = criterio;
		this.path = path;

	}

	List<String> arquivosEncontrados = new ArrayList<String>();

	public Object call() throws Exception {

		File location = new File(path);

		File[] arqs = location.listFiles();

		for (int i = 0; i < arqs.length; i++) {

			File file = arqs[i];

			FileReader fReader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fReader);

			String linha = buffer.readLine();

			while (linha != null) {

				int vezes = linha.lastIndexOf(criterio);

				if (vezes > 0) {
					arquivosEncontrados.add(arqs[i].getName());
				}

			}

		}

		return arquivosEncontrados;
	}

}
