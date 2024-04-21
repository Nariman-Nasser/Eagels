package com.example.Eagle.Quotation;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/Qutation")
@CrossOrigin(origins = "*")
public class QutationController {

    private final QuotationService quotationService;

    public QutationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @GetMapping
    public List<Quotation> GetAllQuotation(){
        return quotationService.GetQuotatio();
    }

    @PostMapping
    public  void AddNewQuotation (@RequestBody Quotation Q) {
        quotationService.addQuotatio(Q);
    }


}
