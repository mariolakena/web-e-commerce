package com.e.web.commerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private LocalDate birthday;

    @Column(unique = true)
    private String email;

    @Column(name = "payment_method")
    private String paymentMethod;

    private String country;

    private String city;

    private String street;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "created_at")
    @CreationTimestamp                                      //kete annotation e vendosim qe java ta krijoje vete
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    @UpdateTimestamp                                        //kete annotation e vendosim qe java ta krijoje vete
    private LocalDateTime updatedAt;
}
