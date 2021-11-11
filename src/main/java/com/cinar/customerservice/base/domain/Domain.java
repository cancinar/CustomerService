package com.cinar.customerservice.base.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public abstract class Domain implements Serializable {
}
