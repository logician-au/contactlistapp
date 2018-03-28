package contactassigment.contactlistapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>
{

  @Query("SELECT c FROM Contact c LEFT JOIN FETCH c.organisation WHERE c.id = ?1")
  Contact findByIdFetchOrganisation(Integer id);

  @Query("FROM Contact c LEFT JOIN FETCH c.organisation")
  List<Contact> findAllFetchOrganisation();
}
