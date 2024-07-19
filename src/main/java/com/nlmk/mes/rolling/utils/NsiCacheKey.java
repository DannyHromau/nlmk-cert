package com.nlmk.mes.rolling.utils;

import java.util.List;

public final class NsiCacheKey {

    public static final String MDM_MODEL_OBJECT = "mdm_model_object";
    public static final String MDM_OBJECT_PROTOTYPE = "mdm_object_prototype";
    public static final String MDM_PROPERTY_PRIMITIVE = "mdm_property_primitive";
    public static final String NSI_CERTIFICATION_OBJECT_MODEL = "nsi_certification_object_model";

    /**
     * Конструктор.
     */
    private NsiCacheKey() {
    }

    public static List<String> getKeys() {
        return List.of(MDM_MODEL_OBJECT, MDM_OBJECT_PROTOTYPE, MDM_PROPERTY_PRIMITIVE,
            NSI_CERTIFICATION_OBJECT_MODEL);
    }
}
