package com.crudrest.restCrud.service;

import com.crudrest.restCrud.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();

    Actor findById(int id);

    Actor update(Actor actor);

    void deleteById(int id);

    Actor add(Actor actor);
}
