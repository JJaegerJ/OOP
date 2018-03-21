package no.hiof.joakimjn.student.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.hiof.joakimjn.student.MainJavaFX;
import no.hiof.joakimjn.student.model.Movie;


public class EditMovieController {
    @FXML
    private ListView<Movie> editListView;
    @FXML
    private DatePicker editMovieReleaseDate;
    @FXML
    private TextField editMovieTitle;
    @FXML
    private TextField editMovieDuration;
    @FXML
    private TextArea editMovieDescription;
    @FXML
    private Stage stage;


    @FXML
    public void initialize() {
        editListView.setItems(MainJavaFX.mainJavaFXApplication.getAllMovies());

        editListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Movie>() {
            @Override
            public void changed(ObservableValue<? extends Movie> observable, Movie oldFilm, Movie newFilm) {
                editMovieDescription.setText(newFilm.getDescription());
                editMovieDuration.setText(String.valueOf(newFilm.getDuration()));
                editMovieReleaseDate.setValue(newFilm.getReleaseDate());
                editMovieTitle.setText(newFilm.getTitle());
            }
        });

        if (!editListView.getItems().isEmpty()) {
            editListView.getSelectionModel().select(MainJavaFX.mainJavaFXApplication.selectedItem);
        }
    }


    @FXML
    private void editMovie(ActionEvent actionEvent){


        if (editMovieTitle.getText().isEmpty())
            MainJavaFX.mainJavaFXApplication.showMessageBox("Type in a title.");
        else if (editMovieDescription.getText().isEmpty())
            MainJavaFX.mainJavaFXApplication.showMessageBox("Type in a description");
        else if (editMovieReleaseDate.getValue() == null)
            MainJavaFX.mainJavaFXApplication.showMessageBox("Select a release date.");
        else if (editMovieDuration.getText().isEmpty())
            MainJavaFX.mainJavaFXApplication.showMessageBox("Type in Duration.");
        else {
            updateInfo();
            MainJavaFX.mainJavaFXApplication.goToMovieListView();

            stage.close();
        }

    }


    private void updateInfo(){
        editListView.getSelectionModel().getSelectedItem().setTitle(editMovieTitle.getText());
        editListView.getSelectionModel().getSelectedItem().setDescription(editMovieDescription.getText());
        editListView.getSelectionModel().getSelectedItem().setDuration(Integer.parseInt(editMovieDuration.getText()));
        editListView.getSelectionModel().getSelectedItem().setReleaseDate(editMovieReleaseDate.getValue());
    }


    @FXML
    private void cancelMovieEdit(ActionEvent actionEvent){
        stage.close();
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }
}