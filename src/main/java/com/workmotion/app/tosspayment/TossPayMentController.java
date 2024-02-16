package com.workmotion.app.tosspayment;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Base64;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/tosspayment/*")
public class TossPayMentController {

	@ResponseBody
	@PostMapping("server")
	public void server(@RequestBody TossPayMentDTO tossPayMentDTO) throws Exception {
	    String widgetSecretKey = "test_sk_jExPeJWYVQj9n09L47Lgr49R5gvN";
	    Base64.Encoder encoder = Base64.getEncoder();
	    byte[] encodedBytes = encoder.encode((widgetSecretKey + ":").getBytes("UTF-8"));
	    String authorizations = "Basic " + new String(encodedBytes, 0, encodedBytes.length);
		
		URL address = new URL("https://api.tosspayments.com/v1/payments/confirm");
		HttpURLConnection connection = (HttpURLConnection) address.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", authorizations);
		connection.setRequestProperty("Content-type", "application/json");
		connection.setDoOutput(true);

		ObjectMapper mapper = new ObjectMapper();
		String tossPay = mapper.writeValueAsString(tossPayMentDTO);
		System.out.println(tossPay);
		OutputStream send = connection.getOutputStream();
		DataOutputStream datasane = new DataOutputStream(send);
		datasane.writeBytes(tossPay);
		datasane.close();
		int result = connection.getResponseCode();
		System.out.println(result);
		

	}

}
