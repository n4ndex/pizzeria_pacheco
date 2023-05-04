package manage.model;

import java.util.ArrayList;

public class MainModel {
    private ArrayList<String> loginTexts;
    private ArrayList<String> labelTexts;


    public MainModel() {
        loginTexts = new ArrayList<>();
        loginTexts.add("Login");//0
        loginTexts.add("Registrarse/Iniciar sesión");//1

        labelTexts = new ArrayList<>();
        labelTexts.add("Bienvenido a Pizzería Pacheco");//0
        labelTexts.add("Número de teléfono");//1
        labelTexts.add("Contraseña");//2
    }

    public ArrayList<String> getLoginTexts() {
        return loginTexts;
    }

    public ArrayList<String> getLabelTexts() {
        return labelTexts;
    }
}
