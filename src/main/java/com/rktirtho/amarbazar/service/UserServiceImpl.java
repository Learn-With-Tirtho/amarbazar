package com.rktirtho.amarbazar.service;

import com.rktirtho.amarbazar.model.UserRegistrationRequest;
import com.rktirtho.amarbazar.repository.UserRepository;

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
}
