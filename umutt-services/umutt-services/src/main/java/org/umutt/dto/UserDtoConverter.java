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
 * Converter for {@link org.umutt.dto.UserDto}.
 *
 * NOTE: This class has been automatically generated from the {@link org.umutt.dto.UserDto} original class using Vert.x codegen.
 */
public class UserDtoConverter {

  public static void fromJson(JsonObject json, UserDto obj) {
    if (json.getValue("email") instanceof String) {
      obj.setEmail((String)json.getValue("email"));
    }
    if (json.getValue("firstName") instanceof String) {
      obj.setFirstName((String)json.getValue("firstName"));
    }
    if (json.getValue("lastName") instanceof String) {
      obj.setLastName((String)json.getValue("lastName"));
    }
    if (json.getValue("password") instanceof String) {
      obj.setPassword((String)json.getValue("password"));
    }
    if (json.getValue("phone") instanceof String) {
      obj.setPhone((String)json.getValue("phone"));
    }
    if (json.getValue("role") instanceof Number) {
      obj.setRole(((Number)json.getValue("role")).intValue());
    }
    if (json.getValue("userId") instanceof String) {
      obj.setUserId((String)json.getValue("userId"));
    }
  }

  public static void toJson(UserDto obj, JsonObject json) {
    if (obj.getEmail() != null) {
      json.put("email", obj.getEmail());
    }
    if (obj.getFirstName() != null) {
      json.put("firstName", obj.getFirstName());
    }
    if (obj.getLastName() != null) {
      json.put("lastName", obj.getLastName());
    }
    if (obj.getPassword() != null) {
      json.put("password", obj.getPassword());
    }
    if (obj.getPhone() != null) {
      json.put("phone", obj.getPhone());
    }
    if (obj.getRole() != null) {
      json.put("role", obj.getRole());
    }
    if (obj.getUserId() != null) {
      json.put("userId", obj.getUserId());
    }
  }
}