package sample.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Phases {
	
	private Long Id;
	
	@NotBlank
	@Size(max=100)
	private String Phase;
	
	@NotBlank
	int Sort;
}
