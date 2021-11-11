package com.cinar.customerservice.base.usecase;

public interface UseCase<I extends Input, O extends Output> {

    O run(I input);
}
