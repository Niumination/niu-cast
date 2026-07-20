package com.transsion.backup.protos;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface BackupDataOrBuilder extends MessageLiteOrBuilder {
    BackupData.AlbumInfo getAlbums(int i10);

    int getAlbumsCount();

    List<BackupData.AlbumInfo> getAlbumsList();

    int getCurrentPage();

    BackupData.AlbumFileInfo getFiles(int i10);

    int getFilesCount();

    List<BackupData.AlbumFileInfo> getFilesList();

    int getTaskId();

    int getTotalPage();
}
