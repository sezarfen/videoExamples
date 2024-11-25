package com.crudrest.restCrud.dal;

import com.crudrest.restCrud.entity.Actor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorDaoImplementation implements ActorDAO{

    private EntityManager entityManager;

    @Autowired
    public ActorDaoImplementation(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<Actor> findAll() {
        return entityManager.createQuery("FROM Actor",Actor.class).getResultList();
    }

    @Override
    public Actor findById(int id) {
        return entityManager.find(Actor.class,id);
    }

    @Override
    public Actor update(Actor actor) {
        return entityManager.merge(actor);
    }

    @Override
    public void deleteById(int id) {
        Actor actor = entityManager.find(Actor.class, id);

        entityManager.remove(actor);
    }

    @Override
    public Actor add(Actor actor) {
        return entityManager.merge(actor);
    }
}
