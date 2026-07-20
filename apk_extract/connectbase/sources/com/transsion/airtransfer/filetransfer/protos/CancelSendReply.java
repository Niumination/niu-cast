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
public final class CancelSendReply extends GeneratedMessageLite<CancelSendReply, Builder> implements CancelSendReplyOrBuilder {
    private static final CancelSendReply DEFAULT_INSTANCE;
    private static volatile Parser<CancelSendReply> PARSER = null;
    public static final int STATE_FIELD_NUMBER = 2;
    public static final int TASKID_FIELD_NUMBER = 1;
    private int state_;
    private long taskId_;

    /* JADX INFO: renamed from: com.transsion.airtransfer.filetransfer.protos.CancelSendReply$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CancelSendReply, Builder> implements CancelSendReplyOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearState() {
            copyOnWrite();
            ((CancelSendReply) this.instance).clearState();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((CancelSendReply) this.instance).clearTaskId();
            return this;
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendReplyOrBuilder
        public ReplyState getState() {
            return ((CancelSendReply) this.instance).getState();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendReplyOrBuilder
        public int getStateValue() {
            return ((CancelSendReply) this.instance).getStateValue();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendReplyOrBuilder
        public long getTaskId() {
            return ((CancelSendReply) this.instance).getTaskId();
        }

        public Builder setState(ReplyState replyState) {
            copyOnWrite();
            ((CancelSendReply) this.instance).setState(replyState);
            return this;
        }

        public Builder setStateValue(int i10) {
            copyOnWrite();
            ((CancelSendReply) this.instance).setStateValue(i10);
            return this;
        }

        public Builder setTaskId(long j10) {
            copyOnWrite();
            ((CancelSendReply) this.instance).setTaskId(j10);
            return this;
        }

        private Builder() {
            super(CancelSendReply.DEFAULT_INSTANCE);
        }
    }

    static {
        CancelSendReply cancelSendReply = new CancelSendReply();
        DEFAULT_INSTANCE = cancelSendReply;
        GeneratedMessageLite.registerDefaultInstance(CancelSendReply.class, cancelSendReply);
    }

    private CancelSendReply() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = 0L;
    }

    public static CancelSendReply getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CancelSendReply parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CancelSendReply) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelSendReply parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CancelSendReply> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(ReplyState replyState) {
        this.state_ = replyState.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateValue(int i10) {
        this.state_ = i10;
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
                return new CancelSendReply();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\f", new Object[]{"taskId_", "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CancelSendReply> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CancelSendReply.class) {
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

    @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendReplyOrBuilder
    public ReplyState getState() {
        ReplyState replyStateForNumber = ReplyState.forNumber(this.state_);
        return replyStateForNumber == null ? ReplyState.UNRECOGNIZED : replyStateForNumber;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendReplyOrBuilder
    public int getStateValue() {
        return this.state_;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.CancelSendReplyOrBuilder
    public long getTaskId() {
        return this.taskId_;
    }

    public static Builder newBuilder(CancelSendReply cancelSendReply) {
        return DEFAULT_INSTANCE.createBuilder(cancelSendReply);
    }

    public static CancelSendReply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelSendReply) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelSendReply parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CancelSendReply parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CancelSendReply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CancelSendReply parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CancelSendReply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CancelSendReply parseFrom(InputStream inputStream) throws IOException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelSendReply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelSendReply parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CancelSendReply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CancelSendReply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
