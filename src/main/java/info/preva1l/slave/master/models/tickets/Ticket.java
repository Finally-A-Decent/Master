package info.preva1l.slave.master.models.tickets;

import com.mongodb.lang.Nullable;
import info.preva1l.slave.master.managers.PersistenceManager;
import info.preva1l.slave.master.managers.TicketManager;
import info.preva1l.slave.master.models.User;
import info.preva1l.slave.master.models.WebhookData;
import info.preva1l.slave.master.persistence.DatabaseObject;
import info.preva1l.slave.master.pubsub.Broker;
import info.preva1l.slave.master.pubsub.Payload;
import info.preva1l.slave.master.pubsub.RedisMessage;
import info.preva1l.slave.master.pubsub.messages.TicketAction;
import info.preva1l.slave.master.pubsub.messages.TicketMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Ticket implements DatabaseObject {
    private final long id;
    private final long owner;
    private final List<Long> participants = new ArrayList<>();
    private final String resource;
    private final String version;
    private final String details;
    private final Map<Long, String> messages = new HashMap<>();
    @Nullable
    private WebhookData webhookData;
    private TicketStatus status;

    public void open(@NotNull User user) {
        // todo: implement
    }

    public void close(@NotNull User user) {
        if (!status.isOpen()) {
            // cant close
            return;
        }
        status = TicketStatus.CLOSED;
        // closing soon
        update();
        RedisMessage.builder()
                .type(RedisMessage.Type.BOT_BOUND_TICKET_CLOSE)
                .payload(Payload.withTicketAction(new TicketAction(this.getId(), user.getId())))
                .build().send(Broker.getInstance());
    }

    public void escalate() {
        if (status != TicketStatus.OPEN) {
            // cant escalate
            return;
        }
        status = TicketStatus.ESCALATED;

        // send escalate message
    }

    /**
     * Send a message to discord
     *
     * @param sender  the user who sent the message
     * @param message the message
     */
    public void sendMessage(User sender, String message) {
        messages.put(sender.getId(), message);
        update();

        RedisMessage.builder()
                .type(RedisMessage.Type.BOT_BOUND_TICKET_MESSAGE)
                .payload(Payload.withTicketMessage(new TicketMessage(this.getId(), sender.getId(), message)))
                .build().send(Broker.getInstance());
    }

    public void update() {
        TicketManager.getInstance().cacheTicket(this);
        PersistenceManager.getInstance().save(Ticket.class, this);
    }
}
