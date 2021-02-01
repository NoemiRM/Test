Feature: Search Trip
  Para buscar un viaje según mi disponibilidad
  Como usuario
  Yo deseo buscar mi viaje

  @end2end1
  Scenario: [Happy Path] - Usuario selecciona parametros de busqueda
    Given Usuario navega hasta la página home
    When Usuario selecciona los parametros de su busqueda:
      | tipo_viaje | One Way                 |
      | destino    | Cusco                   |
      | ruta       | Puno > Cusco            |
      | tren       | Belmond Andean Explorer |
      | start_date | 2021 April 7            |
    And Usuario solicita realizar busqueda
    Then El sistema muestra el paso número del proceso

  @end2end
  Scenario: [Happy Path] - Usuario selecciona cabina / número de personas
    Given Usuario navega hasta la página home
    When Usuario selecciona los parametros de su busqueda:
      | tipo_viaje | One Way                 |
      | destino    | Cusco                   |
      | ruta       | Puno > Cusco            |
      | tren       | Belmond Andean Explorer |
      | start_date | 2021 April 7            |
    And Usuario solicita realizar busqueda
    And El sistema muestra el paso número del proceso
    And Usuario busca SUITE CABINS como cabina
    And Usuario selecciona 1 cabina en SUITE CABINS
    And Usuario selecciona 1 adultos en SUITE CABINS
    And Usuario selecciona 1 niño en SUITE CABINS
    And Usuario continua con el proceso de booking





