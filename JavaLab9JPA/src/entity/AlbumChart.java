package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "album_chart", schema = "music_albums_diana", catalog = "")
public class AlbumChart {
    private int id;
    private Integer albumId;
    private String albumName;
    private Integer topPosition;
    private Albums albumsByAlbumId;
    private Collection<Chart> chartsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "album_id")
    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Basic
    @Column(name = "album_name")
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Basic
    @Column(name = "top_position")
    public Integer getTopPosition() {
        return topPosition;
    }

    public void setTopPosition(Integer topPosition) {
        this.topPosition = topPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumChart that = (AlbumChart) o;
        return id == that.id &&
                Objects.equals(albumId, that.albumId) &&
                Objects.equals(albumName, that.albumName) &&
                Objects.equals(topPosition, that.topPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumId, albumName, topPosition);
    }

    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    public Albums getAlbumsByAlbumId() {
        return albumsByAlbumId;
    }

    public void setAlbumsByAlbumId(Albums albumsByAlbumId) {
        this.albumsByAlbumId = albumsByAlbumId;
    }

    @OneToMany(mappedBy = "albumChartByAlbumChartId")
    public Collection<Chart> getChartsById() {
        return chartsById;
    }

    public void setChartsById(Collection<Chart> chartsById) {
        this.chartsById = chartsById;
    }
}
