package com.example.norman_lee.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    //TODO 5.4 Write unit tests to check the ExchangeRate class
    @Test
    public void exchangeRateDefaultRate() {
        String defaultExchangeRate = "2.95000";
        ExchangeRate exchangeRate = new ExchangeRate();
        assertEquals(defaultExchangeRate, exchangeRate.getExchangeRate().toString());
    }

    @Test
    public void exchangeRateCalculateAmount() {
        ExchangeRate exchangeRate = new ExchangeRate("3");
        String amount = "3.3333";
        assertEquals(amount, exchangeRate.calculateAmount("10").toString());
    }


}