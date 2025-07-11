package com.ms_user.controllers

import com.ms_user.dtos.UserDto
import com.ms_user.models.UserModel
import com.ms_user.services.UserService
import jakarta.validation.Payload
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService){

    @PostMapping
    fun createUser(@RequestBody payload: UserDto): ResponseEntity<UserModel> {
        val newUser = userService.createUser(payload)
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser)
    }
}