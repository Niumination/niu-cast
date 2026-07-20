package cf;

import ze.f1;
import ze.h1;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends h1 {
    @Override // ze.h1
    public f1 a(String str, int i8) {
        return new k(str, i8);
    }

    @Override // ze.h1
    public boolean b() {
        return true;
    }

    @Override // ze.h1
    public int c() {
        try {
            Class.forName("android.app.Application", false, l.class.getClassLoader());
            return 8;
        } catch (Exception unused) {
            return 3;
        }
    }
}
