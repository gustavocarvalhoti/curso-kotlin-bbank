package org.example

fun main() {
    println("******************************************")
    println("BITE BANK")
    println("******************************************")

    //testeTemplate()
    //testaCondicoes(saldo)
    //testeLoop()
    //testeCopias()
    testeContaMichelle()
}

private fun testeContaMichelle() {
    val contaMichelle = Conta("Michelle", 2)
    contaMichelle.setSaldo(100.00)
    contaMichelle.depositar(1000.00)

    // Podemos utilizar as labels tb para construtor e funções
    val contaGustavo = Conta(numero = 1, titular = "Gustavo")
    contaGustavo.depositar(200.00)
    contaGustavo.sacar(100.00)
    contaGustavo.transferir(100.00, contaMichelle)

    println("******************************************")
    println("Gustavo  - Saldo: ${contaGustavo.getSaldo()}")
    println("Michelle - Saldo: ${contaMichelle.getSaldo()}")
}

private fun testeCopias() {
    val conta = Conta("Gustavo", 1)
    println(conta)

    val conta2 = Conta("Michelle", 2)
    println(conta2)
}

private fun testeTemplate() {
    // Val - Imutavel / Var - Mutavel
    // Template
    val titular = "Gus"
    val numeroConta = 10000
    // Precisa inicializar com alguma coisa mesmo que vá mudar
    var saldo = 0.0
    saldo += -60

    println("Titular: $titular")
    println("Conta:   $numeroConta")
    println("Saldo:   $saldo")
}

private fun testeLoop() {
    // Adicionando
    println("******************************************")
    for (i in 1..3) {
        println(i)
    }

    // Diminuindo
    println("******************************************")
    for (i in 5 downTo 1) {
        println(i)
    }

    // Diminuindo de 2 em 2
    println("******************************************")
    for (i in 6 downTo 0 step 2) {
        println(i)
    }

    // While
    println("******************************************")
    var i = 0
    while (i < 5) {
        println(i)
        i++
    }
}

private fun testaCondicoes(saldo: Double) {
    // If else mais eficiente
    when {
        saldo > 0.0 -> println("Saldo positivo")
        saldo == 0.0 -> println("Conta zerada")
        else -> println("Conta negativa")
    }
}

// Aqui é o construtor padrão (Primario)
class Conta(val titular: String, val numero: Int) {

    private var saldo = 0.0

    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(valor: Double) {
        if (valor > 0) {
            saldo = valor
        }
    }

    override fun toString(): String {
        return "Conta(titular='$titular', numero=$numero, saldo=$saldo)"
    }

    // Emcapsular isso dentor da classe
    fun depositar(valor: Double) {
        this.saldo += valor
        println("${this.titular} | Novo deposito: $valor")
        imprimirSaldo()
    }

    fun sacar(valor: Double) {
        this.saldo -= valor
        println("${this.titular} | Novo saque: $valor")
        imprimirSaldo()
    }

    fun transferir(valor: Double, contaDestino: Conta): Boolean {
        println("${this.titular} | Nova transferência: $valor")

        if (saldo >= valor) {
            this.saldo -= valor
            imprimirSaldo()
            contaDestino.depositar(valor)
            return true
        }

        println("ERRO: Saldo insuficiente na conta do $titular. Saldo: $saldo")
        return false
    }

    private fun imprimirSaldo() {
        println("Saldo: ${this.saldo}\n")
    }

}