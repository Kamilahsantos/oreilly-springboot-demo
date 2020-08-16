package com.oreilly.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloControllerUnitTest {

    @Test
    public void sayHello() {
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = controller.sayHello("World", model);
        assertAll(
                () -> assertEquals("World", model.asMap().get("user")),
                () -> assertEquals("hello", result)
        );
    }

    @Test
    void sayHelloWithStub() {
        HelloController controller = new HelloController();
        Model mockModel = mock(Model.class);
        when(mockModel.addAttribute(anyString(), any())).thenReturn(mockModel);
        String result = controller.sayHello("Kamila", mockModel);
        assertEquals("hello", result);
    }
}