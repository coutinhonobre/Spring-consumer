package com.example.spring.consumer.amqp

interface AmqpConsumer<T> {
    fun consumer(t: T)
}