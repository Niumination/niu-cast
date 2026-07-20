package k3;

import com.google.mlkit.vision.barcode.internal.BarcodeScannerImpl;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class xc {
    public static BarcodeScannerImpl a(r5.a aVar) {
        v5.c cVar = (v5.c) p5.f.c().a(v5.c.class);
        cVar.getClass();
        return new BarcodeScannerImpl(aVar, (v5.f) cVar.f10504a.b(aVar), (Executor) cVar.f10505b.f8671a.get(), ee.b(true != v5.a.c() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning"));
    }
}
