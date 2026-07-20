package com.transsion.backup.model;

import com.google.gson.annotations.SerializedName;
import ik.y0;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class BackupMessage<T> {
    public static final int AUTHORIZATION = 1;
    public static final int AUTO_BACKUP_DATA = 6;
    public static final int BACKUP_DATA = 4;
    public static final int CANCEL_BACKUP = 8;

    @l
    public static final Companion Companion = new Companion(null);
    public static final int DELETE_FILES = 5;
    public static final int HANDSHAKE = 0;
    public static final int MANUAL_BACKUP_DATA = 7;
    public static final int SYNC_ALBUM_DATA = 2;
    public static final int SYNC_ALBUM_UPDATE_DATA = 3;
    public static final int SYNC_AUTO_BACKUP_STATUS = 9;

    @SerializedName("data")
    @m
    private final T data;

    @SerializedName(y0.a.f8215h)
    private final int type;

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        private Companion() {
        }
    }

    public BackupMessage(int i10, @m T t10) {
        this.type = i10;
        this.data = t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackupMessage copy$default(BackupMessage backupMessage, int i10, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            i10 = backupMessage.type;
        }
        if ((i11 & 2) != 0) {
            obj = backupMessage.data;
        }
        return backupMessage.copy(i10, obj);
    }

    public final int component1() {
        return this.type;
    }

    @m
    public final T component2() {
        return this.data;
    }

    @l
    public final BackupMessage<T> copy(int i10, @m T t10) {
        return new BackupMessage<>(i10, t10);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupMessage)) {
            return false;
        }
        BackupMessage backupMessage = (BackupMessage) obj;
        return this.type == backupMessage.type && l0.g(this.data, backupMessage.data);
    }

    @m
    public final T getData() {
        return this.data;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.type) * 31;
        T t10 = this.data;
        return iHashCode + (t10 == null ? 0 : t10.hashCode());
    }

    @l
    public String toString() {
        return "BackupMessage(type=" + this.type + ", data=" + this.data + ")";
    }

    public /* synthetic */ BackupMessage(int i10, Object obj, int i11, w wVar) {
        this(i10, (i11 & 2) != 0 ? null : obj);
    }
}
