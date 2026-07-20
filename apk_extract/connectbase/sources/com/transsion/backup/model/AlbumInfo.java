package com.transsion.backup.model;

import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class AlbumInfo {
    private final long albumId;

    @l
    private final String albumName;
    private final int fileCount;

    public AlbumInfo(@l String str, long j10, int i10) {
        l0.p(str, "albumName");
        this.albumName = str;
        this.albumId = j10;
        this.fileCount = i10;
    }

    public static /* synthetic */ AlbumInfo copy$default(AlbumInfo albumInfo, String str, long j10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = albumInfo.albumName;
        }
        if ((i11 & 2) != 0) {
            j10 = albumInfo.albumId;
        }
        if ((i11 & 4) != 0) {
            i10 = albumInfo.fileCount;
        }
        return albumInfo.copy(str, j10, i10);
    }

    @l
    public final String component1() {
        return this.albumName;
    }

    public final long component2() {
        return this.albumId;
    }

    public final int component3() {
        return this.fileCount;
    }

    @l
    public final AlbumInfo copy(@l String str, long j10, int i10) {
        l0.p(str, "albumName");
        return new AlbumInfo(str, j10, i10);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumInfo)) {
            return false;
        }
        AlbumInfo albumInfo = (AlbumInfo) obj;
        return l0.g(this.albumName, albumInfo.albumName) && this.albumId == albumInfo.albumId && this.fileCount == albumInfo.fileCount;
    }

    public final long getAlbumId() {
        return this.albumId;
    }

    @l
    public final String getAlbumName() {
        return this.albumName;
    }

    public final int getFileCount() {
        return this.fileCount;
    }

    public int hashCode() {
        return Integer.hashCode(this.fileCount) + ((Long.hashCode(this.albumId) + (this.albumName.hashCode() * 31)) * 31);
    }

    @l
    public String toString() {
        return "AlbumInfo(albumName=" + this.albumName + ", albumId=" + this.albumId + ", fileCount=" + this.fileCount + ")";
    }
}
