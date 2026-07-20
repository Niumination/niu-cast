package xn;

import java.lang.ref.WeakReference;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static fq.b<String, Object> f20336a;

    static {
        fq.b<String, Object> bVarC = fq.b.c();
        l0.o(bVarC, "empty<String, Any>()");
        f20336a = bVarC;
    }

    public static final void a() {
        fq.b<String, Object> bVarC = fq.b.c();
        l0.o(bVarC, "empty()");
        f20336a = bVarC;
    }

    @os.l
    public static final <T> h<T> b(@os.l Class<T> cls) {
        l0.p(cls, "jClass");
        String name = cls.getName();
        Object objD = f20336a.d(name);
        if (objD instanceof WeakReference) {
            h<T> hVar = (h) ((WeakReference) objD).get();
            if (l0.g(hVar != null ? hVar.f20337d : null, cls)) {
                return hVar;
            }
        } else if (objD != null) {
            WeakReference[] weakReferenceArr = (WeakReference[]) objD;
            int length = weakReferenceArr.length;
            int i10 = 0;
            while (i10 < length) {
                WeakReference weakReference = weakReferenceArr[i10];
                i10++;
                h<T> hVar2 = (h) weakReference.get();
                if (l0.g(hVar2 == null ? null : hVar2.f20337d, cls)) {
                    return hVar2;
                }
            }
            int length2 = ((Object[]) objD).length;
            WeakReference[] weakReferenceArr2 = new WeakReference[length2 + 1];
            System.arraycopy(objD, 0, weakReferenceArr2, 0, length2);
            h<T> hVar3 = new h<>(cls);
            weakReferenceArr2[length2] = new WeakReference(hVar3);
            fq.b<String, Object> bVarH = f20336a.h(name, weakReferenceArr2);
            l0.o(bVarH, "K_CLASS_CACHE.plus(name, newArray)");
            f20336a = bVarH;
            return hVar3;
        }
        h<T> hVar4 = new h<>(cls);
        fq.b<String, Object> bVarH2 = f20336a.h(name, new WeakReference(hVar4));
        l0.o(bVarH2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        f20336a = bVarH2;
        return hVar4;
    }
}
