package b9;

import android.content.Context;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes2.dex */
public class i implements lh.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f771b = "i";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f772a = bc.a.a();

    @Override // lh.e
    public KeyEvent a(long j10, long j11, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, String str) {
        Class cls = Long.TYPE;
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(KeyEvent.class, "obtain", cls, cls, cls2, cls2, cls2, cls2, cls2, cls2, cls2, cls2, cls2, String.class), KeyEvent.class, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str);
        if (objJ instanceof KeyEvent) {
            return (KeyEvent) objJ;
        }
        return null;
    }
}
