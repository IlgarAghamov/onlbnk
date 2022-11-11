package com.example.onlbnk.service.ServiceImpliment;


import com.example.onlbnk.model.User;
import com.example.onlbnk.repository.UserRepository;
import com.example.onlbnk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);


        return user.orElseGet(User::new);

    }

    @Override
    public User createUser(User user) {

        boolean b =true;
        while (b){
            if (user.getUserLogin().length() < 5 & user.getUserLogin().length() > 10) {
                System.out.println("Wrong symbols");
            } else if (user.getUserPassword().length() < 5 & user.getUserPassword().length() > 10) {
                System.out.println("Wrong symbols");
            } else {
                b=false;
            }

        }
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.ifPresent(userRepository::delete);
            return true;
        }else{
            return false;}

    }


    @Override
    public User updateUser(User user) {
        userRepository.findById(user.getUserId());
        return userRepository.save(user);
    }





}

