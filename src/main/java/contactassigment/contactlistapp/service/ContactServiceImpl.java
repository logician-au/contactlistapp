package contactassigment.contactlistapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import contactassigment.contactlistapp.domain.Contact;
import contactassigment.contactlistapp.domain.ContactRepository;
import contactassigment.contactlistapp.domain.Organisation;
import contactassigment.contactlistapp.domain.OrganisationRepository;
import contactassigment.contactlistapp.dto.ContactDTO;
import contactassigment.contactlistapp.dto.ContactSearchCriteriaDTO;

@Service
@Transactional
public class ContactServiceImpl implements ContactService
{

  private final OrganisationRepository organisationRepo;
  private Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

  @PersistenceContext
  private EntityManager em;

  protected final ContactRepository repo;

  @Autowired
  public ContactServiceImpl(ContactRepository repo, OrganisationRepository organisationRepo)
  {
    this.organisationRepo = organisationRepo;
    this.repo = repo;
  }

  protected final ContactRepository getRepository()
  {
    return (ContactRepository) repo;
  }

  @Override
  public ContactDTO findByIdFetchOrganisation(Integer id)
  {
    Contact contact = getRepository().findByIdFetchOrganisation(id);
    if (contact != null)
    {
      return ContactDTO.createBy(contact);
    }
    else
    {
      return null;
    }
  }

  @Override
  public List<ContactDTO> listByCriteriaFetchOrganisation(ContactSearchCriteriaDTO criteria)
  {
    logger.debug("Query Criteria: " + criteria);
    String contactFirstName = criteria.getFirstName();

    String organisationName = criteria.getOrganisationName();

    StringBuilder sbuilder = new StringBuilder("SELECT c FROM Contact c LEFT JOIN FETCH c.organisation o ");
    if (StringUtils.hasText(contactFirstName))
    {
      sbuilder.append("AND c.firstName like :contactFirstNamePattern ");
    }
    if (StringUtils.hasText(organisationName))
    {
      sbuilder.append("AND o.name like :organisationNamePattern ");
    }
    String queryHQL = sbuilder.toString().replaceFirst("AND", "WHERE").trim();
    logger.debug("Query HQL: " + queryHQL);
    Query q = em.createQuery(queryHQL);

    if (StringUtils.hasText(contactFirstName))
    {
      q.setParameter("contactFirstNamePattern", contactFirstName);
    }
    if (StringUtils.hasText(organisationName))
    {
      q.setParameter("organisationNamePattern", organisationName);
    }

    List<Contact> resultList = q.getResultList();

    return ContactDTO.createListBy(resultList);
  }

  @Override
  public ContactDTO updateByDTO(ContactDTO contactDTO) throws EntityNotFoundException
  {
    logger.debug("Update contact with dto: " + contactDTO);
    Contact persistedContact = getRepository().findByIdFetchOrganisation(contactDTO.getId());
    if (persistedContact == null)
    {
      throw new EntityNotFoundException(String.format("Unable to find Entity: %s with id: %d", Contact.class.getCanonicalName(), contactDTO.getId()));
    }
    persistedContact.setFirstName(contactDTO.getFirstName());
    if (Integer.valueOf("-1").equals(contactDTO.getOrganisation().getId()))
    {
      persistedContact.setOrganisation(null);
    }
    else
    {
      Organisation persistedOrg = organisationRepo.findOne(contactDTO.getOrganisation().getId());
      persistedContact.setOrganisation(persistedOrg);
    }
    persistedContact = getRepository().save(persistedContact);
    return ContactDTO.createBy(persistedContact);
  }
}
