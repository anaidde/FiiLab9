package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Chart {
    private int id;
    private String name;
    private Collection<ChartPosition> chartPositionsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
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
        Chart chart = (Chart) o;
        return id == chart.id &&
                Objects.equals(name, chart.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "chartByChartId")
    public Collection<ChartPosition> getChartPositionsById() {
        return chartPositionsById;
    }

    public void setChartPositionsById(Collection<ChartPosition> chartPositionsById) {
        this.chartPositionsById = chartPositionsById;
    }
}
