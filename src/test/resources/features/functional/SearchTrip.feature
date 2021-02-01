Feature: Search Trip
  Para buscar un viaje según mi disponibilidad
  Como usuario
  Yo deseo buscar mi viaje

  @end2end
  Scenario: [Happy Path] - Usuario selecciona parametros de busqueda
    Given Usuario navega hasta la página home
    When Usuario selecciona los parametros de su busqueda:
      | tipo_viaje | One Way                 |
      | destino    | Cusco                   |
      | ruta       | Puno > Cusco            |
      | tren       | Belmond Andean Explorer |
      | start_date | 2021 April 7            |
    And Usuario solicita realizar busqueda
    Then El sistema muestra la 2 paso del proceso


