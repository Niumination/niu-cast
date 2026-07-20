package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import java.util.Arrays;
import rs.f;

/* JADX INFO: loaded from: classes3.dex */
final class OpenSslSessionId {
    static final OpenSslSessionId NULL_ID = new OpenSslSessionId(EmptyArrays.EMPTY_BYTES);
    private final int hashCode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final byte[] f8333id;

    public OpenSslSessionId(byte[] bArr) {
        this.f8333id = bArr;
        this.hashCode = Arrays.hashCode(bArr);
    }

    public byte[] cloneBytes() {
        return (byte[]) this.f8333id.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OpenSslSessionId) {
            return Arrays.equals(this.f8333id, ((OpenSslSessionId) obj).f8333id);
        }
        return false;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return "OpenSslSessionId{id=" + Arrays.toString(this.f8333id) + f.f14860b;
    }
}
