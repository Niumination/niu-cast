package v5;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import gg.y;
import k3.be;
import k3.e0;
import k3.ee;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p5.f f10506b;

    public d(p5.f fVar) {
        this.f10506b = fVar;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0031  */
    @Override // gg.y
    public final Object a(Object obj) {
        g hVar;
        r5.a aVar = (r5.a) obj;
        p5.f fVar = this.f10506b;
        Context contextB = fVar.b();
        be beVarB = ee.b(true != a.c() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning");
        e0 e0Var = h.f10520h;
        if (g3.e.a(contextB, ModuleDescriptor.MODULE_ID) > 0) {
            hVar = new h(contextB, aVar, beVarB);
        } else {
            p2.b.f8650b.getClass();
            if (p2.b.a(contextB) >= 204500000) {
                hVar = new h(contextB, aVar, beVarB);
            } else {
                e8.b bVar = new e8.b();
                zzah zzahVar = new zzah();
                bVar.f4716c = zzahVar;
                bVar.f4715b = contextB;
                zzahVar.f1986a = aVar.f9381a;
                bVar.f4717d = beVarB;
                hVar = bVar;
            }
        }
        return new f(fVar, aVar, hVar, beVarB);
    }
}
