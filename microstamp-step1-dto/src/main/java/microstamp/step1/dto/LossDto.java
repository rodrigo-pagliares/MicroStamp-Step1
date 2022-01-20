package microstamp.step1.dto;

import java.util.Objects;

public class LossDto {

    private String name;

    private Long projectId;

    public LossDto(){
    }

    public LossDto(String name, Long projectId) {
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
        LossDto lossDto = (LossDto) o;
        return Objects.equals(name, lossDto.name) &&
                Objects.equals(projectId, lossDto.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectId);
    }

    @Override
    public String toString() {
        return "LossDto{" +
                "name='" + name + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
