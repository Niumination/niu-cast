package qo;

import eo.e1;
import eo.m;
import java.util.Map;
import kn.l0;
import kn.n0;
import uo.y;
import uo.z;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final h f14093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final m f14094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Map<y, Integer> f14096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final up.h<y, ro.m> f14097e;

    public static final class a extends n0 implements jn.l<y, ro.m> {
        public a() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final ro.m invoke(@os.l y yVar) {
            l0.p(yVar, "typeParameter");
            Integer num = i.this.f14096d.get(yVar);
            if (num == null) {
                return null;
            }
            i iVar = i.this;
            return new ro.m(qo.a.h(qo.a.b(iVar.f14093a, iVar), iVar.f14094b.getAnnotations()), yVar, iVar.f14095c + num.intValue(), iVar.f14094b);
        }
    }

    public i(@os.l h hVar, @os.l m mVar, @os.l z zVar, int i10) {
        l0.p(hVar, "c");
        l0.p(mVar, "containingDeclaration");
        l0.p(zVar, "typeParameterOwner");
        this.f14093a = hVar;
        this.f14094b = mVar;
        this.f14095c = i10;
        this.f14096d = eq.a.d(zVar.getTypeParameters());
        this.f14097e = hVar.f14088a.f14055a.f(new a());
    }

    @Override // qo.l
    @os.m
    public e1 a(@os.l y yVar) {
        l0.p(yVar, "javaTypeParameter");
        ro.m mVarInvoke = this.f14097e.invoke(yVar);
        return mVarInvoke == null ? this.f14093a.f14089b.a(yVar) : mVarInvoke;
    }
}
