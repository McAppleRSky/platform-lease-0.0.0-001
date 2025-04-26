package ru.khtu.lease.statemachine.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import ru.khtu.lease.common.ControllerConstant;

import java.util.Map;

@RestController
public class SomeController implements ControllerConstant {

    private String PATH_KEY_ACTION = new String("action");

//    @PostMapping("/test") @PostMapping("/api/0.0.1/create") public String test() {return "test1";}

    //    @RequestMapping(value = "/api/0.0.1/create/{woName}/{action}", method = RequestMethod.POST)
    @PostMapping(value = "/api/0.0.1/open/create/{woName}/{action}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@PathVariable Map<String, String> path, @RequestBody Map<Object, Object> body) {
        // woName → wPeople, action → wDelete
        // formName → "", inMemory → ""
        System.out.println();
    }

    @PatchMapping(value = "/api/0.0.1/open/action/{woName}/{action}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void action(@PathVariable Map<String, String> path, @RequestBody Map<Object, Object> body) {
        // woName → wPeople, action → wDelete
        // recordId → "0"
        System.out.println();
    }

}
