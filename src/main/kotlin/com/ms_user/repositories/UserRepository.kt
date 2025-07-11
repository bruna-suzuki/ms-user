package com.ms_user.repositories

import com.ms_user.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<UserModel, UUID> {
}