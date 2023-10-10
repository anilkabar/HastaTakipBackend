package com.hastatakip.aut;

import com.hastatakip.entites.model.UserAuthority;
import com.hastatakip.entites.model.Users;
import com.hastatakip.repositories.IUserAuthorityRepository;
import com.hastatakip.repositories.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailService implements UserDetailsService {
    private Map<String,String> users=new HashMap<>();

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private IUserAuthorityRepository userAuthorityRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUser=usersRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            Users us=optionalUser.get();
            Collection<SimpleGrantedAuthority> roles=new ArrayList<>();
            List<UserAuthority> roleList=userAuthorityRepository.findAllByUsersId(us.getId());
            for (UserAuthority role:roleList){

                roles.add(new SimpleGrantedAuthority(role.getPageAdmin().getName()));
            }
            //roles.add(new SimpleGrantedAuthority(""+us.getTitle()));
            //System.out.println(us.getRole());
            return new User(username,us.getPassword(),roles);
        }


        /*
        if (users.containsKey(username)){
            return new User(username,users.get(username).toString(),new ArrayList<>());
        }

         */
        throw new UsernameNotFoundException(username);
    }






}
