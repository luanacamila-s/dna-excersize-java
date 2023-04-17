import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

public class DNA {
    // checar tem letras diferentes de (ACGT)
    public  boolean checkLetters(String dna) {
        ArrayList<Character> lettersNotAllowed = new ArrayList<Character>(Arrays.asList(
                'b', 'd', 'e', 'f', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'));

        for (int i = 0; i < dna.length(); i++) {
            char letter = dna.toLowerCase().charAt(i);
            if (lettersNotAllowed.contains(letter)) {
                return false;
            }
        }

        return true;
    }

    public  boolean checkStartCodon(String dna) {
        return dna.startsWith("ATG"); 
    }
    public  boolean checkEndCodon(String dna) {
        return dna.endsWith("TGA");
    }
    public  boolean checkSizeIsCompatible(String dna) {
        if(dna.length() % 3 != 0) return false;
        return true;
    }   

    public void validate(String dna) {
        System.out.println("ANALISE: " + dna);
        
        if (!this.checkSizeIsCompatible(dna)) {
            System.out.println("Não é uma proteína, tamanho incompatível");
        }
        if(!this.checkLetters(dna)) {
            System.out.println("Não é uma proteína, Alguma letra incompatível");
        }
        if(!this.checkStartCodon(dna)) {
            System.out.println("Não é uma proteína, Não foi encontrado códon de inicio");
        }
        if(!this.checkEndCodon(dna)) {
            System.out.println("Não é uma proteína, Não foi encontrado códon de parada");
        }
        else {
            System.out.println("É uma proteína!");
        }

        System.out.println("\n");
    }


    public static void main(String[] args) {
        DNA instanceDna = new DNA();

        String proteina1 = "ATGCGATACTGA";
        String proteina2 = "ATGCGATAGA";
        String proteina3 = "ATGCGATAAATGTGA";


        instanceDna.validate(proteina1);
        instanceDna.validate(proteina2);
        instanceDna.validate(proteina3);
    }
}
