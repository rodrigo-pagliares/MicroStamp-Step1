package microstamp.step1.dto;

import java.util.List;
import java.util.Objects;

public class HazardDto {

    private String name;

    private Long projectId;

    private List<Long> lossIds;

    public HazardDto() {
    }

    public HazardDto(String name, Long projectId, List<Long> lossIds) {
        this.name = name;
        this.projectId = projectId;
        this.lossIds = lossIds;
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

    public List<Long> getLossIds() {
        return lossIds;
    }

    public void setLossIds(List<Long> lossIds) {
        this.lossIds = lossIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HazardDto hazardDto = (HazardDto) o;
        return Objects.equals(name, hazardDto.name) &&
                Objects.equals(projectId, hazardDto.projectId) &&
                Objects.equals(lossIds, hazardDto.lossIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectId, lossIds);
    }

    @Override
    public String toString() {
        return "HazardDto{" +
                "name='" + name + '\'' +
                ", projectId=" + projectId +
                ", lossIds=" + lossIds +
                '}';
    }
}