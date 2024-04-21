package com.example.Eagle.Port;


import com.example.Eagle.Quotation.Quotation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  long portid;

    @Column(name = "portname")
    @NonNull
    private String portname;

    @Column(name = "portcountry")
    @NonNull
    private String portcountry;

    @OneToMany(mappedBy = "portidlod", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Quotation> Quotationportofloadind = new ArrayList<>();



   @OneToMany(mappedBy = "portidpod", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Quotation> Quotationportofdestitaion = new ArrayList<>();




}
