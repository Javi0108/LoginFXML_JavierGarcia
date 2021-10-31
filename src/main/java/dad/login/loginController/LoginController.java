package dad.login.loginController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.codec.digest.DigestUtils;

import dad.login.loginModel.LoginModel;
import dad.login.loginView.LoginView;
import javafx.application.Platform;

public class LoginController {

	private LoginModel model;
	private LoginView view = new LoginView();

	public LoginController() throws IOException {
		try {
			model = new LoginModel(insercionFichero("users.csv"));
			
			model.usuarioProperty().bind(view.getUsuarioText().textProperty());
			model.contraseñaProperty().bind(view.getContraseñaText().textProperty());
			
		} catch (IOException e) {
			e.getStackTrace();
		}
		
		view.getAccederButton().setOnAction(e -> onAccederButtonAction());
		view.getCancelarButton().setOnAction(e -> onCancelarButtonAction());
		
	}

	private HashMap<String, String> insercionFichero(String nom) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(nom));
		HashMap<String, String> resultado = new HashMap<String, String>();
		String line = "";

		while ((line = br.readLine()) != null) {
			String[] field = line.split(",");
			resultado.put(field[0], field[1]);
		}

		br.close();
		return resultado;

	}

	public boolean usuarioExistente() {
		return (model.getLogin().containsKey(model.getUsuario()));
	}

	private void onAccederButtonAction() {
		if (usuarioExistente()) {
			String md5 = DigestUtils.md5Hex(model.getContraseña()).toUpperCase();
			if (model.getLogin().get(model.getUsuario()).equals(md5))
				view.accesoPermitido();
			else
				view.accesoDenegado();
		} else {
			view.nombreNoCorrecto();
		}

	}
	
	public void onCancelarButtonAction() {
		Platform.exit();
	}

	public LoginView getView() {
		return view;
	}

	public void setView(LoginView view) {
		this.view = view;
	}

}
