package x0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class h implements k0<s0.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f19905a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y0.c.a f19906b = y0.c.a.a("t", "f", p6.s.f13016a, "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    @Override // x0.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public s0.c a(y0.c cVar, float f10) throws IOException {
        s0.c.a aVar = s0.c.a.CENTER;
        cVar.d();
        s0.c.a aVar2 = aVar;
        String strA = null;
        String strA2 = null;
        float fQ = 0.0f;
        float fQ2 = 0.0f;
        float fQ3 = 0.0f;
        float fQ4 = 0.0f;
        int iT = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zP = true;
        while (cVar.o()) {
            switch (cVar.e0(f19906b)) {
                case 0:
                    strA = cVar.A();
                    break;
                case 1:
                    strA2 = cVar.A();
                    break;
                case 2:
                    fQ = (float) cVar.q();
                    break;
                case 3:
                    int iT2 = cVar.t();
                    aVar2 = s0.c.a.CENTER;
                    if (iT2 <= aVar2.ordinal() && iT2 >= 0) {
                        aVar2 = s0.c.a.values()[iT2];
                    }
                    break;
                case 4:
                    iT = cVar.t();
                    break;
                case 5:
                    fQ2 = (float) cVar.q();
                    break;
                case 6:
                    fQ3 = (float) cVar.q();
                    break;
                case 7:
                    iD = p.d(cVar);
                    break;
                case 8:
                    iD2 = p.d(cVar);
                    break;
                case 9:
                    fQ4 = (float) cVar.q();
                    break;
                case 10:
                    zP = cVar.p();
                    break;
                default:
                    cVar.f0();
                    cVar.g0();
                    break;
            }
        }
        cVar.k();
        return new s0.c(strA, strA2, fQ, aVar2, iT, fQ2, fQ3, iD, iD2, fQ4, zP);
    }
}
