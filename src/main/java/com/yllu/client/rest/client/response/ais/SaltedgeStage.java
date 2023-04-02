package com.yllu.client.rest.client.response.ais;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@Data
public class SaltedgeStage {

    private String id;
    private String name;
    @JsonProperty("interactive_fields_options")
    private Object interactiveFieldsOptions;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("interactive_html")
    private String interactiveHtml;
    @JsonProperty("interactive_fields_names")
    private List<String> interactiveFieldsNames;
}
