package org.mvc2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Second extends First {
    public final First first;

    @Autowired
    public Second(First first) {
        super((Second) first);
        this.first = first;
    }
}
