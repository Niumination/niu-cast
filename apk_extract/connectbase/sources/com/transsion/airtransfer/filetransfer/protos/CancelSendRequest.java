package com.transsion.airtransfer.filetransfer.protos;

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
public final class CancelSendRequest extends GeneratedMessageLite<CancelSendRequest, Builder> implements CancelSendRequestOrBuilder {
    private static final CancelSendRequest DEFAULT_INSTANCE;
    public static final int FILEID_FIELD_NUMBER = 2;
    private static volatile Parser<CancelSendRequest> PARSER = null;
    public static final int SENTLENGTH_FIELD_NUMBER = 3;
    public static final int TASKID_FIELD_NUMBER = 1;
    private long fileId_;
    private long sentLength_;
    private long taskId_;

    /* JADX INFO: renamed from: com.transsion.airtransfer.filetransfer.protos.CancelSendRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CancelSendRequest, Builder> implements CancelSendRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFileId() {
            copyOnWrite();
            ((CancelSendRequest) this.instance).clearFileId();
            return this;
        }

        public Builder clearSentLength() {
            copyOnWrite();
            ((CancelSendRequest) this.instance).clearSentLength();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((CancelSendRequest) this.instance).clearTaskId();
            return this;
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendRequestOrBuilder
        public long getFileId() {
            return ((CancelSendRequest) this.instance).getFileId();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendRequestOrBuilder
        public long getSentLength() {
            return ((CancelSendRequest) this.instance).getSentLength();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendRequestOrBuilder
        public long getTaskId() {
            return ((CancelSendRequest) this.instance).getTaskId();
        }

        public Builder setFileId(long j10) {
            copyOnWrite();
            ((CancelSendRequest) this.instance).setFileId(j10);
            return this;
        }

        public Builder setSentLength(long j10) {
            copyOnWrite();
            ((CancelSendRequest) this.instance).setSentLength(j10);
            return this;
        }

        public Builder setTaskId(long j10) {
            copyOnWrite();
            ((CancelSendRequest) this.instance).setTaskId(j10);
            return this;
        }

        private Builder() {
            super(CancelSendRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        CancelSendRequest cancelSendRequest = new CancelSendRequest();
        DEFAULT_INSTANCE = cancelSendRequest;
        GeneratedMessageLite.registerDefaultInstance(CancelSendRequest.class, cancelSendRequest);
    }

    private CancelSendRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFileId() {
        this.fileId_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSentLength() {
        this.sentLength_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = 0L;
    }

    public static CancelSendRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CancelSendRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CancelSendRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelSendRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CancelSendRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileId(long j10) {
        this.fileId_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSentLength(long j10) {
        this.sentLength_ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskId(long j10) {
        this.taskId_ = j10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i10) {
            case 1:
                return new CancelSendRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002", new Object[]{"taskId_", "fileId_", "sentLength_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CancelSendRequest> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CancelSendRequest.class) {
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

    @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendRequestOrBuilder
    public long getFileId() {
        return this.fileId_;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendRequestOrBuilder
    public long getSentLength() {
        return this.sentLength_;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendRequestOrBuilder
    public long getTaskId() {
        return this.taskId_;
    }

    public static Builder newBuilder(CancelSendRequest cancelSendRequest) {
        return DEFAULT_INSTANCE.createBuilder(cancelSendRequest);
    }

    public static CancelSendRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelSendRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelSendRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CancelSendRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CancelSendRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CancelSendRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CancelSendRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CancelSendRequest parseFrom(InputStream inputStream) throws IOException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelSendRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelSendRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CancelSendRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelSendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
