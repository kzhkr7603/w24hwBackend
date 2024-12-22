package kr.ac.kumoh.s20210296.hw_Backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "activity")
data class Activity(
    @Id val id: String? = null,
    val type: String,
    val aurl: String,
    val date: String,
    val name: String,
    val additionalContent: AdditionalContent? = null
)