@Registro
Feature: Registro de Usuarios
  Como nuevo usuario en TravelNow
  Quiero registrarme y crear una cuenta
  Para poder acceder a servicios y hacer reservas.

@RegistroExitoso @Registro
  Scenario Outline: Registro exitoso de nuevo usuario
    Given que soy un usuario nuevo y no estoy registrado
    When intento registrarme con email "<email>" y contraseña "<contraseña>"
    And completa la siguiente información personal:
      | campo              | valor             |
      | Nombre Completo    | <nombre>          |
      | País de Residencia | <pais>            |
    Then el registro es exitoso
    And se me redirige a la página principal de mi perfil
    
    Examples:
      | nombre        | email                  | contraseña | pais      |
      | Laura Pérez   | laura.perez@test.com   | Segura123  | México    |
      | Martín Gómez  | martin.gomez@test.com  | Secreta456 | Colombia  |
      
@RegistroEmailInvalido @Registro
  Scenario: Intento de registro con formato de email inválido
    Given que soy un usuario nuevo y no estoy registrado
    When intento registrarme con email "correo_invalido.com" y contraseña "Cualquiera123"
    Then el registro falla
    And el sistema muestra el mensaje de error "El formato del correo electrónico es inválido."

@RegistroEmailExistente @Registro
  Scenario: Intento de registro con email ya registrado
    Given que el email "existente@test.com" ya está asociado a una cuenta
    When intento registrarme con email "existente@test.com" y contraseña "NuevaClave789"
    Then el registro falla
    And el sistema de registro muestra el mensaje de error "Este correo electrónico ya se encuentra registrado."