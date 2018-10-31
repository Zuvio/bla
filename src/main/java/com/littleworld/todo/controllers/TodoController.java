package com.littleworld.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.littleworld.todo.services.*;
import com.littleworld.todo.model.*;

@Controller
public class TodoController {

  @Autowired  
  private TodoService todoService;

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String create(Todo todo) {
    todoService.save(todo);
    return "redirect:/list";
  }
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String findAll(Model model) {
    model.addAttribute("todos", todoService.findAll());
    return "todoList";
  }
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public String delete(@PathVariable int id) {
    todoService.delete(id);
    return "redirect:/list";
  }


  /**  R E S T  A P I     -0-------
   * nu de fancy manier om het web gedeelte al het werk te laten obv json berichten die hij binnenkrijgt*/
  @ResponseBody
  @RequestMapping(value = "/create2", method = RequestMethod.POST)
  public void create2(@RequestBody Todo todo) {
    todoService.save(todo);
  }
  /**nu de fancy manier om het web gedeelte al het werk te laten obv json berichten die hij binnenkrijgt*/
  @ResponseBody
  @RequestMapping(value = "/list2", method = RequestMethod.GET)
  public Iterable<Todo> findAll2() {
    return todoService.findAll();
  }
}

