import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;

public class CinemaManager {
    public static void main(String[] args) {
        CinemaDao myCinema = new RamDao();
        myCinema.addShowRoom(new ShowRoom(1, "Coders.Bay, Red Box"));
        myCinema.addShowRoom(new ShowRoom(2, "Grand Garage, Magazin 3"));
        myCinema.addSeat(1, 1, 1);
        myCinema.addSeat(1, 1, 2);
        myCinema.addSeat(1, 1, 3);
        myCinema.addSeat(1, 1, 4);
        myCinema.addSeat(1, 1, 5);
        myCinema.addSeat(1, 2, 1);
        myCinema.addSeat(1, 2, 2);
        myCinema.addSeat(1, 2, 3);
        myCinema.addSeat(1, 2, 4);
        myCinema.addSeat(1, 2, 5);

        myCinema.addSeat(2, 1, 1);
        myCinema.addSeat(2, 1, 2);
        myCinema.addSeat(2, 1, 3);
        myCinema.addSeat(2, 1, 4);
        myCinema.addSeat(2, 2, 1);
        myCinema.addSeat(2, 2, 2);
        myCinema.addSeat(2, 2, 3);
        myCinema.addSeat(2, 2, 4);

        myCinema.addMovie("Monthy Python", "Der Sinn des Lebens", Genre.COMEDY);
        myCinema.addMovie("Spiderman", "Far from Home", Genre.ACTION);

        myCinema.scheduleMovie(1, LocalDate.now(), 1);
        myCinema.scheduleMovie(2, LocalDate.now(), 2);

        myCinema.reserveSeat(2, 3, 3);
        System.out.println(myCinema.getReservation(1));
    }
}
