

Feature: Yo como usuario de Despegar quiero poder buscar los 10 precios más baratos de tiquetes

  @Test1
  Scenario Outline: Busquedad Exitosa
    Given el usuario esta en la pagina de Despegar
    And el usuario esta en la opcion Paquetes
    When el usuario ingresa la ciudad origen "<ciudadOrigen>"
    And el usuario ingresa la ciudad destino "<ciudadDestino>"
    And el usuario ingresa fecha partida "<fechaPartida>"
    And el usuario ingresa fecha regreso "<fechaRegreso>"
    And el usuario presiona boton buscar
    And ordenar por menor precio
    Then guardar en archivo excel

    Examples: 
      | ciudadOrigen | ciudadDestino | fechaPartida | fechaRegreso |
      | Medellin     | Cartagena     | 01/09/2018   | 29/09/2018   |

  @Test2
  Scenario Outline: Busqueda sin ciudad origen
    Given el usuario esta en la pagina de Despegar
    And el usuario esta en la opcion Paquetes
    When el usuario ingresa la ciudad origen "<ciudadOrigen>"
    And el usuario ingresa la ciudad destino "<ciudadDestino>"
    And el usuario ingresa fecha partida "<fechaPartida>"
    And el usuario ingresa fecha regreso "<fechaRegreso>"
    And el usuario presiona boton buscar
    Then muestra mensaje de validacion Ingresa un origen.

    Examples: 
      | ciudadOrigen | ciudadDestino | fechaPartida | fechaRegreso |
      |              | Cartagena     | 01/09/2018   | 29/09/2018   |

  @Test3
  Scenario Outline: Busqueda sin ciudad destino
    Given el usuario esta en la pagina de Despegar
        And el usuario esta en la opcion Paquetes
    When el usuario ingresa la ciudad origen "<ciudadOrigen>"
    And el usuario ingresa la ciudad destino "<ciudadDestino>"
    And el usuario ingresa fecha partida "<fechaPartida>"
    And el usuario ingresa fecha regreso "<fechaRegreso>"
    And el usuario presiona boton buscar
    Then muestra mensaje de validacion El destino deben ser diferente al origen.

    Examples: 
      | ciudadOrigen | ciudadDestino | fechaPartida | fechaRegreso |
      | Medellin     |               | 01/09/2018   | 29/09/2018   |

  @Test4
  Scenario Outline: Busqueda sin ciudad destino igual ciudad origen
    Given el usuario esta en la pagina de Despegar
        And el usuario esta en la opcion Paquetes
    When el usuario ingresa la ciudad origen "<ciudadOrigen>"
    And el usuario ingresa la ciudad destino "<ciudadDestino>"
    And el usuario ingresa fecha partida "<fechaPartida>"
    And el usuario ingresa fecha regreso "<fechaRegreso>"
    And el usuario presiona boton buscar
    Then muestra mensaje de validacion El destino deben ser diferente al origen.

    Examples: 
      | ciudadOrigen | ciudadDestino | fechaPartida | fechaRegreso |
      | Medellin     | Medellin      | 01/09/2018   | 29/09/2018   |

  @Test5
  Scenario Outline: Busqueda sin fecha partida
    Given el usuario esta en la pagina de Despegar
        And el usuario esta en la opcion Paquetes
    When el usuario ingresa la ciudad origen "<ciudadOrigen>"
    And el usuario ingresa la ciudad destino "<ciudadDestino>"
    And el usuario presiona boton buscar
    Then muestra mensaje de validacion Ingresa una fecha de partida.

    Examples: 
      | ciudadOrigen | ciudadDestino | fechaPartida | fechaRegreso |
      | Medellin     | Cartagena     |              |              |

  @Test6
  Scenario Outline: Busqueda sin fecha regreso
    Given el usuario esta en la pagina de Despegar
        And el usuario esta en la opcion Paquetes
    When el usuario ingresa la ciudad origen "<ciudadOrigen>"
    And el usuario ingresa la ciudad destino "<ciudadDestino>"
    And el usuario presiona boton buscar
    Then muestra mensaje de validacion Ingresa una fecha de regreso.

    Examples: 
      | ciudadOrigen | ciudadDestino | fechaPartida | fechaRegreso |
      | Medellin     | Cartagena     |              |              |
