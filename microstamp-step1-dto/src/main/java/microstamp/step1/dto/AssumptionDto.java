package microstamp.step1.dto;

import java.util.Objects;

public class AssumptionDto {

    private String name;

    private Long projectId;

    public AssumptionDto() {
    }

    public AssumptionDto(String name, Long projectId) {
        this.name = name;
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssumptionDto that = (AssumptionDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectId);
    }

    @Override
    public String toString() {
        return "AssumptionDto{" +
                "name='" + name + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
