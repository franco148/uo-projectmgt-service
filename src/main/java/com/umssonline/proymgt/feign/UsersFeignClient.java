package com.umssonline.proymgt.feign;

import com.umssonline.proymgt.models.dto.user.AssignedToResponseDto;
import com.umssonline.proymgt.models.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Component("authService")
@Component
@FeignClient("AUTH-SERVICE")
public interface UsersFeignClient {

    @RequestMapping
    (
        value = "/users/{user_id}",
        method = RequestMethod.GET,
        consumes = { "application/json" },
        produces = { "application/json" }
    )
    User findById(@PathVariable("user_id") final Long userId);

    @RequestMapping
    (
        value = "/users/{user_id}",
        method = RequestMethod.GET,
        consumes = { "application/json" },
        produces = { "application/json" }
    )
    AssignedToResponseDto getUser(@PathVariable("user_id") final  Long userId);
}
