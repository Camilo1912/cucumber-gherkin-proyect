package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void inicializarEntorno(Scenario scenario) {
        System.out.println("*****************************************");
        System.out.println("INICIANDO ESCENARIO: " + scenario.getName());
        System.out.println("Navegador web abierto y maximizado.");
    }

    @Before
    public void ingresarPaginaTravelNow(Scenario scenario) {
        System.out.println("*****************************************");
        System.out.println("HOOK: Se ingresa a la pagina de Travel Now");
    }

    @After
    public void finalizarEntorno(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("¡Escenario FALLIDO! Tomando captura de pantalla...");
        }
        System.out.println("Cerrando navegador web.");
        System.out.println("ESCENARIO: " + scenario.getName() + " - ESTADO: " + scenario.getStatus());
        System.out.println("*****************************************\n");
    }
}