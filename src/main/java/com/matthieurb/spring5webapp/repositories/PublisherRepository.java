package com.matthieurb.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.matthieurb.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
