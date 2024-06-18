package com.thiagowlian.ticketmanager.interfaceAdapter.repository

import com.thiagowlian.ticketmanager.entities.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>