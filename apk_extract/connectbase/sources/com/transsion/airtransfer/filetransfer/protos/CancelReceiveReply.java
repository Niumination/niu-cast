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
public final class CancelReceiveReply extends GeneratedMessageLite<CancelReceiveReply, Builder> implements CancelReceiveReplyOrBuilder {
    private static final CancelReceiveReply DEFAULT_INSTANCE;
    public static final int FILEID_FIELD_NUMBER = 2;
    private static volatile Parser<CancelReceiveReply> PARSER = null;
    public static final int SENTLENGTH_FIELD_NUMBER = 3;
    public static final int TASKID_FIELD_NUMBER = 1;
    private long fileId_;
    private long sentLength_;
    private long taskId_;

    /* JADX INFO: renamed from: com.transsion.airtransfer.filetransfer.protos.CancelReceiveReply$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CancelReceiveReply, Builder> implements CancelReceiveReplyOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFileId() {
            copyOnWrite();
            ((CancelReceiveReply) this.instance).clearFileId();
            return this;
        }

        public Builder clearSentLength() {
            copyOnWrite();
            ((CancelReceiveReply) this.instance).clearSentLength();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((CancelReceiveReply) this.instance).clearTaskId();
            return this;
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.CancelReceiveReplyOrBuilder
        public long getFileId() {
            return ((CancelReceiveReply) this.instance).getFileId();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.CancelReceiveReplyOrBuilder
        public long getSentLength() {
            return ((CancelReceiveReply) this.instance).getSentLength();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.CancelReceiveReplyOrBuilder
        public long getTaskId() {
            return ((CancelReceiveReply) this.instance).getTaskId();
        }

        public Builder setFileId(long j10) {
            copyOnWrite();
            ((CancelReceiveReply) this.instance).setFileId(j10);
            return this;
        }

        public Builder setSentLength(long j10) {
            copyOnWrite();
            ((CancelReceiveReply) this.instance).setSentLength(j10);
            return this;
        }

        public Builder setTaskId(long j10) {
            copyOnWrite();
            ((CancelReceiveReply) this.instance).setTaskId(j10);
            return this;
        }

        private Builder() {
            super(CancelReceiveReply.DEFAULT_INSTANCE);
        }
    }

    static {
        CancelReceiveReply cancelReceiveReply = new CancelReceiveReply();
        DEFAULT_INSTANCE = cancelReceiveReply;
        GeneratedMessageLite.registerDefaultInstance(CancelReceiveReply.class, cancelReceiveReply);
    }

    private CancelReceiveReply() {
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

    public static CancelReceiveReply getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CancelReceiveReply parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CancelReceiveReply) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelReceiveReply parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CancelReceiveReply> parser() {
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
                return new CancelReceiveReply();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002", new Object[]{"taskId_", "fileId_", "sentLength_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CancelReceiveReply> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CancelReceiveReply.class) {
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

    @Override // com.transsion.airtransfer.filetransfer.protos.CancelReceiveReplyOrBuilder
    public long getFileId() {
        return this.fileId_;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.CancelReceiveReplyOrBuilder
    public long getSentLength() {
        return this.sentLength_;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.CancelReceiveReplyOrBuilder
    public long getTaskId() {
        return this.taskId_;
    }

    public static Builder newBuilder(CancelReceiveReply cancelReceiveReply) {
        return DEFAULT_INSTANCE.createBuilder(cancelReceiveReply);
    }

    public static CancelReceiveReply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelReceiveReply) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelReceiveReply parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CancelReceiveReply parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CancelReceiveReply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CancelReceiveReply parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CancelReceiveReply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CancelReceiveReply parseFrom(InputStream inputStream) throws IOException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelReceiveReply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelReceiveReply parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CancelReceiveReply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelReceiveReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
