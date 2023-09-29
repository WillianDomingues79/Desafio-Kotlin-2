package com.example.desafiokotlin2

import java.util.Scanner
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    //desafio1()
    //desafio2()
    //desafio3()
    //desafio4()
    desafio5()
}

fun desafio1(){
    class Bancaria(private val numeroConta: Int, private val nomeTitular: String, private val saldo: Double) {
        fun getNumeroConta(): Int {
            return numeroConta
        }

        fun getNomeTitular(): String {
            return nomeTitular
        }

        fun getSaldo(): Double {
            return saldo
        }
    }

        val scanner = Scanner(System.`in`)

        val numeroConta = scanner.nextInt()
        scanner.nextLine()

        val nomeTitular = scanner.nextLine()

        val saldo = scanner.nextDouble()

        //TODO: Criar uma instância de "ContaBancaria" com os valores de Entrada.
        val conta = Bancaria(numeroConta, nomeTitular, saldo)

        //TODO: Imprimir as informações da conta usando o objeto criado no TODO acima.
        println("Informacoes:")
        println("Conta: ${conta.getNumeroConta()}")
        println("Titular: ${conta.getNomeTitular()}")
        println("Saldo: R$ ${conta.getSaldo()}")
}

fun desafio2(){



    open class Bancaria(private val numeroConta: Int, private val nomeTitular: String, private val saldo: Double) {
        protected val decimalFormat = DecimalFormat("#.0")

        open fun exibirInformacoes() {
            println(nomeTitular)
            println(numeroConta)
            println("Saldo: R$ " + decimalFormat.format(saldo))
        }
    }

    class ContaPoupanca(  // TODO: Implementar adequadamente esta sobrecarga de construtores.  numeroConta: Int,
        numeroConta: Int,
        nomeTitular: String,
        saldo: Double,
        private val taxaJuros: Double ) : Bancaria(numeroConta, nomeTitular, saldo) {



        override fun exibirInformacoes() {
            super.exibirInformacoes()
            // TODO: Complementar as informações com a taxa de juros.
            println("Taxa de juros: $taxaJuros%")
        }
    }

    val scanner = Scanner(System.`in`)

    val nomeTitular = scanner.next()
    val numeroConta = scanner.nextInt()
    val saldo = scanner.nextDouble()
    val taxaJuros = scanner.nextDouble()

    val contaPoupanca = ContaPoupanca(numeroConta, nomeTitular, saldo, taxaJuros)

    println("Conta Poupanca:")
    contaPoupanca.exibirInformacoes()

    scanner.close()

}

fun desafio3(){
    abstract class Cofre(protected val tipo: String, protected val metodoAbertura: String) {

        fun imprimirInformacoes() {
            println("Tipo: $tipo")
            println("Metodo de abertura: $metodoAbertura")
        }
    }

    class CofreDigital(private val senha: Int) : Cofre("Cofre Digital", "Senha") {

        fun validarSenha(confirmacaoSenha: Int): Boolean {
            return confirmacaoSenha == senha
        }
    }

    class CofreFisico : Cofre("Cofre Fisico", "Chave")

    val scanner = Scanner(System.`in`)

    val tipoCofre = scanner.nextLine()
    // TODO:  Implemente a condição necessário para a verificação dos cofres seguros:
    when (tipoCofre) {
        "digital" -> {
            val senha = scanner.nextInt()
            val confrimacaoSenha = scanner.nextInt()

            val cofreDigital = CofreDigital(senha)

            if (cofreDigital.validarSenha(senha) == cofreDigital.validarSenha(confrimacaoSenha)) {
                cofreDigital.imprimirInformacoes()
                println("Cofre aberto!")
            } else {
                cofreDigital.imprimirInformacoes()
                println("Senha incorreta!")
            }
        }
        "fisico" -> {
            val cofre = CofreFisico()
            cofre.imprimirInformacoes()
        }
        else -> {
            println("Tipo de cofre não reconhecido.")
        }
    }

    scanner.close()
}

fun desafio4(){
    /*fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val dataInicial = scanner.nextLine()
        val dataFinal = scanner.nextLine()

        val sistemaAcionistas = SistemaAcionistas()
        val analises = sistemaAcionistas.obterAnalisesDesempenho(dataInicial, dataFinal)

        for (analise in analises) {
            println(analise)
        }
    }

    class SistemaAcionistas {
        fun obterAnalisesDesempenho(dataInicialStr: String, dataFinalStr: String): List<String> {
            val df = SimpleDateFormat("dd/MM/yyyy")
            val dataInicial = df.parse(dataInicialStr)
            val dataFinal = df.parse(dataFinalStr)

            val analises = mutableListOf<Analise>()
            analises.add(Analise(df.parse("01/01/2023"), "Analise de Desempenho Financeiro"))
            analises.add(Analise(df.parse("15/02/2023"), "Analise de Riscos e Exposicoes"))
            analises.add(Analise(df.parse("31/03/2023"), "Analises Corporativas"))
            analises.add(Analise(df.parse("01/04/2023"), "Analise de Politicas e Regulamentacoes"))
            analises.add(Analise(df.parse("15/05/2023"), "Analise de Ativos"))
            analises.add(Analise(df.parse("30/06/2023"), "Analise de Inovacao e Tecnologia"))

            val analisesFiltradas = mutableListOf<String>()

            for (analise in analises) {
                if (analise.data >= dataInicial && analise.data <= dataFinal) {
                    analisesFiltradas.add(analise.descricao)
                }
            }

            return analisesFiltradas
        }
    }

    data class Analise(val data: Date, val descricao: String)*/
}

fun desafio5(){

    class Transacao(private val data: String, private val hora: String, private val descricao: String, private val valor: Double) {

        fun imprimir() {
            println(descricao)
            println(data)
            println(hora)
            System.out.printf("%.2f", valor)
        }
    }

    val scanner = Scanner(System.`in`)

    val entrada = scanner.nextLine()
    val partes = entrada.split(",".toRegex()).toTypedArray()

    if (partes.size == 4) {
        val data = partes[0]
        val hora = partes[1]
        val descricao = partes[2]
        val valor = partes[3].toDouble()

        val transacao = Transacao(data, hora, descricao, valor)

        // Imprime os detalhes da transação
        transacao.imprimir()
    } else {
        println("Entrada inválida. Certifique-se de fornecer os dados no formato correto.")
    }

}