package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.Image;


@Repository
public interface IImageRepo  extends JpaRepository<Image, Long> {

}
