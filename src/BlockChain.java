import java.util.ArrayList;

/**
 * Classe principale che avvia la simulazione della Blockchain.
 */
public class BlockChain {
    public static void main(String[] args) {
        ArrayList<Block> blockChain = new ArrayList<>();

        // Più è alta la difficulty e più tempo ci vorrà per creare un blocco
        int difficulty = 3;

        // Creazione e mining del primo blocco
        System.out.println("Mining Blocco 1...");
        Block b1 = new Block("Primo blocco", "0");
        b1.mine(difficulty);
        blockChain.add(b1);

        // Creazione del secondo blocco, collegato al primo tramite l'hash
        System.out.println("Mining Blocco 2...");
        Block b2 = new Block("Secondo blocco", blockChain.get(0).hash);
        b2.mine(difficulty);
        blockChain.add(b2);

        System.out.println("\nBlockchain creata. Numero blocchi: " + blockChain.size());
    }
}