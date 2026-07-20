package cp;

import fp.i;
import in.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import lm.t0;
import nm.h0;
import nm.y;
import nm.z;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final g f3382a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final fp.g f3383b;

    static {
        fp.g gVarD = fp.g.d();
        bp.a.a(gVarD);
        l0.o(gVarD, "newInstance().apply(JvmP…f::registerAllExtensions)");
        f3383b = gVarD;
    }

    public static /* synthetic */ d.a d(g gVar, yo.a.n nVar, ap.c cVar, ap.g gVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return gVar.c(nVar, cVar, gVar2, z10);
    }

    @n
    public static final boolean f(@l yo.a.n nVar) {
        l0.p(nVar, "proto");
        c.f3361a.getClass();
        ap.b.C0019b c0019b = c.f3362b;
        Object extension = nVar.getExtension(bp.a.f1007e);
        l0.o(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean boolD = c0019b.d(((Number) extension).intValue());
        l0.o(boolD, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return boolD.booleanValue();
    }

    @n
    @l
    public static final t0<f, yo.a.c> h(@l byte[] bArr, @l String[] strArr) {
        l0.p(bArr, "bytes");
        l0.p(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new t0<>(f3382a.k(byteArrayInputStream, strArr), yo.a.c.parseFrom(byteArrayInputStream, f3383b));
    }

    @n
    @l
    public static final t0<f, yo.a.c> i(@l String[] strArr, @l String[] strArr2) {
        l0.p(strArr, "data");
        l0.p(strArr2, "strings");
        byte[] bArrE = a.e(strArr);
        l0.o(bArrE, "decodeBytes(data)");
        return h(bArrE, strArr2);
    }

    @n
    @l
    public static final t0<f, yo.a.i> j(@l String[] strArr, @l String[] strArr2) {
        l0.p(strArr, "data");
        l0.p(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(strArr));
        return new t0<>(f3382a.k(byteArrayInputStream, strArr2), yo.a.i.parseFrom(byteArrayInputStream, f3383b));
    }

    @n
    @l
    public static final t0<f, yo.a.l> l(@l byte[] bArr, @l String[] strArr) {
        l0.p(bArr, "bytes");
        l0.p(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new t0<>(f3382a.k(byteArrayInputStream, strArr), yo.a.l.parseFrom(byteArrayInputStream, f3383b));
    }

    @n
    @l
    public static final t0<f, yo.a.l> m(@l String[] strArr, @l String[] strArr2) {
        l0.p(strArr, "data");
        l0.p(strArr2, "strings");
        byte[] bArrE = a.e(strArr);
        l0.o(bArrE, "decodeBytes(data)");
        return l(bArrE, strArr2);
    }

    @l
    public final fp.g a() {
        return f3383b;
    }

    @m
    public final d.b b(@l yo.a.d dVar, @l ap.c cVar, @l ap.g gVar) {
        String strM3;
        l0.p(dVar, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(gVar, "typeTable");
        i.g<yo.a.d, bp.a.c> gVar2 = bp.a.f1003a;
        l0.o(gVar2, "constructorSignature");
        bp.a.c cVar2 = (bp.a.c) ap.e.a(dVar, gVar2);
        String strC = (cVar2 == null || !cVar2.hasName()) ? "<init>" : cVar.c(cVar2.getName());
        if (cVar2 == null || !cVar2.hasDesc()) {
            List<yo.a.u> valueParameterList = dVar.getValueParameterList();
            l0.o(valueParameterList, "proto.valueParameterList");
            List<yo.a.u> list = valueParameterList;
            ArrayList arrayList = new ArrayList(z.b0(list, 10));
            for (yo.a.u uVar : list) {
                g gVar3 = f3382a;
                l0.o(uVar, "it");
                String strG = gVar3.g(ap.f.n(uVar, gVar), cVar);
                if (strG == null) {
                    return null;
                }
                arrayList.add(strG);
            }
            strM3 = h0.m3(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            strM3 = cVar.c(cVar2.getDesc());
        }
        return new d.b(strC, strM3);
    }

    @m
    public final d.a c(@l yo.a.n nVar, @l ap.c cVar, @l ap.g gVar, boolean z10) {
        String strG;
        l0.p(nVar, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(gVar, "typeTable");
        i.g<yo.a.n, bp.a.d> gVar2 = bp.a.f1006d;
        l0.o(gVar2, "propertySignature");
        bp.a.d dVar = (bp.a.d) ap.e.a(nVar, gVar2);
        if (dVar == null) {
            return null;
        }
        bp.a.b field = dVar.hasField() ? dVar.getField() : null;
        if (field == null && z10) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? nVar.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            strG = g(ap.f.k(nVar, gVar), cVar);
            if (strG == null) {
                return null;
            }
        } else {
            strG = cVar.c(field.getDesc());
        }
        return new d.a(cVar.c(name), strG);
    }

    @m
    public final d.b e(@l yo.a.i iVar, @l ap.c cVar, @l ap.g gVar) {
        String strC;
        l0.p(iVar, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(gVar, "typeTable");
        i.g<yo.a.i, bp.a.c> gVar2 = bp.a.f1004b;
        l0.o(gVar2, "methodSignature");
        bp.a.c cVar2 = (bp.a.c) ap.e.a(iVar, gVar2);
        int name = (cVar2 == null || !cVar2.hasName()) ? iVar.getName() : cVar2.getName();
        if (cVar2 == null || !cVar2.hasDesc()) {
            List listP = y.P(ap.f.h(iVar, gVar));
            List<yo.a.u> valueParameterList = iVar.getValueParameterList();
            l0.o(valueParameterList, "proto.valueParameterList");
            List<yo.a.u> list = valueParameterList;
            ArrayList arrayList = new ArrayList(z.b0(list, 10));
            for (yo.a.u uVar : list) {
                l0.o(uVar, "it");
                arrayList.add(ap.f.n(uVar, gVar));
            }
            List listE4 = h0.E4(listP, arrayList);
            ArrayList arrayList2 = new ArrayList(z.b0(listE4, 10));
            Iterator it = listE4.iterator();
            while (it.hasNext()) {
                String strG = f3382a.g((yo.a.q) it.next(), cVar);
                if (strG == null) {
                    return null;
                }
                arrayList2.add(strG);
            }
            String strG2 = g(ap.f.j(iVar, gVar), cVar);
            if (strG2 == null) {
                return null;
            }
            strC = l0.C(h0.m3(arrayList2, "", "(", ")", 0, null, null, 56, null), strG2);
        } else {
            strC = cVar.c(cVar2.getDesc());
        }
        return new d.b(cVar.c(name), strC);
    }

    public final String g(yo.a.q qVar, ap.c cVar) {
        if (qVar.hasClassName()) {
            return b.b(cVar.b(qVar.getClassName()));
        }
        return null;
    }

    public final f k(InputStream inputStream, String[] strArr) throws IOException {
        bp.a.e delimitedFrom = bp.a.e.parseDelimitedFrom(inputStream, f3383b);
        l0.o(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new f(delimitedFrom, strArr);
    }
}
