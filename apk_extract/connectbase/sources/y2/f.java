package y2;

import java.util.UUID;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final f f20685a = new f();

    @Override // y2.e
    public long a() {
        return b();
    }

    public final long b() {
        long mostSignificantBits = UUID.randomUUID().getMostSignificantBits();
        return mostSignificantBits < 0 ? -mostSignificantBits : mostSignificantBits;
    }
}
