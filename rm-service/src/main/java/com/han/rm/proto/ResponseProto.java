// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/protoc/Response.proto

package com.han.rm.proto;

public final class ResponseProto {
  private ResponseProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Response)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 response_status = 1;</code>
     */
    int getResponseStatus();

    /**
     * <code>int32 response_code = 2;</code>
     */
    int getResponseCode();

    /**
     * <code>string response_content = 3;</code>
     */
    java.lang.String getResponseContent();
    /**
     * <code>string response_content = 3;</code>
     */
    com.google.protobuf.ByteString
        getResponseContentBytes();
  }
  /**
   * Protobuf type {@code Response}
   */
  public  static final class Response extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Response)
      ResponseOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Response.newBuilder() to construct.
    private Response(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Response() {
      responseStatus_ = 0;
      responseCode_ = 0;
      responseContent_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Response(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              responseStatus_ = input.readInt32();
              break;
            }
            case 16: {

              responseCode_ = input.readInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              responseContent_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.han.rm.proto.ResponseProto.internal_static_Response_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.han.rm.proto.ResponseProto.internal_static_Response_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.han.rm.proto.ResponseProto.Response.class, com.han.rm.proto.ResponseProto.Response.Builder.class);
    }

    public static final int RESPONSE_STATUS_FIELD_NUMBER = 1;
    private int responseStatus_;
    /**
     * <code>int32 response_status = 1;</code>
     */
    public int getResponseStatus() {
      return responseStatus_;
    }

    public static final int RESPONSE_CODE_FIELD_NUMBER = 2;
    private int responseCode_;
    /**
     * <code>int32 response_code = 2;</code>
     */
    public int getResponseCode() {
      return responseCode_;
    }

    public static final int RESPONSE_CONTENT_FIELD_NUMBER = 3;
    private volatile java.lang.Object responseContent_;
    /**
     * <code>string response_content = 3;</code>
     */
    public java.lang.String getResponseContent() {
      java.lang.Object ref = responseContent_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        responseContent_ = s;
        return s;
      }
    }
    /**
     * <code>string response_content = 3;</code>
     */
    public com.google.protobuf.ByteString
        getResponseContentBytes() {
      java.lang.Object ref = responseContent_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        responseContent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (responseStatus_ != 0) {
        output.writeInt32(1, responseStatus_);
      }
      if (responseCode_ != 0) {
        output.writeInt32(2, responseCode_);
      }
      if (!getResponseContentBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, responseContent_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (responseStatus_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, responseStatus_);
      }
      if (responseCode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, responseCode_);
      }
      if (!getResponseContentBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, responseContent_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.han.rm.proto.ResponseProto.Response)) {
        return super.equals(obj);
      }
      com.han.rm.proto.ResponseProto.Response other = (com.han.rm.proto.ResponseProto.Response) obj;

      boolean result = true;
      result = result && (getResponseStatus()
          == other.getResponseStatus());
      result = result && (getResponseCode()
          == other.getResponseCode());
      result = result && getResponseContent()
          .equals(other.getResponseContent());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + RESPONSE_STATUS_FIELD_NUMBER;
      hash = (53 * hash) + getResponseStatus();
      hash = (37 * hash) + RESPONSE_CODE_FIELD_NUMBER;
      hash = (53 * hash) + getResponseCode();
      hash = (37 * hash) + RESPONSE_CONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getResponseContent().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.han.rm.proto.ResponseProto.Response parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.han.rm.proto.ResponseProto.Response parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.han.rm.proto.ResponseProto.Response parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.han.rm.proto.ResponseProto.Response parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.han.rm.proto.ResponseProto.Response parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.han.rm.proto.ResponseProto.Response parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.han.rm.proto.ResponseProto.Response parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.han.rm.proto.ResponseProto.Response parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.han.rm.proto.ResponseProto.Response parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.han.rm.proto.ResponseProto.Response parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.han.rm.proto.ResponseProto.Response parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.han.rm.proto.ResponseProto.Response parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.han.rm.proto.ResponseProto.Response prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Response}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Response)
        com.han.rm.proto.ResponseProto.ResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.han.rm.proto.ResponseProto.internal_static_Response_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.han.rm.proto.ResponseProto.internal_static_Response_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.han.rm.proto.ResponseProto.Response.class, com.han.rm.proto.ResponseProto.Response.Builder.class);
      }

      // Construct using com.han.rm.proto.ResponseProto.Response.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        responseStatus_ = 0;

        responseCode_ = 0;

        responseContent_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.han.rm.proto.ResponseProto.internal_static_Response_descriptor;
      }

      public com.han.rm.proto.ResponseProto.Response getDefaultInstanceForType() {
        return com.han.rm.proto.ResponseProto.Response.getDefaultInstance();
      }

      public com.han.rm.proto.ResponseProto.Response build() {
        com.han.rm.proto.ResponseProto.Response result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.han.rm.proto.ResponseProto.Response buildPartial() {
        com.han.rm.proto.ResponseProto.Response result = new com.han.rm.proto.ResponseProto.Response(this);
        result.responseStatus_ = responseStatus_;
        result.responseCode_ = responseCode_;
        result.responseContent_ = responseContent_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.han.rm.proto.ResponseProto.Response) {
          return mergeFrom((com.han.rm.proto.ResponseProto.Response)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.han.rm.proto.ResponseProto.Response other) {
        if (other == com.han.rm.proto.ResponseProto.Response.getDefaultInstance()) return this;
        if (other.getResponseStatus() != 0) {
          setResponseStatus(other.getResponseStatus());
        }
        if (other.getResponseCode() != 0) {
          setResponseCode(other.getResponseCode());
        }
        if (!other.getResponseContent().isEmpty()) {
          responseContent_ = other.responseContent_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.han.rm.proto.ResponseProto.Response parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.han.rm.proto.ResponseProto.Response) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int responseStatus_ ;
      /**
       * <code>int32 response_status = 1;</code>
       */
      public int getResponseStatus() {
        return responseStatus_;
      }
      /**
       * <code>int32 response_status = 1;</code>
       */
      public Builder setResponseStatus(int value) {
        
        responseStatus_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 response_status = 1;</code>
       */
      public Builder clearResponseStatus() {
        
        responseStatus_ = 0;
        onChanged();
        return this;
      }

      private int responseCode_ ;
      /**
       * <code>int32 response_code = 2;</code>
       */
      public int getResponseCode() {
        return responseCode_;
      }
      /**
       * <code>int32 response_code = 2;</code>
       */
      public Builder setResponseCode(int value) {
        
        responseCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 response_code = 2;</code>
       */
      public Builder clearResponseCode() {
        
        responseCode_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object responseContent_ = "";
      /**
       * <code>string response_content = 3;</code>
       */
      public java.lang.String getResponseContent() {
        java.lang.Object ref = responseContent_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          responseContent_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string response_content = 3;</code>
       */
      public com.google.protobuf.ByteString
          getResponseContentBytes() {
        java.lang.Object ref = responseContent_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          responseContent_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string response_content = 3;</code>
       */
      public Builder setResponseContent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        responseContent_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string response_content = 3;</code>
       */
      public Builder clearResponseContent() {
        
        responseContent_ = getDefaultInstance().getResponseContent();
        onChanged();
        return this;
      }
      /**
       * <code>string response_content = 3;</code>
       */
      public Builder setResponseContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        responseContent_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Response)
    }

    // @@protoc_insertion_point(class_scope:Response)
    private static final com.han.rm.proto.ResponseProto.Response DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.han.rm.proto.ResponseProto.Response();
    }

    public static com.han.rm.proto.ResponseProto.Response getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Response>
        PARSER = new com.google.protobuf.AbstractParser<Response>() {
      public Response parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Response(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Response> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Response> getParserForType() {
      return PARSER;
    }

    public com.han.rm.proto.ResponseProto.Response getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Response_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Response_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032main/protoc/Response.proto\"T\n\010Response" +
      "\022\027\n\017response_status\030\001 \001(\005\022\025\n\rresponse_co" +
      "de\030\002 \001(\005\022\030\n\020response_content\030\003 \001(\tB!\n\020co" +
      "m.han.rm.protoB\rResponseProtob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Response_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Response_descriptor,
        new java.lang.String[] { "ResponseStatus", "ResponseCode", "ResponseContent", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}