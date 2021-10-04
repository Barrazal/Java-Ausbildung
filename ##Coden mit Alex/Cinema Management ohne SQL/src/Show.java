import java.time.LocalDate;

public class Show {
    private static int counter = 1;
    private int id;
    private int movieId;
    private int showRoomId;
    private LocalDate date;
    private CinemaDao dao;

    public Show(CinemaDao dao, int id, int movieId, int showRoomId, LocalDate date) {
        this.dao = dao;
        this.showRoomId = showRoomId;
        this.movieId = movieId;
        this.date = date;
        this.id = id;
        counter++;
    }

    public Show(CinemaDao dao, int movieId, int showRoomId, LocalDate date) {
        this(dao, counter, movieId, showRoomId, date);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Show.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShowRoomId() {
        return showRoomId;
    }

    public void setShowRoomId(int showRoomId) {
        this.showRoomId = showRoomId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Show ("+id+"): " + dao.getMovie(movieId).getTitle() + ", Show Room: " + showRoomId + ", " + date;
    }
}
