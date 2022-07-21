package org.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(CondA.class)
public class Amess implements Mess{
    @Override
    public void tak() {
        System.out.println("Amess");
    }
}
