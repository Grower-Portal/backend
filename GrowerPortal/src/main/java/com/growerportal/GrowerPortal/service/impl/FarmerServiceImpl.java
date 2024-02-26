package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import com.growerportal.GrowerPortal.dto.LoginResponseDTO;
import com.growerportal.GrowerPortal.dto.UserInfoDto;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.repository.RoleRepository;
import com.growerportal.GrowerPortal.service.AddApplicationService;
import com.growerportal.GrowerPortal.service.FarmerService;
import com.growerportal.GrowerPortal.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class FarmerServiceImpl implements FarmerService, UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private final FarmerPersonalInfoRepository farmerPersonalInfoRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddApplicationService addApplicationService;


    public FarmerServiceImpl(FarmerPersonalInfoRepository farmerPersonalInfoRepository) {
        this.farmerPersonalInfoRepository = farmerPersonalInfoRepository;
    }

    public UserInfoDto getUserInfo(String email) {
        FarmerPersonalInfo farmer = farmerPersonalInfoRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(String.format("No user found with email: %s", email)));



        UserInfoDto userInfoDTO = new UserInfoDto();
        userInfoDTO.setName(String.format("%s %s", farmer.getFirstName(), farmer.getLastName()));
        userInfoDTO.setEmail(farmer.getEmail());
        userInfoDTO.setPhone(farmer.getPhoneNumber());
        userInfoDTO.setAddress(farmer.getAddress());
        userInfoDTO.setDob(farmer.getDob());


            // Get applications related to the farmer
            List<AddApplicationDto> farmerApplications = addApplicationService.getApplicationsByFarmerId(farmer);
        userInfoDTO.setAddApplicationDto(farmerApplications);

        return userInfoDTO;
    }

    public LoginResponseDTO loginUser(String username, String password) {

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);
            return new LoginResponseDTO(farmerPersonalInfoRepository.findByEmail(username).get(), token);
        } catch (AuthenticationException e) {
            return new LoginResponseDTO(null, null); // Return a failed response
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return farmerPersonalInfoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("No user found with email: %s", email)));
    }

}
