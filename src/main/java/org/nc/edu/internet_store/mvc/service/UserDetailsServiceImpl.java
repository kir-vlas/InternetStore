package org.nc.edu.internet_store.mvc.service;

import org.nc.edu.internet_store.mvc.dao.AccountDAO;
import org.nc.edu.internet_store.mvc.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public UserDetails loadUserByUsername(String login){
        Account account = accountDAO.findAccount(login);

        if (account == null) {
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        }

        String role = account.getRole();

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);

        grantList.add(authority);

        boolean enabled = account.isActive();

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = (UserDetails) new User(account.getLogin(),
                account.getPassword(),enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantList);
        return userDetails;
    }
}
