package com.crudrest.restCrud.service;

import com.crudrest.restCrud.dal.ActorDAO;
import com.crudrest.restCrud.entity.Actor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImplementation implements ActorService{

    private ActorDAO actorDAO;

    @Autowired
    public ActorServiceImplementation(ActorDAO actorDAO)
    {
        this.actorDAO = actorDAO;
    }

    @Override
    public List<Actor> findAll() {
        return actorDAO.findAll();
    }

    @Override
    public Actor findById(int id) {
        return actorDAO.findById(id);
    }

    @Override
    @Transactional
    public Actor update(Actor actor) {
        return actorDAO.update(actor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Actor actor = actorDAO.findById(id);

        if (actor == null)
            throw new RuntimeException("Actor not found!");
        actorDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Actor add(Actor actor) {
        return actorDAO.add(actor);
    }
}
