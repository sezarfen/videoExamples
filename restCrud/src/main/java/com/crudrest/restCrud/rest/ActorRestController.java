package com.crudrest.restCrud.rest;

import com.crudrest.restCrud.entity.Actor;
import com.crudrest.restCrud.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorRestController {

    private ActorService actorService;

    @Autowired
    public ActorRestController(ActorService actorService)
    {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public List<Actor> findAll()
    {
        return actorService.findAll();
    }

    @GetMapping("/actors/{actorId}")
    public Actor findById(@PathVariable int actorId)
    {
        return actorService.findById(actorId);
    }

    @PutMapping("/actors")
    public Actor update(@RequestBody Actor actor)
    {
        return actorService.update(actor);
    }

    @DeleteMapping("/actors/{actorId}")
    public String deleteById(@PathVariable int actorId)
    {
        actorService.deleteById(actorId);
        return "Actor deleted successfully! - " + actorId;
    }

    @PostMapping("/actors")
    public Actor add(@RequestBody Actor actor)
    {
        return actorService.add(actor);
    }
}
