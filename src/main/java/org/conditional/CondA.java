package org.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CondA implements Condition {
    private final static String type = System.getProperty("m_type") == null ? "local" : System.getProperty("m_type");
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return type.equals("local");
    }
}
