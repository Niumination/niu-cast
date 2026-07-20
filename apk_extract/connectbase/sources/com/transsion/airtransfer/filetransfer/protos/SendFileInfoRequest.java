package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SendFileInfoRequest extends GeneratedMessageLite<SendFileInfoRequest, Builder> implements SendFileInfoRequestOrBuilder {
    private static final SendFileInfoRequest DEFAULT_INSTANCE;
    public static final int EXTEND_FIELD_NUMBER = 3;
    public static final int FILES_FIELD_NUMBER = 2;
    private static volatile Parser<SendFileInfoRequest> PARSER = null;
    public static final int TASKID_FIELD_NUMBER = 1;
    private long taskId_;
    private Internal.ProtobufList<FileInfo> files_ = GeneratedMessageLite.emptyProtobufList();
    private String extend_ = "";

    /* JADX INFO: renamed from: com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SendFileInfoRequest, Builder> implements SendFileInfoRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFiles(Iterable<? extends FileInfo> iterable) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).addAllFiles(iterable);
            return this;
        }

        public Builder addFiles(FileInfo fileInfo) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).addFiles(fileInfo);
            return this;
        }

        public Builder clearExtend() {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).clearExtend();
            return this;
        }

        public Builder clearFiles() {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).clearFiles();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).clearTaskId();
            return this;
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
        public String getExtend() {
            return ((SendFileInfoRequest) this.instance).getExtend();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
        public ByteString getExtendBytes() {
            return ((SendFileInfoRequest) this.instance).getExtendBytes();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
        public FileInfo getFiles(int i10) {
            return ((SendFileInfoRequest) this.instance).getFiles(i10);
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
        public int getFilesCount() {
            return ((SendFileInfoRequest) this.instance).getFilesCount();
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
        public List<FileInfo> getFilesList() {
            return Collections.unmodifiableList(((SendFileInfoRequest) this.instance).getFilesList());
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
        public long getTaskId() {
            return ((SendFileInfoRequest) this.instance).getTaskId();
        }

        public Builder removeFiles(int i10) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).removeFiles(i10);
            return this;
        }

        public Builder setExtend(String str) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).setExtend(str);
            return this;
        }

        public Builder setExtendBytes(ByteString byteString) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).setExtendBytes(byteString);
            return this;
        }

        public Builder setFiles(int i10, FileInfo fileInfo) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).setFiles(i10, fileInfo);
            return this;
        }

        public Builder setTaskId(long j10) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).setTaskId(j10);
            return this;
        }

        private Builder() {
            super(SendFileInfoRequest.DEFAULT_INSTANCE);
        }

        public Builder addFiles(int i10, FileInfo fileInfo) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).addFiles(i10, fileInfo);
            return this;
        }

        public Builder setFiles(int i10, FileInfo.Builder builder) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).setFiles(i10, builder.build());
            return this;
        }

        public Builder addFiles(FileInfo.Builder builder) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).addFiles(builder.build());
            return this;
        }

        public Builder addFiles(int i10, FileInfo.Builder builder) {
            copyOnWrite();
            ((SendFileInfoRequest) this.instance).addFiles(i10, builder.build());
            return this;
        }
    }

    public static final class FileInfo extends GeneratedMessageLite<FileInfo, Builder> implements FileInfoOrBuilder {
        private static final FileInfo DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int MD5_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile Parser<FileInfo> PARSER = null;
        public static final int SIZE_FIELD_NUMBER = 3;
        private long id_;
        private long size_;
        private String name_ = "";
        private String md5_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<FileInfo, Builder> implements FileInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearId() {
                copyOnWrite();
                ((FileInfo) this.instance).clearId();
                return this;
            }

            public Builder clearMd5() {
                copyOnWrite();
                ((FileInfo) this.instance).clearMd5();
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((FileInfo) this.instance).clearName();
                return this;
            }

            public Builder clearSize() {
                copyOnWrite();
                ((FileInfo) this.instance).clearSize();
                return this;
            }

            @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
            public long getId() {
                return ((FileInfo) this.instance).getId();
            }

            @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
            public String getMd5() {
                return ((FileInfo) this.instance).getMd5();
            }

            @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
            public ByteString getMd5Bytes() {
                return ((FileInfo) this.instance).getMd5Bytes();
            }

            @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
            public String getName() {
                return ((FileInfo) this.instance).getName();
            }

            @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
            public ByteString getNameBytes() {
                return ((FileInfo) this.instance).getNameBytes();
            }

            @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
            public long getSize() {
                return ((FileInfo) this.instance).getSize();
            }

            public Builder setId(long j10) {
                copyOnWrite();
                ((FileInfo) this.instance).setId(j10);
                return this;
            }

            public Builder setMd5(String str) {
                copyOnWrite();
                ((FileInfo) this.instance).setMd5(str);
                return this;
            }

            public Builder setMd5Bytes(ByteString byteString) {
                copyOnWrite();
                ((FileInfo) this.instance).setMd5Bytes(byteString);
                return this;
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((FileInfo) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((FileInfo) this.instance).setNameBytes(byteString);
                return this;
            }

            public Builder setSize(long j10) {
                copyOnWrite();
                ((FileInfo) this.instance).setSize(j10);
                return this;
            }

            private Builder() {
                super(FileInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            FileInfo fileInfo = new FileInfo();
            DEFAULT_INSTANCE = fileInfo;
            GeneratedMessageLite.registerDefaultInstance(FileInfo.class, fileInfo);
        }

        private FileInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMd5() {
            this.md5_ = getDefaultInstance().getMd5();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSize() {
            this.size_ = 0L;
        }

        public static FileInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static FileInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FileInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FileInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(long j10) {
            this.id_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMd5(String str) {
            str.getClass();
            this.md5_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMd5Bytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.md5_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSize(long j10) {
            this.size_ = j10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i10) {
                case 1:
                    return new FileInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\u0002\u0004Ȉ", new Object[]{"id_", "name_", "size_", "md5_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileInfo> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (FileInfo.class) {
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

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
        public long getId() {
            return this.id_;
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
        public String getMd5() {
            return this.md5_;
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
        public ByteString getMd5Bytes() {
            return ByteString.copyFromUtf8(this.md5_);
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest.FileInfoOrBuilder
        public long getSize() {
            return this.size_;
        }

        public static Builder newBuilder(FileInfo fileInfo) {
            return DEFAULT_INSTANCE.createBuilder(fileInfo);
        }

        public static FileInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FileInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FileInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FileInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FileInfo parseFrom(InputStream inputStream) throws IOException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FileInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface FileInfoOrBuilder extends MessageLiteOrBuilder {
        long getId();

        String getMd5();

        ByteString getMd5Bytes();

        String getName();

        ByteString getNameBytes();

        long getSize();
    }

    static {
        SendFileInfoRequest sendFileInfoRequest = new SendFileInfoRequest();
        DEFAULT_INSTANCE = sendFileInfoRequest;
        GeneratedMessageLite.registerDefaultInstance(SendFileInfoRequest.class, sendFileInfoRequest);
    }

    private SendFileInfoRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFiles(Iterable<? extends FileInfo> iterable) {
        ensureFilesIsMutable();
        AbstractMessageLite.addAll(iterable, this.files_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFiles(FileInfo fileInfo) {
        fileInfo.getClass();
        ensureFilesIsMutable();
        this.files_.add(fileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtend() {
        this.extend_ = getDefaultInstance().getExtend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFiles() {
        this.files_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = 0L;
    }

    private void ensureFilesIsMutable() {
        Internal.ProtobufList<FileInfo> protobufList = this.files_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.files_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static SendFileInfoRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SendFileInfoRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SendFileInfoRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SendFileInfoRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFiles(int i10) {
        ensureFilesIsMutable();
        this.files_.remove(i10);
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
    public void setFiles(int i10, FileInfo fileInfo) {
        fileInfo.getClass();
        ensureFilesIsMutable();
        this.files_.set(i10, fileInfo);
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
                return new SendFileInfoRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0002\u0002\u001b\u0003Ȉ", new Object[]{"taskId_", "files_", FileInfo.class, "extend_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SendFileInfoRequest> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (SendFileInfoRequest.class) {
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

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
    public String getExtend() {
        return this.extend_;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
    public ByteString getExtendBytes() {
        return ByteString.copyFromUtf8(this.extend_);
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
    public FileInfo getFiles(int i10) {
        return this.files_.get(i10);
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
    public int getFilesCount() {
        return this.files_.size();
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
    public List<FileInfo> getFilesList() {
        return this.files_;
    }

    public FileInfoOrBuilder getFilesOrBuilder(int i10) {
        return this.files_.get(i10);
    }

    public List<? extends FileInfoOrBuilder> getFilesOrBuilderList() {
        return this.files_;
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestOrBuilder
    public long getTaskId() {
        return this.taskId_;
    }

    public static Builder newBuilder(SendFileInfoRequest sendFileInfoRequest) {
        return DEFAULT_INSTANCE.createBuilder(sendFileInfoRequest);
    }

    public static SendFileInfoRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SendFileInfoRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SendFileInfoRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFiles(int i10, FileInfo fileInfo) {
        fileInfo.getClass();
        ensureFilesIsMutable();
        this.files_.add(i10, fileInfo);
    }

    public static SendFileInfoRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SendFileInfoRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SendFileInfoRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SendFileInfoRequest parseFrom(InputStream inputStream) throws IOException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SendFileInfoRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SendFileInfoRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SendFileInfoRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SendFileInfoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
