package com.thiagowlian.ticketmanager.entities.ticket

import com.thiagowlian.ticketmanager.entities.ticket.exception.TicketInvalidStatusChangeException
import com.thiagowlian.ticketmanager.entities.ticket.interfaces.Ticket
import com.thiagowlian.ticketmanager.entities.user.UserImplementation
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period

class TicketImplementation : Ticket {
    var identificationCode: String
        private set
    var title: String
        private set
    var description: String? = null
        private set
    var creationDate: LocalDate = LocalDate.now()
        private set
    var status: Status
        private set
    var creator: UserImplementation
        private set
    var urgency: Urgency? = null
        private set
    var responsible: UserImplementation? = null
        private set
    var messages: MutableSet<Message> = HashSet()
        private set
    var startDateTime: LocalDateTime? = null
        private set
    var history: List<Change> = ArrayList()
        private set

    constructor(identificationCode: String, title: String, status: Status, creator: UserImplementation) {
        this.identificationCode = identificationCode
        this.title = title
        this.status = status
        this.creator = creator
        verifyIfNewStatusIsValid(status)
    }

    constructor(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String) {
        this.identificationCode = identificationCode
        this.title = title
        this.status = status
        this.creator = creator
        this.description = description
        verifyIfNewStatusIsValid(status)
    }

    constructor(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String, responsible: UserImplementation, startDateTime: LocalDateTime, urgency: Urgency) {
        this.identificationCode = identificationCode
        this.title = title
        this.status = status
        this.creator = creator
        this.description = description
        this.responsible = responsible
        this.startDateTime = startDateTime
        this.urgency = urgency
        verifyIfNewStatusIsValid(status)
    }

    constructor(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String, responsible: UserImplementation, startDateTime: LocalDateTime, urgency: Urgency, messages: HashSet<Message>) {
        this.identificationCode = identificationCode
        this.title = title
        this.status = status
        this.creator = creator
        this.description = description
        this.responsible = responsible
        this.urgency = urgency
        this.startDateTime = startDateTime
        this.messages = messages
        verifyIfNewStatusIsValid(status)
    }

    constructor(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String, responsible: UserImplementation, startDateTime: LocalDateTime, urgency: Urgency, messages: HashSet<Message>, history: List<Change>) {
        this.identificationCode = identificationCode
        this.title = title
        this.status = status
        this.creator = creator
        this.description = description
        this.responsible = responsible
        this.urgency = urgency
        this.startDateTime = startDateTime
        this.messages = messages
        this.history = history
        verifyIfNewStatusIsValid(status)
    }

    override fun getPriority(): Int {
        return calculePriority(getDaysStarted())
    }

    private fun calculePriority(daysOpen: Int): Int {
        return urgency?.priorityMultiplier?.times(daysOpen) ?: 0
    }

    private fun getDaysStarted(): Int {
        return startDateTime?.let {
            val localDateNow = LocalDate.now()
            Period.between(localDateNow, it.toLocalDate()).days
        } ?: 0
    }

    override fun changeStatus(status: Status, userImplementation: UserImplementation) {
        verifyIfNewStatusIsValid(status)
        updateTicketValuesByStatus(status)
        updateStatus(status, userImplementation)
    }

    private fun verifyIfNewStatusIsValid(status: Status) {
        val result = status.executeValidationStatus(this)
        if (result.isError()) {
            throw TicketInvalidStatusChangeException(result.getMessage())
        }
    }

    private fun updateTicketValuesByStatus(status: Status) {
        if (status.isEmAndamento()) {
            addStartDate()
        }
    }

    private fun addStartDate() {
        if (isStarted()) {
            this.startDateTime = LocalDateTime.now()
        }
    }

    private fun isStarted(): Boolean {
        return startDateTime == null
    }

    private fun updateStatus(status: Status, userImplementation: UserImplementation) {
        addChangeHistory("Status", userImplementation, this.status.nameExibicao, status.nameExibicao)
        this.status = status
    }

    override fun changeDescription(description: String, userImplementation: UserImplementation) {
        val oldValue = getNormalizedDescription()
        addChangeHistory("Title", userImplementation, oldValue, description)
        this.description = description
    }

    private fun getNormalizedDescription(): String {
        return this.description ?: "Vazio"
    }

    override fun changeTitle(title: String, userImplementation: UserImplementation) {
        addChangeHistory("Title", userImplementation, this.title, title)
        this.title = title
    }

    override fun changeResponsible(responsible: UserImplementation, userImplementation: UserImplementation) {
        val oldValue = getNullSafetyResponsibleName()
        addChangeHistory("Responsible", userImplementation, oldValue, responsible.username)
        this.responsible = responsible
    }

    private fun getNullSafetyResponsibleName(): String {
        return this.responsible?.username ?: "Vazio"
    }

    private fun addChangeHistory(field: String, userImplementation: UserImplementation, oldValue: String, newValue: String) {
        history.addLast(Change(userImplementation, field, oldValue, newValue))
    }

    override fun getIdentificationCode(): String {
        return identificationCode
    }

    override fun getTitle(): String {
        return title
    }

    override fun getDescription(): String? {
        return description
    }

    override fun getCreationDate(): LocalDate {
        return creationDate
    }

    override fun getStatus(): Status {
        return status
    }

    override fun getCreator(): UserImplementation {
        return creator
    }

    override fun getUrgency(): Urgency? {
        return urgency
    }

    override fun getResponsible(): UserImplementation? {
        return responsible
    }

    override fun getMessages(): MutableSet<Message> {
        return messages
    }

    override fun getStartDateTime(): LocalDateTime? {
        return startDateTime
    }

    override fun getHistory(): List<String> {
        return history.map { it.toString() }
    }

    override fun comment(identificationCode: String, message: String, userImplementation: UserImplementation) {
        this.messages.add(Message(identificationCode, message, userImplementation))
    }

    override fun removeComment(identificationCode: String) {
        this.messages.removeIf {
            it.identificationCode == identificationCode
        }
    }
}