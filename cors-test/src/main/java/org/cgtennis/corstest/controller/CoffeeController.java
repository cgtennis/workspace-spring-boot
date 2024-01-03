package org.cgtennis.corstest.controller;

import org.cgtennis.corstest.model.Coffee;
import org.cgtennis.corstest.model.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/coffee")
// @CrossOrigin(origins = "http://localhost:3000")
public class CoffeeController {

    private List<Coffee> coffeeList = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    public CoffeeController() {
        coffeeList.add(new Coffee(1,"Caffe Americano", Size.GRANDE));
        coffeeList.add(new Coffee(2,"Caffe Latte", Size.GRANDE));
        coffeeList.add(new Coffee(3,"Caffe Caramel Macchiato", Size.GRANDE));

    }

    @GetMapping
    public List<Coffee> fineAll() {
        logger.info("****** Here inside findAll() method ****");
        return coffeeList;
    }


    @DeleteMapping
    public void delete(Integer id)
    {
        coffeeList.removeIf( x -> x.id().equals(id));
    }
}
