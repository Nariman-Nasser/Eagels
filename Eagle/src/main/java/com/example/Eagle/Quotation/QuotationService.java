package com.example.Eagle.Quotation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class QuotationService {


private  final QuotatioRepostiory quotatioRepostiory;

    @Autowired
    public QuotationService(QuotatioRepostiory quotatioRepostiory)
    {

        this.quotatioRepostiory = quotatioRepostiory;
    }

    public List<Quotation> GetQuotatio()
    {
        return quotatioRepostiory.findAll();
    }

    public  void addQuotatio(Quotation quote )
    {
        quote.setQutedata(LocalDate.now());
        quotatioRepostiory.save(quote);
    }



}
