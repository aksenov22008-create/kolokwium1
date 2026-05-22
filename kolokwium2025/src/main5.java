import java.util.*;

public class main5 {

    public static void main(
            String[] args)
            throws Exception{


        // Створюємо вибори
        Election election =
                new Election();


        // Завантажуємо файли
        election.populate(
                "kandydaci(2025).txt",
                "1(2025).csv",
                "2(2025).csv"
        );


        // Виводимо переможця
        Candidate winner =
                election.getWinner();

        System.out.println(
                "Winner:"
        );

        System.out.println(
                winner.name()
        );


        // Загальна статистика
        Vote summary =
                election
                        .getFirstTurn()
                        .summarize();

        System.out.println(
                summary
        );


        // Результати по воєводству
        List<String> location =
                List.of(
                        "lubelskie"
                );

        Vote result =
                election
                        .getFirstTurn()
                        .summarize(
                                location
                        );

        System.out.println(
                result
        );


        // Перевірка карти
        SelectableMap map =
                new SelectableMap();

        map.select(
                "lubelskie"
        );

        map.saveToSvg(
                "map.svg"
        );

    }

}