package kz.webProgram.service;


import kz.webProgram.model.Toys;
import kz.webProgram.repo.ToysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ToysService {

    @Autowired
    private ToysRepository repo;

    public List<Toys> listAll() {
        return repo.findAll();
    }

    public void save(Toys toys) {
        repo.save(toys);
    }

    public Toys get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
