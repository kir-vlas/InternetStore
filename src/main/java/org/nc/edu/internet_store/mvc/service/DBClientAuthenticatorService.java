package org.nc.edu.internet_store.mvc.service;

import org.nc.edu.internet_store.mvc.dao.ClientDAO;
import org.nc.edu.internet_store.mvc.domain.AuthorizedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DBClientAuthenticatorService implements UserDetailsService{

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public UserDetails loadUserByUsername(String login){
        AuthorizedClient client = clientDAO.findClient(login);

        if (client == null) {
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        }

        String role = client.getRole();

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);

        grantList.add(authority);

        boolean enabled = client.isActive();

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = (UserDetails) new User(client.getLogin(),
                client.getPassword(),enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantList);
        return userDetails;
    }
}
