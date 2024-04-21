package com.example.Eagle.Contanier;


import com.example.Eagle.Quotation.Quotation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contanier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long cntrid;
    @NonNull
     private int cntrsize;
    @NonNull
     private  String cntrType;
    @NonNull
     private  int addvalue;

    @OneToMany(mappedBy = "cntrid", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Quotation> Quotations = new ArrayList<>();
}
