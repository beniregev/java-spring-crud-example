package com.beniregev.javaspringcrudexample.service;

import com.beniregev.javaspringcrudexample.model.Client;
import com.beniregev.javaspringcrudexample.model.ClientRegisterRequest;
import com.beniregev.javaspringcrudexample.model.ClientUpdateRequest;
import com.beniregev.javaspringcrudexample.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> getAll() {
        return repository.findAll();
    }

    public Client getById(String id) throws ClassNotFoundException {
        return repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new ClassNotFoundException("Retrieve Failed! Client with id " + id + " not found."));
    }

//    public List<OnlineClientResponse> getAllOnlineClients() {
//        return repository.findAllOnlineClients().stream().map(OnlineClientResponse::new).collect(Collectors.toList());
//    }
//
//    public Client getByUsername(String username) {
//        return repository.findByUsername(username).orElse(null);
//    }
//
//    public Client getByUsernameAndEmail(String username, String email) {
//        return repository.findByUsernameAndEmail(username, email).orElse(null);
//    }

    /**
     * Update username, password, email, or IP fields.
     * @param registerClient {@link ClientRegisterRequest} object with the data to create and register a new client
     * @return client entity that was created.
     */
    public Client createClient(ClientRegisterRequest registerClient) {
        Client client = new Client(registerClient);
        return repository.save(client);
    }

    /**
     * Update a specific client by its unique identifier, only update username, password, email, or IP fields.
     * @param id The unique identification of the client to update
     * @param request {@link ClientUpdateRequest} object with the data to update the client
     * @return the updated client entity, {@link ClassNotFoundException} if unique identifier not found.
     * @throws ClassNotFoundException exception thrown when client with the specified unique identifier not found.
     */
    public Client updateClient(String id, ClientUpdateRequest request) throws ClassNotFoundException {
        Client client = this.getById(id);
        if (Objects.isNull(client))
            throw new ClassNotFoundException("Update Failed! Client with id " + id + " not found.");

        client.setUsername(request.getUsername());
        client.setPassword(request.getEmail());
        client.setEmail(request.getEmail());
        client.setIp(request.getIp());
        client.setLastUpdated(new Date(System.currentTimeMillis()));
        return repository.save(client);
    }

    /**
     * Delete a specific client by its unique identifier.
     * @param id The unique identification of the client to delete
     * @return the client entity that was deleted, {@link ClassNotFoundException} if unique identifier not found.
     * @throws ClassNotFoundException exception thrown when client with the specified unique identifier not found.
     */
    public Client deleteClient(String id) throws ClassNotFoundException {
        Client client = this.getById(id);
        if (Objects.isNull(client))
            throw new ClassNotFoundException("Delete Failed! Client with id " + id + " not found.");

        repository.delete(client);
        return this.getById(id) == null ? client : null;
    }
}
