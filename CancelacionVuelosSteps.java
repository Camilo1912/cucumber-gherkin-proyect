package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class CancelacionVuelosSteps {

    // ==================== GIVEN ====================
    
    @Given("que estoy autenticado en TravelNow")
    public void queEstoyAutenticadoEnTravelNow() {
        System.out.println("Paso: Usuario autenticado en el sistema TravelNow.");
    }

    @Given("tengo una reserva de vuelo activa")
    public void tengoUnaReservaDeVueloActiva() {
        System.out.println("Paso: Verificando que existe una reserva de vuelo activa.");
    }

    @Given("que estoy en la página {string}")
    public void queEstoyEnLaPagina(String pagina) {
        System.out.println("Paso: Navegando a la página: " + pagina);
    }

    @Given("mi vuelo sale en menos de {int} horas")
    public void miVueloSaleEnMenosDe24Horas(int horas) {
        System.out.println("Paso: Verificando que el vuelo sale en menos de " + horas + " horas.");
    }

    @Given("que he cancelado mi reserva de vuelo {string}")
    public void queHeCanceladoMiReservaDeVuelo(String codigoReserva) {
        System.out.println("Paso: Se ha cancelado previamente la reserva: " + codigoReserva);
    }

    // ==================== WHEN ====================
    
    @When("selecciono mi reserva de vuelo con código {string}")
    public void seleccionoMiReservaDeVueloConCodigo(String codigoReserva) {
        System.out.println("Paso: Seleccionando reserva de vuelo con código: " + codigoReserva);
    }

    @When("confirmo la cancelación seleccionando {string}")
    public void confirmoLaCancelacionSeleccionando(String opcionReembolso) {
        System.out.println("Paso: Confirmando cancelación con opción: " + opcionReembolso);
    }

    @When("el tipo de tarifa es {string}")
    public void elTipoDeTarifaEs(String tipoTarifa) {
        System.out.println("Paso: Verificando tipo de tarifa: " + tipoTarifa);
    }

    @When("confirmo la cancelación")
    public void confirmoLaCancelacion() {
        System.out.println("Paso: Confirmando la cancelación de la reserva.");
    }

    @When("accedo a mi bandeja de notificaciones")
    public void accedoAMiBandejaDeNotificaciones() {
        System.out.println("Paso: Accediendo a la bandeja de notificaciones.");
    }

    // ==================== THEN ====================
    
    @Then("debería ver el mensaje {string}")
    public void deberiaVerElMensaje(String mensaje) {
        System.out.println("Paso: Verificando mensaje mostrado: " + mensaje);
    }

    @Then("debería recibir una confirmación por email")
    public void deberiaRecibirUnaConfirmacionPorEmail() {
        System.out.println("Paso: Verificando recepción de email de confirmación.");
    }

    @Then("el estado de la reserva debería cambiar a {string}")
    public void elEstadoDeLaReservaDeberiaCambiarA(String nuevoEstado) {
        System.out.println("Paso: Verificando cambio de estado a: " + nuevoEstado);
    }

    @Then("debería recibir un código de crédito válido por {int} meses")
    public void deberiaRecibirUnCodigoDeCreditoValidoPorMeses(int meses) {
        System.out.println("Paso: Verificando generación de código de crédito válido por " + meses + " meses.");
    }

    @Then("el monto del crédito debería ser {string} del valor pagado")
    public void elMontoDelCreditoDeberiaSerDelValorPagado(String porcentaje) {
        System.out.println("Paso: Verificando que el crédito sea el " + porcentaje + " del valor pagado.");
    }

    @Then("debería ver el mensaje de error {string}")
    public void deberiaVerElMensajeDeError(String mensajeError) {
        System.out.println("Paso: Verificando mensaje de error: " + mensajeError);
    }

    @Then("el botón {string} debería estar deshabilitado")
    public void elBotonDeberiaEstarDeshabilitado(String nombreBoton) {
        System.out.println("Paso: Verificando que el botón '" + nombreBoton + "' esté deshabilitado.");
    }

    @Then("debería recibir un reembolso de {string}")
    public void deberiaRecibirUnReembolsoDe(String porcentajeReembolso) {
        System.out.println("Paso: Verificando reembolso del " + porcentajeReembolso);
    }

    @Then("el tiempo de procesamiento debería ser {string}")
    public void elTiempoDeProcesamientoDeberiaSerDe(String tiempoProcesamiento) {
        System.out.println("Paso: Verificando tiempo de procesamiento: " + tiempoProcesamiento);
    }

    @Then("debería ver una notificación de {string}")
    public void deberiaVerUnaNotificacionDe(String tipoNotificacion) {
        System.out.println("Paso: Verificando notificación: " + tipoNotificacion);
    }

    @Then("debería ver los detalles del reembolso o crédito")
    public void deberiaVerLosDetallesDelReembolsoOCredito() {
        System.out.println("Paso: Verificando visualización de detalles de reembolso/crédito.");
    }

    @Then("la notificación debería incluir el número de referencia de cancelación")
    public void laNotificacionDeberiaIncluirElNumeroDeReferenciaDeCancelacion() {
        System.out.println("Paso: Verificando que la notificación incluya número de referencia.");
    }
}
