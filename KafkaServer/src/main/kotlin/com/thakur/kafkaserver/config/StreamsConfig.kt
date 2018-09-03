package com.thakur.kafkaserver.config

import org.springframework.cloud.stream.annotation.EnableBinding

@EnableBinding(KafkaServerStreams::class)
class StreamsConfig