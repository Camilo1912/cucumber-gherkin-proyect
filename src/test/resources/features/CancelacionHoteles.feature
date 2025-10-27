@Cancelacion @HU-004
Feature: Cancelación de Hoteles
  Como usuario de TravelNow
  Quiero cancelar mis reservas de hotel
  Para no incurrir en cargos cuando mis planes cambien

  Background:
    Given que estoy autenticado en TravelNow
    And tengo una reserva de hotel activa

  @SmokeTest @Cancelacion
  Scenario: Cancelación gratuita dentro del período permitido
    Given que estoy en la página "Mis Reservas"
    When selecciono mi reserva de hotel con código "HT-54321"
    And la fecha de check-in es en más de 48 horas
    And hago clic en el botón "Cancelar Reserva"
    And confirmo la cancelación
    Then debería ver el mensaje "Reserva de hotel cancelada sin cargo"
    And debería recibir un email de confirmación
    And no debería tener cargos en mi método de pago

  @Cancelacion
  Scenario: Cancelación con cargo por cancelación tardía
    Given que estoy en la página "Mis Reservas"
    When selecciono mi reserva de hotel con código "HT-98765"
    And la fecha de check-in es en menos de 48 horas
    And hago clic en el botón "Cancelar Reserva"
    And confirmo la cancelación aceptando el cargo
    Then debería ver el mensaje "Reserva cancelada con cargo de una noche"
    And debería ver el monto del cargo aplicado
    And debería recibir un comprobante de la cancelación

  @Cancelacion @Negativo
  Scenario: Intento de cancelación de reserva no reembolsable
    Given que estoy en la página "Mis Reservas"
    When selecciono mi reserva de hotel con código "HT-11223"
    And el tipo de tarifa es "No reembolsable"
    And hago clic en el botón "Cancelar Reserva"
    Then debería ver el mensaje de advertencia "Esta reserva no es reembolsable"
    And debería ver las opciones "Cancelar de todos modos" o "Mantener reserva"
    And si confirmo debería perder el monto total pagado

  @Cancelacion @ScenarioOutline
  Scenario Outline: Cancelación de hoteles según políticas de cancelación
    Given que estoy en la página "Mis Reservas"
    When selecciono mi reserva de hotel con código "<codigo_reserva>"
    And faltan "<dias_anticipacion>" días para el check-in
    And la política de cancelación es "<politica>"
    And hago clic en el botón "Cancelar Reserva"
    And confirmo la cancelación
    Then el cargo aplicado debería ser "<cargo_aplicado>"
    And debería recibir "<tipo_confirmacion>"

    Examples:
      | codigo_reserva | dias_anticipacion | politica              | cargo_aplicado    | tipo_confirmacion        |
      | HT-11111       | 7                 | Cancelación gratuita  | Sin cargo         | Email de confirmación    |
      | HT-22222       | 3                 | Flexible              | Sin cargo         | Email de confirmación    |
      | HT-33333       | 1                 | Moderada              | 50% del total     | Email con cargo          |
      | HT-44444       | 0                 | Estricta              | 100% del total    | Email con cargo completo |
      | HT-55555       | 10                | No reembolsable       | 100% del total    | Cancelación sin reembolso|

  @Cancelacion
  Scenario: Cancelación múltiple de habitaciones
    Given que estoy en la página "Mis Reservas"
    And tengo una reserva con 3 habitaciones con código "HT-77777"
    When selecciono la opción "Cancelar habitaciones"
    And selecciono 2 habitaciones para cancelar
    And confirmo la cancelación parcial
    Then debería ver el mensaje "2 habitaciones canceladas exitosamente"
    And debería mantener 1 habitación activa
    And el precio total debería actualizarse

  @Cancelacion
  Scenario: Verificación de historial de cancelaciones
    Given que he cancelado mi reserva de hotel "HT-88888"
    When accedo a "Mi Historial"
    And filtro por "Reservas Canceladas"
    Then debería ver mi reserva "HT-88888" con estado "Cancelada"
    And debería ver la fecha de cancelación
    And debería ver el monto reembolsado o retenido
