package com.thakur.kafkaserver.restcontroller

import com.thakur.kafkaserver.model.Person
import com.thakur.kafkaserver.service.KafkaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("kafka")
class KafkaRestController {

    val firstNames = arrayOf("Ankit", "Pete", "Steve", "Avi", "Madhu", "Gopu")
    val lastNames= arrayOf("Thakur", "Jordon", "Johnson", "Singh", "Gopal", "Menon")

    private val service:KafkaService

    constructor(service: KafkaService) {
        this.service = service
    }

    @GetMapping("hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun helloWorld():String {
        return service.helloService()
    }

    @GetMapping("message")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun helloKafka() {
        val randomFirstNameIndex:Int = Random().nextInt(firstNames.size)
        val randomLastNameIndex:Int = Random().nextInt(lastNames.size)

        val person:Person = Person(firstName = firstNames[randomFirstNameIndex], lastName = lastNames[randomLastNameIndex], messageTime = System.currentTimeMillis())
        service.sendMessage(person)
    }
}