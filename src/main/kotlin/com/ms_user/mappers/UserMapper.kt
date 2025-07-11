package com.ms_user.mappers

import com.ms_user.dtos.UserDto
import com.ms_user.models.UserModel

fun UserDto.toUserModel(): UserModel {
    return UserModel(
        userName = this.name,
        userEmail = this.email
    )
}