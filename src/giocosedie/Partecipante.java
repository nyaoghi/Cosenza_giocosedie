package giocosedie;
import java.io.FileWriter;
import java.io.IOException;

/**
 * classe per la gestione dei partecipanti e delle sedie
 */
class Partecipante extends Thread

{
	Posto sedie[];

/**
 * metodo costruttore della classe Partecipante
 * @param sedie array della classe Posto 
 */
	public Partecipante(Posto sedie[]) {

		this.sedie = sedie;

	}
/**
 * metodo run per lo svolgimento del gioco 
 * decisione dell'occupazione del posto 
 */
	public void run() {

		try {
			sleep((int) (Math.random() * 1000));

			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
					System.out.println("Sono il Thread " + this.getName()
							+ ". Sono riuscito a sedermi sul posto " + i);
							scriviFile(i);
					return;
				}
			}
			System.out.println("Sono il Thread " + this.getName()
					+ ". Ho perso :((((");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
/**
 * metodo per la scrittura del file Risultato.txt
 * @param i index 
 */
    public void scriviFile(int i){
		try {
			FileWriter scrittore = new FileWriter("Risultato.txt", true);
			scrittore.write(" id thread: "+this.getId()+" posto in cui si è seduto: "+i+"\n");
			scrittore.close();
		} catch (IOException e) {
			System.out.println("I/O Expection");
			e.printStackTrace();
		}


		

	}
		
}
