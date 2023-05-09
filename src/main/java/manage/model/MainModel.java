package manage.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class MainModel {
    private ArrayList<String> messages;
    private ArrayList<String> loginTexts;
    private ArrayList<String> labelTexts;
    private ArrayList<String> buttonTexts;
    private ArrayList<String> controlTexts;


    public MainModel() {
        messages = new ArrayList<>();
        messages.add("El cliente ya existe");//0
        messages.add("Usuario o contraseña incorrectos");//1

        loginTexts = new ArrayList<>();
        loginTexts.add("Login");//0

        labelTexts = new ArrayList<>();
        labelTexts.add("Bienvenido a Pizzería Pacheco");//0
        labelTexts.add("Número de teléfono");//1
        labelTexts.add("Contraseña");//2

        buttonTexts = new ArrayList<>();
        buttonTexts.add("Iniciar Sesión");//0
        buttonTexts.add("Registrarse");//1

        controlTexts = new ArrayList<>();
        controlTexts.add("Seleccion de Pizzas");//0
        controlTexts.add("Terminar");//1
    }

    public ArrayList<String> getLoginTexts() {
        return loginTexts;
    }

    public ArrayList<String> getLabelTexts() {
        return labelTexts;
    }
}
