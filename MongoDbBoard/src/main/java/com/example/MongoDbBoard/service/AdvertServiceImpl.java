package com.example.MongoDbBoard.service;

import com.example.MongoDbBoard.model.Advert;
import com.example.MongoDbBoard.repository.AdvertRepository;
import com.google.common.base.Strings;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//
@Service
//@Transactional(readOnly = true)
public class AdvertServiceImpl {

    @Autowired
    private AdvertRepository repository;

    public Collection<Advert> findAll() {
        Collection<Advert> adverts = repository.findAll();
        return CollectionUtils.isEmpty(adverts) ? Collections.emptyList() : Collections.unmodifiableCollection(adverts);
    }


    public Collection<Advert> findAll(Pageable pageable) {
        Collection<Advert> adverts = repository.findAll(pageable).getContent();
        return CollectionUtils.isEmpty(adverts) ? Collections.emptyList() : Collections.unmodifiableCollection(adverts);
    }


    public Advert findById(String id) {
        Assert.notNull(id, "id must be a set");
        return  repository.findById(id);
    }

    public Collection<Advert> findByPriceLessThan(int maxPrice) {
        Collection<Advert> adverts = repository.findByPriceLessThan(maxPrice);
        return CollectionUtils.isEmpty(adverts) ? Collections.emptyList() : Collections.unmodifiableCollection(adverts);
    }

    public Collection<Advert> findByAuthor(String name) {
        //if (Strings.isNullOrEmpty(name)) throw new IllegalArgumentException("name must be a set");
        Assert.notNull(name, "name must be a set");
        Collection<Advert> adverts = repository.findByAuthor(name);
        return CollectionUtils.isEmpty(adverts) ? Collections.emptyList() : Collections.unmodifiableCollection(adverts);
    }

    public Iterable<Advert> findAllByFilter(Predicate predicate) {
        if (Objects.isNull(predicate)) return findAll();
        else {
            Iterable<Advert> adverts = repository.findAll(predicate);
            if (Objects.isNull(adverts)) {
                return Collections.emptyList();
            } else {
                return adverts;
            }
        }
    }
}
