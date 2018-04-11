package no.hiof.joakimjn.student;

import no.hiof.joakimjn.student.model.Movie;
import no.hiof.joakimjn.student.model.Production;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class FileHandler {

    public static void readFile() {

        String fileName = "Movies.csv";
        File file = new File(fileName);
        String noe = "noe"; //Variable for testing invalid filepath

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");


                String title = values[0];
                int runtime = Integer.parseInt(values[2]);
                String description = values[1];
                LocalDate date = LocalDate.parse(values[3]);
                String poster = values[4];


                Movie lmao = new Movie(title, runtime, description, date, poster);
                MainJavaFX.mainJavaFXApplication.getAllMovies().add(lmao);
            }


        } catch (FileNotFoundException fnfe) {
            MainJavaFX.mainJavaFXApplication.showMessageBox("Error when trying to read file: " + fnfe.getMessage());
        } catch (IOException ioexc) {
            System.out.println(ioexc);
        }

    }

    public static void writeToFile(){

        File file = new File("Movies.csv");

        if (file.exists()) {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (Movie aFilm : MainJavaFX.mainJavaFXApplication.getAllMovies()) {
                    bw.write(aFilm.getTitle() + ";" + aFilm.getDescription() + ";" + aFilm.getDuration() + ";" + aFilm.getReleaseDate() + ";" + aFilm.getPosterURL());
                    bw.newLine();
                }
            }catch (IOException ioexc) {
                System.out.println(ioexc);
            }
        }
        else
            MainJavaFX.mainJavaFXApplication.showMessageBox("Error when trying to write to file");
    }


}