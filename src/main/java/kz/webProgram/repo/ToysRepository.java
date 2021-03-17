package kz.webProgram.repo;

import kz.webProgram.model.Toys;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToysRepository extends JpaRepository<Toys, Long> {

}