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



}