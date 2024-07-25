package com.nlmk.mes.rolling;

import java.util.List;

public class CommonCertificate {

  private String ts;
  private Operation op;
  private PkType pk;
  private SystemMetadata systemMetadata;
  private KafkaMetadata metadata;
  private Data data;

  public static class PkType {

    private String systemCode;
    private String id;
  }

  public static class SystemMetadata {

    private int seqId;
    private String traceId;
  }

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

  public static class Data {

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

  public static class Vehicle {

    private int vehicleType;
    private String vehicleNum;
    private String trailerNum;
  }

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

    public static class SpecValue {

        private String value;
        private String description;
    }

    public static class MetalUnit {

        private String Id;
        private int lineId;
        private Marking marking;
        private List<Specification> specifications;
    }

    public static class Marking {

        private int heat;
        private int slab;
        private int strand;
        private int hnum;
        private int roll;
        private int bundle;
        private int tnum;
    }

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

      public static class ValuesSpec {

        private String value;
        private String description;
      }

}
