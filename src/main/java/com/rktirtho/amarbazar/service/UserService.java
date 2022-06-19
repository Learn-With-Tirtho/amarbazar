package com.rktirtho.amarbazar.service;

import com.rktirtho.amarbazar.model.UserRegistrationRequest;
import com.rktirtho.amarbazar.model.UserResponse;

import java.util.List;

public interface UserService {

    int save(UserRegistrationRequest registrationRequest);

    boolean login(String email, String password);
    List<UserResponse> getAllUser();
}
