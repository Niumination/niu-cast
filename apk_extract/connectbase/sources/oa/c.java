package oa;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import java.util.List;
import od.a1;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12124c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a1 f12125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x7.d f12126b;

    public AudioRecord a() {
        return b(fc.b.a.H).i();
    }

    public ig.c b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f12124c, "TranThubAudioPolicy");
            a1 a1Var = this.f12125a;
            if (a1Var != null) {
                return a1Var;
            }
            a1 a1Var2 = new a1();
            this.f12125a = a1Var2;
            return a1Var2;
        }
        dc.e.f(f12124c, "TranAospAudioPolicy");
        x7.d dVar = this.f12126b;
        if (dVar != null) {
            return dVar;
        }
        x7.d dVar2 = new x7.d();
        this.f12126b = dVar2;
        return dVar2;
    }

    public void c(Context context, int i10, AudioFormat audioFormat) {
        if (context == null || audioFormat == null) {
            dc.e.f(f12124c, "init param null, return");
        } else {
            b(fc.b.a.H).k(context, i10, audioFormat);
        }
    }

    public void d() {
        b(fc.b.a.H).release();
    }

    public void e(List<Integer> list, int i10) {
        if (list == null) {
            dc.e.f(f12124c, "updateAudioUid param null, return");
        } else {
            b(fc.b.a.H).j(list, i10);
        }
    }
}
