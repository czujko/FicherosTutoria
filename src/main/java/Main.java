import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Director director = new Director("Steven Spielberg", "EUA", "Fantástico");
        Director director2 = new Director("Quentin Tarantino", "EUA", "Terror");
        Director director3 = new Director("Martin Scorsese", "EUA", "Drama");
        Director director4 = new Director("Christopher Nolan", "EUA", "Acción");
        Director director5 = new Director("David Fincher", "EUA", "Acción");
        Director director6 = new Director("James Cameron", "EUA", "Acción");
        Director director7 = new Director("Ridley Scott", "EUA", "Ciencia ficción");
        Director director8 = new Director("David Lynch", "EUA", "Drama");
        Director director9 = new Director("Guillermo del Toro", "EUA", "Acción");
        Director director10 = new Director("Alfonso Cuarón", "EUA", "Drama");
        Director director11 = new Director("Francis Ford Coppola", "EUA", "Drama");


        //ArrayList de directores
        ArrayList<Director> directores = new ArrayList<Director>();

        directores.add(director);
        directores.add(director2);
        directores.add(director3);
        directores.add(director4);
        directores.add(director5);
        directores.add(director6);
        directores.add(director7);
        directores.add(director8);
        directores.add(director9);
        directores.add(director10);
        directores.add(director11);

        director.writeDirector(directores);
        director.writeDirectorXML(directores);
        director.writeDirectorCSV(directores);


        System.out.println("Lectura de archivo .CSV\n" + director.leeDirectorCSV());
        System.out.println("Lectura de archivo .XML\n" + director.leeDirectorXML());
        System.out.print("Lectura de archivo .TXT\n");
        director.leeDirector();

        /*Director director12 = new Director("John Ford", "EUA", "Western");
        director.writeDirector(director12);*/

        //director.leeDirectorTXT();

        //director.writeDirectorXML(director.DirectorTxtToArrayList());
        //director.DirectorTxtToArrayList().forEach(System.out::println);



    }
}
