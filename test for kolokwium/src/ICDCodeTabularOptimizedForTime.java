import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ICDCodeTabularOptimizedForTime
        implements ICDCodeTabular {

    private Map<String,String> codes =
            new HashMap<>();

    public ICDCodeTabularOptimizedForTime(
            String path) throws IOException {

        BufferedReader file =
                new BufferedReader(
                        new FileReader(path));

        String line;
        int lineNumber = 0;

        while((line = file.readLine()) != null){

            lineNumber++;

            // Dane zaczynają się od linii 88
            if(lineNumber < 88){
                continue;
            }

            line = line.trim();

            // Poprawny kod ICD
            if(line.matches(
                    "^[A-Z][0-9][0-9](\\.[A-Z0-9]+)?\\s+.*"
            )){

                String[] parts =
                        line.split("\\s+",2);

                if(parts.length == 2){

                    String code = parts[0];
                    String description = parts[1];

                    codes.put(code,description);
                }
            }
        }

        file.close();
    }

    @Override
    public String getDescription(String code) {

        if(codes.containsKey(code)){

            return codes.get(code);
        }

        throw new IndexOutOfBoundsException(
                "Nie znaleziono kodu: " + code
        );
    }
}