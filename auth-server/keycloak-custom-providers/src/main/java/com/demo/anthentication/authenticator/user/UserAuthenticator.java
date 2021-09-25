package com.demo.anthentication.authenticator.user;

import com.demo.storage.user.CustomUserStorageProvider;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAuthenticator implements Authenticator {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserStorageProvider.class);

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        logger.debug("authenticate called ... context = " + context);

        String a = "";
        context.success();
    }

    @Override
    public void action(AuthenticationFlowContext context) {
//        logger.info("autenticado com sucesso  " + context);
//        String a = "";
//        context.success();
    }


    @Override
    public boolean requiresUser() {
        logger.debug("requiresUser called ... returning true");
        return true;
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
        logger.debug("configuredFor called ... session=" + session + ", realm=" + realm + ", user=" + user);
        boolean result = true;
        logger.debug("... returning " + result);
        return result;
    }

    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
        logger.debug("setRequiredActions called ... session=" + session + ", realm=" + realm + ", user=" + user);
    }

    @Override
    public void close() {
        logger.debug("close called ...");
    }

}
