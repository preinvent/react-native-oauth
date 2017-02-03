package com.github.scribejava.apis;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.Verb;

/**
 * Created by matt on 2/3/17.
 */

public class SmartthingsApi extends DefaultApi20 {

    protected SmartthingsApi() {
    }

    private static class InstanceHolder {
        private static final SmartthingsApi INSTANCE = new SmartthingsApi();
    }

    public static SmartthingsApi instance() {
        return SmartthingsApi.InstanceHolder.INSTANCE;
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://graph.api.smartthings.com/oauth/token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://graph.api.smartthings.com/oauth/authorize";
    }

    @Override
    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
        return OAuth2AccessTokenJsonExtractor.instance();
    }
}