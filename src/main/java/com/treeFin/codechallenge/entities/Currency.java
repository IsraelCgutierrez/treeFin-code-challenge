package com.treeFin.codechallenge.entities;

import org.apache.logging.log4j.util.Strings;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Currency {
  @NotEmpty
  private String symbol;
  @Positive
  private Double exchange;
  @NotNull
  private LocalDate date;

  public static final String invalidSymbol = "invalid Symbol";

  public Currency(String date, String symbol, String exchange) throws Exception {
    this.symbol = validateSymbol(symbol);
    this.exchange = convertExchange(exchange);
    this.date = convertDate(date);
  }

  private String validateSymbol(String symbol) throws Exception {
    if (Strings.isNotEmpty(symbol)) {
      return symbol.trim();
    } else {
      throw new Exception(invalidSymbol);
    }
  }

  public Double convertExchange(String exchange) {
    return Double.parseDouble(exchange);
  }

  public LocalDate convertDate(String date) {              //30 April 2020
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    return LocalDate.parse(date, formatter);
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) throws Exception {
    this.symbol = validateSymbol(symbol);
  }

  public Double getExchange() {
    return exchange;
  }

  public void setExchange(Double exchange) {
    this.exchange = exchange;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @Override
  public int hashCode() {
    return symbol.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Currency) {
      return symbol.equals(((Currency) obj).getSymbol());
    }
    return false;
  }


}
