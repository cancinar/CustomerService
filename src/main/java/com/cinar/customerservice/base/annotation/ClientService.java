package com.cinar.customerservice.base.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.stereotype.Service;

@Target(TYPE)
@Retention(RUNTIME)
@Documented
@Service
@Inherited
public @interface ClientService {

}
