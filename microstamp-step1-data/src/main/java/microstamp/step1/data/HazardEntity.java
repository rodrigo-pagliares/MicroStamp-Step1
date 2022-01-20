package microstamp.step1.data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class HazardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "hazard_loss",
            joinColumns = @JoinColumn(name = "hazard_id"),
            inverseJoinColumns = @JoinColumn(name = "loss_id")
    )
    private List<LossEntity> lossEntities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ssc_id")
    private SystemSafetyConstraintEntity systemSafetyConstraintEntity;

    public HazardEntity() {
    }

    public HazardEntity(Long id, String name, List<LossEntity> lossEntities, SystemSafetyConstraintEntity systemSafetyConstraintEntity) {
        this.id = id;
        this.name = name;
        this.lossEntities = lossEntities;
        this.systemSafetyConstraintEntity = systemSafetyConstraintEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LossEntity> getLossEntities() {
        return lossEntities;
    }

    public void setLossEntities(List<LossEntity> lossEntities) {
        this.lossEntities = lossEntities;
    }

    public SystemSafetyConstraintEntity getSystemSafetyConstraintEntity() {
        return systemSafetyConstraintEntity;
    }

    public void setSystemSafetyConstraintEntity(SystemSafetyConstraintEntity systemSafetyConstraintEntity) {
        this.systemSafetyConstraintEntity = systemSafetyConstraintEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HazardEntity that = (HazardEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lossEntities, that.lossEntities) &&
                Objects.equals(systemSafetyConstraintEntity, that.systemSafetyConstraintEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lossEntities, systemSafetyConstraintEntity);
    }

    @Override
    public String toString() {
        return "HazardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lossEntities=" + lossEntities +
                ", systemSafetyConstraintEntity=" + systemSafetyConstraintEntity +
                '}';
    }
}
