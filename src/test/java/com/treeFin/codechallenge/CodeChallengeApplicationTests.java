package com.treeFin.codechallenge;

import com.treeFin.codechallenge.entities.Currency;
import com.treeFin.codechallenge.services.CurrenciesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.treeFin.codechallenge.entities.Currency.invalidSymbol;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CodeChallengeApplicationTests {

  @Autowired
  private CurrenciesService currenciesService;

  @Test
  void createCurrencies() {

    // currency without symbol
    Exception exception = assertThrows(Exception.class, () -> {
      new Currency("10 May 2020", "", "29.1");
    });

    String expectedMessage = invalidSymbol;
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));

    // currency without date or wrong date
    exception = assertThrows(Exception.class, () -> {
      new Currency("", "XX", "29.1");
    });

    expectedMessage = "Text '' could not be parsed at index 0";
    actualMessage = exception.getMessage();

    System.out.println(actualMessage);
    assertTrue(actualMessage.contains(expectedMessage));



  }

}
