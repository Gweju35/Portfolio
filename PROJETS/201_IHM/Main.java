import java.util.Date;

import donnees.Client;
import donnees.Reservation;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public void start(Stage primaryStage){
		primaryStage = new Interface_recherche();
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}