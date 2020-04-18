package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Table(name = "Albums")
@NamedQueries({
        @NamedQuery(
                name = "Albums.findByName",
                query = "SELECT a from Albums a where a.name = :name"
        ),
        @NamedQuery(
                name = "Albums.findByArtistID",
                query = "SELECT a from Albums a where a.artistId = :id"
        )
})

@Entity
public class Albums {
    private int id;
    private String name;
    private Integer artistId;
    private Integer releaseYear;
    private Collection<AlbumChart> albumChartsById;
    //private AlbumChart albumChartByName;
    private Artists artistsByArtistId;

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

    @OneToMany(mappedBy = "albumsByAlbumId")
    public Collection<AlbumChart> getAlbumChartsById() {
        return albumChartsById;
    }

    public void setAlbumChartsById(Collection<AlbumChart> albumChartsById) {
        this.albumChartsById = albumChartsById;
    }

//    @ManyToOne
//    @JoinColumn(name = "name", referencedColumnName = "album_name")
//    public AlbumChart getAlbumChartByName() {
//        return albumChartByName;
//    }
//
//    public void setAlbumChartByName(AlbumChart albumChartByName) {
//        this.albumChartByName = albumChartByName;
//    }

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    public Artists getArtistsByArtistId() {
        return artistsByArtistId;
    }

    public void setArtistsByArtistId(Artists artistsByArtistId) {
        this.artistsByArtistId = artistsByArtistId;
    }

    public String toString() {
        return "Album ID: " + this.id + ", Name: " + this.name + ", Artist ID: " + this.artistId + ", Release year: " + this.releaseYear;
    }
}
