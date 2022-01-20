package microstamp.step1.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SystemSafetyConstraintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public SystemSafetyConstraintEntity() {
    }

    public SystemSafetyConstraintEntity(Long id, String name) {
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
        SystemSafetyConstraintEntity that = (SystemSafetyConstraintEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "SystemSafetyConstraintEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
