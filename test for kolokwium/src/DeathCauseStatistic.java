import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeathCauseStatistic {
    private String kodICD10;
    private int[] deathsByAgeGroup;

    public DeathCauseStatistic(String kodICD10, int[] deathsByAgeGroup) {
        this.kodICD10 = kodICD10;
        this.deathsByAgeGroup = deathsByAgeGroup;
    }

    public String getKodICD10() {
        return kodICD10;
    }

    public int[] getDeathsByAgeGroup() {
        return deathsByAgeGroup;
    }

    public static DeathCauseStatistic[] fromCsv(String path) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(path));
        file.readLine();
        file.readLine();
        String line;
        List<DeathCauseStatistic> deathCauseStatistics = new ArrayList<>();
        while ((line = file.readLine()) != null) {
            DeathCauseStatistic test = DeathCauseStatistic.fromCsvLine(line);
            deathCauseStatistics.add(test);
        }
        return deathCauseStatistics.toArray(new DeathCauseStatistic[0]);
    }
    //21
    public static DeathCauseStatistic fromCsvLine(String line){
        String[] fields = line.split(",");
        String kodICD10 = fields[0];
        int[] deathsByAgeGroup = new int[fields.length - 1];
        for (int i = 1; i < fields.length; i++){
            if(!fields[i].equals("-")){
                deathsByAgeGroup[i-1]=Integer.parseInt(fields[i]);
            }else{
                deathsByAgeGroup[i-1]=0;
            }
        }
        return new DeathCauseStatistic(kodICD10, deathsByAgeGroup);
    }

    @Override
    public String toString() {
        return "DeathCauseStatistic{" +
                "kodICD10='" + kodICD10 + '\'' +
                ", deathsByAgeGroup=" + Arrays.toString(deathsByAgeGroup) +
                '}'+'\n';
    }
    public AgeBracketDeaths DeathCauseStatistic(int young ,int old) {
        int tmp=0;
        int[] deathsByAgeGroup1 = this.deathsByAgeGroup;
        for (int i = young / 5; i < old / 5; i++) {
            tmp += deathsByAgeGroup1[i+1];

        }
        return new AgeBracketDeaths(young,old,tmp);
    }
    public class AgeBracketDeaths{
        public final int young ;
        public final int old;
        public final int deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;

        }

        @Override
        public String toString() {
            return "AgeBracketDeaths{" +
                    "young=" + young +
                    ", old=" + old +
                    ", deathCount=" + deathCount +
                    '}';
        }
    }
    }


