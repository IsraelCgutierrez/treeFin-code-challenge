package com.treeFin.codechallenge.services;

import com.opencsv.CSVReader;
import com.treeFin.codechallenge.entities.Currency;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CurrenciesService {
  Logger logger = LoggerFactory.getLogger(CurrenciesService.class);
  Set<Currency> currencies = new HashSet<>();

  @PostConstruct
  public void loadData() throws Exception {
    File file = ResourceUtils.getFile("classpath:eurofxref.csv");
    List<String[]> allData = readAll(Files.newBufferedReader(file.toPath()));
    createCurrencies(allData);
  }

  private void createCurrencies(List<String[]> allData) throws Exception {
    if (allData.size() == 2) {
      String[] row1 = allData.get(0);
      String[] row2 = allData.get(1);
      if (row2.length > 1 && row1.length == row2.length) {
        String date = row2[0];
        for (int i = 1; i < row1.length; i++) {
          Currency currency = null;
          try {
            currency = new Currency(date, row1[i], row2[i]);
          } catch (Exception e) {
            logger.warn("Invalid entry: " + date + "," + row1[i] + "," + row2[i], e);
          }
          if (currency != null) {
            addCurrency(currency);
          }
        }
      } else {
        throw new Exception("invalid csv");
      }
    } else {
      throw new Exception("invalid csv");
    }
  }

  private void addCurrency(Currency currency) {
    if (currency != null) {
      Optional<Currency> previous = currencies.stream().filter(c1 -> c1.equals(currency)).findAny();
      if (previous.isPresent()) {
        if (previous.get().getDate().isBefore(currency.getDate())) {
          currencies.add(currency);
        }
      } else {
        currencies.add(currency);
      }
    }
  }


  public Set<Currency> getAll() {
    return currencies;
  }

  public Currency getSymbol(String symbol) throws Exception {
    if (Strings.isNotEmpty(symbol)) {
      Optional<Currency> found = currencies.stream().filter(cu -> cu.getSymbol().equals(symbol)).findAny();
      if (found.isPresent()) {
        return found.get();
      }
    }
    throw new Exception("Symbol " + symbol + " not found");
  }

  public List<String[]> readAll(Reader reader) throws Exception {
    CSVReader csvReader = new CSVReader(reader);
    List<String[]> list = csvReader.readAll();
    reader.close();
    csvReader.close();
    return list;
  }
}
