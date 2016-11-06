package com.brestopencampus.beers.repository;

import com.brestopencampus.beers.Beer;

/**
 * Created by sca on 05/11/16.
 */
public interface BeersService {

  Beer findBeer(String name);

  void addBeer(Beer b);
}
