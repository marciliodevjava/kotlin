package aula2

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers


fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=147"))
        .build()

    val response = client.send(request, BodyHandlers.ofString())

    val json = response.body()

    println(json)

    val meuJogo = Jogo1(
        "Batman: Arkham Asylum Game of the Year Edition",
        "https:\\/\\/cdn.cloudflare.steamstatic.com\\/steam\\/apps\\/35140\\/capsule_sm_120.jpg?t=1681938587"
    )

    val novoJogo = Jogo1(
        capa = "https:\\/\\/cdn.cloudflare.steamstatic.com\\/steam\\/apps\\/43190\\/capsule_sm_120.jpg?t=1678983225",
        titulo = "The Haunted: Hells Reach"
    )

    println(meuJogo)
    println("=========================================")
    println(novoJogo)
}