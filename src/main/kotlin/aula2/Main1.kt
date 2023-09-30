package aula2

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*


fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite o codigo do jogo:")
    val busca = leitura.nextLine().trim();
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client.send(request, BodyHandlers.ofString())
    val json = response.body()

//    println(json)

    val gson = Gson()

    var meuJogo: Jogo1? = null

    val resultado = runCatching {
        val meuJogoInfo = gson.fromJson(json, InfoJogo::class.java)
        meuJogo = Jogo1(meuJogoInfo.info.title, meuJogoInfo.info.thumb)
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir um descrição personalizada?")
        println("                   SIM                    ")
        println("                   Não                    ")
        val opcao = leitura.nextLine()
        if (opcao.equals("sim", true)) {
            println("Insira a descrição personalida para o jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso")
    }

//    try {
//        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
//        val meuJogo = Jogo1(
//            meuInfoJogo.info.title,
//            meuInfoJogo.info.thumb)
//
//        println(meuJogo)
//    } catch (ex: JsonSyntaxException) {
//        println("Não existe jogo vinculado a esse ID")
//    }
}