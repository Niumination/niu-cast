package j3;

import android.content.Context;
import java.util.ArrayList;
import k3.be;
import k3.vd;
import k3.xd;
import m3.la;
import m3.na;
import m3.oa;

/* JADX INFO: loaded from: classes.dex */
public final class w extends gg.y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6089b;

    @Override // gg.y
    public final Object a(Object obj) {
        switch (this.f6089b) {
            case 0:
                p5.f fVarC = p5.f.c();
                Context contextB = p5.f.c().b();
                ArrayList arrayList = new ArrayList();
                q5.a aVar = new q5.a();
                b2.a aVar2 = b2.a.e;
                d2.l.b(contextB);
                d2.l.a().c(aVar2);
                b2.a.f1180d.contains(new a2.b("json"));
                arrayList.add(aVar);
                return new v(fVarC.b(), (p5.i) fVarC.a(p5.i.class));
            case 1:
                vd vdVar = (vd) obj;
                p5.f fVarC2 = p5.f.c();
                return new be(fVarC2.b(), (p5.i) fVarC2.a(p5.i.class), new xd(p5.f.c().b(), vdVar), vdVar.f6685a);
            default:
                p5.f fVarC3 = p5.f.c();
                return new oa(fVarC3.b(), (p5.i) fVarC3.a(p5.i.class), new na(p5.f.c().b(), (la) obj));
        }
    }
}
