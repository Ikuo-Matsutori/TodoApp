package com.example.TodoApp

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// interface TodoRepository extends JpaRepository<Todo, Long>
@Repository
interface TodoRepository : JpaRepository<Todo, Long> {

}

// fun add(@Autowired val repository: TodoRepository)
// val todo = new Todo(1, "foo")
// repository.save(todo)