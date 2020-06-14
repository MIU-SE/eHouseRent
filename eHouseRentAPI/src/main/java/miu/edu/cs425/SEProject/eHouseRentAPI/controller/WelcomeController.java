package miu.edu.cs425.SEProject.eHouseRentAPI.controller;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.AuthenticationRequest;
import miu.edu.cs425.SEProject.eHouseRentAPI.model.AuthenticationResponse;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.impl.MyUserDetailService;
import miu.edu.cs425.SEProject.eHouseRentAPI.utill.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class WelcomeController {

    @RequestMapping({"/ehouserent/hello"})
//    @PreAuthorize("hasRole('USER')")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping({"/ehouserent/welcome"})
//    @PreAuthorize("hasRole('OWNER')")
    public String welcome(){
        return "Welcome";
    }
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
//
//
////    @CrossOrigin
    @PostMapping(value = "/ehouserent/signin")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
       try{
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassWord())
           );
       }
        catch (BadCredentialsException e){
           throw new Exception("Incorect username or password", e);
        }
       final UserDetails userDetails=userDetailsService
               .loadUserByUsername(authenticationRequest.getUserName());

       final String jwt=jwtUtil.generateToken(userDetails);
       return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    }
