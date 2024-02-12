package datasource.network

import datasource.NotesDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
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

    override fun testApi(result: (String) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val api = httpClient.get("https://api.spacexdata.com/v5/launches")

            if (api.call.response.status == HttpStatusCode.OK) {
               result.invoke(api.body())
            }
        }

    }


    override fun testInvokeApiCall() {
        CoroutineScope(Dispatchers.IO).launch{
            val result = httpClient.get("https://api.spacexdata.com/v5/launches")

           if (result.call.response.status == HttpStatusCode.OK) {
               println("API Result: ${result.body<String>()}")
           }
        }
    }


}