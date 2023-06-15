
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import donnees.Prestation;
import donnees.Reservation;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Interface_affichage extends Stage{

	private Reservation reservation;
	private BorderPane racine = new BorderPane();
	
	public Interface_affichage() {
		this.setTitle("Affichage d'une réservation");
		this.setWidth(900);
		this.setHeight(600);
		this.setScene(new Scene(creerContenu()));
		
	}
	
	private String count(String lib) {
		Integer som=0;
		for (Prestation i : reservation.getPrestations().keySet()) {
			if (i.getLibelle()==lib)
				som=som+1;
			}
		return String.valueOf(som);
	}
	
	private Parent creerContenu() {
		HBox Charlie = new HBox();
		Label charlie_emily = new Label("Affichage Réservation");
		charlie_emily.setPadding(new Insets(10, 30, 10, this.getWidth()-600));
		charlie_emily.setStyle("-fx-font-size:18 ; -fx-font-weight:BOLD");
		Charlie.getChildren().addAll(charlie_emily);
		Charlie.setBackground(new Background(new BackgroundFill(Color.web("8EA2C6", 1.0), new CornerRadii(0), new Insets(0))));
		Charlie.setPadding(new Insets(10, 30, 10, 50));
		
		VBox v_res = new VBox();
		Label titre_res 	= new Label("Réservation");
		titre_res.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		Label titre_num 	= new Label();
		titre_num.setPadding(new Insets(10, 30, 10, 30));
		VBox v_cli = new VBox();
		Label titre_client 	= new Label("Client");
		titre_client.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		HBox h_name = new HBox();
		h_name.setPadding(new Insets(10, 30, 10, 30));
		Label titre_nom 	= new Label();
		Label titre_prenom 	= new Label();
		Label titre_tel 	= new Label();
		titre_tel.setPadding(new Insets(10, 30, 10, 30));
		HBox h_adr = new HBox();
		h_adr.setPadding(new Insets(10, 30, 10, 30));
		Label titre_adresse1 	= new Label();
		Label titre_adresse2 	= new Label();
		HBox h_ct = new HBox();
		h_ct.setPadding(new Insets(10, 30, 10, 30));
		Label titre_post 	= new Label();
		Label titre_city 	= new Label();
		VBox v_dt = new VBox();
		Label titre_general 	= new Label("Dates");
		titre_general.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		HBox h_arr = new HBox();
		h_arr.setPadding(new Insets(10, 30, 10, 30));
		Label titre_arr 	= new Label("Date d'arrivée :");
		Label titre_arrive 	= new Label();
		HBox h_dep = new HBox();
		h_dep.setPadding(new Insets(10, 30, 10, 30));
		Label titre_dep 	= new Label("Date de départ :");
		Label titre_depart 	= new Label();
		VBox v_room = new VBox();
		Label titre_chambre 	= new Label("Chambre");
		titre_chambre.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		VBox v_presto = new VBox();
		Label titre_prestation 	= new Label("Prestations");
		titre_prestation.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		VBox nevermore = new VBox();
		
		SimpleStringProperty num 	= new SimpleStringProperty();
		
		titre_num.textProperty().bind(Bindings.createStringBinding( () -> num.get(),num));
		
		SimpleStringProperty nom 	= new SimpleStringProperty();
		titre_nom.textProperty().bind(Bindings.createStringBinding( () -> nom.get(),nom));
		
		v_res.getChildren().addAll(titre_res,titre_num);
		h_name.getChildren().addAll(titre_nom,titre_prenom);
		h_ct.getChildren().addAll(titre_city,titre_post);
		h_adr.getChildren().addAll(titre_adresse1,titre_adresse2);
		v_cli.getChildren().addAll(titre_client,h_name,titre_tel,h_adr,h_ct);
		h_arr.getChildren().addAll(titre_arr,titre_arrive);
		h_dep.getChildren().addAll(titre_dep,titre_depart);
		v_dt.getChildren().addAll(titre_general,h_arr,h_dep);
				
		GridPane chambres = new GridPane();
		chambres.setPadding(new Insets(10, 30, 10, 30));
		
		Label cellnum = new Label("Numéros");
		cellnum.setPadding(new Insets(10, 30, 10, 30));
		chambres.add(cellnum, 0, 0);
		Label cellcat = new Label("Catégorie");
		cellcat.setPadding(new Insets(10, 30, 10, 30));
		chambres.add(cellcat, 1, 0);
		Label cellocc = new Label("Nombre d'occupants");
		cellocc.setPadding(new Insets(10, 30, 10, 30));
		chambres.add(cellocc, 2, 0);
		chambres.setGridLinesVisible(true);
		
		Label tabnum;
		Label tabcat;
		Label tabocc;
		
		GridPane prestations = new GridPane();
		prestations.setPadding(new Insets(10, 30, 10, 30));
		
		/*
		for (int i=0; i<reservation.getChambres().size();i++) {
			   tabnum=new Label(reservation.getChambres().get(i).getNumero_chambre());
			   chambres.add(tabnum, 0, i+1);
			   tabcat=new Label(reservation.getChambres().get(i).getCategorie());
			   chambres.add(tabcat, 1, i+1);
			   tabocc=new Label(String.valueOf(reservation.getChambres().get(i).getNb_clients()));
			   chambres.add(tabocc, 2, i+1);
		}
		*/
		
		
		v_room.getChildren().addAll(titre_chambre,chambres);
		
		
		

		
		Label cellcatcat = new Label("Categorie");
		cellcatcat.setPadding(new Insets(10, 30, 10, 30));
		prestations.add(cellcatcat, 0, 0);
		Label cellli = new Label("Libelle");
		cellli.setPadding(new Insets(10, 30, 10, 30));
		prestations.add(cellli, 1, 0);
		Label celldt = new Label("Date");
		celldt.setPadding(new Insets(10, 30, 10, 30));
		prestations.add(celldt, 2, 0);
		Label cellqt = new Label("Quantité");
		cellqt.setPadding(new Insets(10, 30, 10, 30));
		prestations.add(cellqt, 3, 0);
		prestations.setGridLinesVisible(true);
		
		List<String> list=new ArrayList<String>();
		
		Label tablib;
		Label tabdat;
		Label tabqt;
		Integer ppress=1;
		/*
		for (Prestation i : reservation.getPrestations().keySet()) {
			if (list.contains(i.getLibelle())) {
				tablib=new Label(i.getLibelle());
				prestations.add(tablib, 1, ppress);
				tabdat=new Label(String.valueOf(reservation.getPrestations().get(i)));
				prestations.add(tabdat, 2, ppress);
				tabqt=new Label(count(i.getLibelle()));
				prestations.add(tabqt, 3, ppress);
				ppress=ppress+1;
				list.add(i.getLibelle());
			}
			};
		*/
		
		
		v_presto.getChildren().addAll(titre_prestation,prestations);
		
		
		nevermore.setPadding(new Insets(10, 10, 10, 50));
		nevermore.setSpacing(20);
		nevermore.getChildren().addAll(v_res,v_cli,v_dt,v_room,v_presto);
		
		racine.setCenter(nevermore);
		racine.setTop(Charlie);
		
		return racine;
	}
}
