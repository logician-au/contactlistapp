package contactassigment.contactlistapp.dto;

import java.util.ArrayList;
import java.util.List;

import contactassigment.contactlistapp.domain.Contact;
import contactassigment.contactlistapp.domain.Organisation;

public class ContactDTO
{

  public static ContactDTO createBy(Contact contact)
  {
    return new ContactDTO(contact);
  }

  public static List<ContactDTO> createListBy(List<Contact> contacts)
  {
    List<ContactDTO> contactDTOs = new ArrayList<ContactDTO>(contacts.size());
    for (Contact c : contacts)
    {
      contactDTOs.add(ContactDTO.createBy(c));
    }
    return contactDTOs;
  }

  private Integer id;

  private String firstName;

  private String secondName;

  private OrganisationDTO organisation;

  public ContactDTO()
  {
  }

  public ContactDTO(Contact contact)
  {
    setId(contact.getId());
    setFirstName(contact.getFirstName());
    setSecondName(contact.getSecondName());
    Organisation org = contact.getOrganisation();
    if (org != null)
    {
      setOrganisation(new OrganisationDTO(contact.getOrganisation()));
    }
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getFirstName()
  {
    return this.firstName;
  }

  public String getSecondName() {
	return secondName;
}

public void setSecondName(String secondName) {
	this.secondName = secondName;
}

public OrganisationDTO getOrganisation()
  {
    return organisation;
  }

  public void setOrganisation(OrganisationDTO organisation)
  {
    this.organisation = organisation;
  }

  public String getOrganisationInfo()
  {
    OrganisationDTO org = getOrganisation();
    if (org != null)
    {
      return org.getName();
    }
    else
    {
      return Constants.EMPTY_STRING;
    }
  }

  public String getOrganisationName()
  {
    OrganisationDTO org = getOrganisation();
    if (org != null)
    {
      return org.getName();
    }
    else
    {
      return Constants.EMPTY_STRING;
    }
  }
}
