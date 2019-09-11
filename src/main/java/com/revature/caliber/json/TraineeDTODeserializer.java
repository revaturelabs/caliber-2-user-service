package com.revature.caliber.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.revature.caliber.dto.TraineeDTO;
import com.revature.caliber.pojo.TraineeFlag;
import com.revature.caliber.pojo.TrainingStatus;

import java.io.IOException;

/**
 * @author William Gentry
 */
public class TraineeDTODeserializer extends StdDeserializer<TraineeDTO> {

	public TraineeDTODeserializer() {
		this(null);
	}

	public TraineeDTODeserializer(Class<TraineeDTO> t) {
		super(t);
	}

	@Override
	public TraineeDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		JsonNode node = jsonParser.getCodec().readTree(jsonParser);
		TraineeDTO dto = new TraineeDTO();
		if (node.has("traineeId"))
			dto.setTraineeId(node.get("traineeId").asInt());
		if (node.has("resourceId"))
			dto.setResourceId(node.get("resourceId").asText());
		if (node.has("name"))
			dto.setName(node.get("name").asText());
		if (node.has("email"))
			dto.setEmail(node.get("email").asText());
		if (node.has("trainingStatus"))
			dto.setTrainingStatus(TrainingStatus.valueOf(node.get("trainingStatus").asText().toUpperCase()));
		if (node.has("batchId"))
			dto.setBatchId(node.get("batchId").asInt());
		if (node.has("phoneNumber"))
			dto.setPhoneNumber(node.get("phoneNumber").asText());
		if (node.has("skypeId"))
			dto.setSkypeId(node.get("skypeId").asText());
		if (node.has("profileUrl"))
			dto.setProfileUrl(node.get("profileUrl").asText());
		if (node.has("recruiterName"))
			dto.setRecruiterName(node.get("recruiterName").asText());
		if (node.has("college"))
			dto.setCollege(node.get("college").asText());
		if (node.has("degree"))
			dto.setDegree(node.get("degree").asText());
		if (node.has("major"))
			dto.setMajor(node.get("major").asText());
		if (node.has("techScreenerName"))
			dto.setTechScreenerName(node.get("techScreenerName").asText());
		if (node.has("techScreenScore"))
			dto.setTechScreenScore(node.get("techScreenScore").asDouble());
		if (node.has("projectCompletion"))
			dto.setProjectCompletion(node.get("projectCompletion").asText());
		if (node.has("flagStatus")) {
			TraineeFlag flag = TraineeFlag.valueOf(node.get("flagStatus").asText());
			dto.setFlagStatus(flag);
			System.out.println(flag);
		}
		if (node.has("flagNotes"))
			dto.setFlagNotes(node.get("flagNotes").asText());

		// What in the world do we do with a java.sql.Timestamp??
		// Omitted for the time being
		// Also flagNoteAuthor

		System.out.println(dto);
		return dto;
	}
}
