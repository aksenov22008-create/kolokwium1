import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ICDCodeTabularOptimizedForMemory
        implements ICDCodeTabular {

    private String path;

    public ICDCodeTabularOptimizedForMemory(
            String path) {

        this.path = path;
    }

    @Override
    public String getDescription(String code) {

        try {

            BufferedReader file =
                    new BufferedReader(
                            new FileReader(path));

            String line;
            int lineNumber = 0;

            while((line = file.readLine()) != null){

                lineNumber++;

                // Dane od linii 88
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

                        String currentCode =
                                parts[0];

                        String description =
                                parts[1];

                        if(currentCode.equals(code)){

                            file.close();

                            return description;
                        }
                    }
                }
            }

            file.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        throw new IndexOutOfBoundsException(
                "Nie znaleziono kodu: " + code
        );
    }
}