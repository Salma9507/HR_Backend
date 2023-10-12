package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.Meeting;

@Repository
public interface IMeetingRepo  extends JpaRepository<Meeting, Long> {

}
