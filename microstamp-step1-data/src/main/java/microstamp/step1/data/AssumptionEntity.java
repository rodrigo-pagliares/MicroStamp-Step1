package microstamp.step1.data;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "assumptions")
@Table(name = "assumptions")
public class AssumptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public AssumptionEntity() {
    }

    public AssumptionEntity(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssumptionEntity that = (AssumptionEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AssumptionEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
