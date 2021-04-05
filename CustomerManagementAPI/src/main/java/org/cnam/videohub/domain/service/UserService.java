package org.cnam.videohub.domain.service;

import org.cnam.videohub.domain.entity.User;
import org.cnam.videohub.domain.entity.UserToCreate;
import org.cnam.videohub.domain.entity.UserToRegister;
import org.cnam.videohub.repository.UserRepository;
import org.cnam.videohub.repository.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(Long id) {
        UserModel entityUserFound = userRepository.getOne(id);
        return new User(entityUserFound.getId(), entityUserFound.getName(), entityUserFound.getFirstname(), entityUserFound.getMail(), entityUserFound.getFidelity_points());
    }

    public User create(UserToCreate userToCreate) {
        UserModel entityUserToCreate = new UserModel(userToCreate.name, userToCreate.firstname, userToCreate.mail, userToCreate.fidelity_points);
        UserModel entityUserCreated = userRepository.save(entityUserToCreate);
        return new User(entityUserCreated.getId(), entityUserCreated.getName(), entityUserCreated.getFirstname(), entityUserCreated.getMail(), entityUserCreated.getFidelity_points());
    }

    public User register(UserToRegister userToRegister) {
        UserModel entityUserToCreate = new UserModel(userToRegister.name, userToRegister.firstname, userToRegister.mail, FidelityPointsService.BONUSES.NEW_MEMBER_BONUS.getValue());
        UserModel entityUserCreated = userRepository.save(entityUserToCreate);
        return new User(entityUserCreated.getId(), entityUserCreated.getName(), entityUserCreated.getFirstname(), entityUserCreated.getMail(), entityUserCreated.getFidelity_points());
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User userToUpdate) {
        UserModel entityUserToUpdate = new UserModel(userToUpdate.id, userToUpdate.name, userToUpdate.firstname, userToUpdate.mail, userToUpdate.fidelity_points);
        UserModel entityUserUpdated = userRepository.save(entityUserToUpdate);
        return new User(entityUserUpdated.getId(), entityUserUpdated.getName(), entityUserUpdated.getFirstname(), entityUserUpdated.getMail(), entityUserUpdated.getFidelity_points());
    }



}
