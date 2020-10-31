package com.lambdaschool.piggybank.controllers;


import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;

    private List<Coin> findCoins(List<Coin> myList, CheckCoin tester) {
        List<Coin> testList = new ArrayList<>();

        for (Coin c : myList) {
            if (tester.test(c)){
                testList.add(c);
            }
        }

    return testList;
    }

    // http://localhost:2019/total
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listAndTotalAllCoins() {
        List<Coin> myList = new ArrayList<>();
        coinRepository.findAll().iterator().forEachRemaining(myList::add);

        //int quarters = myList.iterator().
        double total = 0;
        for (Coin c : myList) {
            if (c.getQuantity() == 1) {
                total = total + c.getValue();
                System.out.println(c.getQuantity() + " " + c.getName());
            }else {
                total = total + (c.getValue() * c.getQuantity());
                System.out.println(c.getQuantity() + " " + c.getNameplural());
            }
        }

        System.out.println("The piggybank holds " + total);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
