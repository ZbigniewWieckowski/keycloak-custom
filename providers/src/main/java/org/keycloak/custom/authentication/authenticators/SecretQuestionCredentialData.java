package org.keycloak.custom.authentication.authenticators;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public class SecretQuestionCredentialData {

    private final String question;

    @JsonCreator
    public SecretQuestionCredentialData(@JsonProperty("question") String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}
