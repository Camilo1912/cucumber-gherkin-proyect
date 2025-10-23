@Busqueda @HU-001
Feature: Búsqueda de Vuelos
  Como usuario de TravelNow
  Quiero buscar vuelos disponibles
  Para poder planificar mi viaje

  @SmokeTest
  Scenario: Búsqueda de vuelo exitosa (Ida y Vuelta)
    Given que estoy en la página de inicio de TravelNow
    When ingreso "Santiago" como ciudad de origen
    And ingreso "Buenos Aires" como ciudad de destino
    And selecciono la fecha de ida "2023-12-01" y fecha de vuelta "2023-12-10"
    And hago clic en el botón "Buscar"
    Then debería ver una lista de vuelos disponibles