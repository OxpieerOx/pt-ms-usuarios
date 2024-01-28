package com.intech.ptmsusuarios.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
public class ServiceResponse implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  private String code;
  private String message;
  @Nullable
  private String error;
  @Nullable
  private transient Object data;
}
