package com.hastatakip.restcontrollers;
import com.hastatakip.aut.TokenManager;
import com.hastatakip.entites.dto.UsersDto;
import com.hastatakip.entites.model.Users;
import com.hastatakip.repositories.IUsersRepository;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin
@RequestMapping("login")
public class LoginRestController {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsersRepository usersRepository;

    @PostMapping("save")
    public ResponseEntity<String > register(@RequestBody UsersDto usersDto){
        Users u=new Users();
        u.setUsername(usersDto.getUsername());
        u.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        usersRepository.save(u);
        return ResponseEntity.ok("User Success");
    }


    @PostMapping("Giris")
    public Map<String, Object> login(@RequestBody UsersDto usersDto){
        UsernamePasswordAuthenticationToken autToken=new UsernamePasswordAuthenticationToken(usersDto.getUsername(),usersDto.getPassword());
        Authentication aut=authenticationManager.authenticate(autToken);
        SecurityContextHolder.getContext().setAuthentication(aut);
        Map<String, Object> map=new LinkedHashMap<>();
        Optional<Users> opt=usersRepository.findByUsername(aut.getName());
        if (opt.get().getIsActive()==false){
            map.put("durum",false);
            return map;
        }
        List<String> role=new ArrayList<>();
        for (Object s:aut.getAuthorities().toArray()){
            role.add(s.toString());
        }
        String jwtToken=tokenManager.generateToken(aut.getName(),role,opt.get().getId().toString());

        map.put("token",jwtToken);
        if (opt.isPresent()){
            map.put("companyId",opt.get().getCompany().getId());
        }
        //System.out.println(role);
        return map;

    }
}
