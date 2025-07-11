package com.ms_user.services

import com.ms_user.dtos.UserDto
import com.ms_user.mappers.toUserModel
import com.ms_user.models.UserModel
import com.ms_user.producers.UserProducer
import com.ms_user.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userProducer: UserProducer) {

    fun createUser(payload: UserDto): UserModel {
        val newUser = payload.toUserModel()
        userProducer.publishMessage(newUser)
        userRepository.save(newUser)
        return newUser
    }
}