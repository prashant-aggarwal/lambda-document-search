package com.pc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pc.lambda.model.LambdaDemoIO;

public class Handler implements RequestHandler<LambdaDemoIO, LambdaDemoIO> {

	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public LambdaDemoIO handleRequest(LambdaDemoIO event, Context context) {
		
		LambdaLogger logger = context.getLogger();
		logger.log("event => " + gson.toJson(event) + "\n");
		logger.log("context => " + gson.toJson(context) + "\n");
		
		LambdaDemoIO response = new LambdaDemoIO();
		response.setFirstName(event.getFirstName());
		response.setLastName(event.getLastName());
		response.setFuncStates(event.getFuncStates());
		response.getFuncStates().setDocumentFound(true);
		return response;
	}
}
