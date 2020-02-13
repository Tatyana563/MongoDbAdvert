package com.example.MongoDbBoard.service;

import com.example.MongoDbBoard.model.Advert;
import com.example.MongoDbBoard.repository.AdvertRepository;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;


@Service
public class AdvertServiceImpl {

    @Autowired
    private AdvertRepository repository;

    public Collection<Advert> findAll(Pageable pageable) {
        Collection<Advert> adverts = repository.findAll(pageable).getContent();
        return CollectionUtils.isEmpty(adverts) ? Collections.emptyList() : Collections.unmodifiableCollection(adverts);
    }

    public Advert findById(String id) {
        if (Strings.isNullOrEmpty(id)) throw new IllegalArgumentException("id must be set");
        return repository.findById(id);
    }

    public Collection<Advert> findByPriceLessThan(int maxPrice) {
        Collection<Advert> adverts = repository.findByPriceLessThan(maxPrice);
        return CollectionUtils.isEmpty(adverts) ? Collections.emptyList() : Collections.unmodifiableCollection(adverts);
    }

    public Collection<Advert> findByAuthor(String name) {
        if (Strings.isNullOrEmpty(name)) throw new IllegalArgumentException("name must be set");
        Collection<Advert> adverts = repository.findByAuthor(name);
        return CollectionUtils.isEmpty(adverts) ? Collections.emptyList() : Collections.unmodifiableCollection(adverts);
    }
}
