package no.hiof.joakimjn.student.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import no.hiof.joakimjn.student.MainJavaFX;
import no.hiof.joakimjn.student.model.Movie;
import no.hiof.joakimjn.student.model.Production;

import java.util.Objects;


public class AddMovieController {
    @FXML
    private TextField addMovieTitle;
    @FXML
    private TextField addMovieDuration;
    @FXML
    private TextArea addMovieDescription;
    @FXML
    private DatePicker addMovieReleaseDate;

    private Stage stage;
    private MainJavaFX mainJavaFX;



    @FXML
    public void initialize(){
    }

    @FXML
    private void cancelAddMovie(ActionEvent actionEvent){
        stage.close();
    }


    @FXML
    private void addMovie(ActionEvent actionEvent){

        try{
             if (addMovieTitle.getText().isEmpty())
                MainJavaFX.mainJavaFXApplication.showMessageBox("Type in a title");
            else if (addMovieDescription.getText().isEmpty())
                MainJavaFX.mainJavaFXApplication.showMessageBox("Type in a description");
            else if (addMovieReleaseDate.getValue() == null)
                MainJavaFX.mainJavaFXApplication.showMessageBox("Select a release date");
            else if (addMovieDuration.getText().isEmpty())
                MainJavaFX.mainJavaFXApplication.showMessageBox("Type in a duration");


            if (!addMovieTitle.getText().isEmpty() && !addMovieDescription.getText().isEmpty() && addMovieReleaseDate.getValue() != null && !addMovieDuration.getText().isEmpty()) {
                Production oneMovie = new Movie(addMovieTitle.getText(),Integer.parseInt(addMovieDuration.getText()), addMovieDescription.getText(), addMovieReleaseDate.getValue());
                mainJavaFX.mainJavaFXApplication.getAllMovies().add((Movie) oneMovie);
                stage.close();
            }



        }
        catch (Error e){
            System.out.println(e.getMessage());
        }

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}