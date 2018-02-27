package no.hiof.joakimjn.student;

import javax.management.relation.RoleList;
import java.util.*;


public class Main {

    public static void main(String[] args) {


        //Her lager jeg et par episode objekter.

       Episode dexterS01E01 = new Episode(01,01, "Dexter",53);
       Episode dexterS03E01 = new Episode(01,03, "Our Father",58);
       Episode dexterS01E02 = new Episode(02,01, "Crocodile",55);
       Episode dexterS02E01 = new Episode(01,02, "It's Alive!",53);
       Episode dexterS07E01 = new Episode(01,07, "Are You...?",55);

        //Her lager jeg et Serie objekt

        Series Dexter = new Series("Dexter", "By day, mild-mannered Dexter is a blood-spatter analyst for the Miami police. But at night, he is a serial killer who only targets other murderers.", new Date(2006,01,01));

        //Her bruker jeg metoden addEpisode som legger episodene inn i en arraylist i series objektet "Dexter".

        Dexter.addEpisode(dexterS01E01);
        Dexter.addEpisode(dexterS01E02);
        Dexter.addEpisode(dexterS02E01);
        Dexter.addEpisode(dexterS03E01);

        //Løkke som lager 5 sesonger med 20 episoder i hver.

        for(int i=1; i<=5; i++){

            for(int j=1; j<=20; j++){
                Dexter.addEpisode(new Episode (j,i, "Ep"+j, new Random().nextInt(15+1)+40) );
            }
        }

        //Metoden printSeason med parameter 4, skriver ut alle episodene i sesong 4.

        Dexter.printSeason(4);


        //Printer ut Series objektet "Dexter" (toString override fra Series)

        System.out.println(Dexter);


        //Metode for å printer ut gjennomsnittlig spilletid av en serie

        System.out.println("Gjennomsnittsspilletid: " + Dexter.getAvgDuration() + " min");


        //Metode for å printe ut antall sesonger av en serie

        System.out.println("Antall sesonger: " + Dexter.getNumberOfSeasons());


        //Prøver å legge til en episode til Series som er 2 eller mer sesonger høyere enn den daværende høyeste sesongen.

        Dexter.addEpisode(dexterS07E01);

        System.out.println("*********************");



        Movie theGodfather = new Movie("The Godfather",175, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", new Date(1972,03,24));
        Movie angryMen = new Movie("12 Angry Men",96, "blalalslassa",new Date (1923,3,12));

        System.out.println(theGodfather.getTitle());
        System.out.println(angryMen.getTitle());

        System.out.println("*********************");

        Person director1 = new Person("Hans", "Preben");
        Person director2 = new Person("Knut", "Knutsen");
        Person director3 = new Person("Hønse", "Louisa");

        angryMen.setDirector(director1);
        theGodfather.setDirector(director2);
        dexterS01E01.setDirector(director3);

        System.out.println("Regissøren er: " + angryMen.getDirector());
        System.out.println("Regissøren er: " + theGodfather.getDirector());
        System.out.println("Regissøren er: " + dexterS01E01.getDirector());

        System.out.println("*********************");

        // Her lager jeg noen personer som jeg senere bruker som skuespillere i rolle klassen.
        Person marlonBrandon = new Person("Marlon", "Brandon");
        Person alPacino = new Person("Al", "Pacino");
        Person jamesCaan = new Person("James", "Caan");
        Person robertDuvall = new Person("Robert", "Duvall");

        Person michaelCHall = new Person("Michael C.", "Hall");
        Person jenniferCarpenter = new Person("Jennifer", "Carpenter");
        Person danielGoldman = new Person("Daniel", "Goldman");


        // Her lager jeg roller
        Role donVitoCorleone = new Role("Don Vito", "Corleone",marlonBrandon);
        Role michaelCorleone = new Role("Michael", "Corleone",alPacino);
        Role sonnyCorleone = new Role("Sonny","Corleone",jamesCaan);
        Role tomHagen = new Role("Tom", "Hagen", robertDuvall);

        Role dexterMorgan = new Role("Dexter", "Morgan", michaelCHall);
        Role debraMorgan = new Role("Debra", "Morgan", jenniferCarpenter);
        Role codyBennett = new Role("Cody", "Bennett", danielGoldman);

        // Her legger jeg til noen roller i episode 1 og 2 av Dexter
        dexterS01E01.addRole(dexterMorgan);
        dexterS01E01.addRole(debraMorgan);
        dexterS01E01.addRole(codyBennett);

        dexterS01E02.addRole(dexterMorgan);
        dexterS01E02.addRole(debraMorgan);

        // Her bruker jeg medtoden addRole for å legge til roller til filmen Gudfaren
        //theGodfather.addRole(donVitoCorleone);
        //theGodfather.addRole(michaelCorleone);
        //theGodfather.addRole(sonnyCorleone);
        theGodfather.addRole(tomHagen);


        // Her lager jeg et nytt rolle array og legger til 3 roller slik at jeg kan teste metoden addManyRoles
        ArrayList<Role> godfatherRoleList = new ArrayList<>();
        godfatherRoleList.add(donVitoCorleone);
        godfatherRoleList.add(michaelCorleone);
        godfatherRoleList.add(sonnyCorleone);


        // Her tester jeg medtoden addManyRoles
        theGodfather.addManyRoles(godfatherRoleList);

        // Her skriver jeg ut rollelisten til filmen Gudfaren
        System.out.println(theGodfather.getRoleList());

        System.out.println("*********************");

        // Her skriver jeg ut hele film obkjektet Gudfaren.
        System.out.println(theGodfather);

        System.out.println("*********************");

        //Her bruker jeg metoden getCast som henter ut alle roller i tv serien dexter og hva de heter.
     System.out.println(Dexter.getCast());

        Collections.sort();


    }
}
