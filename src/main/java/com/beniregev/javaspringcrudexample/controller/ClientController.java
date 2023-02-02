package com.beniregev.javaspringcrudexample.controller;

import com.beniregev.javaspringcrudexample.model.Client;
import com.beniregev.javaspringcrudexample.model.dtos.ClientRegisterRequest;
import com.beniregev.javaspringcrudexample.model.dtos.ResponseEntityGeneral;
import com.beniregev.javaspringcrudexample.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * Get all clients
 * Get specific client by username
 * Get specific client by email
 * Create new client (register)
 * update client (update all details, except id)
 * Update client (login / logout )
 * Delete client by username
 * Delete client by email
 */
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {
        "https://localhost:4200/",
        "https://localhost:8080/",
        "https://java-spring-crud-with-angular-frontend-example.netlify.app/"})
public class ClientController {

    @Autowired
    private ClientService clientService;

    private ResponseEntityGeneral response;

    @GetMapping("/clients")
    public ResponseEntity<ResponseEntityGeneral> getAll() {
        List<Client> clients = clientService.getAll();
        response = ResponseEntityGeneral
                .builder()
                .result(clients)
                .success(clients != null)
                .httpStatus(clients != null ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ResponseEntityGeneral> getById(@PathVariable String id) {
        try {
            Client client = clientService.getById(id);
            response = ResponseEntityGeneral
                    .builder()
                    .result(client)
                    .success(Objects.nonNull(client))
                    .httpStatus(HttpStatus.OK)
                    .build();
        } catch (ClassNotFoundException e) {
            response = ResponseEntityGeneral
                    .builder()
                    .result(e)
                    .success(Objects.nonNull(false))
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .build();
        }
        return new ResponseEntity<>(response, response.getHttpStatus());
    }


//    @GetMapping("/clients/online")
//    public ResponseEntity<ResponseEntityGeneral> getAllOnlineClients() {
//        List<OnlineClientResponse> clients = clientService.getAllOnlineClients()
//    }

//    @GetMapping("/clients/name/{username}")
//    public ResponseEntity<ResponseEntityGeneral> get(@PathVariable String username,
//                                                     @RequestParam(name = "email", required = false) String email) {
//        List<OnlineClientResponse> clients = null;
//        if (Strings.isEmpty(email)) {
//            clients = clientService.getByUsername(username);
//        } else {
//            clients = clientService.getByUsernameAndEmail(username, email);
//        }
//        response = ResponseEntityGeneral
//                .builder()
//                .result(clients)
//                .success(clients != null)
//                .httpStatus(clients != null ? HttpStatus.OK : HttpStatus.NOT_FOUND)
//                .build();
//        return new ResponseEntity<>(response, response.getHttpStatus());
//    }

    @PostMapping("/clients")
    public ResponseEntity<ResponseEntityGeneral> createClient(@RequestBody ClientRegisterRequest requestBody) {
        Client client = clientService.createClient(requestBody);
        response = ResponseEntityGeneral
                .builder()
                .result(client)
                .success(Objects.nonNull(client))
                .httpStatus(client != null ? HttpStatus.CREATED : HttpStatus.NOT_MODIFIED)
                .build();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<ResponseEntityGeneral> updateClient(@PathVariable String id,
                                                              @RequestBody ClientRegisterRequest requestBody) {
        return null;
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<ResponseEntityGeneral> deleteClientById(@PathVariable String id) {
        return null;
    }

    @DeleteMapping("/clients/{username}")
    public ResponseEntity<ResponseEntityGeneral> deleteClientByUsername(@PathVariable String username) {
        return null;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Server is saying \"Hello\"";
    }
}
