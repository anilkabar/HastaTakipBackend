package com.hastatakip.aut;

import com.hastatakip.entites.model.PageAdmin;
import com.hastatakip.entites.model.UserAuthority;
import com.hastatakip.entites.model.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MyUserDetails implements UserDetails {

    @Autowired
    private UserAuthority userAuthority;

    @Autowired
    private Users users;

    @Autowired
    private PageAdmin pageAdmin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //List<UserAuthority> roles=userAuthority.getPageAdmin().getUserAuthorityList();
        List<UserAuthority> roles=pageAdmin.getUserAuthorityList();

        System.out.println("MyUSerDetail"+roles);

       // List<UserAuthority> roles=users.getUserAuthorityList();
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for (UserAuthority role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getPageAdmin().getName()));
        }
        return authorities;

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}


