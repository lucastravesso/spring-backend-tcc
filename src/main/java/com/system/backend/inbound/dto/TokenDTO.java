package com.system.backend.inbound.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TokenDTO {

    private String token;
    private String type;
}
