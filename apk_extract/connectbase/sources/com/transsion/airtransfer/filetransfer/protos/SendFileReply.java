package com.transsion.airtransfer.filetransfer.protos;

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
public final class SendFileReply extends GeneratedMessageLite<SendFileReply, Builder> implements SendFileReplyOrBuilder {
    private static final SendFileReply DEFAULT_INSTANCE;
    public static final int EXTEND_FIELD_NUMBER = 3;
    public static final int ISACCEPT_FIELD_NUMBER = 2;
    private static volatile Parser<SendFileReply> PARSER = null;
    public static final int TASKID_FIELD_NUMBER = 1;
    private String extend_ = "";
    private boolean isAccept_;
    private long taskId_;

    /* JADX INFO: renamed from: com.transsion.airtransfer.filetransfer.protos.SendFileReply$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SendFileReply, Builder> implements SendFileReplyOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearExtend() {
            copyOnWrite();
            ((SendFileReply) this.instance).clearExtend();
            return this;
        }

        public Builder clearIsAccept() {
            copyOnWrite();
            ((SendFileReply) this.instance).clearIsAccept();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((SendFileReply) this.instance).clearTaskId();
            return this;
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileReplyOrBuilder
        public String getExtend() {
            return ((SendFileReply) this.instance).getExtend();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileReplyOrBuilder
        public ByteString getExtendBytes() {
            return ((SendFileReply) this.instance).getExtendBytes();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileReplyOrBuilder
        public boolean getIsAccept() {
            return ((SendFileReply) this.instance).getIsAccept();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileReplyOrBuilder
        public long getTaskId() {
            return ((SendFileReply) this.instance).getTaskId();
        }

        public Builder setExtend(String str) {
            copyOnWrite();
            ((SendFileReply) this.instance).setExtend(str);
            return this;
        }

        public Builder setExtendBytes(ByteString byteString) {
            copyOnWrite();
            ((SendFileReply) this.instance).setExtendBytes(byteString);
            return this;
        }

        public Builder setIsAccept(boolean z10) {
            copyOnWrite();
            ((SendFileReply) this.instance).setIsAccept(z10);
            return this;
        }

        public Builder setTaskId(long j10) {
            copyOnWrite();
            ((SendFileReply) this.instance).setTaskId(j10);
            return this;
        }

        private Builder() {
            super(SendFileReply.DEFAULT_INSTANCE);
        }
    }

    static {
        SendFileReply sendFileReply = new SendFileReply();
        DEFAULT_INSTANCE = sendFileReply;
        GeneratedMessageLite.registerDefaultInstance(SendFileReply.class, sendFileReply);
    }

    private SendFileReply() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtend() {
        this.extend_ = getDefaultInstance().getExtend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsAccept() {
        this.isAccept_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = 0L;
    }

    public static SendFileReply getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SendFileReply parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SendFileReply) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SendFileReply parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SendFileReply> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtend(String str) {
        str.getClass();
        this.extend_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtendBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.extend_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsAccept(boolean z10) {
        this.isAccept_ = z10;
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
                return new SendFileReply();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0007\u0003Ȉ", new Object[]{"taskId_", "isAccept_", "extend_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SendFileReply> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (SendFileReply.class) {
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

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileReplyOrBuilder
    public String getExtend() {
        return this.extend_;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileReplyOrBuilder
    public ByteString getExtendBytes() {
        return ByteString.copyFromUtf8(this.extend_);
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileReplyOrBuilder
    public boolean getIsAccept() {
        return this.isAccept_;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileReplyOrBuilder
    public long getTaskId() {
        return this.taskId_;
    }

    public static Builder newBuilder(SendFileReply sendFileReply) {
        return DEFAULT_INSTANCE.createBuilder(sendFileReply);
    }

    public static SendFileReply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SendFileReply) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SendFileReply parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SendFileReply parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SendFileReply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SendFileReply parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SendFileReply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SendFileReply parseFrom(InputStream inputStream) throws IOException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SendFileReply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SendFileReply parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SendFileReply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SendFileReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
