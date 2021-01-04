package examples.anonymousAndLambda.example;

public class Book {

    public int num = 5;
    private String title;
    private String author;
    private String year;
    private String description;
    private static String publisher = "Presença";


   // Book > getNumber
    public int getNumber() {
        return num;
    }

    // variavel estática tem sempre o mesmo valor
    // função estática retorna sempre o mesmo valor quando lhe é passado os mesmos argumentos
   //Book > getPublisher
    public static String getPublisher(){
        return  publisher;
    }

    public Book (int num, String title, String author, String year, String description){
        this.num = num;
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
    }

    //Book > Writer
    // Classes internas
    public class Writer{

        public String name;
        public int age;
        public String gender;

        public Writer (String name, int age, String gender){
            this.name = name;
            this.age = age;
            this.gender = gender;
            System.out.println(title);
        }

    }

    //Book > Editor
    public static class Editor{

        public String name;
        public int age;
        public String gender;

        public Editor (String name, int age, String gender){
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

    }

}




