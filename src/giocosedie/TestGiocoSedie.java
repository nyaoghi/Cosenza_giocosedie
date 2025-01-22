/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocosedie;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Cosenza Olga
 */
public class TestGiocoSedie {
       private static int nPartecipanti = 0;
    //private final static int NUMSEDIE = nPartecipanti-1 ;
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        @suppressWarnings


        Scanner scanner = new Scanner(System.in);

        System.out.println("inserisci il numero dei partecipanti");

        nPartecipanti = scanner.nextInt();

        Posto sedie[] = new Posto[nPartecipanti-1];

	for (int k = 0; k < sedie.length; k++)
		sedie[k] = new Posto();

	Display display = new Display(sedie);
	//System.out.println("Sto facendo partire il Display.");
        logger.info("Sto facendo partire il Display.\n");
	display.start();
        try {
                FileWriter cestino = new FileWriter("Risultato.txt");
                cestino.write("");
                cestino.close();
        } catch (IOException e) {
                System.out.println("ERRORE! Non abbiamo eliminato il file :(");
                // TODO Auto-generated catch block
                e.printStackTrace();
        }


	Partecipante array[] = new Partecipante[nPartecipanti];
	for (int i = 0; i < nPartecipanti + 1; i++) {
		array[i] = new Partecipante(sedie);
                //System.out.println("Sto facendo partire il thread n." + array[i].getId());
                logger.info("Sto facendo partire il thread id: " + array[i].getId()+" name: "+array[i].getName()+"\n");
                array[i].start();
                }
	}
    }
 
