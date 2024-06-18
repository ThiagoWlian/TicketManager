package com.thiagowlian.ticketmanager.interfaceAdapter.mapper.ticket

import com.thiagowlian.ticketmanager.entities.ticket.Status
import com.thiagowlian.ticketmanager.entities.ticket.Urgency
import com.thiagowlian.ticketmanager.interfaceAdapter.mapper.user.UserDataMapper
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "ticket")
data class TicketDataMapper(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val identificationCode: String,
        @Column(name = "title")
        val title: String,
        @Column(name = "status")
        val status: Status,
        val creator: UserDataMapper,
        @Column(name = "description")
        val description: String? = null,
        val responsible: UserDataMapper? = null,
        @Column(name = "startDate")
        val startDateTime: LocalDateTime? = null,
        @Column(name = "urgency")
        val urgency: Urgency? = null,
        @OneToMany(
                mappedBy = "ticket",
                cascade = [CascadeType.ALL],
                orphanRemoval = true
        )
        val messages: Set<MessageDataMapper> = HashSet(),
        @OneToMany(
                mappedBy = "ticket",
                cascade = [CascadeType.ALL],
                orphanRemoval = true
        )
        val history: List<ChangeDataMapper> = ArrayList()
)
