import java.io.*;
import java.util.*;

public class Election {

    // Список кандидатів
    private List<Candidate>
            candidates =
            new ArrayList<>();

    // Перша тура
    private ElectionTurn
            firstTurn =
            new ElectionTurn(
                    candidates
            );

    // Друга тура
    private ElectionTurn
            secondTurn;

    // Переможець
    private Candidate winner;


    // Повернути копію списку
    public List<Candidate>
    getCandidates(){

        return new ArrayList<>(
                candidates
        );
    }


    // Завантажити кандидатів
    public void populateCandidates(
            String path)
            throws Exception{

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(path)
                );

        String line;

        while(
                (line=
                        reader.readLine())
                        !=null
        ){

            Candidate candidate =
                    new Candidate(
                            line
                    );

            candidates.add(
                    candidate
            );
        }

        reader.close();
    }


    // Завантаження всіх даних
    public void populate(
            String candidateFile,
            String firstFile,
            String secondFile)
            throws Exception{

        // Завантажуємо кандидатів
        populateCandidates(
                candidateFile
        );

        // Завантажуємо першу туру
        firstTurn.populate(
                firstFile
        );


        try{

            // Пробуємо знайти переможця
            winner =
                    firstTurn
                            .winner();

        }

        catch(
                NoWinnerException e){

            // Отримуємо двох кандидатів
            List<Candidate>
                    finalists =

                    firstTurn
                            .runoffCandidates();


            // Створюємо другу туру
            secondTurn =
                    new ElectionTurn(
                            finalists
                    );

            // Завантажуємо результати
            secondTurn.populate(
                    secondFile
            );

            // Знаходимо переможця
            winner =
                    secondTurn
                            .winner();
        }

    }


    public Candidate
    getWinner(){

        return winner;
    }


    public ElectionTurn
    getFirstTurn(){

        return firstTurn;
    }


    public ElectionTurn
    getSecondTurn(){

        return secondTurn;
    }

}