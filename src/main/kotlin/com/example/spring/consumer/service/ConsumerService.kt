package com.example.spring.consumer.service

import com.example.spring.consumer.dto.Message

interface ConsumerService {

    @Throws(Exception::class)
    fun action(message: Message)
}