package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class CancelacionHotelesSteps {

    // ==================== GIVEN ====================
    
    @Given("tengo una reserva de hotel activa")
    public void tengoUnaReservaDeHotelActiva() {
        System.out.println("Paso: Verificando que existe una reserva de hotel activa.");
    }

    @Given("la fecha de check-in es en más de {int} horas")
    public void laFechaDeCheckInEsEnMasDe48Horas(int horas) {
        System.out.println("Paso: Verificando que el check-in es en más de " + horas + " horas.");
    }

    @Given("la fecha de check-in es en menos de {int} horas")
    public void laFechaDeCheckInEsEnMenosDe48Horas(int horas) {
        System.out.println("Paso: Verificando que el check-in es en menos de " + horas + " horas.");
    }

    @Given("que he cancelado mi reserva de hotel {string}")
    public void queHeCanceladoMiReservaDeHotel(String codigoReserva) {
        System.out.println("Paso: Se ha cancelado previamente la reserva de hotel: " + codigoReserva);
    }

    @Given("tengo una reserva con {int} habitaciones con código {string}")
    public void tengoUnaReservaConHabitacionesConCodigo(int numHabitaciones, String codigoReserva) {
        System.out.println("Paso: Verificando reserva con " + numHabitaciones + " habitaciones, código: " + codigoReserva);
    }

    // ==================== WHEN ====================
    
    @When("selecciono mi reserva de hotel con código {string}")
    public void seleccionoMiReservaDeHotelConCodigo(String codigoReserva) {
        System.out.println("Paso: Seleccionando reserva de hotel con código: " + codigoReserva);
    }

    @When("confirmo la cancelación aceptando el cargo")
    public void confirmoLaCancelacionAceptandoElCargo() {
        System.out.println("Paso: Confirmando cancelación y aceptando el cargo por cancelación tardía.");
    }

    @When("faltan {string} días para el check-in")
    public void faltanDiasParaElCheckIn(String diasAnticipacion) {
        System.out.println("Paso: Verificando que faltan " + diasAnticipacion + " días para el check-in.");
    }

    @When("la política de cancelación es {string}")
    public void laPoliticaDeCancelacionEs(String politica) {
        System.out.println("Paso: Verificando política de cancelación: " + politica);
    }

    @When("selecciono la opción {string}")
    public void seleccionoLaOpcion(String opcion) {
        System.out.println("Paso: Seleccionando opción: " + opcion);
    }

    @When("selecciono {int} habitaciones para cancelar")
    public void seleccionoHabitacionesParaCancelar(int numHabitaciones) {
        System.out.println("Paso: Seleccionando " + numHabitaciones + " habitaciones para cancelar.");
    }

    @When("confirmo la cancelación parcial")
    public void confirmoLaCancelacionParcial() {
        System.out.println("Paso: Confirmando cancelación parcial de habitaciones.");
    }

    @When("accedo a {string}")
    public void accedoA(String seccion) {
        System.out.println("Paso: Accediendo a la sección: " + seccion);
    }

    @When("filtro por {string}")
    public void filtroPor(String filtro) {
        System.out.println("Paso: Aplicando filtro: " + filtro);
    }

    // ==================== THEN ====================
    
    @Then("no debería tener cargos en mi método de pago")
    public void noDeberiaTenerCargosEnMiMetodoDePago() {
        System.out.println("Paso: Verificando que no hay cargos aplicados en el método de pago.");
    }

    @Then("debería ver el monto del cargo aplicado")
    public void deberiaVerElMontoDelCargoAplicado() {
        System.out.println("Paso: Verificando visualización del monto del cargo aplicado.");
    }

    @Then("debería recibir un comprobante de la cancelación")
    public void deberiaRecibirUnComprobanteDeLaCancelacion() {
        System.out.println("Paso: Verificando recepción de comprobante de cancelación.");
    }

    @Then("debería ver el mensaje de advertencia {string}")
    public void deberiaVerElMensajeDeAdvertencia(String mensajeAdvertencia) {
        System.out.println("Paso: Verificando mensaje de advertencia: " + mensajeAdvertencia);
    }

    @Then("debería ver las opciones {string} o {string}")
    public void deberiaVerLasOpcionesO(String opcion1, String opcion2) {
        System.out.println("Paso: Verificando opciones disponibles: " + opcion1 + " / " + opcion2);
    }

    @Then("si confirmo debería perder el monto total pagado")
    public void siConfirmoDeberiaPerderlMontoTotalPagado() {
        System.out.println("Paso: Verificando que al confirmar se pierde el monto total pagado.");
    }

    @Then("el cargo aplicado debería ser {string}")
    public void elCargoAplicadoDeberiaSer(String cargoAplicado) {
        System.out.println("Paso: Verificando cargo aplicado: " + cargoAplicado);
    }

    @Then("debería recibir {string}")
    public void deberiaRecibir(String tipoConfirmacion) {
        System.out.println("Paso: Verificando recepción de: " + tipoConfirmacion);
    }

    @Then("debería mantener {int} habitación activa")
    public void deberiaMantenerlHabitacionActiva(int numHabitaciones) {
        System.out.println("Paso: Verificando que se mantiene " + numHabitaciones + " habitación(es) activa(s).");
    }

    @Then("el precio total debería actualizarse")
    public void elPrecioTotalDeberiaActualizarse() {
        System.out.println("Paso: Verificando actualización del precio total.");
    }

    @Then("debería ver mi reserva {string} con estado {string}")
    public void deberiaVerMiReservaConEstado(String codigoReserva, String estado) {
        System.out.println("Paso: Verificando reserva " + codigoReserva + " con estado: " + estado);
    }

    @Then("debería ver la fecha de cancelación")
    public void deberiaVerLaFechaDeCancelacion() {
        System.out.println("Paso: Verificando visualización de fecha de cancelación.");
    }

    @Then("debería ver el monto reembolsado o retenido")
    public void deberiaVerElMontoReembolsadoORetenido() {
        System.out.println("Paso: Verificando visualización del monto reembolsado o retenido.");
    }

    @Then("debería recibir un email de confirmación")
    public void deberiaRecibirUnEmailDeConfirmacion() {
        System.out.println("Paso: Verificando recepción de email de confirmación.");
    }
}
