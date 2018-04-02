package contactassigment.contactlistapp.dto;

public class ContactSearchCriteriaDTO
{

  private String firstName = Constants.EMPTY_STRING;
  private String lastName = Constants.EMPTY_STRING;
  private String organisationName = Constants.EMPTY_STRING;

  public String getFirstName()
  {
    return firstName;
  }

  public String getQueryFirstName()
  {
    return getQueryString(firstName);
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName() {
	return lastName;
  }

  public String getQueryLastName() {
	return getQueryString(lastName);
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getOrganisationName()
  {
    return organisationName;
  }

  public String getQueryOrganisationName()
  {
    return getQueryString(organisationName);
  }

  public void setOrganisationName(String organisationName)
  {
    this.organisationName = organisationName;
  }
  
  private String getQueryString(String matchString) {
	  return matchString.toLowerCase().replace('*', '%') + '%';
  }
}
