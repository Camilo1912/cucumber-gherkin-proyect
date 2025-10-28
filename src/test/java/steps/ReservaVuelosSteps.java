package steps;
import io.cucumber.java.en.*;

public class ReservaVuelosSteps {

  @Given("que he seleccionado el vuelo {string} de {string} a {string}")
  public void seleccionarVuelo(String vuelo, String origen, String destino) {
    System.out.println("Vuelo seleccionado: " + vuelo + " (" + origen + " -> " + destino + ")");
  }

  @And("selecciono las siguientes preferencias de vuelo:")
  public void seleccionarPreferencias(io.cucumber.datatable.DataTable dataTable) {
    System.out.println("Preferencias seleccionadas: " + dataTable.asMap(String.class, String.class));
  }

  @And("selecciono el servicio adicional de vuelo {string}")
  public void seleccionarServicio(String servicioAdicional) {
    System.out.println("Servicio adicional: " + servicioAdicional);
  }

  @And("he completado los datos de los pasajeros")
  public void completarDatosPasajeros() {
    System.out.println("Datos de pasajeros completados.");
  }

  @When("confirmo el pago de vuelo utilizando un saldo de mi Monedero TravelNow")
  public void confirmarPago() {
    System.out.println("Pago confirmado con Monedero TravelNow.");
  }

  @Then("la reserva de vuelo se confirma con exito")
  public void confirmarReserva() {
    System.out.println("Reserva confirmada con éxito.");
  }

  @And("^el detalle de la reserva de vuelo (.*?) el costo del \"([^\"]*)\"$")
  public void verificarDetalleReserva(String resultadoServicio, String servicioAdicional) {
    System.out.println("Verificando detalle: La reserva " + resultadoServicio + " el costo del " + servicioAdicional);
  }
}