package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController(){
		super();
	}
	
	public String os () {
		String os = System.getProperty("os.name");
		System.out.println("Nome OS: " + os);
		return os;
	}
	
	public void listaProcessos (String os) {
		try {
			if (os.contains("Windows")) {
				String process = "TASKLIST /FO TABLE";
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			}
			else {
				System.err.println("Comando inválido para esse os");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mataPid (String param) {
			String cmdPid = "TASKKILL /PID";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
				pid = Integer.parseInt(param);
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch(IOException e) {
					e.printStackTrace();
				}
		}
		
	public void mataNome (String paraNom) {
			String cmdNome = "TASKKILL /IM";
			StringBuffer buffer = new StringBuffer();
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(paraNom);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch(IOException e) {
				e.printStackTrace();
			}
	
	

	}
}	

