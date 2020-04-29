package com.example.spring.consumer.amqp.implementation

import com.example.spring.consumer.amqp.AmqpConsumer
import com.example.spring.consumer.dto.Message
import com.example.spring.consumer.service.ConsumerService
import org.springframework.amqp.AmqpRejectAndDontRequeueException
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RabbitMQConsumer : AmqpConsumer<Message?> {
    @Autowired
    private val consumerService: ConsumerService? = null

    @RabbitListener(queues = ["\${spring.rabbitmq.request.routing-key.producer}"])
    override fun consumer(t: Message?) {
        try {
            consumerService!!.action(t!!)
        } catch (ex: Exception) {
            throw AmqpRejectAndDontRequeueException(ex)
        }
    }
}