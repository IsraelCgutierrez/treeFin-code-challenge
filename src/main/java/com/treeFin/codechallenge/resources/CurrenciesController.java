package com.treeFin.codechallenge.resources;

import com.treeFin.codechallenge.services.CurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CurrenciesController.PATH)
public class CurrenciesController {
  static final String PATH = "/currencies";
  static final String liefert = "/liefert";
  static final String symbol = "/{SYMBOL}";

  private final CurrenciesService currenciesService;

  public CurrenciesController (CurrenciesService currenciesService){
    this.currenciesService = currenciesService;
  }

  @GetMapping(liefert)
  public ResponseEntity getClients() {
    return ResponseEntity.ok(currenciesService.getAll());
  }

  @GetMapping("/{SYMBOL}")
  public ResponseEntity getRetailers(@PathVariable("SYMBOL") String symbol) throws Exception {
    return ResponseEntity.ok(currenciesService.getSymbol(symbol));
  }

}
