

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Calculadora extends Application  {
	
		
    private TextField dtext,ctext,btext,atext;	
	private Label etiqueta,etiqueta2, etiquetamas,etiquetai,etiquetamas1,etiquetai1,etiquetamas2,etiquetai2;
	private ComboBox combo;
private DoubleProperty numeroAD,numeroBD,numeroCD,numeroDD;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	
		NumberStringConverter converter = new NumberStringConverter();
		
		atext = new TextField("0");
		atext.setPrefColumnCount(7);
		
		 numeroAD = new SimpleDoubleProperty();
		StringProperty numeroA = new SimpleStringProperty();
		
		numeroA.bindBidirectional(atext.textProperty());			
		Bindings.bindBidirectional(numeroA, numeroAD, converter);
		
		
		btext = new TextField("0");		
		btext.setPrefColumnCount(7);
		
		  numeroBD = new SimpleDoubleProperty();
		StringProperty numeroB = new SimpleStringProperty();
		
		numeroB.bindBidirectional(btext.textProperty());			
		Bindings.bindBidirectional(numeroB, numeroBD, converter);
		
		
		ctext = new TextField("0");		
		ctext.setPrefColumnCount(7);
		
		  numeroCD = new SimpleDoubleProperty();
		StringProperty numeroC = new SimpleStringProperty();
		
		numeroC.bindBidirectional(ctext.textProperty());			
		Bindings.bindBidirectional(numeroC, numeroCD, converter);
		
		
		dtext = new TextField("0");		
		dtext.setPrefColumnCount(7);
		
		  numeroDD = new SimpleDoubleProperty();
		StringProperty numeroD = new SimpleStringProperty();
		
		numeroD.bindBidirectional(dtext.textProperty());			
		Bindings.bindBidirectional(numeroD, numeroDD, converter);
		

		etiquetamas = new Label();
		etiquetamas.setText("+");
		
		etiquetai= new Label();
		etiquetai.setText("i");
		
		
		etiquetamas1 = new Label();
		etiquetamas1.setText("+");
		
		etiquetai1= new Label();
		etiquetai1.setText("i");
		

		etiquetamas2 = new Label();
		etiquetamas2.setText("+");
		
		etiquetai2= new Label();
		etiquetai2.setText("i");
		
		etiqueta = new Label();
		etiqueta2 = new Label();
		


			
		 HBox ahbox = new HBox(8);
		 ahbox.setAlignment(Pos.BASELINE_CENTER);
		 ahbox.setSpacing(7);
		 ahbox.getChildren().addAll(atext,etiquetamas,btext,etiquetai);
		 
		 
		 
		 
		 
		 HBox chbox = new HBox(8);
		 chbox.setAlignment(Pos.BASELINE_CENTER);
		 chbox.setSpacing(7);
		 chbox.getChildren().addAll(ctext,etiquetamas1,dtext,etiquetai1);
		 
		 
		
		 
		 HBox resulhbox = new HBox(8);
		 resulhbox.setAlignment(Pos.BASELINE_CENTER);
		 resulhbox.setSpacing(7);
		 resulhbox.getChildren().addAll(etiqueta,etiquetamas2,etiqueta2,etiquetai2);
		 

		 combo = new ComboBox();
		 combo.getItems().addAll("+","-","*","/");
		
			combo.valueProperty().addListener((observable,oldValue,newValue)->cambiar(newValue));
			
					
			
			Label resultado = new Label("=");
		resultado.setTranslateX(10);
		
			 Separator separator = new Separator(Orientation.HORIZONTAL);
			
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(ahbox,chbox,separator,resulhbox);
		
		
		VBox operador = new VBox();
		operador.setSpacing(5);
		operador.setAlignment(Pos.CENTER);
		operador.getChildren().add(combo);
		
		VBox boton = new VBox();
		boton.setSpacing(5);
		boton.setAlignment(Pos.CENTER);
		boton.getChildren().addAll(resultado);
		
		
		
		HBox panel =new HBox();
		panel.getChildren().addAll(operador,root,resultado);
		panel.setAlignment(Pos.CENTER);

		Scene escena = new Scene(panel, 350, 250);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Calcuadora Compleja");
		primaryStage.show();
	}
	
	private void cambiar(Object newValue) {
		
		if("+"==newValue) {
			etiqueta.textProperty().bind(new SimpleStringProperty("") .concat((numeroCD.add(numeroAD)).asString()));
			etiqueta2.textProperty().bind(new SimpleStringProperty("") .concat((numeroBD.add(numeroDD)).asString()));
		
		}
		if("-"==newValue) {
			etiqueta.textProperty().bind(new SimpleStringProperty("") .concat((numeroAD.subtract(numeroCD)).asString()));
			etiqueta2.textProperty().bind(new SimpleStringProperty("") .concat((numeroBD.subtract(numeroDD)).asString()));
		
		}
		if("*"==newValue) {
			etiqueta.textProperty().bind(new SimpleStringProperty("") .concat(
					(numeroAD.multiply(numeroCD)).subtract((numeroBD.multiply(numeroDD))).asString()
					));
			etiqueta2.textProperty().bind(new SimpleStringProperty("") .concat(
					(numeroAD.multiply(numeroDD)).add((numeroBD.multiply(numeroCD))).asString()
					));
		
		}
		if("/"==newValue) {
			etiqueta.textProperty().bind(new SimpleStringProperty("") .concat(
					((numeroAD.multiply(numeroCD)).add((numeroBD.multiply(numeroDD)))).divide((numeroCD.multiply(numeroCD)).add((numeroDD.multiply(numeroDD))))
					.asString()
					));
			

			etiqueta2.textProperty().bind(new SimpleStringProperty("") .concat(
					((numeroBD.multiply(numeroCD)).subtract((numeroAD.multiply(numeroDD)))).divide((numeroCD.multiply(numeroCD)).add((numeroDD.multiply(numeroDD))))
					.asString()
					));
		}
	}

	

	public static void main(String[] args) {
		launch(args);
	}

	
	
	
	
	
	
	
}