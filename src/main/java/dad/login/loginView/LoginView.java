package dad.login.loginView;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class LoginView extends BorderPane {

	private TextField usuarioText;
	private PasswordField contraseñaText;
	private CheckBox usarLDAPCheck;
	private Button accederButton;
	private Button cancelarButton;

	public LoginView() {
		super();

		usuarioText = new TextField();
		usuarioText.setPrefColumnCount(13);
		usuarioText.setPromptText("Nombre de usuario");

		contraseñaText = new PasswordField();
		contraseñaText.setPrefColumnCount(13);
		contraseñaText.setPromptText("Contraseña del usuario");

		usarLDAPCheck = new CheckBox("Usar LDAP");
		BorderPane.setAlignment(usarLDAPCheck, Pos.CENTER);

		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);
		cancelarButton = new Button("Cancelar");

		HBox botones = new HBox(5, accederButton, cancelarButton);
		botones.setAlignment(Pos.BASELINE_CENTER);
		
		GridPane centro = new GridPane();
		centro.setHgap(5);
		centro.setVgap(5);
		centro.setAlignment(Pos.CENTER);
		centro.addRow(0, new Label("Usuario:"), usuarioText);
		centro.addRow(1, new Label("Contraseña:"), contraseñaText);
		centro.add(usarLDAPCheck, 0, 2);
		centro.add(botones, 0, 3);
		GridPane.setColumnSpan(usarLDAPCheck, 3);
		GridPane.setHalignment(usarLDAPCheck, HPos.CENTER);

		GridPane.setColumnSpan(botones, 2);
		
		this.setCenter(centro);
	}

	public void accesoPermitido() {
		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle("Iniciar Sesion");
		alert.setHeaderText("Acceso Permitido");
		alert.setContentText("Las credenciales de acceso son válidas");

		alert.showAndWait();
	}

	public void accesoDenegado() {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("Iniciar Sesion");
		alert.setHeaderText("Acceso Denegado");
		alert.setContentText("El suario y/o la contraseña son incorrectos");

		alert.showAndWait();
	}

	public void nombreNoCorrecto() {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("Iniciar Sesion");
		alert.setHeaderText("Acceso Denegado");
		alert.setContentText("Usuario incorrecto");

		alert.showAndWait();
	}

	public void ficheroInexistente() {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("Iniciar Sesion");
		alert.setHeaderText("Fichero Nulo");
		alert.setContentText("El Fichero no ha sido encontrado");

		alert.showAndWait();
	}

	public TextField getUsuarioText() {
		return usuarioText;
	}

	public PasswordField getContraseñaText() {
		return contraseñaText;
	}

	public CheckBox getUsarLDAPCheck() {
		return usarLDAPCheck;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

}
