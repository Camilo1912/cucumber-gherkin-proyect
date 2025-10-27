@Cancelacion @HU-003
Feature: Cancelación de Vuelos
  Como usuario de TravelNow
  Quiero cancelar mis reservas de vuelos
  Para recuperar mi dinero o crédito cuando no pueda viajar

  Background:
    Given que estoy autenticado en TravelNow
    And tengo una reserva de vuelo activa

  @SmokeTest @Cancelacion
  Scenario: Cancelación exitosa de vuelo con reembolso completo
    Given que estoy en la página "Mis Reservas"
    When selecciono mi reserva de vuelo con código "VL-12345"
    And hago clic en el botón "Cancelar Reserva"
    And confirmo la cancelación seleccionando "Reembolso completo"
    Then debería ver el mensaje "Reserva cancelada exitosamente"
    And debería recibir una confirmación por email
    And el estado de la reserva debería cambiar a "Cancelada"

  @Cancelacion
  Scenario: Cancelación de vuelo con crédito para futura compra
    Given que estoy en la página "Mis Reservas"
    When selecciono mi reserva de vuelo con código "VL-67890"
    And hago clic en el botón "Cancelar Reserva"
    And confirmo la cancelación seleccionando "Crédito para futuras compras"
    Then debería ver el mensaje "Reserva cancelada exitosamente"
    And debería recibir un código de crédito válido por 12 meses
    And el monto del crédito debería ser "100%" del valor pagado

  @Cancelacion @Negativo
  Scenario: Intento de cancelación fuera del plazo permitido
    Given que estoy en la página "Mis Reservas"
    And mi vuelo sale en menos de 24 horas
    When selecciono mi reserva de vuelo con código "VL-11111"
    And hago clic en el botón "Cancelar Reserva"
    Then debería ver el mensaje de error "No es posible cancelar vuelos con menos de 24 horas de anticipación"
    And el botón "Confirmar Cancelación" debería estar deshabilitado

  @Cancelacion @ScenarioOutline
  Scenario Outline: Cancelación de vuelos con diferentes políticas de reembolso
    Given que estoy en la página "Mis Reservas"
    When selecciono mi reserva de vuelo con código "<codigo_reserva>"
    And el tipo de tarifa es "<tipo_tarifa>"
    And hago clic en el botón "Cancelar Reserva"
    And confirmo la cancelación
    Then debería recibir un reembolso de "<porcentaje_reembolso>"
    And el tiempo de procesamiento debería ser "<tiempo_procesamiento>"

    Examples:
      | codigo_reserva | tipo_tarifa   | porcentaje_reembolso | tiempo_procesamiento |
      | VL-22222       | Flexible      | 100%                 | 5 días hábiles       |
      | VL-33333       | Semi-flexible | 75%                  | 7 días hábiles       |
      | VL-44444       | Económica     | 50%                  | 10 días hábiles      |
      | VL-55555       | Promocional   | 0%                   | No aplica            |

  @Cancelacion
  Scenario: Verificación de notificaciones post-cancelación
    Given que he cancelado mi reserva de vuelo "VL-99999"
    When accedo a mi bandeja de notificaciones
    Then debería ver una notificación de "Cancelación confirmada"
    And debería ver los detalles del reembolso o crédito
    And la notificación debería incluir el número de referencia de cancelación
