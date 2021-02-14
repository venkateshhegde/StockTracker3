package org.ven.ticker.services;

import org.springframework.stereotype.Component;
import yahoofinance.YahooFinance;

import java.math.BigDecimal;

@Component
public class TickerService {

    public Rate getRate(String symbol) {

        Rate r = new Rate();
        r.setSymbol(symbol);

        try {
            BigDecimal bd = YahooFinance.get(
                    symbol.replace(" ", "").
                            replace(".", "")).
                    getQuote().getPrice();
            r.setRate(bd.toPlainString());
        } catch (Exception e) {

        }
        return r;

    }
}
