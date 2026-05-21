import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Election {
    private Candidate[] candidates;
    private static ElectionTurn firstTurn;
    private ElectionTurn secondTurn;


    public Election(Candidate[] candidates) {

        this.candidates = candidates;

        // створення першої тури
        this.firstTurn =
                new ElectionTurn(Arrays.asList(candidates));

        // друга тура поки null
        this.secondTurn = null;
    }

    public List<Candidate> copyCandidateList() {
        List<Candidate> candidateList = Arrays.asList(candidates);
        return candidateList;
    }
    public static List<Candidate> populateCandidates(String path) throws IOException {
        List<Candidate> candidateList = new ArrayList<>();
        firstTurn.populate("1(2025).csv");
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while((line = reader.readLine())!=null){
            candidateList.add(new Candidate(line));
        }
        return candidateList;
    }
}
