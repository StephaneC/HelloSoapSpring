package com.brestopencampus.beers.repository;

import com.brestopencampus.beers.Beer;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * Created by sca on 05/11/16.
 */
@Component
public class BeersServiceImpl implements BeersService {

  private static final List<Beer> beers = new ArrayList<Beer>();

  @PostConstruct
  public void initData() {
    Beer kro = new Beer();
    kro.setName("Kronembourg");
    kro.setAlcohol(4);
    kro.setFrom("Alsace");

    beers.add(kro);

    Beer seize = new Beer();
    seize.setName("1664");
    seize.setAlcohol(5);
    seize.setFrom("Bas-Rhin");

    beers.add(seize);

    for (Beer beer : beers) {
      System.out.println("beer added :" + beer.getFrom());
    }
  }

  @Override
  public Beer findBeer(String name) {
    System.out.println("let's find beer=" + name);

    Assert.notNull(name);

    for (Beer beer : beers) {
      System.out.println("check beer=" + beer.getName());
      if (name.toLowerCase().equals(beer.getName().toLowerCase())) {
        return beer;
      }
    }
    return null;
  }

  @Override
  public void addBeer(Beer b) {
    System.out.println("add beer=" + b.getName());
    beers.add(b);
  }

}
