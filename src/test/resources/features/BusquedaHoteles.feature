@HU-002 @Busqueda @Hoteles
Feature: Búsqueda y Filtrado de Hoteles
  Como usuario de la plataforma TravelNow
  Quiero buscar hoteles en un destino y fechas específicas
  Para poder encontrar la mejor opción de alojamiento para mi viaje

  @SmokeTest
  Scenario: Búsqueda exitosa de hoteles en un destino y fechas válidas
    Given que estoy en la página principal de TravelNow
    And he seleccionado la pestaña "Hoteles"
    When ingreso "Cancún" como destino
    And selecciono la fecha de check-in "2024-03-15" y check-out "2024-03-20"
    And especifico "2" adultos y "1" habitación
    And hago clic en el botón "Buscar" de hoteles
    Then deberia ver al menos 10 hoteles en la lista de resultados
    And todos los hoteles listados deberían estar en "Cancún"
    
  @Regression
  Scenario Outline: Filtrado de hoteles por categoría (estrellas)
    Given he completado una búsqueda exitosa de hoteles en "Nueva York"
    When selecciono la categoria <Estrellas> en los filtros de la pagina
    And hago clic en el botón "Aplicar" de filtro de hoteles
    Then solo se muestran hoteles con <Estrellas> estrellas
    And la cantidad de resultados se reduce

    Examples:
      | Estrellas |
      | 5         |
      | 4         |
      | 3         |
      
  Scenario: Búsqueda sin resultados por destino inexistente
    Given que estoy en la página principal de TravelNow
    When ingreso "Esto no existe" como destino
    And hago clic en el botón "Buscar" de hoteles
    Then debería ver un mensaje que dice "Lo sentimos, no encontramos hoteles en ese destino."
    And la lista de resultados debe estar vacía