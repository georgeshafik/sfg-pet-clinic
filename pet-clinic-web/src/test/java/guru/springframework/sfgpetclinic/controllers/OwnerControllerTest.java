package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    // Setup controllers injecting the mocks
    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    // Spring MVC - setups up the controller for testing
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        // Very light weight (no server)
        // for each test method this simulates a mock environment
        // for each controller - so we can test a number of different interactions with this
        // so the model is mocked for us also.
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void listOwners() throws Exception {
        // this setups up our mock in our action
        when(ownerService.findAll()).thenReturn(owners);

        // Expecting a return status of ok i.e 200
        // Expecting a view sent back of "owners/index"
        // Expecting a model of the size of 2
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2))); // if we say 4 instead of 2 it fails
    }


    // Test a different path
    @Test
    void listOwnersByIndex() throws Exception {
        // this setups up our mock in our action
        when(ownerService.findAll()).thenReturn(owners);

        // Expecting a return status of ok i.e 200
        // Expecting a view sent back of "owners/index"
        // Expecting a model of the size of 2
        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2))); // if we say 4 instead of 2 it fails
    }

    @Test
    void findOwners() throws Exception {

        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyZeroInteractions(ownerService);
    }
}
