package com.supportportal.service;

import com.supportportal.domain.User;
import com.supportportal.exception.domain.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage,String rank,String job, String offre, String prefoffre,String experience,User manager) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException, MessagingException;

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage,String rank,String job, String offre, String prefoffre,String experience,User manager) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

    void deleteUser(String username) throws IOException;

    void resetPassword(String email) throws MessagingException, EmailNotFoundException;

    User updateProfileImage(String username, MultipartFile profileImage,String imageName) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;
    
    void verifyOTP(String code, String email)throws MessagingException, EmailNotFoundException;
    
    User updatePassword(String newPassword,String checkPassword,String userName)throws UserNotFoundException;
    
    User updateRank(String userName)throws UserNotFoundException, HighRankException;
}
