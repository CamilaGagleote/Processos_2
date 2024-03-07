package view;
		
import controller.KillController;

public class Main {

	public static void main(String[] args) {
		
			KillController kc = new KillController();
			String receb = kc.os();
			kc.listaProcessos(receb);
			String param = "27888";
			kc.mataPid(param);
			String paraNom = "Notepad.exe";
			kc.mataNome(paraNom);
	}

}
