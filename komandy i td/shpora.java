/*
========================================
ОСНОВНА ШПОРА
========================================
*/

        extends
// наслідування

                implements
// interface

@Override
// перевизначення

private
// приховування

public
// доступ звідусіль

protected
// доступ спадкоємцям

this
// поточний об'єкт

        super
// батьківський клас

static
// належить класу

final
// не змінюється

abstract
// шаблон

throw
// кинути помилку

        throws
// передати помилку

        try
        catch

<T>
// generics

x->x+1
// lambda

stream()
// потік

new
// створення об'єкта

        instanceof
// перевірка типу
/*
========================================
КЛЮЧОВІ МЕТОДИ
========================================
*/

/*
----------------------------------------
ArrayList
----------------------------------------
*/

        people.add(person);
// додати

people.get(0);
// отримати

people.remove(0);
// видалити

people.size();
// розмір

people.contains(person);
// перевірка

people.clear();
// очистити

people.isEmpty();
// чи пустий



/*
----------------------------------------
HashMap
----------------------------------------
*/

map.put(key,value);
// додати

map.get(key);
// отримати

map.remove(key);
// видалити

map.containsKey(key);
// ключ існує

map.containsValue(value);
// значення існує

map.keySet();
// всі ключі

map.values();
// всі значення



/*
----------------------------------------
Collections
----------------------------------------
*/

Collections.sort(list);
// сортування

Collections.reverse(list);
// реверс

Collections.max(list);
// максимум

Collections.min(list);
// мінімум



/*
----------------------------------------
String
----------------------------------------
*/

text.split(",");
// розділити

text.contains("abc");
// містить

text.substring(0,5);
// частина

text.replace("a","b");
// заміна

text.trim();
// пробіли

text.equals("abc");
// порівняння

text.startsWith("ab");
// початок

text.endsWith(".txt");
// кінець

text.charAt(0);
// символ

text.indexOf("a");
// індекс



/*
----------------------------------------
Math
----------------------------------------
*/

Math.max(a,b);

Math.min(a,b);

Math.abs(-5);

Math.sqrt(25);

Math.pow(2,3);

Math.random();

Math.round(3.7);
/*
========================================
ГОТОВІ ШАБЛОНИ КОДУ
========================================
*/

/*
----------------------------------------
Person + getter/setter
----------------------------------------
*/

class Person{

    private String name;
    private int age;

    public Person(
            String name,
            int age
    ){
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    @Override
    public String toString(){
        return name+" "+age;
    }

}



/*
----------------------------------------
Comparable
----------------------------------------
*/

class Person
        implements Comparable<Person>{

    int age;

    @Override
    public int compareTo(
            Person p
    ){
        return age-p.age;
    }

}



/*
----------------------------------------
Comparator
----------------------------------------
*/

people.sort(
        (a,b)->
        a.getAge()-b.getAge()
);
/*
----------------------------------------
CSV читання
----------------------------------------
*/

Scanner sc=
        new Scanner(
                new File(
                        "people.txt"
                ));

sc.nextLine();

while(
        sc.hasNextLine()
){

String line=
        sc.nextLine();

String[] data=
        line.split(",");

}

        sc.close();



/*
----------------------------------------
foreach
----------------------------------------
*/

for(Person p:people){

        System.out.println(
        p
        );

}



/*
----------------------------------------
HashMap foreach
----------------------------------------
*/

        for(String key:
        map.keySet()){

        System.out.println(
        key+" "+
                map.get(key)
    );

            }



/*
----------------------------------------
Stream
----------------------------------------
*/

            people.stream()
.filter(
        p->p.getAge()>18
        )
        .forEach(
        System.out::println
);



/*
----------------------------------------
try catch
----------------------------------------
*/

try{

int x=5/0;

}
        catch(Exception e){

        System.out.println(
        e.getMessage()
    );

            }
