package info.preva1l.slave.master.listeners;

import info.preva1l.slave.master.managers.PersistenceManager;
import info.preva1l.slave.master.models.projects.Project;
import info.preva1l.slave.master.pubsub.Broker;
import info.preva1l.slave.master.registries.Projects;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.stream.Stream;

@WebListener
public class StartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        PersistenceManager.getInstance();
        Broker.getInstance().connect();

        Stream.of(
                new Project("fadah",
                        "Finally a Decent Auction House",
                        "Finally a Decent AuctionHouse, is the fast, modern and advanced auction house plugin that you have been looking for!",
                        -1)
        ).forEach(Projects::put);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        PersistenceManager.getInstance().shutdown();
        Broker.getInstance().destroy();
    }
}