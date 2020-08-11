package org.keycloak.custom.authentication.authenticators;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public class SecretQuestionSecretData {

     private final String answer;

    @JsonCreator
     public SecretQuestionSecretData(@JsonProperty("answer") String answer) {
         this.answer = answer;
     }

    public String getAnswer() {
        return answer;
    }
}
