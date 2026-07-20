package com.transsion.iotservice.iotcard.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class SwitchClickAction extends GeneratedMessageLite<SwitchClickAction, Builder> implements SwitchClickActionOrBuilder {
    public static final int CONTROL_ID_FIELD_NUMBER = 1;
    private static final SwitchClickAction DEFAULT_INSTANCE;
    public static final int DEVICE_SWITCH_FIELD_NUMBER = 2;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 4;
    private static volatile Parser<SwitchClickAction> PARSER = null;
    public static final int PID_FIELD_NUMBER = 3;
    private boolean deviceSwitch_;
    private String controlId_ = "";
    private String pid_ = "";
    private String packageName_ = "";

    /* JADX INFO: renamed from: com.transsion.iotservice.iotcard.proto.SwitchClickAction$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SwitchClickAction, Builder> implements SwitchClickActionOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearControlId() {
            copyOnWrite();
            ((SwitchClickAction) this.instance).clearControlId();
            return this;
        }

        public Builder clearDeviceSwitch() {
            copyOnWrite();
            ((SwitchClickAction) this.instance).clearDeviceSwitch();
            return this;
        }

        public Builder clearPackageName() {
            copyOnWrite();
            ((SwitchClickAction) this.instance).clearPackageName();
            return this;
        }

        public Builder clearPid() {
            copyOnWrite();
            ((SwitchClickAction) this.instance).clearPid();
            return this;
        }

        @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
        public String getControlId() {
            return ((SwitchClickAction) this.instance).getControlId();
        }

        @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
        public ByteString getControlIdBytes() {
            return ((SwitchClickAction) this.instance).getControlIdBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
        public boolean getDeviceSwitch() {
            return ((SwitchClickAction) this.instance).getDeviceSwitch();
        }

        @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
        public String getPackageName() {
            return ((SwitchClickAction) this.instance).getPackageName();
        }

        @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
        public ByteString getPackageNameBytes() {
            return ((SwitchClickAction) this.instance).getPackageNameBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
        public String getPid() {
            return ((SwitchClickAction) this.instance).getPid();
        }

        @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
        public ByteString getPidBytes() {
            return ((SwitchClickAction) this.instance).getPidBytes();
        }

        public Builder setControlId(String str) {
            copyOnWrite();
            ((SwitchClickAction) this.instance).setControlId(str);
            return this;
        }

        public Builder setControlIdBytes(ByteString byteString) {
            copyOnWrite();
            ((SwitchClickAction) this.instance).setControlIdBytes(byteString);
            return this;
        }

        public Builder setDeviceSwitch(boolean z2) {
            copyOnWrite();
            ((SwitchClickAction) this.instance).setDeviceSwitch(z2);
            return this;
        }

        public Builder setPackageName(String str) {
            copyOnWrite();
            ((SwitchClickAction) this.instance).setPackageName(str);
            return this;
        }

        public Builder setPackageNameBytes(ByteString byteString) {
            copyOnWrite();
            ((SwitchClickAction) this.instance).setPackageNameBytes(byteString);
            return this;
        }

        public Builder setPid(String str) {
            copyOnWrite();
            ((SwitchClickAction) this.instance).setPid(str);
            return this;
        }

        public Builder setPidBytes(ByteString byteString) {
            copyOnWrite();
            ((SwitchClickAction) this.instance).setPidBytes(byteString);
            return this;
        }

        private Builder() {
            super(SwitchClickAction.DEFAULT_INSTANCE);
        }
    }

    static {
        SwitchClickAction switchClickAction = new SwitchClickAction();
        DEFAULT_INSTANCE = switchClickAction;
        GeneratedMessageLite.registerDefaultInstance(SwitchClickAction.class, switchClickAction);
    }

    private SwitchClickAction() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearControlId() {
        this.controlId_ = getDefaultInstance().getControlId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceSwitch() {
        this.deviceSwitch_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPackageName() {
        this.packageName_ = getDefaultInstance().getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPid() {
        this.pid_ = getDefaultInstance().getPid();
    }

    public static SwitchClickAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SwitchClickAction parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SwitchClickAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SwitchClickAction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SwitchClickAction> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControlId(String str) {
        str.getClass();
        this.controlId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControlIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.controlId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceSwitch(boolean z2) {
        this.deviceSwitch_ = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageName(String str) {
        str.getClass();
        this.packageName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.packageName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPid(String str) {
        str.getClass();
        this.pid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPidBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.pid_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i8 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i8) {
            case 1:
                return new SwitchClickAction();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0007\u0003Ȉ\u0004Ȉ", new Object[]{"controlId_", "deviceSwitch_", "pid_", "packageName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SwitchClickAction> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (SwitchClickAction.class) {
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

    @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
    public String getControlId() {
        return this.controlId_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
    public ByteString getControlIdBytes() {
        return ByteString.copyFromUtf8(this.controlId_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
    public boolean getDeviceSwitch() {
        return this.deviceSwitch_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
    public String getPackageName() {
        return this.packageName_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
    public ByteString getPackageNameBytes() {
        return ByteString.copyFromUtf8(this.packageName_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
    public String getPid() {
        return this.pid_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.SwitchClickActionOrBuilder
    public ByteString getPidBytes() {
        return ByteString.copyFromUtf8(this.pid_);
    }

    public static Builder newBuilder(SwitchClickAction switchClickAction) {
        return DEFAULT_INSTANCE.createBuilder(switchClickAction);
    }

    public static SwitchClickAction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SwitchClickAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SwitchClickAction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SwitchClickAction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SwitchClickAction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SwitchClickAction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SwitchClickAction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SwitchClickAction parseFrom(InputStream inputStream) throws IOException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SwitchClickAction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SwitchClickAction parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SwitchClickAction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SwitchClickAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
