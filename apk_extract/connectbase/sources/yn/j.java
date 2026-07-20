package yn;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kn.l0;
import nm.k0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final j f21501a = new j();

    @Override // yn.d
    @l
    public List<Type> a() {
        return k0.INSTANCE;
    }

    @Override // yn.d
    public Member b() {
        return null;
    }

    @m
    public Void c() {
        return null;
    }

    @Override // yn.d
    @m
    public Object call(@l Object[] objArr) {
        l0.p(objArr, d6.a.F);
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // yn.d
    @l
    public Type getReturnType() {
        Class cls = Void.TYPE;
        l0.o(cls, "TYPE");
        return cls;
    }
}
