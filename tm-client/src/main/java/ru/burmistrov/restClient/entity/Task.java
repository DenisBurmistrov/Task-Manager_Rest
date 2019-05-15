package ru.burmistrov.restClient.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Nullable
    private String id;

    @Nullable
    private String projectId;

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
        return "Task{" +
                "id='" + id + '\'' +
                ", projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateBegin='" + dateBegin + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                '}';
    }
}
