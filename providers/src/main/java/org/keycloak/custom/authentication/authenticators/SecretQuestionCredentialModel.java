package org.keycloak.custom.authentication.authenticators;

  import java.io.IOException;

  import org.keycloak.credential.CredentialModel;
  import org.keycloak.util.JsonSerialization;

  public class SecretQuestionCredentialModel extends CredentialModel {

      public static final String TYPE = "SECRET_QUESTION";

      private SecretQuestionCredentialData credentialData;
      private SecretQuestionSecretData secretData;

      @Override
      public String getType() {
          return SecretQuestionCredentialModel.TYPE;
      }

      private SecretQuestionCredentialModel(SecretQuestionCredentialData credentialData, SecretQuestionSecretData secretData) {
          this.credentialData = credentialData;
          this.secretData = secretData;
      }

      public static SecretQuestionCredentialModel createFromCredentialModel(CredentialModel credentialModel){
      try {
          SecretQuestionCredentialData credentialData = JsonSerialization.readValue(credentialModel.getCredentialData(), SecretQuestionCredentialData.class);
          SecretQuestionSecretData secretData = JsonSerialization.readValue(credentialModel.getSecretData(), SecretQuestionSecretData.class);

          SecretQuestionCredentialModel secretQuestionCredentialModel = new SecretQuestionCredentialModel(credentialData, secretData);
          secretQuestionCredentialModel.setUserLabel(credentialModel.getUserLabel());
          secretQuestionCredentialModel.setCreatedDate(credentialModel.getCreatedDate());
          secretQuestionCredentialModel.setType(TYPE);
          secretQuestionCredentialModel.setId(credentialModel.getId());
          secretQuestionCredentialModel.setSecretData(credentialModel.getSecretData());
          secretQuestionCredentialModel.setCredentialData(credentialModel.getCredentialData());
          return secretQuestionCredentialModel;
      } catch (IOException e){
          throw new RuntimeException(e);
      }
  }

}
