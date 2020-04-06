package com.kvr.model;

import java.util.List;

public class ProtocolNode {
	private String name;
	private List<ProtocolTransition> transitions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProtocolTransition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<ProtocolTransition> transitions) {
		this.transitions = transitions;
	}

}
