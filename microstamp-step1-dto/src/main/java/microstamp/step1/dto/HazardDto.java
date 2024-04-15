package microstamp.step1.dto;

import java.util.List;
import java.util.Objects;

public class HazardDto {

    private String name;

    private Long projectId;

    private List<Long> lossIds;

    private Long fatherId;

    public HazardDto() {
    }

    public HazardDto(String name, Long projectId, List<Long> lossIds, Long fatherId) {
        this.name = name;
        this.projectId = projectId;
        this.lossIds = lossIds;
        this.fatherId = fatherId;
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

    public Long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HazardDto hazardDto = (HazardDto) o;
        return Objects.equals(name, hazardDto.name) &&
                Objects.equals(projectId, hazardDto.projectId) &&
                Objects.equals(lossIds, hazardDto.lossIds) &&
                Objects.equals(fatherId, hazardDto.fatherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectId, lossIds, fatherId);
    }

    @Override
    public String toString() {
        return "HazardDto{" +
                "name='" + name + '\'' +
                ", projectId=" + projectId +
                ", lossIds=" + lossIds +
                ", fatherId=" + fatherId +
                '}';
    }
}