import donnees.Reservation;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class GestionInterface {
    private TableView<Reservation> tableReservations; // Tableau utilisé pour afficher les réservations
    private Stage primaryStage; // Stage principal de l'application

    public GestionInterface(TableView<Reservation> tableReservations, Stage primaryStage) {
        this.tableReservations = tableReservations;
        this.primaryStage = primaryStage;
        initListeners(); // Initialise les écouteurs d'événements
    }

    private void initListeners() {
        tableReservations.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            // Lorsque la sélection dans le tableau change
            if (newSelection != null) {
                afficherInterfaceAffichage(newSelection); // Affiche l'interface de visualisation pour la nouvelle réservation sélectionnée
            }
        });
    }

    private void afficherInterfaceAffichage(Reservation reservation) {
        Interface_affichage interfaceAffichage = new Interface_affichage();
        interfaceAffichage.show(); // Affiche l'interface de visualisation pour la réservation donnée
    }
}
