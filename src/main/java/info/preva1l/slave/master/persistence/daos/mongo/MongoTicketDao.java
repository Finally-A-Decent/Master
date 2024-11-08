package info.preva1l.slave.master.persistence.daos.mongo;

import com.mongodb.client.MongoClient;
import info.preva1l.slave.master.models.tickets.Ticket;
import info.preva1l.slave.master.persistence.Dao;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class MongoTicketDao implements Dao<Ticket> {
    private final MongoClient client;

    /**
     * Get an object from the database by its id.
     *
     * @param id the id of the object to get.
     * @return an optional containing the object if it exists, or an empty optional if it does not.
     */
    @Override
    public Optional<Ticket> get(UUID id) {
        return Optional.empty();
    }

    /**
     * Get all objects of type T from the database.
     *
     * @return a list of all objects of type T in the database.
     */
    @Override
    public List<Ticket> getAll() {
        return List.of();
    }

    /**
     * Save an object of type T to the database.
     *
     * @param ticket the object to save.
     */
    @Override
    public void save(Ticket ticket) {

    }

    /**
     * Update an object of type T in the database.
     *
     * @param ticket the object to update.
     * @param params the parameters to update the object with.
     */
    @Override
    public void update(Ticket ticket, String[] params) {

    }

    /**
     * Delete an object of type T from the database.
     *
     * @param ticket the object to delete.
     */
    @Override
    public void delete(Ticket ticket) {

    }
}
