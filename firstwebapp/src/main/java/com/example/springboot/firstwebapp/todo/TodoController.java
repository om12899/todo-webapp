package com.example.springboot.firstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    public TodoController(com.example.springboot.firstwebapp.todo.todoService todoService) {
        super();
        this.todoService = todoService;
    }

    private todoService todoService;


    @RequestMapping("todolist")
    public String listAllTodos(ModelMap todoModel){
       List<Todo> todos= todoService.findByUsername("Tim Cook");
       todoModel.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = (String)model.get("name");
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value="add-todo",method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        todoService.addTodos((String)model.get("name"),todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:todolist";
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        // Delete todo with ID

        todoService.deletebyID(id);

        return "redirect:todolist";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id, ModelMap model){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        //update todo by ID
        return "todo";
    }

    @RequestMapping(value="update-todo",method = RequestMethod.POST)
    public String updateTodoSave(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username = (String)model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:todolist";
    }
}

