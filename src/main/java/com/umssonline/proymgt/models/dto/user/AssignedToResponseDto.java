package com.umssonline.proymgt.models.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "User Model")
@Getter
@Setter
public class AssignedToResponseDto {

    @ApiModelProperty
    (
        notes = "Id field should not be null or empty.",
        required = true
    )
    private Long id;

    @ApiModelProperty
    (
        notes = "Name field should not be null or empty.",
        required = true
    )
    private String name;

    @ApiModelProperty
    (
        notes = "Last Name field should not be null or empty.",
        required = true
    )
    private String lastName;

    @ApiModelProperty
    (
        notes = "Nick Name field should not be null or empty.",
        required = true
    )
    private String nickName;
}
