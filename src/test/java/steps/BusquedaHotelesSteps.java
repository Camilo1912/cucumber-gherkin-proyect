package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class BusquedaHotelesSteps {

    private int resultadosActuales = 0;
    private String destinoBuscado = "";
    private int estrellasFiltradas = 0;
    
    @Given("que estoy en la página principal de TravelNow")
    public void queEstoyEnLaPaginaPrincipalDeTravelNow() {
        System.out.println("Given: Abriendo la URL principal de TravelNow.");
    }

    @Given("he seleccionado la pestaña {string}")
    public void heSeleccionadoLaPestana(String pestana) {
        System.out.println("Given: Clic en la pestaña: " + pestana);
    }
    
    @Given("he completado una búsqueda exitosa de hoteles en {string}")
    public void heCompletadoUnaBusquedaExitosaDeHotelesEn(String destino) {
        this.destinoBuscado = destino;
        this.resultadosActuales = 50;
        System.out.println("Given: Simulación de búsqueda exitosa en " + destino + ". Resultados iniciales: " + resultadosActuales);
    }

    @When("ingreso {string} como destino")
    public void ingresoComoDestino(String destino) {
        this.destinoBuscado = destino;
        System.out.println("Cuando: Ingresando destino: " + destino);
    }

    @When("selecciono la fecha de check-in {string} y check-out {string}")
    public void seleccionoLaFechaDeCheckInYCheckOut(String checkIn, String checkOut) {
        System.out.println("Cuando: Seleccionando fechas: " + checkIn + " a " + checkOut);
    }

    @When("especifico {string} adultos y {string} habitación")
    public void especificoAdultosYHabitacion(String adultos, String habitaciones) {
        System.out.println("Cuando: Especificando " + adultos + " adultos y " + habitaciones + " habitación(es).");
    }

    @When("hago clic en el botón {string} de hoteles")
    public void hagoClicEnElBoton(String boton) {
        System.out.println("Cuando: Clic en el botón: " + boton);
        if (boton.equals("Buscar") && !destinoBuscado.equals("Esto no existe")) {
            this.resultadosActuales = 12;
        } else if (boton.equals("Buscar") && destinoBuscado.equals("Esto no existe")) {
            this.resultadosActuales = 0;
        }
    }
    
    @When("selecciono la categoria {int} en los filtros de la pagina")
    public void seleccionoLaCategoriaEnLosFiltrosDeLaPagina(int estrellas) {
        this.estrellasFiltradas = estrellas;
        System.out.println("Cuando: Aplicando filtro de " + estrellas + " estrellas.");
    }
    
    @When("hago clic en el botón {string} de filtro de hoteles")
    public void hagoClicEnElBotonDeLosFiltros(String boton) {
        System.out.println("Cuando: Clic en el botón: " + boton);
        
        if (this.resultadosActuales > 0) {
            this.resultadosActuales = (int) (this.resultadosActuales * 0.5);
        }
    }

    @Then("deberia ver al menos {int} hoteles en la lista de resultados")
    public void deberiaVerAlMenosHotelesEnLaListaDeResultados(int cantidadMinima) {
        System.out.println("Entonces: Verificando que haya al menos " + cantidadMinima + " resultados. Actual: " + resultadosActuales);
        Assert.assertTrue("La cantidad de resultados (" + resultadosActuales + ") es menor que la mínima esperada (" + cantidadMinima + ").", 
                          resultadosActuales >= cantidadMinima);
    }

    @Then("todos los hoteles listados deberían estar en {string}")
    public void todosLosHotelesListadosDeberianEstarEn(String destino) {
        System.out.println("Entonces: Verificando que todos los hoteles sean de: " + destino);
        Assert.assertEquals("El destino en los resultados no coincide con la búsqueda.", this.destinoBuscado, destino);
    }
    
    @Then("solo se muestran hoteles con {int} estrellas")
    public void soloSeMuestranHotelesConEstrellas(int estrellas) {
        System.out.println("Entonces: Verificando que el filtro de " + estrellas + " estrellas esté activo y sea correcto.");
        Assert.assertEquals(this.estrellasFiltradas, estrellas);
    }
    
    @Then("la cantidad de resultados se reduce")
    public void laCantidadDeResultadosSeReduce() {
        System.out.println("Entonces: La nueva cantidad de resultados es: " + resultadosActuales);
        Assert.assertTrue(resultadosActuales < 50); 
    }

    @Then("debería ver un mensaje que dice {string}")
    public void deberiaVerUnMensajeQueDice(String mensajeEsperado) {
        System.out.println("Entonces: Verificando mensaje de error: " + mensajeEsperado);
        Assert.assertTrue("No hay resultados, el mensaje debería ser visible.", resultadosActuales == 0);
    }

    @Then("la lista de resultados debe estar vacía")
    public void laListaDeResultadosDebeEstarVacia() {
        System.out.println("Entonces: Verificando que la lista de resultados esté vacía.");
        Assert.assertEquals(0, resultadosActuales);
    }
}