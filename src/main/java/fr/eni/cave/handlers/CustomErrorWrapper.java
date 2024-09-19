package fr.eni.cave.handlers;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CustomErrorWrapper {
    private List<String> messages = new ArrayList<>();

    public void addMessage(String message) {
        this.messages.add(message);
    }
}
