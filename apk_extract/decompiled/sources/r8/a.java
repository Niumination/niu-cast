package r8;

import android.view.IDisplayFoldListener;
import j3.z;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import pa.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends IDisplayFoldListener.Stub {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f9383b;

    public final void onDisplayFoldChanged(int i8, boolean z2) {
        if (this.f9383b != null) {
            Iterator it = CollectionsKt.toList(c.f8710h).iterator();
            while (it.hasNext()) {
                ((Function2) it.next()).invoke(Integer.valueOf(i8), Boolean.valueOf(z2));
            }
        }
    }
}
