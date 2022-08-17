package microstamp.step1.dto;

import java.util.List;
import java.util.Objects;

public class SystemSafetyConstraintDto {

    private String name;

    private Long projectId;

    private List<Long> hazardsId;

    public SystemSafetyConstraintDto(){
    }

    public SystemSafetyConstraintDto(String name, Long projectId, List<Long> hazardsId) {
        this.name = name;
        this.projectId = projectId;
        this.hazardsId = hazardsId;
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

    public List<Long> getHazardsId() {
        return hazardsId;
    }

    public void setHazardsId(List<Long> hazardsId) {
        this.hazardsId = hazardsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemSafetyConstraintDto that = (SystemSafetyConstraintDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(hazardsId, that.hazardsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectId, hazardsId);
    }

    @Override
    public String toString() {
        return "SystemSafetyConstraintDto{" +
                "name='" + name + '\'' +
                ", projectId=" + projectId +
                ", hazardsId=" + hazardsId +
                '}';
    }
}
