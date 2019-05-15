package ru.burmistrov.restClient.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.restClient.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Nullable
    private String id = UUID.randomUUID().toString();

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private String dateBegin;

    @Nullable
    private String dateEnd;

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateBegin='" + dateBegin + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                '}';
    }

    public Project(@Nullable String name, @Nullable String description) throws ParseException {
        this.name = name;
        this.description = description;
        this.dateBegin = DateUtil.parseDate(new Date());
        this.dateEnd = DateUtil.parseDate(new Date());
    }
}
