package org.mvc2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class First {
    private Second second;

    @Autowired
    public First(Second second) {
        this.second = second;
    }
}
