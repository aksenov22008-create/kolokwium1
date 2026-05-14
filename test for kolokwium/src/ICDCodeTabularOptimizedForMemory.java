import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ICDCodeTabularOptimizedForMemory implements ICDCodeTabular {

    private String path;

    public ICDCodeTabularOptimizedForMemory(String path) {
        this.path = path;
    }

    @Override
    public String getDescription(String code) {

        try {

            BufferedReader file = new BufferedReader(new FileReader(path));

            String line;
            int lineNumber = 0;

            while((line = file.readLine()) != null){

                lineNumber++;

                /*
                 * continue
                 * пропускає ітерацію.
                 */
                if(lineNumber < 88){
                    continue;
                }

                /*
                 * trim()
                 * прибирає пробіли.
                 */
                line = line.trim();

                /*
                 * matches()
                 * перевірка regex.
                 */
                if(line.matches("^[A-Z][0-9][0-9](\\.[A-Z0-9]+)?\\s+.*")){

                    /*
                     * split("\\s+",2)
                     * ділить по пробілах.
                     */
                    String[] parts = line.split("\\s+",2);

                    if(parts.length == 2){

                        String currentCode = parts[0];
                        String description = parts[1];

                        if(currentCode.equals(code)){

                            file.close();

                            return description;
                        }
                    }
                }
            }

            file.close();

        } catch (IOException e) {

            /*
             * printStackTrace()
             * повний текст помилки.
             */
            e.printStackTrace();
        }

        /*
         * throw
         * створення помилки вручну.
         */
        throw new IndexOutOfBoundsException("Nie znaleziono kodu: " + code);
    }
}