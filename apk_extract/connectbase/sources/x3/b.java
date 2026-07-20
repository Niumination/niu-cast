package x3;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.transsion.athena.data.TrackData;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f20002a;

    public b(Handler handler) {
        this.f20002a = handler;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0058 A[Catch: Exception -> 0x006f, TRY_ENTER, TryCatch #0 {Exception -> 0x006f, blocks: (B:27:0x0066, B:22:0x0058, B:25:0x005f, B:18:0x0049, B:14:0x0041, B:20:0x0052), top: B:49:0x0041, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:25:0x005f A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:27:0x0066, B:22:0x0058, B:25:0x005f, B:18:0x0049, B:14:0x0041, B:20:0x0052), top: B:49:0x0041, inners: #1, #3 }] */
    @Override // java.lang.Runnable
    public void run() {
        String str;
        boolean z10;
        Context contextH0 = k6.g.h0();
        m0.a aVarA = m0.a.a(contextH0);
        String strI = aVarA.i("athena_id");
        try {
            str = y3.e.e(contextH0).f20696a;
        } catch (Exception e10) {
            y3.b.c("%s", e10.getMessage());
            str = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(strI, str)) {
            aVarA.g("athena_id", str);
            if (!TextUtils.isEmpty(strI)) {
                int i10 = y3.d.f20693e;
                try {
                    try {
                        if (contextH0.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                            try {
                                if (contextH0.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") != 0) {
                                    z10 = false;
                                } else if (k6.g.w0()) {
                                    z10 = true;
                                } else {
                                    z10 = !y3.d.j(contextH0);
                                }
                            } catch (Exception e11) {
                                y3.b.d(e11.getMessage());
                            }
                        } else if (k6.g.w0()) {
                            z10 = true;
                        } else {
                            z10 = !y3.d.j(contextH0);
                        }
                    } catch (Exception e12) {
                        y3.b.d(e12.getMessage());
                    }
                } catch (Exception unused) {
                }
                if (z10) {
                    if (TextUtils.isEmpty("")) {
                        k6.g.j0(9999).c1("data_discard", new TrackData().n("en", "device_id_transfer", 2).f("cnt", 1, 1), 9999);
                    } else {
                        k6.g.j0(9999).c1("device_id_transfer", new TrackData().m("pre_gaid", strI).m("sn", ""), 9999);
                    }
                }
            }
            strI = str;
        }
        if (!TextUtils.isEmpty(strI)) {
            y3.d.f(strI);
        }
        if (!((TextUtils.isEmpty(strI) && TextUtils.isEmpty("")) ? false : true)) {
            y3.b.c("%s", "device gaid and iid are null");
        }
        this.f20002a.postDelayed(this, 7200000L);
    }
}
