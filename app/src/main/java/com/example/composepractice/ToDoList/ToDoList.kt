//package com.example.composepractice.ToDoList
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.border
//import androidx.compose.foundation.gestures.detectTapGestures
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Done
//import androidx.compose.material.icons.filled.KeyboardArrowDown
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Alignment.Companion.CenterVertically
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.scale
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextDecoration
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun TodoItem(item: ToDo, onChange: (todo: ToDo) -> Unit, onDelete: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .padding(horizontal = 16.dp, vertical = 8.dp)
//            .fillMaxWidth()
//            .pointerInput(Unit) {
//                detectTapGestures(onLongPress = { onDelete() })
//            }
//    ) {
//        Row(modifier = Modifier.padding(16.dp)) {
//            if (item.onEdit) {
//                TextField(
//                    value = item.text,
//                    onValueChange = { onChange(item.copy(text = it)) },
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(end = 8.dp)
//                )
//                IconButton(
//                    modifier = Modifier.align(CenterVertically),
//                    onClick = { onChange(item.copy(onEdit = false)) }
//                ) {
//                    Icon(
//                        tint = MaterialTheme.colorScheme.primary,
//                        imageVector = Icons.Filled.Done,
//                        contentDescription = "Todo done"
//                    )
//                }
//            } else {
//                Text(
//                    text = item.text,
//                    textDecoration = if (item.done) TextDecoration.LineThrough else TextDecoration.None,
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(end = 8.dp)
//                )
//                Checkbox(
//                    colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary),
//                    modifier = Modifier.align(CenterVertically),
//                    checked = item.done,
//                    onCheckedChange = { onChange(item.copy(done = it)) }
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun TodoList(
//    todos: List<ToDo>,
//    onChange: (i: Int, todo: ToDo) -> Unit,
//    onDelete: (i: Int) -> Unit
//) {
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp)
//    ) {
//        itemsIndexed(items = todos) { i, todo ->
//            TodoItem(
//                item = todo,
//                onChange = { onChange(i, it) },
//                onDelete = { onDelete(i) }
//            )
//        }
//    }
//}
//
//@Composable
//fun TopBar(onAction: () -> Unit) {
//    TopAppBar(
//        title = { Text(text = "ToDoList") },
//        actions = {
//            IconButton(onClick = { onAction() }) {
//                Icon(
//                    imageVector = Icons.Filled.Add,
//                    contentDescription = "Add ToDo"
//                )
//            }
//        }
//    )
//}
//
//@Composable
//fun DeleteDialog(
//    showDialog: Boolean,
//    setShowDialog: (Boolean) -> Unit,
//    onConfirm: () -> Unit
//) {
//    if (!showDialog) return
//    AlertDialog(
//        onDismissRequest = { setShowDialog(false) },
//        title = { Text(text = "삭제하기") },
//        text = { Text(text = "삭제하기") },
//        confirmButton = {
//            Button(
//                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
//                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colorScheme.secondary),
//                onClick = {
//                    onConfirm()
//                    setShowDialog(false)
//                }) {
//                Text(
//                    text = stringResource(R.string.dialog_confirm),
//                    color = MaterialTheme.
//                )
//            }
//        },
//        dismissButton = {
//            Button(
//                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
//                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryColor),
//                onClick = { setShowDialog(false) }) {
//                Text(
//                    text = stringResource(R.string.dialog_cancel),
//                    color = MaterialTheme.colors.primaryColor
//                )
//            }
//        }
//    )
//}
//
//@Composable
//fun Main() {
//    var list: List<ToDo> by rememberSaveable { mutableStateOf(listOf()) }
//
//    fun addTodo(todo: ToDo) {
//        list = list + listOf(todo)
//    }
//
//    fun editTodo(i: Int, todo: ToDo) {
//        list = list.toMutableList().also { it[i] = todo }
//    }
//
//    fun deleteTodo(i: Int) {
//        list = list.toMutableList().also { it.removeAt(i) }
//    }
//
//    val (showDialog, setShowDialog) = rememberSaveable { mutableStateOf(false) }
//    var deleteItem by rememberSaveable { mutableStateOf(0) }
//
//    Scaffold(
//        topBar = {
//            TopBar(onAction = { addTodo(ToDo()) })
//        }
//    ) {
//        TodoList(
//            todos = list,
//            onChange = { i, todo -> editTodo(i, todo) },
//            onDelete = {
//                deleteItem = it
//                setShowDialog(true)
//            }
//        )
//        DeleteDialog
//    }
//}

// https://blog.chanhyo.dev/jetpack-compose (블로그 주소)
