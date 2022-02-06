package plane;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor

@Entity(name = "PlaneSeats")
public class Seat {
    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)//specify how we want to convert it
    @Column(name = "SeatNumber")
    private SeatNumber seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "TicketType")
    private TicketType ticketType;

    @Enumerated(EnumType.STRING)
    @Column(name = "SeatStatus")
    private SeatStatus seatStatus;

    @OneToOne
    private Passenger passenger; /*passenger is a primary key,
     we set the conn @TOneToMany mutltiple pets connected toOne Owner,
     @JoinColumn("owner_id") private List<Pet>pets; */


    public Seat(SeatNumber seatNumber, TicketType ticketType, SeatStatus seatStatus, Passenger passenger) {
        this.seatNumber = seatNumber;
        this.ticketType = ticketType;
        this.seatStatus = seatStatus;
        this.passenger = passenger;
    }

    public Seat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SeatNumber getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(SeatNumber seatNumber) {
        this.seatNumber = seatNumber;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Seat(Long id, SeatNumber seatNumber, TicketType ticketType, SeatStatus seatStatus, Passenger passenger) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.ticketType = ticketType;
        this.seatStatus = seatStatus;
        this.passenger = passenger;
    }
}
