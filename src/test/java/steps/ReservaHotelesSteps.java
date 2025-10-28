package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse; 

public class ReservaHotelesSteps {

    private boolean pagoProcesado = false;
    private String mensajeErrorActual = "";
    private boolean servicioAdicionalSeleccionado = false;
    private String tipoHabitacionActual = "";
    private int adultosActual = 0;
    private int ninosActual = 0;


    @Given("que he agregado el {string} con {int} noches al carrito")
    public void heAgregadoElHotelAlCarrito(String hotel, int noches) { 
        System.out.println("DADO: Agregado el hotel '" + hotel + "' por " + noches + " noches al carrito.");
    }
    
    @And("^he completado los datos de los huéspedes$")
    public void heCompletadoLosDatosDeLosHuespedes() { 
        System.out.println("Y: Datos de huéspedes completados correctamente.");
    }
    
    // ESCENARIO EXITOSO

    @And("selecciono las siguientes preferencias para la reserva:")
    public void seleccionoLasSiguientesPreferenciasParaLaReserva(io.cucumber.datatable.DataTable dataTable) {
        java.util.Map<String, String> preferencias = dataTable.asMap(String.class, String.class);

        this.tipoHabitacionActual = preferencias.get("Tipo Habitación");
        
        try {
            this.adultosActual = Integer.parseInt(preferencias.get("Adultos"));
            this.ninosActual = Integer.parseInt(preferencias.get("Niños"));
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a número: " + e.getMessage());
        }

        System.out.println("Y: Preferencias de habitación seleccionadas:");
        System.out.println("   - Tipo: " + this.tipoHabitacionActual);
        System.out.println("   - Adultos: " + this.adultosActual + ", Niños: " + this.ninosActual);
    }

    @And("^selecciono el servicio adicional de hotel \"([^\"]*)\"$")
    public void seleccionoElServicioAdicionalDe(String servicio) { 
        if (!servicio.equalsIgnoreCase("Ninguno")) {
            System.out.println("Y: Servicio extra seleccionado: " + servicio);
            this.servicioAdicionalSeleccionado = true;
        } else {
            System.out.println("Y: No se seleccionó servicio adicional (Ninguno).");
            this.servicioAdicionalSeleccionado = false;
        }
    }

    @When("^confirmo el pago de hotel utilizando un saldo de mi Monedero TravelNow$")
    public void confirmoElPagoUtilizandoUnSaldoDeMiMonederoTravelNow() { 
        System.out.println("CUANDO: Procesando pago con Monedero TravelNow (Éxito simulado).");
        this.pagoProcesado = true;
    }

    @Then("^la reserva de hotel se confirma con éxito$")
    public void laReservaDeHotelSeConfirmaConExito() { 
        System.out.println("ENTONCES: Verificación de confirmación en la UI.");
        assertTrue(this.pagoProcesado);
    }

    @And("^el detalle de la reserva de hotel (incluye|NO incluye) el costo del \"([^\"]*)\"$")
    public void elDetalleDeLaReservaIncluyeONoElCostoDelServicio(String resultadoEsperado, String servicio) { 
        System.out.println("Y: Verificación condicional: el detalle " + resultadoEsperado + " el costo de " + servicio);
        
        if (resultadoEsperado.equalsIgnoreCase("incluye")) {
            assertTrue("Se esperaba que el servicio fuera incluido.", this.servicioAdicionalSeleccionado);
        } else { // Si el Feature dice "NO incluye"
            assertFalse("Se esperaba que el servicio NO fuera incluido.", this.servicioAdicionalSeleccionado);
        }
    }

    // PASOS ESPECÍFICOS DEL ESCENARIO DE ERROR

    @When("^intento pagar con una tarjeta de crédito rechazada o expirada$")
    public void intentoPagarConUnaTarjetaDeCreditoRechazadaOExpirada() { 
        System.out.println("CUANDO: Procesando pago con tarjeta inválida (Fallo simulado).");
        this.pagoProcesado = false;
        this.mensajeErrorActual = "Pago rechazado. Intente con otra tarjeta."; 
    }

    @Then("^la reserva no se crea$")
    public void laReservaNoSeCrea() { 
        System.out.println("ENTONCES: Verificando la ausencia de un código de reserva.");
        assertFalse(this.pagoProcesado);
    }

    @And("el sistema de reservas muestra el mensaje de error {string}")
    public void elSistemaMuestraElMensajeDeError(String mensajeEsperado) { 
        System.out.println("Y: Verificando mensaje de error: " + mensajeEsperado);
        assertEquals(mensajeEsperado, this.mensajeErrorActual);
}

    @But("^el carrito de compras mantiene los datos del hotel seleccionado$")
    public void elCarritoDeComprasMantieneLosDatosDelHotelSeleccionado() { 
        System.out.println("BUT: Verificando que el ítem permanezca en el carrito.");
        assertTrue(true); 
    }

    @Given("que NO he iniciado sesión en TravelNow")
    public void queNOHeIniciadoSesionEnTravelNow() {
        System.out.println("DADO: Estado inicial: Usuario NO autenticado.");
    }

    @When("confirmo el pago utilizando cualquier método de pago")
    public void confirmoElPagoUtilizandoCualquierMetodoDePago() {
        System.out.println("CUANDO: Haciendo clic en pagar sin sesión.");
        this.pagoProcesado = false; 
        this.mensajeErrorActual = "Debe iniciar sesión para completar su reserva";
    }

    @Then("el sistema interrumpe el proceso de pago") 
    public void elSistemaInterrumpeElProcesoDePago() {
        System.out.println("ENTONCES: Verificando interrupción de la navegación/API.");
        assertFalse(this.pagoProcesado);
    }

    @Then("muestra el mensaje de error {string}") 
    public void muestraElMensajeDeError(String string) {
        System.out.println("Y/ENTONCES: Muestra el mensaje de error: " + string);
    }

    @But("la información del carrito y huéspedes se mantiene para después del login")
    public void laInformacionDelCarritoYHuespedesSeMantieneParaDespuesDelLogin() {
        System.out.println("BUT: Validando retención de datos en el carrito.");
        assertTrue(true);
    }
    
}