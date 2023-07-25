package com.green.alpha.service;

import com.green.alpha.dto.UserDTO;
import com.green.alpha.mapper.UserMapper;
import com.green.alpha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.green.alpha.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save (UserDTO userDTO){
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        User userSaved = userRepository.save(user);
        UserDTO userDTOSaved = UserMapper.INSTANCE.toDto(userSaved);
        return userDTOSaved;
    }

    public UserDTO findById(Long id){
        User user = userRepository.findById(id).get();
        return UserMapper.INSTANCE.toDto(user);
    }

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO =  new ArrayList<>();
        for(User user: users){
            //System.out.println(user.toString());
            UserDTO userDTO = UserMapper.INSTANCE.toDto(user);
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }

}
