package oq;

import android.os.Looper;
import java.util.List;
import nq.x2;
import os.l;
import vq.e0;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements e0 {
    @Override // vq.e0
    @l
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // vq.e0
    @l
    public x2 b(@l List<? extends e0> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new d(g.e(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // vq.e0
    public int c() {
        return 1073741823;
    }
}
