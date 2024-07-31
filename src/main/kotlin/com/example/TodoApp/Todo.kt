package com.example.TodoApp

import jakarta.persistence.Entity
import jakarta.persistence.Id

// { "id":123, "text":"something!" }
@Entity
class Todo(
    @Id
    val id: Long,
    val text: String
)
