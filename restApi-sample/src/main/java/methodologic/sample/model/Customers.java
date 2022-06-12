package methodologic.sample.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customers {
	
	private Long Id;
	
	@NotBlank
	@Size(max=120)
	private String CustomerName;
	
	@NotBlank
	@Size(max=120)
	private String MainContactName;
	
	@NotBlank
	@Size(max=120)
	private String Country;
	
	@NotBlank
	@Size(max=60)
	private String City;
	
	@NotBlank
	@Size(max=120)
	private String AddressLine1;
	
	@NotBlank
	@Size(max=120)
	private String PostalCode;
	
	@NotBlank
	@Size(max=120)
	private String ContactEmail;
	
	@NotBlank
	@Size(max=120)
	private String MainPhone;

}
