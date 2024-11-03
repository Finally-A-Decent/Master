package info.preva1l.slave.master.pubsub;

import com.google.gson.Gson;
import info.preva1l.slave.master.Config;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public abstract class Broker {
    private static Broker instance;
    protected final Gson gson;

    protected Broker() {
        this.gson = new Gson();
    }

    protected void handle(@NotNull RedisMessage message) {
        switch (message.getType()) {

            default -> throw new IllegalStateException("Unexpected value: " + message.getType());
        }
    }

    public abstract void connect();

    protected abstract void send(@NotNull RedisMessage message);

    public abstract void destroy();

    @Getter
    @AllArgsConstructor
    public enum Type {
        REDIS("Redis"),
        ;
        private final String displayName;
    }

    public static Broker getInstance() {
        if (instance == null) {
            instance = switch (Config.i().getBroker().getType()) {
                case REDIS -> new RedisBroker();
                default -> new RedisBroker();
            };
            instance.connect();
        }
        return instance;
    }
}
