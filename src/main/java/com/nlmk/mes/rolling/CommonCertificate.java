package com.nlmk.mes.rolling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonCertificate {

    private Instant ts;
    private EnumOp op;
    private PkType pk;
    private SystemMetadata systemMetadata;
    private KafkaMetadata metadata;
    private MessageData data;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PkType {

        private String systemCode;
        private String id;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SystemMetadata {

        private int seqId;
        private String traceId;
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class KafkaMetadata {

        private int kafkaKeySchemaId;
        private int kafkaValueSchemaId;
        private String kafkaKey;
        private int kafkaPartition;
        private long kafkaOffset;
        private String kafkaTimestamp;
        private String kafkaTopic;
        private String kafkaHeaders;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MessageData {

        private int werks;
        private String werksName;
        private int workshop;
        private String workshopid;
        private String workshopName;
        private long certNum;
        private int certYear;
        private String creationDate;
        private String regDate;
        private int accShift;
        private int orderNum;
        private int orderPos;
        private Vehicle vehicle;
        private String certQR;
        private List<AttrCert> attrCert;
        private List<MetalUnit> metalUnits;
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Vehicle {

        private int vehicleType;
        private String vehicleNum;
        private String trailerNum;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AttrCert {

        private int specСode;
        private String specName;
        private int specTypeCode;
        private String specTypeName;
        private int specTypeValue;
        private String specValue;
        private List<SpecValue> listSpecValues;
        private String specDecryption;
        private String specFormat;
        private String specMeasure;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SpecValue {

        private String value;
        private String description;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MetalUnit {

        private String Id;
        private int lineId;
        private Marking marking;
        private List<Specification> specifications;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Marking {

        private int heat;
        private int slab;
        private int strand;
        private int hnum;
        private int roll;
        private int bundle;
        private int tnum;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Specification {

        private int specCode;
        private String specName;
        private int specTypeCode;
        private String specTypeName;
        private int specTypeValue;
        private String specValue;
        private List<ValuesSpec> listValuesSpec;
        private String specDecryption;
        private String specFormat;
        private String specMeasure;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ValuesSpec {

        private String value;
        private String description;
    }
}
