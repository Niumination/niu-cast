package vd;

import android.os.Bundle;
import com.transsion.hubsdk.os.ITranMediaCallback;
import com.transsion.hubsdk.os.TranVibrator;

/* JADX INFO: loaded from: classes2.dex */
public class b1 implements pg.r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16909b = "TranThubVibratorManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranVibrator f16910a = new TranVibrator();

    public class a implements ITranMediaCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public va.y.a f16911a;

        public a(va.y.a aVar) {
            this.f16911a = aVar;
        }

        public int a() {
            if (b1.this.f16910a != null) {
                return this.f16911a.a();
            }
            return -1;
        }
    }

    @Override // pg.r
    public void a(String str, va.y.a aVar) {
        a aVar2 = aVar != null ? new a(aVar) : null;
        dc.e.a(f16909b, "vibrate by file and callback: " + str);
        TranVibrator tranVibrator = this.f16910a;
        if (tranVibrator != null) {
            tranVibrator.vibrate(str, aVar2);
        }
    }

    @Override // pg.r
    public void b(String str) {
        dc.e.a(f16909b, "vibrate by file: " + str);
        TranVibrator tranVibrator = this.f16910a;
        if (tranVibrator != null) {
            tranVibrator.vibrate(str);
        }
    }

    @Override // pg.r
    public void c(String str, Bundle bundle) {
        dc.e.a(f16909b, "vibrate by file: " + str);
        TranVibrator tranVibrator = this.f16910a;
        if (tranVibrator != null) {
            tranVibrator.vibrate(str, bundle);
        }
    }

    @Override // pg.r
    public void d(String str, va.y.a aVar, Bundle bundle) {
        a aVar2 = aVar != null ? new a(aVar) : null;
        dc.e.a(f16909b, "vibrate by file and callback: " + str);
        TranVibrator tranVibrator = this.f16910a;
        if (tranVibrator != null) {
            tranVibrator.vibrate(str, aVar2, bundle);
        }
    }

    @Override // pg.r
    public void e(int i10) {
        dc.e.a(f16909b, "vibrate by type: " + i10);
        TranVibrator tranVibrator = this.f16910a;
        if (tranVibrator != null) {
            tranVibrator.vibrate(i10);
        }
    }

    @Override // pg.r
    public void stop() {
        dc.e.a(f16909b, "stop vibrate");
        TranVibrator tranVibrator = this.f16910a;
        if (tranVibrator != null) {
            tranVibrator.stop();
        }
    }
}
