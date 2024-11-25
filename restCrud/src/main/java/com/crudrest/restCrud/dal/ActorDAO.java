package com.crudrest.restCrud.dal;

import com.crudrest.restCrud.entity.Actor;

import java.util.List;

public interface ActorDAO {
    List<Actor> findAll();
    Actor findById(int id);
    Actor update(Actor actor);
    void deleteById(int id);
    Actor add(Actor actor);
}
