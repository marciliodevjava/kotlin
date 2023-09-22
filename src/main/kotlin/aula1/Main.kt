package aula1

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers


fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()

    val response = client.send(request, BodyHandlers.ofString())

    val json = response.body()

    println(json)

    val meuJogo = Jogo()
    meuJogo.titulo = "Batman: Guerreiro Negro"
    meuJogo.capa = "https://pt.wikipedia.org/wiki/Batman_%281989%29#/media/Ficheiro:Batman_ver2.jpg"

    println(meuJogo)
}