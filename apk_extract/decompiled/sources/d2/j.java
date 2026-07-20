package d2;

import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static c a() {
        c cVar = new c();
        a2.c cVar2 = a2.c.DEFAULT;
        if (cVar2 == null) {
            throw new NullPointerException("Null priority");
        }
        cVar.f4268c = cVar2;
        return cVar;
    }

    public final String toString() {
        d dVar = (d) this;
        byte[] bArr = dVar.f4270b;
        return "TransportContext(" + dVar.f4269a + ", " + dVar.f4271c + ", " + (bArr == null ? "" : Base64.encodeToString(bArr, 2)) + ")";
    }
}
