package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chart_position", schema = "music_albums_diana", catalog = "")
public class ChartPosition {
    private int id;
    private int chartId;
    private int albumId;
    private int position;
    private Chart chartByChartId;
    private Albums albumsByAlbumId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "chart_id")
    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    @Basic
    @Column(name = "album_id")
    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Basic
    @Column(name = "position")
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartPosition that = (ChartPosition) o;
        return id == that.id &&
                chartId == that.chartId &&
                albumId == that.albumId &&
                position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chartId, albumId, position);
    }

    @ManyToOne
    @JoinColumn(name = "chart_id", referencedColumnName = "id", nullable = false)
    public Chart getChartByChartId() {
        return chartByChartId;
    }

    public void setChartByChartId(Chart chartByChartId) {
        this.chartByChartId = chartByChartId;
    }

    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id", nullable = false)
    public Albums getAlbumsByAlbumId() {
        return albumsByAlbumId;
    }

    public void setAlbumsByAlbumId(Albums albumsByAlbumId) {
        this.albumsByAlbumId = albumsByAlbumId;
    }
}
