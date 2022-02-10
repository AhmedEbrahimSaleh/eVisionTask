package eVision.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class EVisionTaskController {
	
	@PostMapping(value = "/resource", produces = "application/json")
	public ResponseEntity Respond(@Valid @RequestBody EVisionTaskFormatEntity requestBody ) {
		
		String formatParam = requestBody.getFormat();
		
		Date dNow = new Date();															 
		
		SimpleDateFormat dateFormat = new SimpleDateFormat ("E yyyy.MM.dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat ("hh:mm:ss a zzz'Z'");
		
		String dateStr = dateFormat.format(dNow).toString();
		String timeStr = timeFormat.format(dNow).toString();
		
		ResponseEntity resp = new ResponseEntity(HttpStatus.NO_CONTENT);
		
		JSONObject date = new JSONObject();
		JSONObject time = new JSONObject();
		JSONObject error = new JSONObject();
		
		date.put("Date", dateStr);
		time.put("Time", timeStr);
		error.put("Error","Invalid Format");
		
		if(formatParam.equals("date")) {
			resp = new ResponseEntity<>(
					date,
					HttpStatus.OK);
		}																							
		else if(formatParam.equals("time")) {
			resp = new ResponseEntity<>(
					time,
					HttpStatus.OK);
		}
		else {
			resp = new ResponseEntity<>(
					error, 
					HttpStatus.BAD_REQUEST);
		}

		return resp;
	}
}
