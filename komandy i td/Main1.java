/*
========================================
КЛАСИ І OOP
========================================
*/

/*
 * extends
 * наслідування класу.
 */
public class Dog extends Animal

/*
 * implements
 * реалізація interface.
 */
public class Polygon implements Shape

/*
 * super(...)
 * виклик конструктора
 * батьківського класу.
 */
super(name);

        /*
         * this
         * поточний об'єкт.
         */
        this.name = name;

/*
 * this(...)
 * виклик іншого конструктора.
 */
this(firstName,lastName,birthday,null);

/*
 * static
 * належить класу,
 * а не об'єкту.
 */
public static void test()

/*
 * final
 * значення не змінюється.
 */
private final String name;

/*
 * abstract class
 * базовий абстрактний клас.
 */
public abstract class Shape

/*
 * abstract метод
 * без реалізації.
 */
public abstract String toSvg();

/*
 * interface
 * задає методи для класів.
 */
public interface Shape

/*
 * record
 * короткий клас для даних.
 */
public record Vec2(double x, double y)

        /*
         * Serializable
         * дозволяє зберігати
         * об'єкт у файл.
         */
        implements Serializable

/*
 * instanceof
 * перевірка типу об'єкта.
 */
if(obj instanceof Person)

/*
========================================
МЕТОДИ OBJECT
========================================
*/

/*
 * toString()
 * красивий вивід об'єкта.
 */
@Override
public String toString()

/*
 * compareTo()
 * потрібний для сортування.
 */
@Override
public int compareTo(Person other)

/*
 * getMessage()
 * текст помилки.
 */
@Override
public String getMessage()

/*
 * equals()
 * порівняння об'єктів.
 */
@Override
public boolean equals(Object o)

/*
 * hashCode()
 * hash код об'єкта.
 */
@Override
public int hashCode()

/*
========================================
КОЛЕКЦІЇ
========================================
*/

/*
 * ArrayList
 * динамічний список.
 */
List<Person> people =
        new ArrayList<>();

/*
 * HashSet
 * тільки унікальні елементи.
 */
Set<Person> children =
        new HashSet<>();

/*
 * Map<Key,Value>
 * ключ -> значення.
 */
Map<String,List<Person>> family =
        new HashMap<>();

/*
 * add()
 * додає елемент.
 */
people.add(person);

/*
 * get()
 * отримує елемент.
 */
people.get(0);

/*
 * put()
 * додає елемент у Map.
 */
family.put(key,value);

/*
 * containsKey()
 * перевірка чи є ключ.
 */
family.containsKey(key);

/*
 * size()
 * кількість елементів.
 */
people.size();

/*
 * remove()
 * видалення елемента.
 */
people.remove(0);

/*
 * clear()
 * очищення колекції.
 */
people.clear();

/*
 * contains()
 * чи є елемент.
 */
people.contains(person);

/*
 * iterator()
 * обхід колекції.
 */
children.iterator().next();

/*
========================================
STREAM API
========================================
*/

/*
 * stream()
 * потік даних колекції.
 */
people.stream()

/*
 * sorted()
 * сортування елементів.
 */
people.stream().sorted()

/*
 * toList()
 * stream -> List
 */
people.stream().toList()

/*
 * filter()
 * фільтрація елементів.
 */
people.stream().filter(p -> p.age > 18);

        /*
         * map()
         * перетворення даних.
         */
        people.stream().map(Person::name);

/*
 * forEach()
 * дія для кожного елемента.
 */
people.forEach(System.out::println);

/*
========================================
РЯДКИ І TEXT
========================================
*/

/*
 * split(",")
 * ділить текст.
 */
String[] data = line.split(",");

/*
 * equals()
 * порівняння тексту.
 */
text.equals(other);

/*
 * equalsIgnoreCase()
 * без врахування регістру.
 */
text.equalsIgnoreCase("Y");

/*
 * String.format(...)
 * вставляє значення у текст.
 *
 * %s -> String
 * %d -> int
 * %f -> float/double
 */
String.format("%s %d",name,age);

/*
 * length()
 * довжина тексту.
 */
text.length();

/*
 * isEmpty()
 * чи рядок пустий.
 */
text.isEmpty();

/*
 * contains()
 * чи містить текст.
 */
text.contains("abc");

/*
 * substring()
 * частина рядка.
 */
text.substring(0,5);

/*
 * replace()
 * заміна тексту.
 */
text.replace("a","b");

/*
 * toLowerCase()
 * нижній регістр.
 */
text.toLowerCase();

/*
 * toUpperCase()
 * верхній регістр.
 */
text.toUpperCase();

/*
 * charAt()
 * символ по індексу.
 */
text.charAt(0);

/*
 * StringBuilder
 * швидке створення тексту.
 */
StringBuilder sb =
        new StringBuilder();

/*
 * append()
 * додає текст.
 */
sb.append("abc");

/*
 * toString()
 * StringBuilder -> String
 */
sb.toString();

/*
========================================
ДАТИ
========================================
*/

/*
 * LocalDate.of(...)
 * створення дати.
 */
LocalDate.of(2024,1,1);

/*
 * LocalDate.parse()
 * String -> дата.
 */
LocalDate.parse("2024-01-01");

/*
 * now()
 * поточна дата.
 */
LocalDate.now();

/*
 * getYear()
 * отримання року.
 */
date.getYear();

/*
 * plusDays()
 * додавання днів.
 */
date.plusDays(5);

/*
 * isAfter()
 * чи дата пізніше.
 */
date1.isAfter(date2);

/*
 * isBefore()
 * чи дата раніше.
 */
date1.isBefore(date2);

/*
 * compareTo()
 * порівняння дат.
 *
 * <0 -> менше
 * >0 -> більше
 * 0 -> однакові
 */
date1.compareTo(date2);

/*
 * DateTimeFormatter
 * форматування дат.
 */
DateTimeFormatter.ofPattern("d.M.y");

/*
========================================
ФАЙЛИ
========================================
*/

/*
 * BufferedReader
 * читання файлу по рядках.
 */
BufferedReader reader =
        new BufferedReader(
                new FileReader(path)
        );

/*
 * readLine()
 * читає рядок.
 */
reader.readLine();

/*
 * FileWriter
 * запис тексту у файл.
 */
FileWriter writer =
        new FileWriter(path);

/*
 * ObjectOutputStream
 * запис об'єктів у файл.
 */
ObjectOutputStream oos =
        new ObjectOutputStream(fos);

/*
 * ObjectInputStream
 * зчитування об'єктів.
 */
ObjectInputStream ois =
        new ObjectInputStream(fis);

/*
 * exists()
 * чи файл існує.
 */
file.exists();

/*
 * canRead()
 * чи можна читати файл.
 */
file.canRead();

/*
 * close()
 * закриття файлу.
 */
reader.close();

/*
========================================
ПОМИЛКИ
========================================
*/

/*
 * try/catch
 * перехоплення помилок.
 */
try{

        }catch(Exception e){

        }

        /*
         * throw
         * створення помилки вручну.
         */
        throw new IOException();

/*
 * RuntimeException
 * помилка часу виконання.
 */
throw new RuntimeException(e);

/*
========================================
ЦИКЛИ І УМОВИ
========================================
*/

/*
 * foreach цикл
 * проходить по колекції.
 */
for(Person p : people)

        /*
         * for цикл
         * цикл по індексах.
         */
        for(int i=0;i<10;i++)

        /*
         * while
         * працює поки умова true.
         */
        while(line != null)

        /*
         * continue
         * пропускає ітерацію.
         */
        continue;

        /*
         * break
         * зупиняє цикл.
         */
        break;

        /*
         * if
         * умова.
         */
        if(x > 0)

        /*
         * else
         * інакше.
         */
        else

        /*
         * switch
         * вибір варіанту.
         */
        switch(day)

/*
========================================
MATH
========================================
*/

        /*
         * Math.max/min
         * максимум і мінімум.
         */
        Math.max(a,b);
Math.min(a,b);

/*
 * Math.random()
 * випадкове число.
 */
Math.random();

/*
 * Math.sqrt()
 * квадратний корінь.
 */
Math.sqrt(25);

/*
 * Math.pow()
 * степінь.
 */
Math.pow(2,3);

/*
 * Math.abs()
 * модуль числа.
 */
Math.abs(-5);

/*
 * Math.round()
 * округлення.
 */
Math.round(5.6);

/*
 * parseInt()
 * String -> int
 */
Integer.parseInt("15");

/*
========================================
SCANNER
========================================
*/

/*
 * Scanner
 * зчитування тексту.
 */
Scanner scanner =
        new Scanner(System.in);

/*
 * nextLine()
 * читає рядок тексту.
 */
scanner.nextLine();

/*
 * nextInt()
 * читає int.
 */
scanner.nextInt();

/*
 * nextDouble()
 * читає double.
 */
scanner.nextDouble();

/*
 * hasNextLine()
 * чи є ще рядок.
 */
scanner.hasNextLine();

/*
========================================
ІНШЕ
========================================
*/

/*
 * return
 * повертає значення.
 */
return result;

/*
 * new
 * створення об'єкта.
 */
Person p = new Person();

/*
 * null
 * відсутність об'єкта.
 */
Person p = null;

/*
 * ==
 * порівняння посилань.
 */
if(a == b)

        /*
         * !=
         * не дорівнює.
         */
        if(a != b)

        /*
         * Arrays.toString()
         * масив -> текст.
         */
        Arrays.toString(array);

/*
 * Arrays.copyOfRange()
 * копіювання частини масиву.
 */
Arrays.copyOfRange(arr,1,4);



/*
========================================
ЩЕ ВАЖЛИВІ КОМАНДИ
========================================
*/

/*
 * private
 * доступ тільки всередині класу.
 */
private int age;

/*
 * public
 * доступ звідусіль.
 */
public void test()

/*
 * protected
 * доступ у дочірніх класах.
 */
protected Shape shape;

/*
 * new
 * створення об'єкта.
 */
Person p = new Person();

/*
 * null
 * об'єкт відсутній.
 */
Person p = null;

/*
 * enum
 * набір констант.
 */
enum Color{
    RED,GREEN,BLUE
}

/*
 * @Override
 * перевизначення методу.
 */
@Override
public String toString()

/*
 * throws
 * метод може викинути помилку.
 */
public void save() throws IOException

/*
 * instanceof
 * перевірка типу.
 */
if(obj instanceof Person)

        /*
         * casting
         * перетворення типу.
         */
        (Person)obj

/*
 * %
 * остача від ділення.
 */
10 % 3

/*
 * ++
 * збільшення на 1.
 */
i++

/*
 * --
 * зменшення на 1.
 */
i--

/*
 * +=
 * додавання до змінної.
 */
sum += x;

/*
 * ternary operator
 * короткий if.
 */
x = (a > b) ? 1 : 0;

        /*
         * lambda
         * короткий запис функції.
         */
        (x,y) -> x+y

/*
 * method reference
 * скорочений виклик методу.
 */
System.out::println

/*
 * trim()
 * прибирає пробіли.
 */
text.trim();

/*
 * startsWith()
 * чи починається текст.
 */
text.startsWith("abc");

/*
 * endsWith()
 * чи закінчується текст.
 */
text.endsWith("txt");

/*
 * indexOf()
 * пошук символу/тексту.
 */
text.indexOf("a");

/*
 * Arrays.sort()
 * сортування масиву.
 */
Arrays.sort(array);

/*
 * Collections.sort()
 * сортування List.
 */
Collections.sort(list);

/*
 * Collections.reverse()
 * перевертає список.
 */
Collections.reverse(list);

/*
 * Optional
 * безпечна робота з null.
 */
Optional<Person>

/*
 * var
 * Java сама визначає тип.
 */
var text = "Hello";

/*
 * static class
 * внутрішній static клас.
 */
public static class Builder

/*
 * Builder pattern
 * поетапне створення об'єкта.
 */
new Builder()
        .name("Jan")
        .age(20)
        .build();

/*
 * varargs
 * багато параметрів одного типу.
 */
public void add(Person... people)

/*
 * generic
 * узагальнений тип.
 */
List<Person>

/*
 * queue
 * черга FIFO.
 */
Queue<Person>

/*
 * stack
 * стек LIFO.
 */
Stack<Integer>

/*
 * peek()
 * подивитись елемент.
 */
stack.peek();

/*
 * pop()
 * взяти і видалити елемент.
 */
stack.pop();

/*
 * push()
 * додати у stack.
 */
stack.push(5);