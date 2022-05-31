package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import application.entities.Employee;
import application.entities.Salaire;
import application.entities.Vendeur;
import application.functions.functions;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class SalController implements Initializable  {
	 @FXML
	    private Button btnChek;

    @FXML
    private AnchorPane btnListeTout;

    @FXML
    private TextField Nom;

    @FXML
    private TextField email;

    @FXML
    private TextField recut;

    @FXML
    private TextField salaire;

    @FXML
    private TextField mat;

    @FXML
    private RadioButton btnE;

    @FXML
    private RadioButton BtnV;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableView<Salaire> table;

    @FXML
    private TableColumn<Salaire, Integer> matColmn;

    @FXML
    private TableColumn<Salaire, Integer> nameColmn;

    @FXML
    private TableColumn<Salaire, Integer> emailColmn;

    @FXML
    private TableColumn<Salaire, Integer> recColmn;

    @FXML
    private TableColumn<Salaire, Integer> salColmn;
    @FXML
    private TableColumn<Salaire, Integer> roleCol;

    @FXML
    private Button btnMax;

    @FXML
    private Button btnMix;

    @FXML
    private Button BTNDet;

    @FXML
    private Button BtnExport;

    @FXML
    private Button BtnListeAn;

    @FXML
    private TextField first;

    @FXML
    private TextField last;

    @FXML
    private Button BtnBetwwen;
    @FXML
    private TextField Hsupp;
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	matColmn.setCellValueFactory(new PropertyValueFactory<>("Matricule"));
    	nameColmn.setCellValueFactory(new PropertyValueFactory<>("Nom"));
    	emailColmn.setCellValueFactory(new PropertyValueFactory<>("Email"));
    	roleCol.setCellValueFactory(new PropertyValueFactory<>("Cat"));
    	recColmn.setCellValueFactory(new PropertyValueFactory<>("AnneRecruit"));
    	salColmn.setCellValueFactory(new PropertyValueFactory<>("Salaire"));
		functions f= new functions();
		table.getItems().addAll(f.listerEmployee());
		table.getItems().addAll(f.listerVendeur());
	}
    @FXML
    void Add(ActionEvent event) {
    	
    	if(btnE.isSelected()) {
    		Employee emp = new Employee(Integer.parseInt(mat.getText()), Nom.getText(), email.getText(),"E",Double.parseDouble(recut.getText()), 0.1,Double.parseDouble(Hsupp.getText()),0);
    		System.out.println(emp.toString());
    		functions AS = new functions();
    		boolean result = AS.createEmployee(emp);
    		table.getItems().add(AS.getSalarie(emp.getMatricule()));
    	} else if(BtnV.isSelected()) {
    		Vendeur vdr = new Vendeur(Integer.parseInt(mat.getText()), Nom.getText(), email.getText(),"E",Double.parseDouble(recut.getText()), 0.1,Double.parseDouble(Hsupp.getText()), 0);
    		System.out.println(vdr.toString());
    		functions AS = new functions();
    		boolean result = AS.createVendeur(vdr);
    		table.getItems().add(AS.getSalarie(vdr.getMatricule()));
    	}
    }

    @FXML
    void Delete(ActionEvent event) {
    	functions AS = new functions();
    	
    	AS.deleteSalarie(table.getSelectionModel().getSelectedItem().getMatricule());
    	
    	table.getItems().remove(table.getSelectionModel().getSelectedItem());
    }

    @FXML
    void Details(ActionEvent event) {

    }

    @FXML
    void Export(ActionEvent event) {

    }

    @FXML
    void ListAnn(ActionEvent event) {
    	functions AS = new functions();
		table.getItems().clear();
		table.getItems().add(AS.listerAnniceir());
    }

    @FXML
    void ListerBetw(ActionEvent event) {

    }

    @FXML
    void ListerCat(ActionEvent event) {

    }

    @FXML
    void ListerMax(ActionEvent event) {
    	
    		functions AS = new functions();
    		table.getItems().clear();
    		table.getItems().add(AS.getMaxVente());
    	


    }

    @FXML
    void ListerMin(ActionEvent event) {

    }

    @FXML
    void Quite(ActionEvent event) {

    }
    @FXML
    void ModifCkeck(ActionEvent event) {
    	functions AS = new functions();
    	int id = table.getSelectionModel().getSelectedItem().getMatricule();
    	String role = table.getSelectionModel().getSelectedItem().getCat();
    	if(role.equals("Vendeur")) {
    		Vendeur vd = AS.VendeurDetails(id);
    		mat.setText(Integer.toString( vd.getMatricule()));
    		email.setText(vd.getEmail());
    		Nom.setText(vd.getNom());
    		recut.setText(Double.toString(vd.getAnneRecruit()));
    		//tfTaux_Pourcentage.setText(Double.toString(vd.getPourcentage()));
    		Hsupp.setText(Double.toString(vd.getVente()));
    		btnE.setSelected(true);
    	}else {
    		Employee emp=AS.EmployeDetails(id);
    		mat.setText(Integer.toString( emp.getMatricule()));
    		email.setText(emp.getEmail());
    		Nom.setText(emp.getNom());
    		recut.setText(Double.toString(emp.getAnneRecruit()));
    		//tfTaux_Pourcentage.setText(Double.toString(emp.getPHsupp()));
    		Hsupp.setText(Double.toString(emp.getHSupp()));
    		BtnV.setSelected(true);
    	}
    }

    @FXML
    void update(ActionEvent event) {
    	functions AS = new functions();
    	
    	if(btnE.isSelected()) {
    		Employee emp = new Employee(Integer.parseInt(mat.getText()), Nom.getText(), email.getText(),"E",Double.parseDouble(recut.getText()), 0.1,Double.parseDouble(Hsupp.getText()),0.2);
    		AS.updateEmploye(emp);
    		table.getItems().remove(table.getSelectionModel().getSelectedItem());
    		table.getItems().add(AS.getSalarie(emp.getMatricule()));
    	} else if(BtnV.isSelected()) {
    		Vendeur vdr = new Vendeur(Integer.parseInt(mat.getText()), Nom.getText(), email.getText(),"E",Double.parseDouble(recut.getText()), 0.1,Double.parseDouble(Hsupp.getText()), 0.2);
    		table.getItems().remove(table.getSelectionModel().getSelectedItem());
    		AS.updateVendeur(vdr);
    		table.getItems().add(AS.getSalarie(vdr.getMatricule()));
    	}
}
}