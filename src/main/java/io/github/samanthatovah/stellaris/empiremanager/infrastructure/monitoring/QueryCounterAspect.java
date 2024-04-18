package io.github.samanthatovah.stellaris.empiremanager.infrastructure.monitoring;

import lombok.Getter;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Getter
@Aspect
@Component
public class QueryCounterAspect {

    private long queryCount = 0;

    @Pointcut("execution(* org.springframework.data.repository.Repository+.*(..))")
    public void repositoryMethods() {
    }

    @Before("repositoryMethods()")
    public void countQuery() {
        queryCount++;
    }

    public void resetCount() {
        queryCount = 0;
    }
}
