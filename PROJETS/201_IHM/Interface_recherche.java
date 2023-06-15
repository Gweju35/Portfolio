import java.util.Date;

import donnees.Client;
import donnees.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Interface_recherche extends Stage {
    // Donnees
    ObservableList<Reservation> liste = FXCollections.observableArrayList();
   
    // Composant graphiques
    private BorderPane racine = new BorderPane();
    private TableView<Reservation> tableReservations = new TableView<Reservation>();

    public Interface_recherche() {
    	Client client1 = new Client(1, "Monsieur", "Michel", "Michel", "18 rue de la paix", "20 rue du portail", "35133", "Lannion", "0606060606", "bonjour@gmail.com");
        Date dateArrivee = new Date(2023, 6, 13);
        Date dateDepart = new Date(2023, 6, 20);
        Reservation reservation1 = new Reservation("2", client1, dateArrivee, dateDepart);
    	
        liste.add(reservation1);

        this.setTitle("Recherche");
        this.setWidth(900);
        this.setHeight(900);
        this.setScene(new Scene(creerContenu()));
        GestionInterface interfaceGestion = new GestionInterface(tableReservations, null);
    }

    private Parent creerContenu() {
        // PARTIE RECHERCHE

        // Titre de sections de recherche
        Label titre_reserv = new Label("Réservation");
        titre_reserv.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
        Label titre_client = new Label("Client");
        titre_client.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");

        // Ligne de recherche en connaissances des infos sur la reservation
        VBox reserv_section = new VBox();

        HBox line_reserv = new HBox();

        // Selection numéro de réservation
        HBox tick_num = new HBox();
        Label titre_num = new Label("Numéro");
        TextField field_num = new TextField();
        field_num.setPrefWidth(150);
        field_num.setMaxWidth(150);
        tick_num.getChildren().addAll(titre_num, field_num);
        tick_num.setSpacing(15);

        line_reserv.getChildren().add(tick_num);
        line_reserv.setPadding(new Insets(0, 0, 0, 30));
        reserv_section.getChildren().addAll(titre_reserv, line_reserv);
        reserv_section.setSpacing(10);

        // Ligne de recherche en connaissances des infos sur le client
        VBox client_section = new VBox();

        HBox line_client = new HBox();

        // Selection prenom
        HBox tick_prenom = new HBox();
        Label titre_prenom = new Label("Prenom");
        TextField field_prenom = new TextField();
        field_prenom.setPrefWidth(100);
        field_prenom.setMaxWidth(100);
        tick_prenom.getChildren().addAll(titre_prenom, field_prenom);
        tick_prenom.setSpacing(15);

        // Selection nom
        HBox tick_nom = new HBox();
        Label titre_nom = new Label("Nom");
        TextField field_nom = new TextField();
        field_nom.setPrefWidth(100);
        field_nom.setMaxWidth(100);
        tick_nom.getChildren().addAll(titre_nom, field_nom);
        tick_nom.setSpacing(15);

        // Selection numéro de téléphone
        HBox tick_tel = new HBox();
        Label titre_tel = new Label("Numéro de téléphone");
        TextField field_tel = new TextField();
        field_tel.setPrefWidth(150);
        field_tel.setMaxWidth(150);
        tick_tel.getChildren().addAll(titre_tel, field_tel);
        tick_tel.setSpacing(15);

        line_client.getChildren().addAll(tick_prenom, tick_nom, tick_tel);
        line_client.setSpacing(20);
        line_client.setPadding(new Insets(0, 0, 0, 30));

        client_section.getChildren().addAll(titre_client, line_client);
        client_section.setSpacing(10);

        HBox line_look = new HBox();
        Button look = new Button("Recherche");
        line_look.getChildren().add(look);
        line_look.setPadding(new Insets(0, 0, 0, this.getWidth() - 300));

        VBox recherche_box = new VBox();
        recherche_box.getChildren().addAll(reserv_section, client_section, line_look);
        recherche_box.setSpacing(20);
        recherche_box.setPadding(new Insets(30, 10, 10, 30));
        recherche_box.setBackground(new Background(new BackgroundFill(Color.web("8EA2C6", 1.0), new CornerRadii(0), new Insets(0))));

        // PARTIE RESULTAT

        TableColumn<Reservation, Integer> colonne1 = new TableColumn<Reservation, Integer>("Num Client");
        colonne1.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("Num Client"));
        tableReservations.getColumns().add(colonne1);

        TableColumn<Reservation, Integer> colonne2 = new TableColumn<Reservation, Integer>("Nom");
        colonne2.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("Nom"));
        tableReservations.getColumns().add(colonne2);

        TableColumn<Reservation, Integer> colonne3 = new TableColumn<Reservation, Integer>("Prenom");
        colonne3.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("Prenom"));
        tableReservations.getColumns().add(colonne3);

        TableColumn<Reservation, Integer> colonne4 = new TableColumn<Reservation, Integer>("Téléphone");
        colonne4.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("Téléphone"));
        tableReservations.getColumns().add(colonne4);

        TableColumn<Reservation, Integer> colonne5 = new TableColumn<Reservation, Integer>("Debut");
        colonne5.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("Debut"));
        tableReservations.getColumns().add(colonne5);

        TableColumn<Reservation, Integer> colonne6 = new TableColumn<Reservation, Integer>("Fin");
        colonne6.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("Fin"));
        tableReservations.getColumns().add(colonne6);

        tableReservations.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tableReservations.setItems(liste);

        racine.setTop(recherche_box);
        racine.setCenter(tableReservations);
        
        // Gestion de l'événement de recherche
        look.setOnAction(e -> {
            String telephone = field_tel.getText();
            if (telephone.matches("\\d*")) {
                // Le numéro de téléphone est valide, effectuez la recherche
                // ...
            } else {
                // Afficher une fenêtre d'erreur
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Le numéro de téléphone doit contenir uniquement des chiffres.");

                alert.showAndWait();
            }
        });

        return racine;
    }
}