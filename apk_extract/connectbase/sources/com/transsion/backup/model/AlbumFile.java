package com.transsion.backup.model;

import k0.d;
import kn.l0;
import kn.w;
import os.l;
import os.m;
import s0.b;

/* JADX INFO: loaded from: classes2.dex */
public final class AlbumFile {

    @l
    public static final Companion Companion = new Companion(null);
    public static final int MEDIA_TYPE_IMAGE = 0;
    public static final int MEDIA_TYPE_VIDEO = 1;

    @l
    public static final String MIME_PREFIX_IMAGE = "image";

    @l
    public static final String MIME_PREFIX_VIDEO = "video";
    private final long albumId;

    @l
    private final String albumName;
    private final long createDate;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f1827id;

    @m
    private final Boolean isDeleted;

    @l
    private final String name;

    @l
    private final transient String path;
    private final long size;
    private final int type;

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        private Companion() {
        }
    }

    public AlbumFile(long j10, @l String str, long j11, @l String str2, int i10, @l String str3, long j12, long j13, @m Boolean bool) {
        l0.p(str, "name");
        l0.p(str2, "path");
        l0.p(str3, "albumName");
        this.f1827id = j10;
        this.name = str;
        this.size = j11;
        this.path = str2;
        this.type = i10;
        this.albumName = str3;
        this.albumId = j12;
        this.createDate = j13;
        this.isDeleted = bool;
    }

    public final long component1() {
        return this.f1827id;
    }

    @l
    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.size;
    }

    @l
    public final String component4() {
        return this.path;
    }

    public final int component5() {
        return this.type;
    }

    @l
    public final String component6() {
        return this.albumName;
    }

    public final long component7() {
        return this.albumId;
    }

    public final long component8() {
        return this.createDate;
    }

    @m
    public final Boolean component9() {
        return this.isDeleted;
    }

    @l
    public final AlbumFile copy(long j10, @l String str, long j11, @l String str2, int i10, @l String str3, long j12, long j13, @m Boolean bool) {
        l0.p(str, "name");
        l0.p(str2, "path");
        l0.p(str3, "albumName");
        return new AlbumFile(j10, str, j11, str2, i10, str3, j12, j13, bool);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumFile)) {
            return false;
        }
        AlbumFile albumFile = (AlbumFile) obj;
        return this.f1827id == albumFile.f1827id && l0.g(this.name, albumFile.name) && this.size == albumFile.size && l0.g(this.path, albumFile.path) && this.type == albumFile.type && l0.g(this.albumName, albumFile.albumName) && this.albumId == albumFile.albumId && this.createDate == albumFile.createDate && l0.g(this.isDeleted, albumFile.isDeleted);
    }

    public final long getAlbumId() {
        return this.albumId;
    }

    @l
    public final String getAlbumName() {
        return this.albumName;
    }

    public final long getCreateDate() {
        return this.createDate;
    }

    public final long getId() {
        return this.f1827id;
    }

    @l
    public final String getName() {
        return this.name;
    }

    @l
    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = (Long.hashCode(this.createDate) + ((Long.hashCode(this.albumId) + b.a(this.albumName, d.a(this.type, b.a(this.path, (Long.hashCode(this.size) + b.a(this.name, Long.hashCode(this.f1827id) * 31, 31)) * 31, 31), 31), 31)) * 31)) * 31;
        Boolean bool = this.isDeleted;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    @m
    public final Boolean isDeleted() {
        return this.isDeleted;
    }

    @l
    public String toString() {
        return "AlbumFile(id=" + this.f1827id + ", name=" + this.name + ", size=" + this.size + ", path=" + this.path + ", type=" + this.type + ", albumName=" + this.albumName + ", albumId=" + this.albumId + ", createDate=" + this.createDate + ", isDeleted=" + this.isDeleted + ")";
    }

    public /* synthetic */ AlbumFile(long j10, String str, long j11, String str2, int i10, String str3, long j12, long j13, Boolean bool, int i11, w wVar) {
        this(j10, str, j11, str2, i10, str3, j12, j13, (i11 & 256) != 0 ? null : bool);
    }
}
