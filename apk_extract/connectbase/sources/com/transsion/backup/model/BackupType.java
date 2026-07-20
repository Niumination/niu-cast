package com.transsion.backup.model;

import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class BackupType {
    public static final int AUTO_BACKUP = 1;

    @l
    public static final BackupType INSTANCE = new BackupType();
    public static final int MANUAL_BACKUP = 0;

    private BackupType() {
    }
}
