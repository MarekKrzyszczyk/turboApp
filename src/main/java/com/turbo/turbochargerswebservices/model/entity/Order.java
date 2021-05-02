package com.turbo.turbochargerswebservices.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column
    private String notes;

    @Column
    private boolean deleted;

    @Column
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "charger_id")
    private Turbocharger turbocharger;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "parts_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id")
    )
    private List<Part> parts;

    @ManyToOne
    @JoinColumn(name = "reason_id")
    private Reason reason;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private User technician;
}
