package examples.anonymousAndLambda.example;

public class Main {
    public static void main(String[] args) {

       Book livroDoAlfama = new Book(12, "O Livro do Alfama", "António Alfama", "2021", "Era uma vez o Alfama...");
       Book livroDoSamuel = new ThrillerBook(13, "O Livro do Samuel", "Samuel Dias", "2021", "Era uma vez o Samuel...");

        livroDoAlfama.getNumber(); //

       Book.getPublisher(); //Presença ---> Mais correta
       livroDoAlfama.getPublisher(); // Presença ---> Também da :)
        livroDoSamuel.getPublisher(); // Presença


        Book.Writer writer = livroDoAlfama.new Writer("Antonio", 120, "Other");
        Book.Editor editor = new Book.Editor("Lia", 121, "Tea and Mushroom");
        System.out.println(writer.name);


    }
}
