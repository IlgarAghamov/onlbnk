package com.example.onlbnk.MainTest;


import com.example.onlbnk.model.User;
import com.example.onlbnk.repository.UserRepository;
import com.example.onlbnk.service.registrationAndVerification.Registration;
import com.example.onlbnk.service.registrationAndVerification.Verification;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class Main {
    private  UserRepository userRepository ;



    public void n() throws ClassNotFoundException {
        List<User> user=userRepository.findAll();
            Registration registration = new Registration((UserRepository) user);
        Verification verification=new Verification();
        verification.verification(user);
        }


    public static void main(String[] args) throws ClassNotFoundException {
        Main main=new Main();
        main.n();
    }



}
