package no.hiof.joakimjn.student;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.ObservableList;
import no.hiof.joakimjn.student.model.Movie;

import java.io.*;
import java.time.LocalDate;

public class FileHandler {



    public static void FileReaderJson(String fileLocation) {
        Gson gson = new Gson();
        File file = new File(fileLocation);
        Gson ggson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();


        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {


            String jsonString = bufferedReader.readLine();
            gson.fromJson(jsonString, Movie[].class);

        } catch (IOException ioexc) {
            System.out.println(ioexc);
        }
    }

    public static void FileWriterJson(String fileLocation, ObservableList<Movie> list) {
        Gson gson = new Gson();
        File filepath = new File(fileLocation);


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLocation))) {
            String movieTojason = gson.toJson(list);
            bufferedWriter.write(movieTojason);
        } catch (IOException ioexc) {
            System.out.println(ioexc);
        }
    }
}
