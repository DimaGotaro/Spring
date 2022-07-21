package org.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(CondB.class)
public class Bmess implements Mess{
    @Override
    public void tak() {
        System.out.println("Bmess");
    }
}
