package com.brestopencampus.beers;

import com.brestopencampus.beers.repository.BeersService;
import com.brestopencampus.beers.repository.BeersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by sca on 05/11/16.
 */
@Endpoint
public class BeersEndPoint {
  private static final String NAMESPACE_URI = "http://brestopencampus.com/beers";

  private BeersService beersRepository;

  @Autowired
  public BeersEndPoint(BeersService beersRepository) {
    this.beersRepository = beersRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBeerRequest")
  @ResponsePayload
  public GetBeerResponse getBeer(@RequestPayload GetBeerRequest request) {
    System.out.println("Requested beer=" + request.getName());
    GetBeerResponse response = new GetBeerResponse();
    response.setBeer(beersRepository.findBeer(request.getName()));

    return response;
  }
}
