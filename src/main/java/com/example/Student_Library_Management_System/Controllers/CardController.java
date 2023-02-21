package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;


    @GetMapping("/get_bookIssued/{id}")
    public List<String> getBookIssuedToCard(@PathVariable("id") int id){
        return cardService.getBookIssuedToCard(id);
    }



//    @GetMapping("/get_bookIssued")
//    public String getBookIssuedToCard(@RequestParam("id") int id){
//        return cardService.getBookIssuedToCard(id);
//    }

}
