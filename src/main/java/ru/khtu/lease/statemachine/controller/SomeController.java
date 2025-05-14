package ru.khtu.lease.statemachine.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.khtu.lease.common.co.controller.RestConstant;
import ru.khtu.lease.statemachine.component.SomeComponent;
import ru.khtu.lease.statemachine.data.enums.ProcessedStatus;
import ru.khtu.lease.statemachine.data.plain.response.ActionBodyPlain;
import ru.khtu.lease.statemachine.util.helper.ActionBodyPlainHelper;

@RestController
@RequiredArgsConstructor
public class SomeController implements RestConstant {

    private final SomeComponent someComponent;

    @GetMapping(value = "/api/0.0.1/open/input")
    @ResponseStatus(HttpStatus.CREATED)
    public void openInput() throws JsonProcessingException {
        this.someComponent.createPeople();
        this.someComponent.activatePeopleRequest(2l);
    }

//    private String PATH_KEY_ACTION = new String("action");

//    @PostMapping("/test") @PostMapping("/api/0.0.1/create") public String test() {return "test1";}

    //    @RequestMapping(value = "/api/0.0.1/create/{woName}/{action}", method = RequestMethod.POST)
    /*@PostMapping(value = "/api/0.0.1/open/create/{woName}/{action}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable Map<String, String> path, @RequestBody Map<Object, Object> body) {
        // woName → wPeople, action → wDelete
        // formName → "", inMemory → ""
//        throw new NotImplementedException();
//        restTemplate = new RestTemplate();
//        headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        personJsonObject = new JSONObject();
//        personJsonObject.put("id", 1);
//        personJsonObject.put("name", "John");
    }*/

    @PostMapping(value = "/api/0.0.1/open/action", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> action(@RequestBody ActionBodyPlain actionBodyPlain) {
        ProcessedStatus processedStatus = this.someComponent
                .activatePeopleProcessing(ActionBodyPlainHelper.toDto(actionBodyPlain));
        if(processedStatus != null && processedStatus.equals(ProcessedStatus.SUCCESS)) {
            return new ResponseEntity<>(/*RestModel*/ null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
