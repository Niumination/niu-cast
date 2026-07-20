package com.transsion.backup.model;

import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class FileServerInfo {
    private final int grpcPort;
    private final int socketPort;

    public FileServerInfo(int i10, int i11) {
        this.socketPort = i10;
        this.grpcPort = i11;
    }

    public static /* synthetic */ FileServerInfo copy$default(FileServerInfo fileServerInfo, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = fileServerInfo.socketPort;
        }
        if ((i12 & 2) != 0) {
            i11 = fileServerInfo.grpcPort;
        }
        return fileServerInfo.copy(i10, i11);
    }

    public final int component1() {
        return this.socketPort;
    }

    public final int component2() {
        return this.grpcPort;
    }

    @l
    public final FileServerInfo copy(int i10, int i11) {
        return new FileServerInfo(i10, i11);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileServerInfo)) {
            return false;
        }
        FileServerInfo fileServerInfo = (FileServerInfo) obj;
        return this.socketPort == fileServerInfo.socketPort && this.grpcPort == fileServerInfo.grpcPort;
    }

    public final int getGrpcPort() {
        return this.grpcPort;
    }

    public final int getSocketPort() {
        return this.socketPort;
    }

    public int hashCode() {
        return Integer.hashCode(this.grpcPort) + (Integer.hashCode(this.socketPort) * 31);
    }

    @l
    public String toString() {
        return "FileServerInfo(socketPort=" + this.socketPort + ", grpcPort=" + this.grpcPort + ")";
    }
}
