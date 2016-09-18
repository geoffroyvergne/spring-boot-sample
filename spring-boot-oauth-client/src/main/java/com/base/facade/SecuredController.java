package com.base.facade;

import com.base.model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/secured")
public class SecuredController {
    @RequestMapping("/test")
    public ResponseEntity<Status> securedCall() {
        return new ResponseEntity<>(new Status(0, "id : " + UUID.randomUUID().toString().toUpperCase()), HttpStatus.OK);
    }
}
