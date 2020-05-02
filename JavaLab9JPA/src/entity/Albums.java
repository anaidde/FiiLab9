package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Albums {
    private int id;
    private String name;
    private Integer artistId;
    private Integer releaseYear;
    private Artists artistsByArtistId;
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

    @Basic
    @Column(name = "artist_id")
    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "release_year")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albums albums = (Albums) o;
        return id == albums.id &&
                Objects.equals(name, albums.name) &&
                Objects.equals(artistId, albums.artistId) &&
                Objects.equals(releaseYear, albums.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artistId, releaseYear);
    }

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    public Artists getArtistsByArtistId() {
        return artistsByArtistId;
    }

    public void setArtistsByArtistId(Artists artistsByArtistId) {
        this.artistsByArtistId = artistsByArtistId;
    }

    @OneToMany(mappedBy = "albumsByAlbumId")
    public Collection<ChartPosition> getChartPositionsById() {
        return chartPositionsById;
    }

    public void setChartPositionsById(Collection<ChartPosition> chartPositionsById) {
        this.chartPositionsById = chartPositionsById;
    }

    public String toString() {
        return "Album ID: " + this.id + ", Name: " + this.name + ", Artist ID: " + this.artistId + ", Release year: " + this.releaseYear;
    }
}
