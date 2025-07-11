package com.ms_user.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tb_user")
data class UserModel(

    @Id
    val id: UUID = UUID.randomUUID(),

    val userName: String,

    @Column(unique = true)
    val userEmail: String,
)
