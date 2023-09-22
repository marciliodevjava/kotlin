package aula1

import com.ibm.jvm.trace.format.api.Message.Arg

class Jogo() {
    var titulo = ""
    var capa = ""
    val descricao = ""

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Titulo: $titulo, \n" +
                "Capa: $capa, \n" +
                "Descricao: $descricao\n"
    }
}