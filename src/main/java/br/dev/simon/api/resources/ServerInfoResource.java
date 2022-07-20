package br.dev.simon.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.simon.api.response.ServerInfoResponse;
import br.dev.simon.api.services.ServerInfoService;

@RestController
@RequestMapping("/info")
public class ServerInfoResource {

	@Autowired
	ServerInfoService serverInfoService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ServerInfoResponse> list() {
		ServerInfoResponse response = serverInfoService.showServerInfo();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
