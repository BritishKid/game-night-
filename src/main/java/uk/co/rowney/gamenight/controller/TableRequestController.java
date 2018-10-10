package uk.co.rowney.gamenight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableRequestController {

    @RequestMapping("/table/getscores")
    public String getTableScores(){
        return null;
    }
}
