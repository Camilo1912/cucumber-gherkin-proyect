@HU-004 @Reserva @Hoteles @PrioridadAlta
Feature: Gestión de Reservas
  Como usuario en TravelNow
  Quiero buscar reservar de hoteles disponibles
  Para poder planificar mi viaje


  @SmokeTest @AuthRequerido
  Scenario Outline: Creación de reserva de hotel
    Given que he agregado el "<Hotel>" con <Noches> noches al carrito
    And selecciono las siguientes preferencias para la reserva:
      | Preferencia         | Valor          |
      | Tipo Habitación     | <TipoHabitacion> |
      | Adultos             | <Adultos>       |
      | Niños               | <Ninos>         |
   
    And selecciono el servicio adicional de "<ServicioAdicional>"
    And he completado los datos de los huéspedes
    When confirmo el pago utilizando un saldo de mi Monedero TravelNow
    Then la reserva de hotel se confirma con éxito
    And el detalle de la reserva <ResultadoServicio> el costo del "<ServicioAdicional>"
 
    Examples:
      | Hotel               | Noches | TipoHabitacion  | Adultos | Ninos | ServicioAdicional   | ResultadoServicio |
      | Hotel Explora       | 3      | Suite           | 2       | 1     | Traslado Aeropuerto | incluye           |
      | Grand Santiago      | 1      | Simple          | 1       | 0     | Ninguno             | NO incluye        |
      | Cabañas del Sur     | 2      | Familiar        | 4       | 2     | Traslado Aeropuerto | incluye           |

      

  @SmokeTest @AuthRequerido
  Scenario: Error al crear reserva de hotel pago rechazado
    Given que he agregado el "Hotel Explora" con 3 noches al carrito
    And he completado los datos de los huéspedes
    When intento pagar con una tarjeta de crédito rechazada o expirada
    Then la reserva no se crea
    And el sistema de reservas muestra el mensaje de error "Pago rechazado. Intente con otra tarjeta."
    But el carrito de compras mantiene los datos del hotel seleccionado

  @SmokeTest
  Scenario: Intento de pago de reserva sin haber iniciado sesión
    Given que NO he iniciado sesión en TravelNow
    And que he agregado el "Hotel Explora" con 2 noches al carrito
    And he completado los datos de los huéspedes
    When confirmo el pago utilizando cualquier método de pago
    Then el sistema interrumpe el proceso de pago
    And muestra el mensaje de error "Debe iniciar sesión para completar su reserva"
    But la información del carrito y huéspedes se mantiene para después del login