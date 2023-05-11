package course.java3.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomClient;
    private double tarif;
    private String codePaiement;
    private boolean reserve;
    @ManyToOne
    private Presentation presentation;
    @OneToOne
    private Place place;

    public static String generateBarcode(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
