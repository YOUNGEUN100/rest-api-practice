package com.example.practice3.objectmapper;

import com.example.practice3.objectmapper.dto.Car;
import com.example.practice3.objectmapper.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Arrays;
import java.util.List;

public class OMAapplication {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("OMAapplication 시작");


        User user = new User();
        user.setName("홍길동");
        user.setAge(30);
        
        Car car1 = new Car();
        car1.setName("sonota");
        car1.setCarNumber("123가4567");
        car1.setType("세단");

        Car car2 = new Car();
        car2.setName("Kono");
        car2.setCarNumber("987가6543");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setUserCars(carList);


        ObjectMapper objectMapper = new ObjectMapper();
        // java object model -> json
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.get("name").asText());
        System.out.println(jsonNode.get("age").asInt());

        JsonNode carsJsonNode = jsonNode.get("userCars");
        ArrayNode arrayNode = (ArrayNode)carsJsonNode;

        // JsonNode -> java object model
        List<Car> listCars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(listCars);

        // json -> java object model
        ObjectNode objectNode = (ObjectNode)jsonNode;
        System.out.println(objectNode.toPrettyString());
    }

}
