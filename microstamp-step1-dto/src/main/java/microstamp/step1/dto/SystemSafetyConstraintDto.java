package microstamp.step1.dto;

import java.util.Objects;

public class SystemSafetyConstraintDto {

    private String name;

    private Long projectId;

    private Long hazardId;

    public SystemSafetyConstraintDto(){
    }

    public SystemSafetyConstraintDto(String name, Long projectId, Long hazardId) {
        this.name = name;
        this.projectId = projectId;
        this.hazardId = hazardId;
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

    public Long getHazardId() {
        return hazardId;
    }

    public void setHazardId(Long hazardId) {
        this.hazardId = hazardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemSafetyConstraintDto that = (SystemSafetyConstraintDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(hazardId, that.hazardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectId, hazardId);
    }

    @Override
    public String toString() {
        return "SystemSafetyConstraintDto{" +
                "name='" + name + '\'' +
                ", projectId=" + projectId +
                ", hazardId=" + hazardId +
                '}';
    }
}
