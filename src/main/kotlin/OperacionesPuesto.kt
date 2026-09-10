import kotlinx.coroutines.delay

suspend fun registrarEntrada(
    puestos: MutableList<Puesto>,
    consola: Consola
): Boolean {

    try {

        // Validar código de consola
        if (!validarCodigo(consola.codigo)) {
            throw IllegalArgumentException(
                "Código de consola inválido: ${consola.codigo}"
            )
        }

        // Buscar puesto libre
        val puesto = puestos.firstOrNull {
            it.estado is EstadoPuesto.Libre
        }

        // Comprobar capacidad
        if (puesto == null) {
            println("Error: No existen puestos disponibles")
            return false
        }

        println(
            "Registrando entrada en puesto ${puesto.numero}..."
        )

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

    } catch (e: IllegalArgumentException) {

        println("Error: ${e.message}")
        return false
    }
}


suspend fun registrarSalida(
    puestos: MutableList<Puesto>,
    codigo: String,
    minutos: Int,
    historial: MutableList<Ticket>
): Boolean {

    try {

        // Validar código
        if (!validarCodigo(codigo)) {
            throw IllegalArgumentException(
                "Código de consola inválido: $codigo"
            )
        }

        // Buscar el puesto donde está jugando esa consola
        val puesto = puestos.firstOrNull { puesto ->
            val estado = puesto.estado

            estado is EstadoPuesto.EnJuego &&
                    estado.consola.codigo == codigo
        }

        // Consola no encontrada
        if (puesto == null) {
            println("Error: Consola no encontrada")
            return false
        }

        // Comprobar que realmente está en juego
        val estadoActual = puesto.estado

        if (estadoActual !is EstadoPuesto.EnJuego) {
            println("Error: La consola no está en juego")
            return false
        }

        // Guardamos la consola antes de cambiar el estado
        val consola = estadoActual.consola

        // Validar minutos
        if (minutos <= 0) {
            throw IllegalArgumentException(
                "Los minutos de uso deben ser mayores que cero"
            )
        }

        println(
            "Calculando salida para ${consola.codigo}..."
        )

        puesto.estado = EstadoPuesto.EnProceso(
            "calculando tarifa"
        )

        delay(6500)

        // Calcular tarifa
        val monto = consola.calcularTarifa(minutos)

        // Validar tarifa
        if (!validarTarifa(consola, minutos, monto)) {

            puesto.estado = EstadoPuesto.Libre

            throw IllegalArgumentException(
                "Tarifa inválida: $monto"
            )
        }

        // Crear ticket
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

        // Liberar puesto
        puesto.estado = EstadoPuesto.Libre

        return true

    } catch (e: IllegalArgumentException) {

        println("Error: ${e.message}")
        return false
    }
}
