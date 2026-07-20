package com.transsion.iotservice.iotcard.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class IotcardList extends GeneratedMessageLite<IotcardList, Builder> implements IotcardListOrBuilder {
    private static final IotcardList DEFAULT_INSTANCE;
    public static final int IOTCARD_BEAN_FIELD_NUMBER = 1;
    private static volatile Parser<IotcardList> PARSER;
    private Internal.ProtobufList<IotcardBean> iotcardBean_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.transsion.iotservice.iotcard.proto.IotcardList$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<IotcardList, Builder> implements IotcardListOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllIotcardBean(Iterable<? extends IotcardBean> iterable) {
            copyOnWrite();
            ((IotcardList) this.instance).addAllIotcardBean(iterable);
            return this;
        }

        public Builder addIotcardBean(IotcardBean iotcardBean) {
            copyOnWrite();
            ((IotcardList) this.instance).addIotcardBean(iotcardBean);
            return this;
        }

        public Builder clearIotcardBean() {
            copyOnWrite();
            ((IotcardList) this.instance).clearIotcardBean();
            return this;
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardListOrBuilder
        public IotcardBean getIotcardBean(int i8) {
            return ((IotcardList) this.instance).getIotcardBean(i8);
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardListOrBuilder
        public int getIotcardBeanCount() {
            return ((IotcardList) this.instance).getIotcardBeanCount();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardListOrBuilder
        public List<IotcardBean> getIotcardBeanList() {
            return Collections.unmodifiableList(((IotcardList) this.instance).getIotcardBeanList());
        }

        public Builder removeIotcardBean(int i8) {
            copyOnWrite();
            ((IotcardList) this.instance).removeIotcardBean(i8);
            return this;
        }

        public Builder setIotcardBean(int i8, IotcardBean iotcardBean) {
            copyOnWrite();
            ((IotcardList) this.instance).setIotcardBean(i8, iotcardBean);
            return this;
        }

        private Builder() {
            super(IotcardList.DEFAULT_INSTANCE);
        }

        public Builder addIotcardBean(int i8, IotcardBean iotcardBean) {
            copyOnWrite();
            ((IotcardList) this.instance).addIotcardBean(i8, iotcardBean);
            return this;
        }

        public Builder setIotcardBean(int i8, IotcardBean.Builder builder) {
            copyOnWrite();
            ((IotcardList) this.instance).setIotcardBean(i8, builder.build());
            return this;
        }

        public Builder addIotcardBean(IotcardBean.Builder builder) {
            copyOnWrite();
            ((IotcardList) this.instance).addIotcardBean(builder.build());
            return this;
        }

        public Builder addIotcardBean(int i8, IotcardBean.Builder builder) {
            copyOnWrite();
            ((IotcardList) this.instance).addIotcardBean(i8, builder.build());
            return this;
        }
    }

    static {
        IotcardList iotcardList = new IotcardList();
        DEFAULT_INSTANCE = iotcardList;
        GeneratedMessageLite.registerDefaultInstance(IotcardList.class, iotcardList);
    }

    private IotcardList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIotcardBean(Iterable<? extends IotcardBean> iterable) {
        ensureIotcardBeanIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.iotcardBean_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIotcardBean(IotcardBean iotcardBean) {
        iotcardBean.getClass();
        ensureIotcardBeanIsMutable();
        this.iotcardBean_.add(iotcardBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIotcardBean() {
        this.iotcardBean_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureIotcardBeanIsMutable() {
        Internal.ProtobufList<IotcardBean> protobufList = this.iotcardBean_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.iotcardBean_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static IotcardList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static IotcardList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (IotcardList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IotcardList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<IotcardList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeIotcardBean(int i8) {
        ensureIotcardBeanIsMutable();
        this.iotcardBean_.remove(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIotcardBean(int i8, IotcardBean iotcardBean) {
        iotcardBean.getClass();
        ensureIotcardBeanIsMutable();
        this.iotcardBean_.set(i8, iotcardBean);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i8 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i8) {
            case 1:
                return new IotcardList();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"iotcardBean_", IotcardBean.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<IotcardList> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (IotcardList.class) {
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

    @Override // com.transsion.iotservice.iotcard.proto.IotcardListOrBuilder
    public IotcardBean getIotcardBean(int i8) {
        return this.iotcardBean_.get(i8);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardListOrBuilder
    public int getIotcardBeanCount() {
        return this.iotcardBean_.size();
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardListOrBuilder
    public List<IotcardBean> getIotcardBeanList() {
        return this.iotcardBean_;
    }

    public IotcardBeanOrBuilder getIotcardBeanOrBuilder(int i8) {
        return this.iotcardBean_.get(i8);
    }

    public List<? extends IotcardBeanOrBuilder> getIotcardBeanOrBuilderList() {
        return this.iotcardBean_;
    }

    public static Builder newBuilder(IotcardList iotcardList) {
        return DEFAULT_INSTANCE.createBuilder(iotcardList);
    }

    public static IotcardList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (IotcardList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static IotcardList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static IotcardList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIotcardBean(int i8, IotcardBean iotcardBean) {
        iotcardBean.getClass();
        ensureIotcardBeanIsMutable();
        this.iotcardBean_.add(i8, iotcardBean);
    }

    public static IotcardList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static IotcardList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static IotcardList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static IotcardList parseFrom(InputStream inputStream) throws IOException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IotcardList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static IotcardList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static IotcardList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (IotcardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
