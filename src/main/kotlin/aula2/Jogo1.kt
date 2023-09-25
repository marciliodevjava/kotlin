package aula2

data class Jogo1(val titulo: String, val capa: String) {
    var descricao:String? = null

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Titulo: $titulo, \n" +
                "Capa: $capa, \n" +
                "Descricao: $descricao\n"
    }
}