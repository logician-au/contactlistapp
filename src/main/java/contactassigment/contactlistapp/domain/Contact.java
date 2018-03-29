package contactassigment.contactlistapp.domain;

import javax.persistence.*;

@Entity
public class Contact
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Access(AccessType.PROPERTY)
  private Integer id;

  @Column(nullable = false, length = 30)
  private String firstName;

  @Column(nullable = false, length = 30)
  private String secondName;

  @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.MERGE)
  private Organisation organisation;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getSecondName() {
	return secondName;
}

public void setSecondName(String secondName) {
	this.secondName = secondName;
}

public Organisation getOrganisation()
  {
    return organisation;
  }

  public void setOrganisation(Organisation organisation)
  {
    this.organisation = organisation;
  }
}
