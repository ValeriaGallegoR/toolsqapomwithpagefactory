# new feature
# Tags: optional

Feature: como empleado de recursos humanos
  necesito actualizar mi informacion personal
  para tener actualizado mis datos

  Scenario: editar la informacion personal del usuario
    Given el empleado se encuentra en la sesion personal details de la plataforma
    When el empleado llene los campos requeridos y presione el boton save
    Then el sistema guardara los cambios realizados