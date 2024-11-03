package info.preva1l.slave.master.models;

import info.preva1l.slave.master.managers.PersistenceManager;
import info.preva1l.slave.master.managers.UserManager;
import info.preva1l.slave.master.persistence.DatabaseObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@AllArgsConstructor
public class User implements DatabaseObject {
    private final long id;
    private final String name;
    private String email;
    private final List<String> resources = new CopyOnWriteArrayList<>(List.of("fadah", "fadcg", "fadcs")); // preload with the free resources

    public boolean isAdmin() {
        return false;
    }

    public boolean isSupport() {
        return false;
    }

    public void setEmail(String email) {
        this.email = email;
        update();
    }

    public String getProfilePicture() {
        return ""; //todo: discord api call
    }

    public void update() {
        UserManager.getInstance().cacheUser(this);
        PersistenceManager.getInstance().save(User.class, this);
    }
}
