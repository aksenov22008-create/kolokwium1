//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.IOException;
import java.util.List;

public class main5 {
    public static void main(String[] args) throws IOException {
        List<Candidate> candidateList = Election.populateCandidates("kandydaci(2025).txt");
        System.out.println(candidateList);
    }
}
