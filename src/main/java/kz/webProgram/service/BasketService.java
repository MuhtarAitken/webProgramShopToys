package kz.webProgram.service;

import kz.webProgram.model.Basket;
import kz.webProgram.repo.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BasketService {

    @Autowired
    private BasketRepository repo;

    public List<Basket> listAll() {
        return repo.findAll();
    }

    public void save(Basket basket) {
        repo.save(basket);
    }

    public Basket get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
