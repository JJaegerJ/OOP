package no.hiof.joakimjn.student.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.hiof.joakimjn.student.MainJavaFX;
import no.hiof.joakimjn.student.model.Movie;

public class MovieOverviewController {


    @FXML
    private Label movieTitle;
    @FXML
    private TextArea movieDescription;
    @FXML
    private TextField movieReleaseDate;
    @FXML
    private TextField movieDuration;
    @FXML
    private ListView<Movie> MovieOverviewList;
    @FXML
    private ImageView PosterView;

    public ObservableList<Movie> movieObservableList = MainJavaFX.mainJavaFXApplication.getAllMovies();

    @FXML
    public void initialize(){


        MovieOverviewList.setItems(MainJavaFX.mainJavaFXApplication.getAllMovies());
        MovieOverviewList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        MovieOverviewList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Movie>() {
            @Override
            public void changed(ObservableValue<? extends Movie> observable, Movie oldMovie, Movie newMovie) {
                if (newMovie != null) {
                    movieDescription.setText(newMovie.getDescription());
                    movieDuration.setText(String.valueOf(newMovie.getDuration()));
                    movieReleaseDate.setText(String.valueOf(newMovie.getReleaseDate()));
                    movieTitle.setText(newMovie.getTitle());
                    Image poster = new Image("https://image.tmdb.org/t/p/w500" + newMovie.getPosterURL());
                    PosterView.setImage(poster);
                }


            }
        });

        if (!MovieOverviewList.getItems().isEmpty()) {
            MovieOverviewList.getSelectionModel().select(MainJavaFX.mainJavaFXApplication.selectedItem);
        }
    }

    @FXML
    public void deleteMovie(ActionEvent actionEvent){
        if (!MovieOverviewList.getItems().isEmpty()) {
            MovieOverviewList.getItems().remove(MovieOverviewList.getSelectionModel().getSelectedIndex());
        }
        else {
            MainJavaFX.mainJavaFXApplication.showMessageBox("Error: Select a file from the list to delete");            }
    }


    @FXML
    public void goToEditScene(ActionEvent actionEvent){
        MainJavaFX.mainJavaFXApplication.goToEditView();
    }

    public ListView<Movie> getMovieOverviewList() {
        return MovieOverviewList;
    }
    @FXML
    public void goToAddScene(ActionEvent actionEvent) {
        MainJavaFX.mainJavaFXApplication.goToAddView();

    }
}
