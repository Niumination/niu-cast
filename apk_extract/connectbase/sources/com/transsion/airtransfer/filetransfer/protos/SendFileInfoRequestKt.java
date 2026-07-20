package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import java.util.List;
import kn.l0;
import kn.r1;
import kn.w;
import lm.l2;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nSendFileInfoRequestKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SendFileInfoRequestKt.kt\ncom/transsion/airtransfer/filetransfer/protos/SendFileInfoRequestKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,233:1\n1#2:234\n*E\n"})
public final class SendFileInfoRequestKt {

    @l
    public static final SendFileInfoRequestKt INSTANCE = new SendFileInfoRequestKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final SendFileInfoRequest.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(SendFileInfoRequest.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public static final class FilesProxy extends DslProxy {
            private FilesProxy() {
            }
        }

        public /* synthetic */ Dsl(SendFileInfoRequest.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ SendFileInfoRequest _build() {
            SendFileInfoRequest sendFileInfoRequestBuild = this._builder.build();
            l0.o(sendFileInfoRequestBuild, "build(...)");
            return sendFileInfoRequestBuild;
        }

        @i(name = "addAllFiles")
        public final /* synthetic */ void addAllFiles(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllFiles(iterable);
        }

        @i(name = "addFiles")
        public final /* synthetic */ void addFiles(DslList dslList, SendFileInfoRequest.FileInfo fileInfo) {
            l0.p(dslList, "<this>");
            l0.p(fileInfo, "value");
            this._builder.addFiles(fileInfo);
        }

        public final void clearExtend() {
            this._builder.clearExtend();
        }

        @i(name = "clearFiles")
        public final /* synthetic */ void clearFiles(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearFiles();
        }

        public final void clearTaskId() {
            this._builder.clearTaskId();
        }

        @i(name = "getExtend")
        @l
        public final String getExtend() {
            String extend = this._builder.getExtend();
            l0.o(extend, "getExtend(...)");
            return extend;
        }

        public final /* synthetic */ DslList getFiles() {
            List<SendFileInfoRequest.FileInfo> filesList = this._builder.getFilesList();
            l0.o(filesList, "getFilesList(...)");
            return new DslList(filesList);
        }

        @i(name = "getTaskId")
        public final long getTaskId() {
            return this._builder.getTaskId();
        }

        @i(name = "plusAssignAllFiles")
        public final /* synthetic */ void plusAssignAllFiles(DslList<SendFileInfoRequest.FileInfo, FilesProxy> dslList, Iterable<SendFileInfoRequest.FileInfo> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllFiles(dslList, iterable);
        }

        @i(name = "plusAssignFiles")
        public final /* synthetic */ void plusAssignFiles(DslList<SendFileInfoRequest.FileInfo, FilesProxy> dslList, SendFileInfoRequest.FileInfo fileInfo) {
            l0.p(dslList, "<this>");
            l0.p(fileInfo, "value");
            addFiles(dslList, fileInfo);
        }

        @i(name = "setExtend")
        public final void setExtend(@l String str) {
            l0.p(str, "value");
            this._builder.setExtend(str);
        }

        @i(name = "setFiles")
        public final /* synthetic */ void setFiles(DslList dslList, int i10, SendFileInfoRequest.FileInfo fileInfo) {
            l0.p(dslList, "<this>");
            l0.p(fileInfo, "value");
            this._builder.setFiles(i10, fileInfo);
        }

        @i(name = "setTaskId")
        public final void setTaskId(long j10) {
            this._builder.setTaskId(j10);
        }

        private Dsl(SendFileInfoRequest.Builder builder) {
            this._builder = builder;
        }
    }

    public static final class FileInfoKt {

        @l
        public static final FileInfoKt INSTANCE = new FileInfoKt();

        @ProtoDslMarker
        public static final class Dsl {

            @l
            public static final Companion Companion = new Companion(null);

            @l
            private final SendFileInfoRequest.FileInfo.Builder _builder;

            public static final class Companion {
                public /* synthetic */ Companion(w wVar) {
                    this();
                }

                @z0
                public final /* synthetic */ Dsl _create(SendFileInfoRequest.FileInfo.Builder builder) {
                    l0.p(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            public /* synthetic */ Dsl(SendFileInfoRequest.FileInfo.Builder builder, w wVar) {
                this(builder);
            }

            @z0
            public final /* synthetic */ SendFileInfoRequest.FileInfo _build() {
                SendFileInfoRequest.FileInfo fileInfoBuild = this._builder.build();
                l0.o(fileInfoBuild, "build(...)");
                return fileInfoBuild;
            }

            public final void clearId() {
                this._builder.clearId();
            }

            public final void clearMd5() {
                this._builder.clearMd5();
            }

            public final void clearName() {
                this._builder.clearName();
            }

            public final void clearSize() {
                this._builder.clearSize();
            }

            @i(name = "getId")
            public final long getId() {
                return this._builder.getId();
            }

            @i(name = "getMd5")
            @l
            public final String getMd5() {
                String md5 = this._builder.getMd5();
                l0.o(md5, "getMd5(...)");
                return md5;
            }

            @i(name = "getName")
            @l
            public final String getName() {
                String name = this._builder.getName();
                l0.o(name, "getName(...)");
                return name;
            }

            @i(name = "getSize")
            public final long getSize() {
                return this._builder.getSize();
            }

            @i(name = "setId")
            public final void setId(long j10) {
                this._builder.setId(j10);
            }

            @i(name = "setMd5")
            public final void setMd5(@l String str) {
                l0.p(str, "value");
                this._builder.setMd5(str);
            }

            @i(name = "setName")
            public final void setName(@l String str) {
                l0.p(str, "value");
                this._builder.setName(str);
            }

            @i(name = "setSize")
            public final void setSize(long j10) {
                this._builder.setSize(j10);
            }

            private Dsl(SendFileInfoRequest.FileInfo.Builder builder) {
                this._builder = builder;
            }
        }

        private FileInfoKt() {
        }
    }

    private SendFileInfoRequestKt() {
    }

    @i(name = "-initializefileInfo")
    @l
    /* JADX INFO: renamed from: -initializefileInfo, reason: not valid java name */
    public final SendFileInfoRequest.FileInfo m51initializefileInfo(@l jn.l<? super FileInfoKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        FileInfoKt.Dsl.Companion companion = FileInfoKt.Dsl.Companion;
        SendFileInfoRequest.FileInfo.Builder builderNewBuilder = SendFileInfoRequest.FileInfo.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        FileInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
