package com.hastatakip.aut;

import com.hastatakip.entites.model.UserAuthority;
import com.hastatakip.entites.model.Users;
import com.hastatakip.repositories.IUserAuthorityRepository;
import com.hastatakip.repositories.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private IUserAuthorityRepository userAuthorityRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String autHeader=request.getHeader("Authorization");
        String username=null;
        String token=null;
        if (autHeader!=null && autHeader.contains("Bearer")){
            token=autHeader.substring(7);
            try{
                username=tokenManager.getUserNameToken(token);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        if (username!=null &&token!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            if (tokenManager.tokenValidate(token)){
                Optional<Users> oUser=usersRepository.findByUsername(username);
                if (oUser.isPresent()){
                    Users us=oUser.get();
                    Collection<SimpleGrantedAuthority> roles=new ArrayList<>();
                    List<UserAuthority> role=userAuthorityRepository.findAllByUsersId(us.getId());
                   // System.out.println("Hasta rolleri"+role);
                    for (UserAuthority rol:role){
                        roles.add(new SimpleGrantedAuthority(rol.getPageAdmin().getName()));
                    }
                    //roles.add(new SimpleGrantedAuthority("ROLE_"+us.getTitle))
                    UsernamePasswordAuthenticationToken upassToken=
                            new UsernamePasswordAuthenticationToken(username,us,roles);
                    upassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(upassToken);

                }



            }
        }
        filterChain.doFilter(request,response);
    }
}
