package com.thakur.kafkaserver.model

import lombok.Getter
import lombok.Setter
import lombok.ToString

@Getter
@Setter
@ToString
data class Person(
        var firstName:String,
        var lastName:String,
        var messageTime:Long
)