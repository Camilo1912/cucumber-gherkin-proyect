package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.Map;

public class RegistroSteps {

    // Simula el proceso de registro
    private boolean usuarioEsNuevo = true;
    private boolean registroExitoso = false;
    private String emailActual = "";
    private String contrasenaActual = "";
    private String mensajeErrorActual = "";
    
    // Variables para almacenar datos personales
    private String nombreCompleto = "";
    private String paisResidencia = "";

    private static final String EMAIL_EXISTENTE = "existente@test.com";

    @Given("que soy un usuario nuevo y no estoy registrado")
    public void queSoyUnUsuarioNuevoYNoEstoyRegistrado() {
        //estado para un nuevo intento de registro
        this.usuarioEsNuevo = true;
        this.registroExitoso = false;
        this.mensajeErrorActual = "";
        System.out.println("DADO: Usuario preparado para registro (estado inicial limpio).");
    }

    @Given("que el email {string} ya está asociado a una cuenta")
    public void queElEmailYaEstaAsociadoAUnaCuenta(String email) {
        // Simula que email ya existe en BBDD
        this.emailActual = email;
        this.usuarioEsNuevo = false;
        System.out.println("DADO: Preparando escenario donde el email '" + email + "' ya existe.");
    }

    @When("intento registrarme con email {string} y contraseña {string}")
    public void intentoRegistrarmeConEmailYContrasena(String email, String contrasena) {
        this.emailActual = email;
        this.contrasenaActual = contrasena;
        System.out.println("CUANDO: Intentando registro con email: " + email);
        System.out.println("SOLO DE PRUEBA: Email y contraseña usados: "+ emailActual + " , " + contrasenaActual);

        //formato de email
        if (!email.contains("@") || !email.contains(".")) {
            this.registroExitoso = false;
            this.mensajeErrorActual = "El formato del correo electrónico es inválido.";
            return;
        }

        // Verifica existe o no email
        if (email.equals(EMAIL_EXISTENTE) || !this.usuarioEsNuevo) {
            this.registroExitoso = false;
            this.mensajeErrorActual = "Este correo electrónico ya se encuentra registrado.";
            return;
        }

        this.registroExitoso = true;
        this.mensajeErrorActual = "";
    }

    @And("completa la siguiente información personal:")
    public void completaLaSiguienteInformacionPersonal(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        this.nombreCompleto = data.get("Nombre Completo");
        this.paisResidencia = data.get("País de Residencia");
        
        System.out.println("Y: Información personal completada: " + this.nombreCompleto + ", " + this.paisResidencia);
    }

    @Then("el registro es exitoso")
    public void elRegistroEsExitoso() {
        System.out.println("ENTONCES: Verificando que el registro fue exitoso.");
        assertTrue("El registro debería haber sido exitoso.", this.registroExitoso);
    }

    @And("se me redirige a la página principal de mi perfil")
    public void seMeRedirigeALaPaginaPrincipalDeMiPerfil() {
        System.out.println("Y: Verificando la redirección a la página principal.");
        assertTrue(this.registroExitoso); 
    }

    @Then("el registro falla")
    public void elRegistroFalla() {
        System.out.println("ENTONCES: Verificando que el registro falló.");
        assertFalse("El registro no debería haber sido exitoso.", this.registroExitoso);
    }

    @And("el sistema muestra el mensaje de error {string}")
    public void elSistemaMuestraElMensajeDeError(String mensajeEsperado) {
        System.out.println("Y: Verificando mensaje de error: " + mensajeEsperado);
        assertEquals(mensajeEsperado, this.mensajeErrorActual);
    }

    @And("el sistema de registro muestra el mensaje de error {string}")
    public void elSistemaDeRegistroMuestraElMensajeDeError(String mensajeEsperado) {
        System.out.println("Y: Verificando mensaje de error: " + mensajeEsperado);
        assertEquals(mensajeEsperado, this.mensajeErrorActual);
    }
    
}

