import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular {

    /*
     * Map<Key,Value>
     * код -> опис.
     */
    private Map<String,String> codes = new HashMap<>();

    public ICDCodeTabularOptimizedForTime(String path) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader(path));

        String line;
        int lineNumber = 0;

        while((line = file.readLine()) != null){

            lineNumber++;

            if(lineNumber < 88){
                continue;
            }

            line = line.trim();

            /*
             * regex
             * шаблон тексту.
             */
            if(line.matches("^[A-Z][0-9][0-9](\\.[A-Z0-9]+)?\\s+.*")){

                String[] parts = line.split("\\s+",2);

                if(parts.length == 2){

                    String code = parts[0];
                    String description = parts[1];

                    /*
                     * put()
                     * додавання у Map.
                     */
                    codes.put(code,description);
                }
            }
        }

        file.close();
    }

    @Override
    public String getDescription(String code) {

        /*
         * containsKey()
         * чи є ключ.
         */
        if(codes.containsKey(code)){

            /*
             * get()
             * отримання значення.
             */
            return codes.get(code);
        }

        throw new IndexOutOfBoundsException("Nie znaleziono kodu: " + code);
    }
}