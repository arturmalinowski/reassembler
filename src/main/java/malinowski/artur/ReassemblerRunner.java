package malinowski.artur;

import java.io.BufferedReader;
import java.io.FileReader;


public class ReassemblerRunner {
    public static void main(String[] args) {
        TextReassembler textReassembler = new TextReassembler(new Comparator());

        try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
            String fragmentProblem;
            while ((fragmentProblem = in.readLine()) != null) {
                System.out.println(textReassembler.reassemble(fragmentProblem));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
