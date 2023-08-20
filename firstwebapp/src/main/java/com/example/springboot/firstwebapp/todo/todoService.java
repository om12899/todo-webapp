package com.example.springboot.firstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class todoService {
    private static List <Todo> todos = new ArrayList<>();

    private static int todosCount = 0;
    static {

        todos.add(new Todo(++todosCount,"Om Thakkar","om12899", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"Tim Cook","apple", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todosCount,"John Cena","WWE", LocalDate.now().plusYears(3),false));

    }

    public void addTodos(String username,String description, LocalDate targetDate, boolean status){
        Todo todo = new Todo(++todosCount, username, description, targetDate, status);
        todos.add(todo);
    }

    public void deletebyID(int id){
        //if todo ID matches the value in table
        //todo-> todo.getId() == id;
        Predicate<? super Todo> predicate=todo-> todo.getId() == id;;
        todos.removeIf( predicate);
    }
    public List<Todo> findByUsername(String username){
        return todos;
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate=todo-> todo.getId() == id;;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deletebyID(todo.getId());
        todos.add(todo);
    }
}
