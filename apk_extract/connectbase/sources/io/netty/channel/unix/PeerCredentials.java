package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;

/* JADX INFO: loaded from: classes2.dex */
public final class PeerCredentials {
    private final int[] gids;
    private final int pid;
    private final int uid;

    public PeerCredentials(int i10, int i11, int... iArr) {
        this.pid = i10;
        this.uid = i11;
        this.gids = iArr == null ? EmptyArrays.EMPTY_INTS : iArr;
    }

    public int[] gids() {
        return (int[]) this.gids.clone();
    }

    public int pid() {
        return this.pid;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("UserCredentials[pid=");
        sb2.append(this.pid);
        sb2.append("; uid=");
        sb2.append(this.uid);
        sb2.append("; gids=[");
        int[] iArr = this.gids;
        if (iArr.length > 0) {
            sb2.append(iArr[0]);
            for (int i10 = 1; i10 < this.gids.length; i10++) {
                sb2.append(", ");
                sb2.append(this.gids[i10]);
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    public int uid() {
        return this.uid;
    }
}
