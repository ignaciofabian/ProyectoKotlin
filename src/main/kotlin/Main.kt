package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("GameZone iniciado")
    val nombreSistema: String = "GameZone"

    val capacidad: Int = 10

    var recaudacionTotal: Double = 0.0

    val codigoConsola: String = "CC12CD"
    val marca: String = "PlayStation"
    val modelo: String = "PlayStation 5"
    val minutosUso: Int = 75
    val tarifaHora: Double = 800.0

    println("Sistema: $nombreSistema")
    println("Capacidad: $capacidad")
    println("Recaudación: $recaudacionTotal")

    recaudacionTotal = 800.0

    println("Nueva recaudación: $recaudacionTotal")

    fun calcularCostoBase(
        minutos: Int,
        tarifaHora: Double
    ): Double {
        return (minutos / 60.0) * tarifaHora
    }

    fun aplicarIva(monto: Double): Double {
        return monto * 1.19
    }

    val costoBase = calcularCostoBase(
        minutosUso,
        tarifaHora
    )

    val totalConIva = aplicarIva(costoBase)
    println("Costo base: $costoBase")
    println("Total con IVA: $totalConIva")


    val tipoUsuario = "socio"

    fun describirTipoUsuario(tipoUsuario: String): String {
        return when (tipoUsuario) {
            "infantil" -> "Usuario infantil"
            "socio" -> "Usuario socio"
            "educacional" -> "Usuario educacional"
            else -> "Tipo de usuario inválido"
        }
    }

    fun aplicarBeneficioUsuario(
        monto: Double,
        tipoUsuario: String
    ): Double {

        return when (tipoUsuario) {
            "socio" -> monto * 0.80
            "educacional" -> monto * 0.50
            "infantil" -> monto
            else -> monto
        }
    }
    val monto = 10000.0

    println(aplicarBeneficioUsuario(monto, "infantil"))
    println(aplicarBeneficioUsuario(monto, "socio"))
    println(aplicarBeneficioUsuario(monto, "educacional"))

    if (tipoUsuario == "socio") {
        println("Tiene beneficio de socio")
    } else {
        println("No tiene beneficio de socio")
    }

    val consola = Consola(
        codigo = "CC12CD",
        marca = "Sony",
        modelo = "PlayStation 5",
        tipoUsuario = "socio"
    )

    println(consola.codigo)
    println(consola.marca)
    println(consola.modelo)
    println(consola.tipoUsuario)



    val clasica = ConsolaClasica(
        "CC12CD",
        "Sony",
        "PlayStation 5",
        "socio"
    )

    val moderna = ConsolaModerna(
        "CM22TO",
        "Nintendo",
        "Switch",
        "infantil"
    )

    val vr = ConsolaVR(
        "VR44RG",
        "Meta",
        "Quest 3",
        "educacional",
        true
    )

    println(clasica)
    println(moderna)
    println(vr)

val consolas: List<Consola> = listOf(
    ConsolaClasica(
        "CC12CD",
        "Sony",
        "PlayStation 5",
        "socio"
    ),
    ConsolaModerna(
        "CM22TO",
        "Nintendo",
        "Switch",
        "infantil"
    ),
    ConsolaVR(
        "VR44RG",
        "Meta",
        "Quest 3",
        "educacional",
        true
    )
)
    consola.calcularTarifa(...)

    fun main() {

        val puesto = Puesto(1)

        println(describirEstado(puesto))

        puesto.estado = EstadoPuesto.EnProceso(
            "registrando entrada"
        )

        println(describirEstado(puesto))

        puesto.estado = EstadoPuesto.EnReparacion(
            "mantenimiento preventivo"
        )

        println(describirEstado(puesto))
    }

    fun main() {

        // Crear los 10 puestos
        val puestos: MutableList<Puesto> = mutableListOf()

        for (numero in 1..10) {
            puestos.add(Puesto(numero))
        }

        // Mostrar los 10 puestos
        for (puesto in puestos) {
            println(
                "Puesto ${puesto.numero}: " +
                        describirEstado(puesto)
            )
        }

        // Buscar el primer puesto libre
        var puestoLibre: Puesto? = null

        for (puesto in puestos) {
            if (puesto.estado is EstadoPuesto.Libre) {
                puestoLibre = puesto
                break
            }
        }

        if (puestoLibre != null) {
            println("Primer puesto libre: ${puestoLibre.numero}")
        } else {
            println("No existen puestos disponibles")
        }
    }
    val historial: MutableList<Consola> = mutableListOf()
    historial.add(
        ConsolaClasica(
            "CC12CD",
            "Sony",
            "PlayStation 5",
            "socio"
        )
    )

    historial.add(
        ConsolaModerna(
            "CM22TO",
            "Nintendo",
            "Switch",
            "infantil"
        )
    )
    for (consola in historial) {
        println(
            "${consola.codigo} - " +
                    "${consola.marca} ${consola.modelo}"
        )
    }

    val tickets: List<Ticket> = listOf(
        Ticket(
            1,
            "CC12CD",
            "Clasica",
            75,
            1200.0
        ),
        Ticket(
            2,
            "CM22TO",
            "Moderna",
            18,
            0.0
        ),
        Ticket(
            3,
            "VR44RG",
            "VR",
            120,
            7000.0
        )
    )
    val ticketsVR = tickets.filter { ticket ->
        ticket.tipoConsola == "VR"
    }

    println("\nTickets VR:")

    for (ticket in ticketsVR) {
        println("${ticket.codigoConsola} - ${ticket.monto}")
    }
    val codigosAtendidos = tickets.map { ticket ->
        ticket.codigoConsola
    }

    println("\nCódigos atendidos:")

    codigosAtendidos.forEach { codigo ->
        println(codigo)
    }
    val recaudacion = tickets.sumOf { ticket ->
        ticket.monto
    }

    println("\nRecaudación total: $recaudacion")
    val disponibles = puestos.count { puesto ->
        puesto.estado is EstadoPuesto.Libre
    }

    println("\nPuestos disponibles: $disponibles")
    val ingresoVR = tickets
        .filter { ticket ->
            ticket.tipoConsola == "VR"
        }
        .sumOf { ticket ->
            ticket.monto
        }

    println("Ingreso generado por VR: $ingresoVR")


}