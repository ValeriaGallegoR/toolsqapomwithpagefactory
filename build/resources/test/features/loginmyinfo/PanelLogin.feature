# new feature
# Tags: optional

Feature: como empleado de recursos humanos
  necesito loguearme a la plataforma orangeHRM
  para realizar la gestión adecuada de recursos humanos de la empresa


  Scenario: inicio de sesion exitoso
    Given el empleado se encuentra en la pagina login de la plataforma
    When el empleado ingrese con el usuario y la contraseña valida
    Then el sistema deberá mostrar un mensaje de Welcome con el nombre del usuario