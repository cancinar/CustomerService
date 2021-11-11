package com.cinar.customerservice.base.usecase;

@FunctionalInterface
public interface ConsumerUseCase<I extends Input> {

    void run(I input);
}
