package com.transsion.iotservice.iotcard.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class IotcardListMap extends GeneratedMessageLite<IotcardListMap, Builder> implements IotcardListMapOrBuilder {
    private static final IotcardListMap DEFAULT_INSTANCE;
    public static final int DISPLAY_TEMPLATES_FIELD_NUMBER = 1;
    private static volatile Parser<IotcardListMap> PARSER;
    private MapFieldLite<String, IotcardList> displayTemplates_ = MapFieldLite.emptyMapField();

    /* JADX INFO: renamed from: com.transsion.iotservice.iotcard.proto.IotcardListMap$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<IotcardListMap, Builder> implements IotcardListMapOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDisplayTemplates() {
            copyOnWrite();
            ((IotcardListMap) this.instance).getMutableDisplayTemplatesMap().clear();
            return this;
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
        public boolean containsDisplayTemplates(String str) {
            str.getClass();
            return ((IotcardListMap) this.instance).getDisplayTemplatesMap().containsKey(str);
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
        @Deprecated
        public Map<String, IotcardList> getDisplayTemplates() {
            return getDisplayTemplatesMap();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
        public int getDisplayTemplatesCount() {
            return ((IotcardListMap) this.instance).getDisplayTemplatesMap().size();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
        public Map<String, IotcardList> getDisplayTemplatesMap() {
            return Collections.unmodifiableMap(((IotcardListMap) this.instance).getDisplayTemplatesMap());
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
        public IotcardList getDisplayTemplatesOrDefault(String str, IotcardList iotcardList) {
            str.getClass();
            Map<String, IotcardList> displayTemplatesMap = ((IotcardListMap) this.instance).getDisplayTemplatesMap();
            return displayTemplatesMap.containsKey(str) ? displayTemplatesMap.get(str) : iotcardList;
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
        public IotcardList getDisplayTemplatesOrThrow(String str) {
            str.getClass();
            Map<String, IotcardList> displayTemplatesMap = ((IotcardListMap) this.instance).getDisplayTemplatesMap();
            if (displayTemplatesMap.containsKey(str)) {
                return displayTemplatesMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        public Builder putAllDisplayTemplates(Map<String, IotcardList> map) {
            copyOnWrite();
            ((IotcardListMap) this.instance).getMutableDisplayTemplatesMap().putAll(map);
            return this;
        }

        public Builder putDisplayTemplates(String str, IotcardList iotcardList) {
            str.getClass();
            iotcardList.getClass();
            copyOnWrite();
            ((IotcardListMap) this.instance).getMutableDisplayTemplatesMap().put(str, iotcardList);
            return this;
        }

        public Builder removeDisplayTemplates(String str) {
            str.getClass();
            copyOnWrite();
            ((IotcardListMap) this.instance).getMutableDisplayTemplatesMap().remove(str);
            return this;
        }

        private Builder() {
            super(IotcardListMap.DEFAULT_INSTANCE);
        }
    }

    public static final class DisplayTemplatesDefaultEntryHolder {
        static final MapEntryLite<String, IotcardList> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, IotcardList.getDefaultInstance());

        private DisplayTemplatesDefaultEntryHolder() {
        }
    }

    static {
        IotcardListMap iotcardListMap = new IotcardListMap();
        DEFAULT_INSTANCE = iotcardListMap;
        GeneratedMessageLite.registerDefaultInstance(IotcardListMap.class, iotcardListMap);
    }

    private IotcardListMap() {
    }

    public static IotcardListMap getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, IotcardList> getMutableDisplayTemplatesMap() {
        return internalGetMutableDisplayTemplates();
    }

    private MapFieldLite<String, IotcardList> internalGetDisplayTemplates() {
        return this.displayTemplates_;
    }

    private MapFieldLite<String, IotcardList> internalGetMutableDisplayTemplates() {
        if (!this.displayTemplates_.isMutable()) {
            this.displayTemplates_ = this.displayTemplates_.mutableCopy();
        }
        return this.displayTemplates_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static IotcardListMap parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (IotcardListMap) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IotcardListMap parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<IotcardListMap> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
    public boolean containsDisplayTemplates(String str) {
        str.getClass();
        return internalGetDisplayTemplates().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i8 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i8) {
            case 1:
                return new IotcardListMap();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"displayTemplates_", DisplayTemplatesDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<IotcardListMap> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (IotcardListMap.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
    @Deprecated
    public Map<String, IotcardList> getDisplayTemplates() {
        return getDisplayTemplatesMap();
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
    public int getDisplayTemplatesCount() {
        return internalGetDisplayTemplates().size();
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
    public Map<String, IotcardList> getDisplayTemplatesMap() {
        return Collections.unmodifiableMap(internalGetDisplayTemplates());
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
    public IotcardList getDisplayTemplatesOrDefault(String str, IotcardList iotcardList) {
        str.getClass();
        MapFieldLite<String, IotcardList> mapFieldLiteInternalGetDisplayTemplates = internalGetDisplayTemplates();
        return mapFieldLiteInternalGetDisplayTemplates.containsKey(str) ? mapFieldLiteInternalGetDisplayTemplates.get(str) : iotcardList;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardListMapOrBuilder
    public IotcardList getDisplayTemplatesOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, IotcardList> mapFieldLiteInternalGetDisplayTemplates = internalGetDisplayTemplates();
        if (mapFieldLiteInternalGetDisplayTemplates.containsKey(str)) {
            return mapFieldLiteInternalGetDisplayTemplates.get(str);
        }
        throw new IllegalArgumentException();
    }

    public static Builder newBuilder(IotcardListMap iotcardListMap) {
        return DEFAULT_INSTANCE.createBuilder(iotcardListMap);
    }

    public static IotcardListMap parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (IotcardListMap) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static IotcardListMap parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static IotcardListMap parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static IotcardListMap parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static IotcardListMap parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static IotcardListMap parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static IotcardListMap parseFrom(InputStream inputStream) throws IOException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IotcardListMap parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static IotcardListMap parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static IotcardListMap parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (IotcardListMap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
