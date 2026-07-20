package ep;

import os.l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final String f4655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final d f4656b;

    @l
    public String a() {
        return b().getDescription();
    }

    @l
    public d b() {
        return this.f4656b;
    }

    @l
    public String toString() {
        String strA = a();
        if (strA.length() <= 0) {
            return this.f4655a;
        }
        return this.f4655a + " (" + strA + ')';
    }
}
