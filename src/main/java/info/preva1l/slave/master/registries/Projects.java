package info.preva1l.slave.master.registries;

import info.preva1l.slave.master.models.projects.Project;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public class Projects {
    public final Project FADAH = get("fadah");

    private Map<String, Project> projects = new ConcurrentHashMap<>();

    public @NotNull Project get(@NotNull String shortId) {
        if (projects == null) {
            projects = new ConcurrentHashMap<>();
        }
        Project project = projects.get(shortId);
        if (project != null) return project;
        return new Project(shortId, "Not Registered", "The requested project was not registered in the Projects Registry!", -1);
    }

    public void put(@NotNull Project project) {
        if (projects == null) {
            projects = new ConcurrentHashMap<>();
        }
        projects.put(project.getShortId(), project);
    }

    public List<Project> toList() {
        return new ArrayList<>(projects.values());
    }
}
