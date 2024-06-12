package com.live


import com.google.gson.Gson
import io.ktor.client.statement.*
import io.ktor.client.utils.*
import io.ktor.http.*
import io.ktor.http.cio.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.net.http.HttpResponse

fun main(args: Array<String>): Unit = EngineMain.main(args)

data class Data(
    val message: String,
    val title: String,
    val code : Int,
)

fun Application.module() {
    module2()
    routing {
        get("/") {
            val data = Data(message = "Hello world", title = "Test", code = HttpStatusCode.OK.value)
            val json = Gson().toJson(data)
            call.respond(json)
        }
    }
}


fun Application.module2() {
    routing {
        get("/module2") {
            call.respondText("Hello from 'module2'!")
        }
    }
}