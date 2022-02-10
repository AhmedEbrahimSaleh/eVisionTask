package eVision.task;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class EVisionTaskFormatEntity {

	@NotNull(message = "format cannot be null")
	@NotBlank(message = "format cannot be blank")
	private String format;

	public String getFormat() {
		return format;
	}

}
