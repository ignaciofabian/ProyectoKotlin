import kotlinx.coroutines.delay

suspend fun registrarEntrada(
    puestos: MutableList<Puesto>,
    consola: Consola
): Boolean {

    val puesto = puestos.firstOrNull {
        it.estado is EstadoPuesto.Libre
    } ?: return false

    println("Registrando entrada en puesto ${puesto.numero}...")

    puesto.estado = EstadoPuesto.EnProceso(
        "registrando entrada"
    )

    delay(3000)

    puesto.estado = EstadoPuesto.EnJuego(
        consola
    )

    println(
        "Entrada registrada. " +
                "Puesto ${puesto.numero} en juego."
    )

    return true
}

suspend fun registrarSalida(
    puestos: MutableList<Puesto>,
    codigo: String,
    minutos: Int,
    historial: MutableList<Ticket>
): Boolean {

    val puesto = puestos.firstOrNull { puesto ->
        val estado = puesto.estado

        estado is EstadoPuesto.EnJuego &&
                estado.consola.codigo == codigo
    } ?: return false

    val estadoActual = puesto.estado

    if (estadoActual !is EstadoPuesto.EnJuego) {
        return false
    }

    val consola = estadoActual.consola

    println(
        "Calculando salida para ${consola.codigo}..."
    )

    puesto.estado = EstadoPuesto.EnProceso(
        "calculando tarifa"
    )

    delay(6500)

    val monto = consola.calcularTarifa(minutos)

    val ticket = Ticket(
        numero = historial.size + 1,
        codigoConsola = consola.codigo,
        tipoConsola = consola::class.simpleName ?: "Desconocida",
        minutosUso = minutos,
        monto = monto
    )

    historial.add(ticket)

    println(
        "Salida registrada. " +
                "Monto: $monto"
    )

    puesto.estado = EstadoPuesto.Libre

    return true
}
