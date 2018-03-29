package contactassigment.contactlistapp.dto;

public class ContactSearchCriteriaDTO
{

  private String name = Constants.EMPTY_STRING;
  private String secondName = Constants.EMPTY_STRING;
  private String organisationName = Constants.EMPTY_STRING;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getSecondName() {
	return secondName;
}

public void setSecondName(String secondName) {
	this.secondName = secondName;
}

public String getOrganisationName()
  {
    return organisationName;
  }

  public void setOrganisationName(String organisationName)
  {
    this.organisationName = organisationName;
  }
}
