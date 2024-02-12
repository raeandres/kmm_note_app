package datasource.network

import datasource.NotesDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import model.Note

class NotesApi : NotesDataSource {

    private val BASE_URL = "http://localhost:3000/api"

    companion object {

       val INSTANCE : NotesApi by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { NotesApi() }
    }

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }



     override suspend fun getAllNotes() : List<Note> {
         return INSTANCE.httpClient.get("$BASE_URL/notes").body()
    }

    override fun addNote() {
        TODO("Not yet implemented")
    }

    override fun removeNote() {
        TODO("Not yet implemented")
    }

    override suspend fun testApi(): String {
        return httpClient.get("https://api.spacexdata.com/v5/launches").body<String>().toString()
    }


}