import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Classe utilitaria per trasformare un testo in un codice criptato.
 */
public class CalculateHash {

    /**
     * Applica l'algoritmo SHA-256 a una stringa per ottenere un hash.
     * Da come output una stringa in formato esadecimale che rappresenta l'hash.
     */
    public static String applySha256(String input) {
        try {
            // Crea l'oggetto che esegue il calcolo SHA-256
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");

            // Trasforma il testo in un array di byte
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            String hashedString = "";

            for (int i = 0; i < hashBytes.length; i++) {
                // Converte il byte in un carattere esadecimale
                String Hexadecimal = Integer.toHexString(hashBytes[i]);
                hashedString += Hexadecimal;
            }

            return hashedString;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}