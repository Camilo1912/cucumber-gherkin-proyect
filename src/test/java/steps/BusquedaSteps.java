package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusquedaSteps {

    @Given("que estoy en la página de inicio de TravelNow")
    public void queEstoyEnLaPaginaDeInicioDeTravelNow() {
        System.out.println("Paso: Navegando a la Home de TravelNow.");
    }

    @When("ingreso {string} como ciudad de origen")
    public void ingresoComoCiudadDeOrigen(String ciudad) {
        System.out.println("Paso: Ingresando Origen: " + ciudad);
    }

    @When("ingreso {string} como ciudad de destino")
    public void ingresoComoCiudadDeDestino(String ciudad) {
        System.out.println("Paso: Ingresando Destino: " + ciudad);
    }

    @When("selecciono la fecha de ida {string} y fecha de vuelta {string}")
    public void seleccionoLaFechaDeIdaYFechaDeVuelta(String fechaIda, String fechaVuelta) {
        System.out.println("Paso: Seleccionando Fechas: " + fechaIda + " - " + fechaVuelta);
    }

    @When("hago clic en el botón {string}")
    public void hagoClicEnElBoton(String boton) {
        System.out.println("Paso: Clic en botón " + boton);
    }

    @Then("debería ver una lista de vuelos disponibles")
    public void deberiaVerUnaListaDeVuelosDisponibles() {
        System.out.println("Paso: Verificando lista de resultados.");
    }

    @Then("debería ver vuelos disponibles para la ruta {string} a {string}")
    public void deberiaVerVuelosDisponiblesParaLaRuta(String origen, String destino) {
        System.out.println("Paso: Verificando resultados para: " + origen + " -> " + destino);
    }
}