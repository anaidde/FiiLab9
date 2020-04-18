package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Chart {
    private int id;
    private String name;
    private Integer albumChartId;
    private AlbumChart albumChartByAlbumChartId;

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

    @Basic
    @Column(name = "album_chart_id")
    public Integer getAlbumChartId() {
        return albumChartId;
    }

    public void setAlbumChartId(Integer albumChartId) {
        this.albumChartId = albumChartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chart chart = (Chart) o;
        return id == chart.id &&
                Objects.equals(name, chart.name) &&
                Objects.equals(albumChartId, chart.albumChartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, albumChartId);
    }

    @ManyToOne
    @JoinColumn(name = "album_chart_id", referencedColumnName = "id")
    public AlbumChart getAlbumChartByAlbumChartId() {
        return albumChartByAlbumChartId;
    }

    public void setAlbumChartByAlbumChartId(AlbumChart albumChartByAlbumChartId) {
        this.albumChartByAlbumChartId = albumChartByAlbumChartId;
    }
}
