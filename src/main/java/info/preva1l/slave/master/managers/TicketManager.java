package info.preva1l.slave.master.managers;

import info.preva1l.slave.master.models.tickets.Ticket;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TicketManager {
    private static TicketManager instance;

    private final Map<Long, Ticket> tickets = new ConcurrentHashMap<>();

    public static TicketManager getInstance() {
        if (instance == null) {
            instance = new TicketManager();
        }
        return instance;
    }

    public void cacheTicket(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    public Ticket getTicket(long channelId) {
        return tickets.get(channelId);
    }
}
