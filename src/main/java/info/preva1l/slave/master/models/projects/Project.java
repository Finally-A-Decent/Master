package info.preva1l.slave.master.models.projects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Project {
    private final String shortId;
    private final String name;
    private final String description;
    private final double price;
}
