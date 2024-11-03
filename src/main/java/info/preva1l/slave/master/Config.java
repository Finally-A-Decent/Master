package info.preva1l.slave.master;

import de.exlll.configlib.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Getter
@Configuration
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("FieldMayBeFinal")
public class Config {
    private static final File dataFolder = new File(System.getProperty("user.dir"));
    private static Config instance;

    private static final YamlConfigurationProperties PROPERTIES = YamlConfigurationProperties.newBuilder()
            .charset(StandardCharsets.UTF_8)
            .setNameFormatter(NameFormatters.LOWER_KEBAB_CASE).build();



    private String databaseUri = "skibid slicer";

    private Broker broker = new Broker();

    @Getter
    @Configuration
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Broker {
        @Comment("Allowed: REDIS")
        private info.preva1l.slave.master.pubsub.Broker.Type type = info.preva1l.slave.master.pubsub.Broker.Type.REDIS;
        private String host = "localhost";
        private int port = 6379;
        private String password = "myAwesomePassword";
        private String channel = "slave:updates";
    }


    public void save() {
        YamlConfigurations.save(new File(dataFolder, "config.yml").toPath(), Config.class, this);
    }

    public static void reload() {
        instance = YamlConfigurations.load(new File(dataFolder, "config.yml").toPath(), Config.class, PROPERTIES);
    }

    public static Config i() {
        if (instance != null) {
            return instance;
        }

        return instance = YamlConfigurations.update(new File(dataFolder, "config.yml").toPath(), Config.class, PROPERTIES);
    }
}