package com.ms_user.producers

import com.ms_user.dtos.MessageEmailDto
import com.ms_user.models.UserModel
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class UserProducer(private val rabbitTemplate: RabbitTemplate) {

    @Value("\${broker.queue.email.name}")
    lateinit var routingKey: String

    fun publishMessage(userModel: UserModel) {
        val message = MessageEmailDto(
            userName = userModel.userName,
            userEmail = userModel.userEmail
        )
        rabbitTemplate.convertAndSend("", routingKey, message)
    }
}