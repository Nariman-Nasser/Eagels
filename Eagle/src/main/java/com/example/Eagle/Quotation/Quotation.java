package com.example.Eagle.Quotation;


import com.example.Eagle.Contanier.Contanier;

import com.example.Eagle.Port.Port;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Quotaid;

   @ManyToOne
    @JoinColumn(name = "portidlod" )
    private Port portidlod;

    @ManyToOne
    @JoinColumn(name = "portidpod"  )
    private Port portidpod;

    @ManyToOne
    @JoinColumn(name = "cntrid")
    private Contanier cntrid ;

    @NonNull
    private  int oceanfright;
    @NonNull
    private  int TT;
    @NonNull
    private float thc;
    @NonNull
    private  String thcunite;
    private LocalDate Qutedata;
    private float BL;
    private float telex;
    private String operationname;
    private  float seal;

    @Column(columnDefinition = "LONGTEXT")
    @Lob
    private String note;





}
