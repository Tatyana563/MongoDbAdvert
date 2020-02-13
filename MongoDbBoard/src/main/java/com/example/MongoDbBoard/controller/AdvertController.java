package com.example.MongoDbBoard.controller;

import com.example.MongoDbBoard.model.Advert;
import com.example.MongoDbBoard.model.QAdvert;
import com.example.MongoDbBoard.service.AdvertServiceImpl;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

//http://localhost:8095/adverts/all
@RestController
@RequestMapping("/adverts")
public class AdvertController {

    @Autowired
    private AdvertServiceImpl service;


    /*  @GetMapping("/all") - ok
      public List<Advert> getAll(){
          List<Advert> adverts = this.advertRepository.findAll();

          return adverts;
      }*/
//http://localhost:8095/adverts/all?start=0&size=1 -ok
/*    @GetMapping("/all")
    public List<Advert> getAll(@QueryParam("start") int start,
                               @QueryParam("size") int size){
     return dbSeeder.getAllBooksPaginated(start,size);
    }*/
  /*  @GetMapping("/all")
    public List<Advert> getAll(int position, int limit){
        Page page = advertRepository.findAll(PageRequest.of(position, limit));
        System.out.println("total elements = " + page.getTotalElements());

        return page.getContent();
    }*/
  //http://localhost:8095/adverts/all?page=0&size=50
    @GetMapping("/all")
    public ResponseEntity<Collection<Advert>> getAll(@RequestParam(name = "page", required = false) Integer page,
                                                     @RequestParam(name = "size", required = false) Integer size) {
        Pageable pageable = new PageRequest(Objects.isNull(page) ? 0 : page, Objects.isNull(size) ? 2 : size); //get 5 profiles on a page
        return ResponseEntity.ok(service.findAll(pageable));
    }

    //http://localhost:8095/adverts/5e4400d3dc2dfb20689e67f4 - ok
    @GetMapping("/{id}")
    public ResponseEntity<Advert> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    //http://localhost:8095/adverts/price/600 - ok
    @GetMapping("/price/{maxPrice}")
    public ResponseEntity<Collection<Advert>> getByPrice(@PathVariable("maxPrice") int maxPrice) {
        return ResponseEntity.ok(this.service.findByPriceLessThan(maxPrice));
    }

    //http://localhost:8095/adverts/author/Tom  - ok
    @GetMapping("/author/{name}")
    public ResponseEntity<Collection<Advert>> getByCity(@PathVariable("name") String name) {
        return ResponseEntity.ok(service.findByAuthor(name));
    }

    //http://localhost:8095/adverts/recommended - ok
    @GetMapping("/recommended")
    public ResponseEntity<Iterable<Advert>> getRecommended(@RequestParam(name = "maxPrice") int maxPrice,
                                                             @RequestParam(name = "location") String location) {
        /*final int maxPrice = 1000;
        final String location = "Nikolaev";*/

        // create a query class (QAdvert)
        QAdvert qAdvert = new QAdvert("ad");

        // using the query class we can create the filters
        BooleanExpression filterByPrice = qAdvert.price.lt(maxPrice);
        BooleanExpression filterByLocation = qAdvert.author.city.containsIgnoreCase(location);

        // we can then pass the filters to the findAll() method
        return ResponseEntity.ok(this.service.findAllByFilter(filterByPrice.and(filterByLocation)));
    }

}
