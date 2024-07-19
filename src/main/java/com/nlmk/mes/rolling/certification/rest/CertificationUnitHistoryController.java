package com.nlmk.mes.rolling.certification.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Складская единица", description = "Интерфейс для работы со складскими единицами")
@RequiredArgsConstructor
@RestController
@RequestMapping("/unit/history")
public class CertificationUnitHistoryController {

}
