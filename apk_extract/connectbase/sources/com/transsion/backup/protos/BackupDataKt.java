package com.transsion.backup.protos;

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
@r1({"SMAP\nBackupDataKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BackupDataKt.kt\ncom/transsion/backup/protos/BackupDataKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
public final class BackupDataKt {

    @l
    public static final BackupDataKt INSTANCE = new BackupDataKt();

    public static final class AlbumFileInfoKt {

        @l
        public static final AlbumFileInfoKt INSTANCE = new AlbumFileInfoKt();

        @ProtoDslMarker
        public static final class Dsl {

            @l
            public static final Companion Companion = new Companion(null);

            @l
            private final BackupData.AlbumFileInfo.Builder _builder;

            public static final class Companion {
                public /* synthetic */ Companion(w wVar) {
                    this();
                }

                @z0
                public final /* synthetic */ Dsl _create(BackupData.AlbumFileInfo.Builder builder) {
                    l0.p(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            public /* synthetic */ Dsl(BackupData.AlbumFileInfo.Builder builder, w wVar) {
                this(builder);
            }

            @z0
            public final /* synthetic */ BackupData.AlbumFileInfo _build() {
                BackupData.AlbumFileInfo albumFileInfoBuild = this._builder.build();
                l0.o(albumFileInfoBuild, "build(...)");
                return albumFileInfoBuild;
            }

            public final void clearAlbumId() {
                this._builder.clearAlbumId();
            }

            public final void clearCreateDate() {
                this._builder.clearCreateDate();
            }

            public final void clearId() {
                this._builder.clearId();
            }

            public final void clearIsDeleted() {
                this._builder.clearIsDeleted();
            }

            public final void clearName() {
                this._builder.clearName();
            }

            public final void clearSize() {
                this._builder.clearSize();
            }

            public final void clearType() {
                this._builder.clearType();
            }

            @i(name = "getAlbumId")
            public final long getAlbumId() {
                return this._builder.getAlbumId();
            }

            @i(name = "getCreateDate")
            public final long getCreateDate() {
                return this._builder.getCreateDate();
            }

            @i(name = "getId")
            public final long getId() {
                return this._builder.getId();
            }

            @i(name = "getIsDeleted")
            public final boolean getIsDeleted() {
                return this._builder.getIsDeleted();
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

            @i(name = "getType")
            public final int getType() {
                return this._builder.getType();
            }

            @i(name = "setAlbumId")
            public final void setAlbumId(long j10) {
                this._builder.setAlbumId(j10);
            }

            @i(name = "setCreateDate")
            public final void setCreateDate(long j10) {
                this._builder.setCreateDate(j10);
            }

            @i(name = "setId")
            public final void setId(long j10) {
                this._builder.setId(j10);
            }

            @i(name = "setIsDeleted")
            public final void setIsDeleted(boolean z10) {
                this._builder.setIsDeleted(z10);
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

            @i(name = "setType")
            public final void setType(int i10) {
                this._builder.setType(i10);
            }

            private Dsl(BackupData.AlbumFileInfo.Builder builder) {
                this._builder = builder;
            }
        }

        private AlbumFileInfoKt() {
        }
    }

    public static final class AlbumInfoKt {

        @l
        public static final AlbumInfoKt INSTANCE = new AlbumInfoKt();

        @ProtoDslMarker
        public static final class Dsl {

            @l
            public static final Companion Companion = new Companion(null);

            @l
            private final BackupData.AlbumInfo.Builder _builder;

            public static final class Companion {
                public /* synthetic */ Companion(w wVar) {
                    this();
                }

                @z0
                public final /* synthetic */ Dsl _create(BackupData.AlbumInfo.Builder builder) {
                    l0.p(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            public /* synthetic */ Dsl(BackupData.AlbumInfo.Builder builder, w wVar) {
                this(builder);
            }

            @z0
            public final /* synthetic */ BackupData.AlbumInfo _build() {
                BackupData.AlbumInfo albumInfoBuild = this._builder.build();
                l0.o(albumInfoBuild, "build(...)");
                return albumInfoBuild;
            }

            public final void clearId() {
                this._builder.clearId();
            }

            public final void clearName() {
                this._builder.clearName();
            }

            @i(name = "getId")
            public final long getId() {
                return this._builder.getId();
            }

            @i(name = "getName")
            @l
            public final String getName() {
                String name = this._builder.getName();
                l0.o(name, "getName(...)");
                return name;
            }

            @i(name = "setId")
            public final void setId(long j10) {
                this._builder.setId(j10);
            }

            @i(name = "setName")
            public final void setName(@l String str) {
                l0.p(str, "value");
                this._builder.setName(str);
            }

            private Dsl(BackupData.AlbumInfo.Builder builder) {
                this._builder = builder;
            }
        }

        private AlbumInfoKt() {
        }
    }

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final BackupData.Builder _builder;

        public static final class AlbumsProxy extends DslProxy {
            private AlbumsProxy() {
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(BackupData.Builder builder) {
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

        public /* synthetic */ Dsl(BackupData.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ BackupData _build() {
            BackupData backupDataBuild = this._builder.build();
            l0.o(backupDataBuild, "build(...)");
            return backupDataBuild;
        }

        @i(name = "addAlbums")
        public final /* synthetic */ void addAlbums(DslList dslList, BackupData.AlbumInfo albumInfo) {
            l0.p(dslList, "<this>");
            l0.p(albumInfo, "value");
            this._builder.addAlbums(albumInfo);
        }

        @i(name = "addAllAlbums")
        public final /* synthetic */ void addAllAlbums(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllAlbums(iterable);
        }

        @i(name = "addAllFiles")
        public final /* synthetic */ void addAllFiles(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllFiles(iterable);
        }

        @i(name = "addFiles")
        public final /* synthetic */ void addFiles(DslList dslList, BackupData.AlbumFileInfo albumFileInfo) {
            l0.p(dslList, "<this>");
            l0.p(albumFileInfo, "value");
            this._builder.addFiles(albumFileInfo);
        }

        @i(name = "clearAlbums")
        public final /* synthetic */ void clearAlbums(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearAlbums();
        }

        public final void clearCurrentPage() {
            this._builder.clearCurrentPage();
        }

        @i(name = "clearFiles")
        public final /* synthetic */ void clearFiles(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearFiles();
        }

        public final void clearTaskId() {
            this._builder.clearTaskId();
        }

        public final void clearTotalPage() {
            this._builder.clearTotalPage();
        }

        public final /* synthetic */ DslList getAlbums() {
            List<BackupData.AlbumInfo> albumsList = this._builder.getAlbumsList();
            l0.o(albumsList, "getAlbumsList(...)");
            return new DslList(albumsList);
        }

        @i(name = "getCurrentPage")
        public final int getCurrentPage() {
            return this._builder.getCurrentPage();
        }

        public final /* synthetic */ DslList getFiles() {
            List<BackupData.AlbumFileInfo> filesList = this._builder.getFilesList();
            l0.o(filesList, "getFilesList(...)");
            return new DslList(filesList);
        }

        @i(name = "getTaskId")
        public final int getTaskId() {
            return this._builder.getTaskId();
        }

        @i(name = "getTotalPage")
        public final int getTotalPage() {
            return this._builder.getTotalPage();
        }

        @i(name = "plusAssignAlbums")
        public final /* synthetic */ void plusAssignAlbums(DslList<BackupData.AlbumInfo, AlbumsProxy> dslList, BackupData.AlbumInfo albumInfo) {
            l0.p(dslList, "<this>");
            l0.p(albumInfo, "value");
            addAlbums(dslList, albumInfo);
        }

        @i(name = "plusAssignAllAlbums")
        public final /* synthetic */ void plusAssignAllAlbums(DslList<BackupData.AlbumInfo, AlbumsProxy> dslList, Iterable<BackupData.AlbumInfo> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllAlbums(dslList, iterable);
        }

        @i(name = "plusAssignAllFiles")
        public final /* synthetic */ void plusAssignAllFiles(DslList<BackupData.AlbumFileInfo, FilesProxy> dslList, Iterable<BackupData.AlbumFileInfo> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllFiles(dslList, iterable);
        }

        @i(name = "plusAssignFiles")
        public final /* synthetic */ void plusAssignFiles(DslList<BackupData.AlbumFileInfo, FilesProxy> dslList, BackupData.AlbumFileInfo albumFileInfo) {
            l0.p(dslList, "<this>");
            l0.p(albumFileInfo, "value");
            addFiles(dslList, albumFileInfo);
        }

        @i(name = "setAlbums")
        public final /* synthetic */ void setAlbums(DslList dslList, int i10, BackupData.AlbumInfo albumInfo) {
            l0.p(dslList, "<this>");
            l0.p(albumInfo, "value");
            this._builder.setAlbums(i10, albumInfo);
        }

        @i(name = "setCurrentPage")
        public final void setCurrentPage(int i10) {
            this._builder.setCurrentPage(i10);
        }

        @i(name = "setFiles")
        public final /* synthetic */ void setFiles(DslList dslList, int i10, BackupData.AlbumFileInfo albumFileInfo) {
            l0.p(dslList, "<this>");
            l0.p(albumFileInfo, "value");
            this._builder.setFiles(i10, albumFileInfo);
        }

        @i(name = "setTaskId")
        public final void setTaskId(int i10) {
            this._builder.setTaskId(i10);
        }

        @i(name = "setTotalPage")
        public final void setTotalPage(int i10) {
            this._builder.setTotalPage(i10);
        }

        private Dsl(BackupData.Builder builder) {
            this._builder = builder;
        }
    }

    private BackupDataKt() {
    }

    @i(name = "-initializealbumFileInfo")
    @l
    /* JADX INFO: renamed from: -initializealbumFileInfo, reason: not valid java name */
    public final BackupData.AlbumFileInfo m54initializealbumFileInfo(@l jn.l<? super AlbumFileInfoKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        AlbumFileInfoKt.Dsl.Companion companion = AlbumFileInfoKt.Dsl.Companion;
        BackupData.AlbumFileInfo.Builder builderNewBuilder = BackupData.AlbumFileInfo.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        AlbumFileInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @i(name = "-initializealbumInfo")
    @l
    /* JADX INFO: renamed from: -initializealbumInfo, reason: not valid java name */
    public final BackupData.AlbumInfo m55initializealbumInfo(@l jn.l<? super AlbumInfoKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        AlbumInfoKt.Dsl.Companion companion = AlbumInfoKt.Dsl.Companion;
        BackupData.AlbumInfo.Builder builderNewBuilder = BackupData.AlbumInfo.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        AlbumInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
