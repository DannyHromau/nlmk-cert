package com.nlmk.mes.rolling.certification.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Складские операции", description = "Интерфейс для выполнения складских операций")
@RequiredArgsConstructor
@RestController
@RequestMapping("/operation")
public class CertificationOperationController {

}
