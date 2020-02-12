package com.example.MongoDbBoard;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;

//http://localhost:8095/adverts/all
@RestController
@RequestMapping("/adverts")
public class AdvertController {
    private AdvertRepository advertRepository;
    public DbSeeder dbSeeder = new DbSeeder();

    public AdvertController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

  /*  @GetMapping("/all") - ok
    public List<Advert> getAll(){
        List<Advert> adverts = this.advertRepository.findAll();

        return adverts;
    }*/
//http://localhost:8095/adverts/all?start=0&size=1 - not ok
    @GetMapping("/all")
    public List<Advert> getAll(@QueryParam("start") int start,
                               @QueryParam("size") int size){
     return dbSeeder.getAllBooksPaginated(start,size);
    }
    //http://localhost:8095/adverts/5e4400d3dc2dfb20689e67f4 - ok
    @GetMapping("/{id}")

    public Advert getById(@PathVariable("id") String id){
        Optional<Advert> ad = Optional.ofNullable(this.advertRepository.findById(id));
        return ad.get();
    }
//http://localhost:8095/adverts/price/600 - ok
    @GetMapping("/price/{maxPrice}")
    public List<Advert> getByPrice(@PathVariable("maxPrice") int maxPrice){
        List<Advert> books= this.advertRepository.findByPriceLessThan(maxPrice);
        return books;
    }
//http://localhost:8095/adverts/author/Tom  - ok
    @GetMapping("/author/{name}")
    public List<Advert> getByCity(@PathVariable("name") String name){
       return this.advertRepository.findByAuthor(name);
    }
//http://localhost:8095/adverts/recommended - ok
    @GetMapping("/recommended")
    public List<Advert> getRecommended(){
        final int maxPrice = 1000;
        final String location="Nikolaev";

        // create a query class (QAdvert)
        QAdvert qAdvert = new QAdvert("ad");

        // using the query class we can create the filters
        BooleanExpression filterByPrice = qAdvert.price.lt(maxPrice);
        BooleanExpression filterByLocation = qAdvert.author.city.containsIgnoreCase(location);

        // we can then pass the filters to the findAll() method
        return (List<Advert>) this.advertRepository.findAll(filterByPrice.and(filterByLocation));
    }

}
