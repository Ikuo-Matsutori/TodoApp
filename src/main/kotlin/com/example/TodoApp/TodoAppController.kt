package com.example.TodoApp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoAppController {
    @GetMapping("/todos")
    fun getTodos ():Array<Todo>{
        // return [{id: 1, text: "foo"},{id: 2, text: "bar"}];
        return arrayOf( Todo(1, "foo"), Todo(2, "bar") )
    }
}