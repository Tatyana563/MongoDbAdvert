package com.example.MongoDbBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private AdvertRepository advertRepository;

    @Autowired
    public DbSeeder(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    List<Advert> books = new ArrayList<>();

    public DbSeeder() {

    }

    @Override
    public void run(String... strings) throws Exception {
        Advert book = new Advert(
                "Thinking Java", 960, "a great book",
                new Author("Tom", "+380682678632", "tom@gmail.com", "Nikolaev")
        );
        Advert book2 = new Advert(
                "Effective Java", 550, "one of the best Java programming books to develop a rich understanding of concurrency and multithreading",
                new Author("Jack", "+380682678635", "jack@gmail.com", "Lviv")
        );
        Advert book3 = new Advert(
                " Java: A Beginner’s Guide", 630, "A must-have book for every Java programmer",
                new Author("Bill", "+380682678638", "bill@gmail.com", "Dnepr")
        );
        Advert book4 = new Advert(
                "Head First Java", 1200, "The most important selling points of Head First Java is its simplicity and super-effective real-life analogie",
                new Author("Mark", "+380682678652", "mark@gmail.com", "Nikolaev")
        );
        // drop all adverts
        this.advertRepository.deleteAll();

        //add our adverts to the database
        books = Arrays.asList(book, book2, book3, book4);
        this.advertRepository.save(books);
    }

    public List<Advert> getAllBooksPaginated(int start, int size) {
        List<Advert> list = advertRepository.findAll();
        return list.subList(start, start + size);
    }
}
