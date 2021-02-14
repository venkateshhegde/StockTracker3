package org.ven.ticker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ven.ticker.services.Rate;
import org.ven.ticker.services.TickerService;

@RestController
@RequestMapping("/ticker")
public class TickerController {

    @Autowired
    TickerService tickerService;

    @GetMapping("/{symbol}")
    public ResponseEntity<Rate> getTickerPrice(@PathVariable("symbol") String symbol) {
        return ResponseEntity.ok(tickerService.getRate(symbol));
    }
}
