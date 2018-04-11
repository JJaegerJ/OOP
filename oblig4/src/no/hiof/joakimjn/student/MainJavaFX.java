package no.hiof.joakimjn.student;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.hiof.joakimjn.student.Controller.AddMovieController;
import no.hiof.joakimjn.student.Controller.EditMovieController;
import no.hiof.joakimjn.student.model.Movie;


import java.io.IOException;
import java.time.LocalDate;

public class MainJavaFX extends Application {

    private ObservableList<Movie> allMovies = FXCollections.observableArrayList();
    private Stage primaryStage;
    public static MainJavaFX mainJavaFXApplication;
    public int selectedItem = 0;

    public MainJavaFX(){


     allMovies.addAll(Movie.getMovieList());

        //allMovies.add(new Movie("The Shawshank Redemption",131,"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", LocalDate.of(1994,10,14)));
        //allMovies.add(new Movie("The Dark Knight",162,"When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.",LocalDate.of(2008,7,18)));
        //allMovies.add(new Movie("Pulp Fiction",164,"The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",LocalDate.of(1994,10,14)));
        //allMovies.add(new Movie("Fight Club",139,"An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soapmaker, forming an underground fight club that evolves into something much, much more.",LocalDate.of(1999,10,15)));

        mainJavaFXApplication = this;


    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        goToMovieListView();
        FileHandler.readFile();

    }
    @Override
    public void stop()throws Exception {
        FileHandler.writeToFile();
    }

    public void goToMovieListView(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("view/MovieOverview.fxml"));
            Parent mainLayout = fxmlLoader.load();

            Scene mainScene = new Scene(mainLayout);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Movie Overview");
            primaryStage.setResizable(true);
            primaryStage.centerOnScreen();
            primaryStage.show();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
            showMessageBox(ioe.getMessage());
        }
    }

    public void goToEditView(){
        try{
            Stage editStage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("view/EditMovie.fxml"));
            Parent editLayout = fxmlLoader.load();

            EditMovieController editMovieController = fxmlLoader.getController();
            editMovieController.setStage(editStage);
            Scene editScene = new Scene(editLayout);

            editStage.initModality(Modality.APPLICATION_MODAL);
            editStage.initOwner(primaryStage);

            editStage.setScene(editScene);
            editStage.setTitle("Edit movie");
            editStage.setResizable(true);
            editStage.centerOnScreen();
            editStage.showAndWait();
        }
        catch (IOException ioe){
            showMessageBox("I/0 error: " + ioe.getMessage());
        }
        catch (IllegalStateException exc) {
            showMessageBox("An error occured: " + exc.getMessage());
            System.err.println(exc);

        }
    }

    public void goToAddView(){
        try {
            Stage addStage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("view/AddMovie.fxml"));
            Parent addLayout = fxmlLoader.load();

            AddMovieController addMovieController = fxmlLoader.getController();
            addMovieController.setStage(addStage);
            Scene addScene = new Scene(addLayout);

            addStage.initModality(Modality.APPLICATION_MODAL);
            addStage.initOwner(primaryStage);

            addStage.setScene(addScene);
            addStage.setTitle("Add movie");
            addStage.setResizable(true);
            addStage.centerOnScreen();
            addStage.showAndWait();
        }
        catch (IOException ioe){
            showMessageBox("I/O error: " + ioe.getMessage());
        }
        catch (IllegalStateException exc) {
            showMessageBox("Error: " + exc.getMessage());
            System.err.println(exc);
        }

    }


    public void showMessageBox(String message){
        Alert e = new Alert(Alert.AlertType.ERROR);
        e.setTitle("An error occurred!");
        e.setHeaderText(null);
        e.setContentText(message);
        e.show();
    }

    public ObservableList<Movie> getAllMovies() {
        return allMovies;
    }


    public static void main(String[] args) {
        launch(args);
    }
}