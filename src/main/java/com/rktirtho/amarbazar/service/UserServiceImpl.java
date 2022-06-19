package com.rktirtho.amarbazar.service;

import com.rktirtho.amarbazar.model.UserRegistrationRequest;
import com.rktirtho.amarbazar.model.UserResponse;
import com.rktirtho.amarbazar.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public int save(UserRegistrationRequest registrationRequest) {
        UserRepository repository = new UserRepository();
        boolean isUserExist = repository.getUserByEmail(registrationRequest.getEmail());
        if (isUserExist){
            return -1;
        }
        return repository.saveUser(registrationRequest);
    }

    @Override
    public boolean login(String email, String password) {
        UserRepository repository = new UserRepository();
        return repository.findUserByCredential(email, password);
    }

    @Override
    public List<UserResponse> getAllUser() {
        UserRepository repository = new UserRepository();
        return repository.getAllUser();
    }


}
