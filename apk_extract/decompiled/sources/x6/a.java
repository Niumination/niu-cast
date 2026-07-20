package x6;

import android.os.Handler;
import android.util.Log;
import androidx.work.PeriodicWorkRequest;
import com.tencent.mmkv.MMKV;
import s6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f10869a;

    public a(c cVar) {
        this.f10869a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (!d.e()) {
            z6.a.e("Athena SDK isAthenaEnable = false");
            return;
        }
        try {
            MMKV mmkvMmkvWithID = MMKV.mmkvWithID("AthenaKV", 2);
            String[] strArrAllKeys = mmkvMmkvWithID.allKeys();
            c cVar = this.f10869a;
            if (strArrAllKeys != null && strArrAllKeys.length > 0) {
                cVar.n(mmkvMmkvWithID);
            }
            ((Handler) cVar.f1435c).postDelayed(this, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }
}
