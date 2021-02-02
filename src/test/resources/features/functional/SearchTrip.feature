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
      | start_date | 2021 June 2             |
    And Usuario solicita realizar busqueda
    Then El sistema muestra el paso número del proceso

  @end2end2
  Scenario: [Happy Path] - Usuario selecciona cabina / número de personas
    Given Usuario navega hasta la página home
    When Usuario selecciona los parametros de su busqueda:
      | tipo_viaje | One Way                 |
      | destino    | Cusco                   |
      | ruta       | Puno > Cusco            |
      | tren       | Belmond Andean Explorer |
      | start_date | 2021 June 2             |
    And Usuario solicita realizar busqueda
    And El sistema muestra el paso número del proceso
    And Usuario busca SUITE CABINS como cabina
    And Usuario selecciona 1 cabina en SUITE CABINS
    And Usuario selecciona 1 adultos en SUITE CABINS
    And Usuario selecciona 1 niño en SUITE CABINS
    And Usuario continua con el proceso de booking
    Then El sistema muestra el paso número 3 del proceso

  @end2end
  Scenario: [Happy Path] - Usuario ingresa datos de los pasajeros
    Given Usuario navega hasta la página home
    When Usuario selecciona los parametros de su busqueda:
      | tipo_viaje | One Way                 |
      | destino    | Cusco                   |
      | ruta       | Puno > Cusco            |
      | tren       | Belmond Andean Explorer |
      | start_date | 2021 June 2             |
    And Usuario solicita realizar busqueda
    And El sistema muestra el paso número del proceso
    When Usuario selecciona los parametros del tipo de cabina:
      | nombre_cabina   | SUITE CABINS |
      | cantidad_cabina | 1            |
      | numero_adultos  | 1            |
      | numero_nino     | 0            |
    And Usuario continua con el proceso de booking
    When Usuario ingresa datos de los pasajeros:
      | nombre_cabina    | SUITE CABINS        |
      | numero_cabina    | 1                   |
      | numero_pasajero  | 1                   |
      | nombre           | Juan                |
      | apellido         | Perez               |
      | fecha_nacimiento | 1980 Jun 2          |
      | nacional         | Peru                |
      | tipo_doc         | Identification Card |
      | num_doc          | 50971319            |
      | sexo             | Female              |
      | telefono         | 949123471           |
      | email            | juan@yopmail.com    |
      | re_email         | juan@yopmail.com    |
    And Usuario continua hacia el proceso de pago
    Then El sistema muestra el paso número 4 del proceso




