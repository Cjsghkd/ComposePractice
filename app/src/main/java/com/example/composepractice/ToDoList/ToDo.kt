package com.example.composepractice.ToDoList

import java.io.Serializable

data class ToDo(
    var text: String = "",
    var done: Boolean = false,
    var onEdit: Boolean = true
) : Serializable