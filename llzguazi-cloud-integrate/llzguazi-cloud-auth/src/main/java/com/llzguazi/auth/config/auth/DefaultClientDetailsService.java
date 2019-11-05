package com.llzguazi.auth.config.auth;/**
 * Created by MI on 2019/9/17.
 */

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

/**
 * @Description: TODO
 * @Author llzguazi
 * @Date 2019/9/17
 **/
public class DefaultClientDetailsService implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails baseClientDetails = new BaseClientDetails(clientId,"resourceIds","scopes","authorization_code","authorities","http://localhost:5005/login");
        return baseClientDetails;
    }
}
