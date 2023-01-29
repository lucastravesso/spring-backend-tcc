package com.system.backend.core.service;

import com.system.backend.core.entity.User;
import com.system.backend.core.repository.UserRepository;
import com.system.backend.core.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAUser() {
        when(userRepository.findByIdAndActive(any())).thenReturn(this.createUser());
        User user = userService.getUser(UUID.fromString("7c3249a8-2811-411d-9e8d-4330c6befb42"));
        assertNotNull(user);
        assertTrue(user.isActive());
        assertEquals("mail@mail", user.getMail());
    }


    private User createUser() {
        return User.builder()
                .id(UUID.fromString("7c3249a8-2811-411d-9e8d-4330c6befb42"))
                .active(true)
                .insertionDate(LocalDate.now())
                .userName("Test User")
                .mail("mail@mail")
                .build();
    }
}
