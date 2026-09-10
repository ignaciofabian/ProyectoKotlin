fun validarCodigo(codigo: String): Boolean {
    val regex = Regex("^[A-Za-z]{2}[0-9]{2}[A-Za-z]{2}$")
    return regex.matches(codigo)
}

fun validarTarifa(
    consola: Consola,
    minutos: Int,
    monto: Double
): Boolean {

    if (monto < 0.0) {
        return false
    }

    if (
        monto == 0.0 &&
        !(consola is ConsolaModerna && minutos < 20)
    ) {
        return false
    }

    return true
}
