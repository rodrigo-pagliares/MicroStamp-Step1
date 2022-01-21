package microstamp.step1.data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long externalId;

    private String name;

    private String description;

    private String url;

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<HazardEntity> hazardEntities;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<LossEntity> lossEntities;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<SystemGoalEntity> systemGoalEntities;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<AssumptionEntity> assumptionEntities;

    public ProjectEntity() {
    }

    public ProjectEntity(Long id, Long externalId, String name, String description, String url, String type, List<HazardEntity> hazardEntities, List<LossEntity> lossEntities, List<SystemGoalEntity> systemGoalEntities, List<AssumptionEntity> assumptionEntities) {
        this.id = id;
        this.externalId = externalId;
        this.name = name;
        this.description = description;
        this.url = url;
        this.type = type;
        this.hazardEntities = hazardEntities;
        this.lossEntities = lossEntities;
        this.systemGoalEntities = systemGoalEntities;
        this.assumptionEntities = assumptionEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<HazardEntity> getHazardEntities() {
        return hazardEntities;
    }

    public void setHazardEntities(List<HazardEntity> hazardEntities) {
        this.hazardEntities = hazardEntities;
    }

    public List<LossEntity> getLossEntities() {
        return lossEntities;
    }

    public void setLossEntities(List<LossEntity> lossEntities) {
        this.lossEntities = lossEntities;
    }

    public List<SystemGoalEntity> getSystemGoalEntities() {
        return systemGoalEntities;
    }

    public void setSystemGoalEntities(List<SystemGoalEntity> systemGoalEntities) {
        this.systemGoalEntities = systemGoalEntities;
    }

    public List<AssumptionEntity> getAssumptionEntities() {
        return assumptionEntities;
    }

    public void setAssumptionEntities(List<AssumptionEntity> assumptionEntities) {
        this.assumptionEntities = assumptionEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity that = (ProjectEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(externalId, that.externalId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(url, that.url) &&
                Objects.equals(type, that.type) &&
                Objects.equals(hazardEntities, that.hazardEntities) &&
                Objects.equals(lossEntities, that.lossEntities) &&
                Objects.equals(systemGoalEntities, that.systemGoalEntities) &&
                Objects.equals(assumptionEntities, that.assumptionEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, name, description, url, type, hazardEntities, lossEntities, systemGoalEntities, assumptionEntities);
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", externalId=" + externalId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", hazardEntities=" + hazardEntities +
                ", lossEntities=" + lossEntities +
                ", systemGoalEntities=" + systemGoalEntities +
                ", assumptionEntities=" + assumptionEntities +
                '}';
    }
}
