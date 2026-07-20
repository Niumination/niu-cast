package com.transsion.backup.protos;

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
public final class BackupData extends GeneratedMessageLite<BackupData, Builder> implements BackupDataOrBuilder {
    public static final int ALBUMS_FIELD_NUMBER = 3;
    public static final int CURRENTPAGE_FIELD_NUMBER = 4;
    private static final BackupData DEFAULT_INSTANCE;
    public static final int FILES_FIELD_NUMBER = 2;
    private static volatile Parser<BackupData> PARSER = null;
    public static final int TASKID_FIELD_NUMBER = 1;
    public static final int TOTALPAGE_FIELD_NUMBER = 5;
    private int currentPage_;
    private int taskId_;
    private int totalPage_;
    private Internal.ProtobufList<AlbumFileInfo> files_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<AlbumInfo> albums_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.transsion.backup.protos.BackupData$1, reason: invalid class name */
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

    public static final class AlbumFileInfo extends GeneratedMessageLite<AlbumFileInfo, Builder> implements AlbumFileInfoOrBuilder {
        public static final int ALBUMID_FIELD_NUMBER = 5;
        public static final int CREATEDATE_FIELD_NUMBER = 6;
        private static final AlbumFileInfo DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int ISDELETED_FIELD_NUMBER = 7;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile Parser<AlbumFileInfo> PARSER = null;
        public static final int SIZE_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 4;
        private long albumId_;
        private long createDate_;
        private long id_;
        private boolean isDeleted_;
        private String name_ = "";
        private long size_;
        private int type_;

        public static final class Builder extends GeneratedMessageLite.Builder<AlbumFileInfo, Builder> implements AlbumFileInfoOrBuilder {
            public Builder clearAlbumId() {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).clearAlbumId();
                return this;
            }

            public Builder clearCreateDate() {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).clearCreateDate();
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).clearId();
                return this;
            }

            public Builder clearIsDeleted() {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).clearIsDeleted();
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).clearName();
                return this;
            }

            public Builder clearSize() {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).clearSize();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).clearType();
                return this;
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
            public long getAlbumId() {
                return ((AlbumFileInfo) this.instance).getAlbumId();
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
            public long getCreateDate() {
                return ((AlbumFileInfo) this.instance).getCreateDate();
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
            public long getId() {
                return ((AlbumFileInfo) this.instance).getId();
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
            public boolean getIsDeleted() {
                return ((AlbumFileInfo) this.instance).getIsDeleted();
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
            public String getName() {
                return ((AlbumFileInfo) this.instance).getName();
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
            public ByteString getNameBytes() {
                return ((AlbumFileInfo) this.instance).getNameBytes();
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
            public long getSize() {
                return ((AlbumFileInfo) this.instance).getSize();
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
            public int getType() {
                return ((AlbumFileInfo) this.instance).getType();
            }

            public Builder setAlbumId(long j10) {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).setAlbumId(j10);
                return this;
            }

            public Builder setCreateDate(long j10) {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).setCreateDate(j10);
                return this;
            }

            public Builder setId(long j10) {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).setId(j10);
                return this;
            }

            public Builder setIsDeleted(boolean z10) {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).setIsDeleted(z10);
                return this;
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).setNameBytes(byteString);
                return this;
            }

            public Builder setSize(long j10) {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).setSize(j10);
                return this;
            }

            public Builder setType(int i10) {
                copyOnWrite();
                ((AlbumFileInfo) this.instance).setType(i10);
                return this;
            }

            private Builder() {
                super(AlbumFileInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            AlbumFileInfo albumFileInfo = new AlbumFileInfo();
            DEFAULT_INSTANCE = albumFileInfo;
            GeneratedMessageLite.registerDefaultInstance(AlbumFileInfo.class, albumFileInfo);
        }

        private AlbumFileInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAlbumId() {
            this.albumId_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreateDate() {
            this.createDate_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsDeleted() {
            this.isDeleted_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSize() {
            this.size_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        public static AlbumFileInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static AlbumFileInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AlbumFileInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AlbumFileInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<AlbumFileInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlbumId(long j10) {
            this.albumId_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreateDate(long j10) {
            this.createDate_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(long j10) {
            this.id_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsDeleted(boolean z10) {
            this.isDeleted_ = z10;
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i10) {
            this.type_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i10) {
                case 1:
                    return new AlbumFileInfo();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\u0002\u0004\u0004\u0005\u0002\u0006\u0002\u0007\u0007", new Object[]{"id_", "name_", "size_", "type_", "albumId_", "createDate_", "isDeleted_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AlbumFileInfo> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AlbumFileInfo.class) {
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

        @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
        public long getAlbumId() {
            return this.albumId_;
        }

        @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
        public long getCreateDate() {
            return this.createDate_;
        }

        @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
        public long getId() {
            return this.id_;
        }

        @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
        public boolean getIsDeleted() {
            return this.isDeleted_;
        }

        @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
        public long getSize() {
            return this.size_;
        }

        @Override // com.transsion.backup.protos.BackupData.AlbumFileInfoOrBuilder
        public int getType() {
            return this.type_;
        }

        public static Builder newBuilder(AlbumFileInfo albumFileInfo) {
            return DEFAULT_INSTANCE.createBuilder(albumFileInfo);
        }

        public static AlbumFileInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlbumFileInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AlbumFileInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AlbumFileInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AlbumFileInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AlbumFileInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AlbumFileInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AlbumFileInfo parseFrom(InputStream inputStream) throws IOException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AlbumFileInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AlbumFileInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AlbumFileInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlbumFileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface AlbumFileInfoOrBuilder extends MessageLiteOrBuilder {
        long getAlbumId();

        long getCreateDate();

        long getId();

        boolean getIsDeleted();

        String getName();

        ByteString getNameBytes();

        long getSize();

        int getType();
    }

    public static final class AlbumInfo extends GeneratedMessageLite<AlbumInfo, Builder> implements AlbumInfoOrBuilder {
        private static final AlbumInfo DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile Parser<AlbumInfo> PARSER;
        private long id_;
        private String name_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<AlbumInfo, Builder> implements AlbumInfoOrBuilder {
            public Builder clearId() {
                copyOnWrite();
                ((AlbumInfo) this.instance).clearId();
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((AlbumInfo) this.instance).clearName();
                return this;
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumInfoOrBuilder
            public long getId() {
                return ((AlbumInfo) this.instance).getId();
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumInfoOrBuilder
            public String getName() {
                return ((AlbumInfo) this.instance).getName();
            }

            @Override // com.transsion.backup.protos.BackupData.AlbumInfoOrBuilder
            public ByteString getNameBytes() {
                return ((AlbumInfo) this.instance).getNameBytes();
            }

            public Builder setId(long j10) {
                copyOnWrite();
                ((AlbumInfo) this.instance).setId(j10);
                return this;
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((AlbumInfo) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((AlbumInfo) this.instance).setNameBytes(byteString);
                return this;
            }

            private Builder() {
                super(AlbumInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            AlbumInfo albumInfo = new AlbumInfo();
            DEFAULT_INSTANCE = albumInfo;
            GeneratedMessageLite.registerDefaultInstance(AlbumInfo.class, albumInfo);
        }

        private AlbumInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        public static AlbumInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static AlbumInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AlbumInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AlbumInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<AlbumInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(long j10) {
            this.id_ = j10;
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i10) {
                case 1:
                    return new AlbumInfo();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"id_", "name_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AlbumInfo> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AlbumInfo.class) {
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

        @Override // com.transsion.backup.protos.BackupData.AlbumInfoOrBuilder
        public long getId() {
            return this.id_;
        }

        @Override // com.transsion.backup.protos.BackupData.AlbumInfoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.transsion.backup.protos.BackupData.AlbumInfoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        public static Builder newBuilder(AlbumInfo albumInfo) {
            return DEFAULT_INSTANCE.createBuilder(albumInfo);
        }

        public static AlbumInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlbumInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AlbumInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AlbumInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AlbumInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AlbumInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AlbumInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AlbumInfo parseFrom(InputStream inputStream) throws IOException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AlbumInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AlbumInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AlbumInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlbumInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface AlbumInfoOrBuilder extends MessageLiteOrBuilder {
        long getId();

        String getName();

        ByteString getNameBytes();
    }

    public static final class Builder extends GeneratedMessageLite.Builder<BackupData, Builder> implements BackupDataOrBuilder {
        public Builder addAlbums(AlbumInfo albumInfo) {
            copyOnWrite();
            ((BackupData) this.instance).addAlbums(albumInfo);
            return this;
        }

        public Builder addAllAlbums(Iterable<? extends AlbumInfo> iterable) {
            copyOnWrite();
            ((BackupData) this.instance).addAllAlbums(iterable);
            return this;
        }

        public Builder addAllFiles(Iterable<? extends AlbumFileInfo> iterable) {
            copyOnWrite();
            ((BackupData) this.instance).addAllFiles(iterable);
            return this;
        }

        public Builder addFiles(AlbumFileInfo albumFileInfo) {
            copyOnWrite();
            ((BackupData) this.instance).addFiles(albumFileInfo);
            return this;
        }

        public Builder clearAlbums() {
            copyOnWrite();
            ((BackupData) this.instance).clearAlbums();
            return this;
        }

        public Builder clearCurrentPage() {
            copyOnWrite();
            ((BackupData) this.instance).clearCurrentPage();
            return this;
        }

        public Builder clearFiles() {
            copyOnWrite();
            ((BackupData) this.instance).clearFiles();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((BackupData) this.instance).clearTaskId();
            return this;
        }

        public Builder clearTotalPage() {
            copyOnWrite();
            ((BackupData) this.instance).clearTotalPage();
            return this;
        }

        @Override // com.transsion.backup.protos.BackupDataOrBuilder
        public AlbumInfo getAlbums(int i10) {
            return ((BackupData) this.instance).getAlbums(i10);
        }

        @Override // com.transsion.backup.protos.BackupDataOrBuilder
        public int getAlbumsCount() {
            return ((BackupData) this.instance).getAlbumsCount();
        }

        @Override // com.transsion.backup.protos.BackupDataOrBuilder
        public List<AlbumInfo> getAlbumsList() {
            return Collections.unmodifiableList(((BackupData) this.instance).getAlbumsList());
        }

        @Override // com.transsion.backup.protos.BackupDataOrBuilder
        public int getCurrentPage() {
            return ((BackupData) this.instance).getCurrentPage();
        }

        @Override // com.transsion.backup.protos.BackupDataOrBuilder
        public AlbumFileInfo getFiles(int i10) {
            return ((BackupData) this.instance).getFiles(i10);
        }

        @Override // com.transsion.backup.protos.BackupDataOrBuilder
        public int getFilesCount() {
            return ((BackupData) this.instance).getFilesCount();
        }

        @Override // com.transsion.backup.protos.BackupDataOrBuilder
        public List<AlbumFileInfo> getFilesList() {
            return Collections.unmodifiableList(((BackupData) this.instance).getFilesList());
        }

        @Override // com.transsion.backup.protos.BackupDataOrBuilder
        public int getTaskId() {
            return ((BackupData) this.instance).getTaskId();
        }

        @Override // com.transsion.backup.protos.BackupDataOrBuilder
        public int getTotalPage() {
            return ((BackupData) this.instance).getTotalPage();
        }

        public Builder removeAlbums(int i10) {
            copyOnWrite();
            ((BackupData) this.instance).removeAlbums(i10);
            return this;
        }

        public Builder removeFiles(int i10) {
            copyOnWrite();
            ((BackupData) this.instance).removeFiles(i10);
            return this;
        }

        public Builder setAlbums(int i10, AlbumInfo albumInfo) {
            copyOnWrite();
            ((BackupData) this.instance).setAlbums(i10, albumInfo);
            return this;
        }

        public Builder setCurrentPage(int i10) {
            copyOnWrite();
            ((BackupData) this.instance).setCurrentPage(i10);
            return this;
        }

        public Builder setFiles(int i10, AlbumFileInfo albumFileInfo) {
            copyOnWrite();
            ((BackupData) this.instance).setFiles(i10, albumFileInfo);
            return this;
        }

        public Builder setTaskId(int i10) {
            copyOnWrite();
            ((BackupData) this.instance).setTaskId(i10);
            return this;
        }

        public Builder setTotalPage(int i10) {
            copyOnWrite();
            ((BackupData) this.instance).setTotalPage(i10);
            return this;
        }

        private Builder() {
            super(BackupData.DEFAULT_INSTANCE);
        }

        public Builder addAlbums(int i10, AlbumInfo albumInfo) {
            copyOnWrite();
            ((BackupData) this.instance).addAlbums(i10, albumInfo);
            return this;
        }

        public Builder addFiles(int i10, AlbumFileInfo albumFileInfo) {
            copyOnWrite();
            ((BackupData) this.instance).addFiles(i10, albumFileInfo);
            return this;
        }

        public Builder setAlbums(int i10, AlbumInfo.Builder builder) {
            copyOnWrite();
            ((BackupData) this.instance).setAlbums(i10, builder.build());
            return this;
        }

        public Builder setFiles(int i10, AlbumFileInfo.Builder builder) {
            copyOnWrite();
            ((BackupData) this.instance).setFiles(i10, builder.build());
            return this;
        }

        public Builder addAlbums(AlbumInfo.Builder builder) {
            copyOnWrite();
            ((BackupData) this.instance).addAlbums(builder.build());
            return this;
        }

        public Builder addFiles(AlbumFileInfo.Builder builder) {
            copyOnWrite();
            ((BackupData) this.instance).addFiles(builder.build());
            return this;
        }

        public Builder addAlbums(int i10, AlbumInfo.Builder builder) {
            copyOnWrite();
            ((BackupData) this.instance).addAlbums(i10, builder.build());
            return this;
        }

        public Builder addFiles(int i10, AlbumFileInfo.Builder builder) {
            copyOnWrite();
            ((BackupData) this.instance).addFiles(i10, builder.build());
            return this;
        }
    }

    static {
        BackupData backupData = new BackupData();
        DEFAULT_INSTANCE = backupData;
        GeneratedMessageLite.registerDefaultInstance(BackupData.class, backupData);
    }

    private BackupData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlbums(AlbumInfo albumInfo) {
        albumInfo.getClass();
        ensureAlbumsIsMutable();
        this.albums_.add(albumInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAlbums(Iterable<? extends AlbumInfo> iterable) {
        ensureAlbumsIsMutable();
        AbstractMessageLite.addAll(iterable, this.albums_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFiles(Iterable<? extends AlbumFileInfo> iterable) {
        ensureFilesIsMutable();
        AbstractMessageLite.addAll(iterable, this.files_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFiles(AlbumFileInfo albumFileInfo) {
        albumFileInfo.getClass();
        ensureFilesIsMutable();
        this.files_.add(albumFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlbums() {
        this.albums_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurrentPage() {
        this.currentPage_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFiles() {
        this.files_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTotalPage() {
        this.totalPage_ = 0;
    }

    private void ensureAlbumsIsMutable() {
        Internal.ProtobufList<AlbumInfo> protobufList = this.albums_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.albums_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureFilesIsMutable() {
        Internal.ProtobufList<AlbumFileInfo> protobufList = this.files_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.files_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static BackupData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static BackupData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BackupData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BackupData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BackupData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAlbums(int i10) {
        ensureAlbumsIsMutable();
        this.albums_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFiles(int i10) {
        ensureFilesIsMutable();
        this.files_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbums(int i10, AlbumInfo albumInfo) {
        albumInfo.getClass();
        ensureAlbumsIsMutable();
        this.albums_.set(i10, albumInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentPage(int i10) {
        this.currentPage_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFiles(int i10, AlbumFileInfo albumFileInfo) {
        albumFileInfo.getClass();
        ensureFilesIsMutable();
        this.files_.set(i10, albumFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskId(int i10) {
        this.taskId_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTotalPage(int i10) {
        this.totalPage_ = i10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new BackupData();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003\u001b\u0004\u0004\u0005\u0004", new Object[]{"taskId_", "files_", AlbumFileInfo.class, "albums_", AlbumInfo.class, "currentPage_", "totalPage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BackupData> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (BackupData.class) {
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

    @Override // com.transsion.backup.protos.BackupDataOrBuilder
    public AlbumInfo getAlbums(int i10) {
        return this.albums_.get(i10);
    }

    @Override // com.transsion.backup.protos.BackupDataOrBuilder
    public int getAlbumsCount() {
        return this.albums_.size();
    }

    @Override // com.transsion.backup.protos.BackupDataOrBuilder
    public List<AlbumInfo> getAlbumsList() {
        return this.albums_;
    }

    public AlbumInfoOrBuilder getAlbumsOrBuilder(int i10) {
        return this.albums_.get(i10);
    }

    public List<? extends AlbumInfoOrBuilder> getAlbumsOrBuilderList() {
        return this.albums_;
    }

    @Override // com.transsion.backup.protos.BackupDataOrBuilder
    public int getCurrentPage() {
        return this.currentPage_;
    }

    @Override // com.transsion.backup.protos.BackupDataOrBuilder
    public AlbumFileInfo getFiles(int i10) {
        return this.files_.get(i10);
    }

    @Override // com.transsion.backup.protos.BackupDataOrBuilder
    public int getFilesCount() {
        return this.files_.size();
    }

    @Override // com.transsion.backup.protos.BackupDataOrBuilder
    public List<AlbumFileInfo> getFilesList() {
        return this.files_;
    }

    public AlbumFileInfoOrBuilder getFilesOrBuilder(int i10) {
        return this.files_.get(i10);
    }

    public List<? extends AlbumFileInfoOrBuilder> getFilesOrBuilderList() {
        return this.files_;
    }

    @Override // com.transsion.backup.protos.BackupDataOrBuilder
    public int getTaskId() {
        return this.taskId_;
    }

    @Override // com.transsion.backup.protos.BackupDataOrBuilder
    public int getTotalPage() {
        return this.totalPage_;
    }

    public static Builder newBuilder(BackupData backupData) {
        return DEFAULT_INSTANCE.createBuilder(backupData);
    }

    public static BackupData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackupData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BackupData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BackupData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlbums(int i10, AlbumInfo albumInfo) {
        albumInfo.getClass();
        ensureAlbumsIsMutable();
        this.albums_.add(i10, albumInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFiles(int i10, AlbumFileInfo albumFileInfo) {
        albumFileInfo.getClass();
        ensureFilesIsMutable();
        this.files_.add(i10, albumFileInfo);
    }

    public static BackupData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BackupData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BackupData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BackupData parseFrom(InputStream inputStream) throws IOException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BackupData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BackupData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BackupData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackupData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
