package com.dependencyscan.dependencyscan.dto;

import com.dependencyscan.dependencyscan.entity.Artefact;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * custom jackson deserializer for the {@link JsonDto}
 */
public class JsonDtoDeserializer extends StdDeserializer<JsonDto> {

    public JsonDtoDeserializer() {
        this(null);
    }

    public JsonDtoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public JsonDto deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {


        JsonNode depsNode = jp.getCodec().readTree(jp);
        JsonDto json = new JsonDto();

        // every step to dezerialize the json and add all required informations
        getAndSetUniqueName(depsNode, json);
        getAndSetVersion(depsNode, json);
        getAndSetMapOfArtefact(depsNode, json);
        getAndSetDescription(depsNode, json);
        getAndSetUrl(depsNode, json);
        getAndSetCreationDate(depsNode, json);
        getAndSetDependingVersion(depsNode, json);

        // return the modified informations
        return json;
    }

    // parse the uniqueName and set it
    private void getAndSetUniqueName(JsonNode depsNode, JsonDto json) {
        String getDisplayName = depsNode.get("display_name").textValue();

        if (getDisplayName.contains("conanfile.py")) {
            String[] getUniqueName1 = getDisplayName.split("\\(");
            String[] getUniqueName2 = getUniqueName1[1].split("\\)");
            String uniqueName = getUniqueName2[0].replace("/", ":");
            json.setUniqueName(uniqueName);
        } else {
            String[] getUniqueName = getDisplayName.split("@");
            String uniqueName = getUniqueName[0].replace("/", ":");
            json.setUniqueName(uniqueName);
        }
    }

    // parse the Version and set it
    private void getAndSetVersion(JsonNode depsNode, JsonDto json) {
        String getDisplayName = depsNode.get("display_name").textValue();

        if (getDisplayName.contains("conanfile.py")) {
            String[] getVersion1 = getDisplayName.split("\\(");
            String[] getVersion2 = getVersion1[1].split("\\)");
            String[] getVersion3 = getVersion2[0].split("/");
            String version = getVersion3[1];
            json.setVersion(version);
        } else {
            String[] getUniqueName = depsNode.get("display_name").textValue().split("@");
            String[] getVersionAndName = getUniqueName[0].split("/");
            String getVersion = getVersionAndName[1];
            json.setVersion(getVersion);
        }
    }

    // parse the artefactOf, create a map and set it
    private void getAndSetMapOfArtefact(JsonNode depsNode, JsonDto json) {
        String getDisplayName = depsNode.get("display_name").textValue();

        if (getDisplayName.contains("conanfile.py")) {
            String[] getVerionName1 = getDisplayName.split("\\(");
            String[] getVerionName2 = getVerionName1[1].split("\\)");
            String[] getVerionName3 = getVerionName2[0].split("/");
            String artefactName = getVerionName3[0];
            Map<String, String> artefactOfVersion = new HashMap<String, String>() {{
                put("name", artefactName);
            }};
            json.setArtefactsOf(artefactOfVersion);
        } else {
            String[] getUniqueName = depsNode.get("display_name").textValue().split("/");
            String artefactName = getUniqueName[0];
            Map<String, String> artefactOfVersion = new HashMap<String, String>() {{
                put("name", artefactName);
            }};
            json.setArtefactsOf(artefactOfVersion);
        }
    }

    // get and set description if not available and set it
    private void getAndSetDescription(JsonNode depsNode, JsonDto json) {
        if (depsNode.has("desription")) {
            json.setDescription(depsNode.get("desription").textValue());
        } else {
            json.setDescription("-");
        }
    }

    // get and set url if not available and set it
    private void getAndSetUrl(JsonNode depsNode, JsonDto json) {
        if (depsNode.has("url")) {
            json.setUrl(depsNode.get("url").textValue());
        } else {
            json.setUrl("-");
        }
    }

    // get and set creation_date if not available and set it
    private void getAndSetCreationDate(JsonNode depsNode, JsonDto json) {
        if (depsNode.has("creation_date")) {
            json.setCreation_date(depsNode.get("creation_date").textValue());
        } else {
            json.setCreation_date("-");
        }
    }

    // get all depending versions, parse them, and map every content to a List<Map<String, String>>
    private void getAndSetDependingVersion(JsonNode depsNode, JsonDto json) {
        List<Map<String, String>> dependencyListMap = new ArrayList();
        if (depsNode.has("requires")) {
            depsNode.get("requires").forEach(dependencyNameEntry -> {

                String dependencyName = dependencyNameEntry.asText();

                String[] getUniqueName = dependencyName.split("@");
                String uniqueName = getUniqueName[0].replace("/", ":");

                Map<String, String> dependencyMap = new HashMap<String, String>() {{
                    put("uniqueName", uniqueName);
                }};
                dependencyListMap.add(dependencyMap);

            });
            json.setDependingVersionsMap(dependencyListMap);
        }
    }
}
