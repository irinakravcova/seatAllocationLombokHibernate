package plane;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Passengers")
public class Passenger {
@Id
@GeneratedValue
    private Long id;
@Column(name = "fullName")
    private String name;
 //   private String ticketType;
    private String seatNumber;

}
