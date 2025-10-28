@HU-003 @Reserva @Vuelos @PrioridadAlta
Feature: Gestion de Reservas de Vuelos
 Como usuario en TravelNow
 Quiero reservar vuelos disponibles
 Para poder planificar mi viaje

 @CreacionReserva @AuthRequerido
 Scenario Outline: Creacion de reserva de vuelo
  Given que he seleccionado el vuelo "<Vuelo>" de "<Origen>" a "<Destino>"
  And selecciono las siguientes preferencias de vuelo:
   | Preferencia     | Valor      |
   | Clase        | <Clase>     |
   | Pasajeros Adultos  | <Adultos>    |
   | Pasajeros Ninos   | <Ninos>     |

  And selecciono el servicio adicional de "<ServicioAdicional>"
  And he completado los datos de los pasajeros
  When confirmo el pago utilizando un saldo de mi Monedero TravelNow
  Then la reserva de vuelo se confirma con exito
  And el detalle de la reserva <ResultadoServicio> el costo del "<ServicioAdicional>"

  Examples:
   | Vuelo  | Origen  | Destino    | Clase   | Adultos | Ninos | ServicioAdicional  | ResultadoServicio |
   | AR1234 | Santiago | Buenos Aires | Economica | 2 | 1 | Equipaje adicional | incluye |
   | LA7890 | Lima   | Bogota    | Premium  | 1 | 0 | Ninguno | NO incluye |
   | UX5678 | Madrid  | Paris     | Business | 2 | 0 | Asiento preferencial | incluye |