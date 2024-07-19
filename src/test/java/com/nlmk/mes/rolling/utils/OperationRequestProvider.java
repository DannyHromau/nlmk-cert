package com.nlmk.mes.rolling.utils;

import com.nlmk.attributes.utils.AttributeConverterUtils;
import com.nlmk.mes.rolling.warehouse.model.OperationRequest;
import com.nlmk.mes.rolling.warehouse.model.OperationType;
import com.nlmk.mes.rolling.warehouse.model.WarehouseUnitOperationRequest;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class OperationRequestProvider {

    public static OperationRequest getCreateRequest() {
        var operType = OperationType.builder().code(42).build();
        var unitRequest = WarehouseUnitOperationRequest.builder()
                .unitRequiredAttributeGroupId(UUID.fromString("16e7e3f4-8022-42d1-90b8-3d74809b626b"))
                .attributes(Map.of(2,
                        AttributeConverterUtils.getAttributeValue(1),
                        1,
                        AttributeConverterUtils.getAttributeValue("123")))
                .build();
        return OperationRequest.builder()
                .operType(operType)
                .accDate(Instant.now())
                .warehouseUnitOperationRequest(unitRequest)
                .warehousePlaceTypeId(UUID.fromString("975051c0-6d07-436d-8883-abb3ce8d1b19"))
                .warehouseId(UUID.fromString("975051c0-6d07-436d-8883-abb3ce8d1b19"))
                .storageId(UUID.fromString("703a0a79-7a75-4780-891e-7ae79b8f57c4"))
                .build();
    }

    public static OperationRequest getPlaceRequest(UUID unitId, Instant time) {
        var operType = OperationType.builder().code(214).build();
        var unitRequest = WarehouseUnitOperationRequest.builder()
                .warehouseUnitId(unitId)
                .build();
        return OperationRequest.builder()
                .operType(operType)
                .accDate(time)
                .warehouseUnitOperationRequest(unitRequest)
                .warehouseId(UUID.fromString("b6dc59a4-46f1-4762-bba0-87dfe5b32c32"))
                .storageId(UUID.fromString("df6351ed-6df0-41a6-80fc-27bdcecfb25a"))
                .build();
    }

    public static OperationRequest getCloseRequest(UUID unitId, Instant time) {
        var operType = OperationType.builder().code(211).build();
        var unitRequest = WarehouseUnitOperationRequest.builder()
                .warehouseUnitId(unitId)
                .build();
        return OperationRequest.builder()
                .operType(operType)
                .accDate(time)
                .warehouseUnitOperationRequest(unitRequest)
                .warehousePlaceTypeId(UUID.fromString("975051c0-6d07-436d-8883-abb3ce8d1b19"))
                .build();
    }
}
