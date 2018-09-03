package com.thakur.kafkaserver.config

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface KafkaServerStreams {

    @Output(PRODUCER_STREAM)
    fun producerChannel(): MessageChannel

    companion object {
        const val PRODUCER_STREAM = "kafkatopic1"
    }
}