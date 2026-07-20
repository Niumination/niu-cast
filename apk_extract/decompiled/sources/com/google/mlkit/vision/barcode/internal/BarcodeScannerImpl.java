package com.google.mlkit.vision.barcode.internal;

import af.r5;
import com.google.android.gms.common.Feature;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import df.m;
import java.util.List;
import java.util.concurrent.Executor;
import k3.be;
import k3.ja;
import k3.la;
import k3.wa;
import k3.yd;
import p5.h;
import p5.l;
import t5.a;
import v5.f;

/* JADX INFO: loaded from: classes2.dex */
public class BarcodeScannerImpl extends MobileVisionBase<List<a>> implements BarcodeScanner {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2276h;

    public BarcodeScannerImpl(r5.a aVar, f fVar, Executor executor, be beVar) {
        super(fVar, executor);
        boolean zC = v5.a.c();
        this.f2276h = zC;
        r5 r5Var = new r5(6, false);
        r5Var.f558c = v5.a.a(aVar);
        wa waVar = new wa(r5Var);
        d2.a aVar2 = new d2.a();
        aVar2.f4259c = zC ? ja.TYPE_THICK : ja.TYPE_THIN;
        aVar2.f4260d = waVar;
        l.INSTANCE.execute(new yd(beVar, new m(aVar2, 1), la.ON_DEVICE_BARCODE_CREATE, beVar.c(), 0));
    }

    @Override // q2.j
    public final Feature[] a() {
        return this.f2276h ? h.f8680a : new Feature[]{h.f8681b};
    }

    @Override // com.google.mlkit.vision.common.internal.MobileVisionBase, java.io.Closeable, java.lang.AutoCloseable, com.google.mlkit.vision.barcode.BarcodeScanner
    public final synchronized void close() {
        super.close();
    }
}
