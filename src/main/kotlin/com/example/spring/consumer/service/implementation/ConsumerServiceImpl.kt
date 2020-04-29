package com.example.spring.consumer.service.implementation

import com.example.spring.consumer.dto.Message
import com.example.spring.consumer.service.ConsumerService
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class ConsumerServiceImpl: ConsumerService {

    @Throws(Exception::class)
    override fun action(message: Message) {
        println("Mensagem => ${message.text}");
    }

}