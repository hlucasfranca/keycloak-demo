package com.demo.anthentication.authenticator.user;

import com.demo.anthentication.authenticator.sms.SMSAuthenticatorConstants;
import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import javax.ws.rs.HttpMethod;
import java.util.ArrayList;
import java.util.List;

import static com.demo.anthentication.authenticator.sms.SMSAuthenticatorConstants.AUTH_METHOD_BASIC;
import static com.demo.anthentication.authenticator.sms.SMSAuthenticatorConstants.AUTH_METHOD_INMESSAGE;


/**
 * Created by joris on 11/11/2016.
 */
public class UserAuthenticatorFactory implements AuthenticatorFactory {

    public static final String PROVIDER_ID = "user-authentication";

    private static Logger logger = Logger.getLogger(UserAuthenticatorFactory.class);
    private static final UserAuthenticator SINGLETON = new UserAuthenticator();
    private static final AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
            AuthenticationExecutionModel.Requirement.REQUIRED,
            AuthenticationExecutionModel.Requirement.ALTERNATIVE,
            AuthenticationExecutionModel.Requirement.DISABLED};

    private static final List<ProviderConfigProperty> configProperties = new ArrayList<ProviderConfigProperty>();

    @Override
    public String getId() {
        logger.debug("getId called ... returning " + PROVIDER_ID);
        return PROVIDER_ID;
    }

    @Override
    public Authenticator create(KeycloakSession session) {
        logger.debug("create called ... returning " + SINGLETON);
        return SINGLETON;
    }


    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        logger.debug("getRequirementChoices called ... returning " + REQUIREMENT_CHOICES);
        return REQUIREMENT_CHOICES;
    }

    @Override
    public boolean isUserSetupAllowed() {
        logger.debug("isUserSetupAllowed called ... returning true");
        return true;
    }
    @Override
    public boolean isConfigurable() {
        boolean result = true;
        logger.debug("isConfigurable called ... returning " + result);
        return result;
    }
    @Override
    public String getHelpText() {
        logger.debug("getHelpText called ...");
        return "Validates an OTP sent by SMS.";
    }
    @Override
    public String getDisplayType() {
        String result = "User Authentication";
        logger.debug("getDisplayType called ... returning " + result);
        return result;
    }
    @Override
    public String getReferenceCategory() {
        logger.debug("getReferenceCategory called ... returning sms-auth-code");
        return "usuario-auth";
    }
    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        logger.debug("getConfigProperties called ... returning " + configProperties);
        return configProperties;
    }
    @Override
    public void init(Config.Scope config) {
        logger.debug("init called ... config.scope = " + config);
    }
    @Override
    public void postInit(KeycloakSessionFactory factory) {
        logger.debug("postInit called ... factory = " + factory);
    }
    @Override
    public void close() {
        logger.debug("close called ...");
    }
}
