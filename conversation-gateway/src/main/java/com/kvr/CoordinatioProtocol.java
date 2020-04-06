package com.kvr;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kvr.model.ProtocolNode;

public class CoordinatioProtocol {

	@Value("${corordination.protocol.file.location}")
	private String protocolFileLocation;

	private List<ProtocolNode> protocolList;

	@PostConstruct
	private void init() throws JsonParseException, JsonMappingException, IOException {
		File file = new File(String.format("src/main/resources/%s", protocolFileLocation));
		ObjectMapper mapper = new ObjectMapper();
		protocolList = Stream.of(mapper.readValue(file, ProtocolNode[].class)).collect(Collectors.toList());
	}

	public List<ProtocolNode> getProtocolList() {
		return protocolList;
	}

	public String getProtocolFileLocation() {
		return protocolFileLocation;
	}

}
