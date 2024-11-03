package info.preva1l.slave.master.managers;

import info.preva1l.slave.master.models.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserManager {
    private static UserManager instance;

    private final Map<Long, User> usersCache = new ConcurrentHashMap<>();

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public @Nullable User getUser(long userId) {
        return usersCache.get(userId);
    }

    public void cacheUser(User user) {
        usersCache.put(user.getId(), user);
    }
}
