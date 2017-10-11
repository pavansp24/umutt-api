/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.umutt.dto;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link org.umutt.dto.RegistrationDto}.
 *
 * NOTE: This class has been automatically generated from the {@link org.umutt.dto.RegistrationDto} original class using Vert.x codegen.
 */
public class DonorConverter {

  public static void fromJson(JsonObject json, RegistrationDto obj) {
    if (json.getValue("address") instanceof String) {
      obj.setAddress((String)json.getValue("address"));
    }
    if (json.getValue("area") instanceof String) {
      obj.setArea((String)json.getValue("area"));
    }
    if (json.getValue("city") instanceof String) {
      obj.setCity((String)json.getValue("city"));
    }
    if (json.getValue("country") instanceof String) {
      obj.setCountry((String)json.getValue("country"));
    }
    if (json.getValue("donorID") instanceof Number) {
      obj.setDonorID(((Number)json.getValue("donorID")).longValue());
    }
    if (json.getValue("email") instanceof String) {
      obj.setEmail((String)json.getValue("email"));
    }
    if (json.getValue("name") instanceof String) {
      obj.setName((String)json.getValue("name"));
    }
    if (json.getValue("noOfFamilyMembers") instanceof Number) {
      obj.setNoOfFamilyMembers(((Number)json.getValue("noOfFamilyMembers")).intValue());
    }
    if (json.getValue("phone") instanceof String) {
      obj.setPhone((String)json.getValue("phone"));
    }
    if (json.getValue("state") instanceof String) {
      obj.setState((String)json.getValue("state"));
    }
    if (json.getValue("volunteer") instanceof JsonObject) {
      obj.setVolunteer(new org.umutt.dto.UserDto((JsonObject)json.getValue("volunteer")));
    }
  }

  public static void toJson(RegistrationDto obj, JsonObject json) {
    if (obj.getAddress() != null) {
      json.put("address", obj.getAddress());
    }
    if (obj.getArea() != null) {
      json.put("area", obj.getArea());
    }
    if (obj.getCity() != null) {
      json.put("city", obj.getCity());
    }
    if (obj.getCountry() != null) {
      json.put("country", obj.getCountry());
    }
    if (obj.getDonorID() != null) {
      json.put("donorID", obj.getDonorID());
    }
    if (obj.getEmail() != null) {
      json.put("email", obj.getEmail());
    }
    if (obj.getName() != null) {
      json.put("name", obj.getName());
    }
    if (obj.getNoOfFamilyMembers() != null) {
      json.put("noOfFamilyMembers", obj.getNoOfFamilyMembers());
    }
    if (obj.getPhone() != null) {
      json.put("phone", obj.getPhone());
    }
    if (obj.getState() != null) {
      json.put("state", obj.getState());
    }
    if (obj.getVolunteer() != null) {
      json.put("volunteer", obj.getVolunteer().toJson());
    }
  }
}