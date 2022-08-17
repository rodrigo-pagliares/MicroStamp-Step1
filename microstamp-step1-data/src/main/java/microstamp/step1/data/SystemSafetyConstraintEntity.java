package microstamp.step1.data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "system_safety_constraints")
@Table(name = "system_safety_constraints")
public class SystemSafetyConstraintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "system_safety_constraint_hazard",
            joinColumns = @JoinColumn(name = "system_safety_constraint_id"),
            inverseJoinColumns = @JoinColumn(name = "hazard_id")
    )
    private List<HazardEntity> hazardEntities;


    public SystemSafetyConstraintEntity() {
    }

    public SystemSafetyConstraintEntity(Long id, String name, List<HazardEntity> hazardEntities) {
        this.id = id;
        this.name = name;
        this.hazardEntities = hazardEntities;
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

    public List<HazardEntity> getHazardEntities() {
        return hazardEntities;
    }

    public void setHazardEntities(List<HazardEntity> hazardEntities) {
        this.hazardEntities = hazardEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemSafetyConstraintEntity that = (SystemSafetyConstraintEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(hazardEntities, that.hazardEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hazardEntities);
    }

    @Override
    public String toString() {
        return "SystemSafetyConstraintEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hazardEntities=" + hazardEntities +
                '}';
    }
}
