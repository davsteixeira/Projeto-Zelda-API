package com.github.userApi.service;
import com.github.userApi.dto.User;
import com.github.userApi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private List<User> userList;

    @BeforeEach
    public void setUp() {
        userList = new ArrayList<>();
        userList.add(new User(1L, "Luffy", 20));
        userList.add(new User(2L, "Sanji", 21));
    }

    @Test
    public void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userService.getAllUsers();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetUserById_WhenUserExists() {
        User user = userList.get(0);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Luffy", result.getNome());
        assertEquals(20, result.getIdade());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetUserById_WhenUserDoesNotExist() {
        when(userRepository.findById(3L)).thenReturn(Optional.empty());

        User result = userService.getUserById(3L);

        assertNull(result);
        verify(userRepository, times(1)).findById(3L);
    }

    @Test
    public void testSaveUser() {
        User newUser = new User(3L, "Charlie", 28);
        userService.saveUser(newUser);
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    public void testUpdateUser_WhenUserExists() {
        User existingUser = new User(2L, "Sanji", 21);
        when(userRepository.existsById(2L)).thenReturn(true);

        userService.updateUser(existingUser);

        verify(userRepository, times(1)).existsById(2L);
        verify(userRepository, times(1)).save(existingUser);
    }

    @Test
    public void testUpdateUser_WhenUserDoesNotExist() {
        User newUser = new User(4L, "David", 35);
        when(userRepository.existsById(4L)).thenReturn(false);

        userService.updateUser(newUser);

        verify(userRepository, times(1)).existsById(4L);
        verify(userRepository, never()).save(newUser);
    }

    @Test
    public void testDeleteUser() {
        userService.delete(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}


