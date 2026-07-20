package com.transsion.backup.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nBackupDataKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BackupDataKt.kt\ncom/transsion/backup/protos/BackupDataKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
public final class BackupDataKtKt {
    @i(name = "-initializebackupData")
    @l
    /* JADX INFO: renamed from: -initializebackupData, reason: not valid java name */
    public static final BackupData m56initializebackupData(@l jn.l<? super BackupDataKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        BackupDataKt.Dsl.Companion companion = BackupDataKt.Dsl.Companion;
        BackupData.Builder builderNewBuilder = BackupData.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        BackupDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final BackupData copy(@l BackupData backupData, @l jn.l<? super BackupDataKt.Dsl, l2> lVar) {
        l0.p(backupData, "<this>");
        l0.p(lVar, "block");
        BackupDataKt.Dsl.Companion companion = BackupDataKt.Dsl.Companion;
        BackupData.Builder builder = backupData.toBuilder();
        l0.o(builder, "toBuilder(...)");
        BackupDataKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final BackupData.AlbumInfo copy(@l BackupData.AlbumInfo albumInfo, @l jn.l<? super BackupDataKt.AlbumInfoKt.Dsl, l2> lVar) {
        l0.p(albumInfo, "<this>");
        l0.p(lVar, "block");
        BackupDataKt.AlbumInfoKt.Dsl.Companion companion = BackupDataKt.AlbumInfoKt.Dsl.Companion;
        BackupData.AlbumInfo.Builder builder = albumInfo.toBuilder();
        l0.o(builder, "toBuilder(...)");
        BackupDataKt.AlbumInfoKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final BackupData.AlbumFileInfo copy(@l BackupData.AlbumFileInfo albumFileInfo, @l jn.l<? super BackupDataKt.AlbumFileInfoKt.Dsl, l2> lVar) {
        l0.p(albumFileInfo, "<this>");
        l0.p(lVar, "block");
        BackupDataKt.AlbumFileInfoKt.Dsl.Companion companion = BackupDataKt.AlbumFileInfoKt.Dsl.Companion;
        BackupData.AlbumFileInfo.Builder builder = albumFileInfo.toBuilder();
        l0.o(builder, "toBuilder(...)");
        BackupDataKt.AlbumFileInfoKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
