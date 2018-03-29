package contactassigment.contactlistapp.web.validators;

import contactassigment.contactlistapp.dto.ContactDTO;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ContactDTOValidator implements Validator
{

  /**
   * This Validator validates *just* Person instances
   */
  public boolean supports(Class clazz)
  {
    return ContactDTO.class.equals(clazz);
  }

  public void validate(Object obj, Errors e)
  {
    ValidationUtils.rejectIfEmpty(e, "firstName", "firstName.empty");
    ValidationUtils.rejectIfEmpty(e, "secondName", "secondName.empty");
    ContactDTO p = (ContactDTO) obj;
    if (p.getFirstName().length() > 30)
    {
      e.rejectValue("firstName", "firstName.too.long");
    }
    if (p.getSecondName().length() > 30)
    {
      e.rejectValue("secondName", "secondName.too.long");
    }
  }
}
