package kn;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q implements un.c, Serializable {

    @lm.f1(version = "1.1")
    public static final Object NO_RECEIVER = a.f9336a;

    @lm.f1(version = "1.4")
    private final boolean isTopLevel;

    @lm.f1(version = "1.4")
    private final String name;

    @lm.f1(version = "1.4")
    private final Class owner;

    @lm.f1(version = "1.1")
    protected final Object receiver;
    private transient un.c reflected;

    @lm.f1(version = "1.4")
    private final String signature;

    @lm.f1(version = "1.2")
    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9336a = new a();

        private Object readResolve() throws ObjectStreamException {
            return f9336a;
        }
    }

    public q() {
        this(NO_RECEIVER);
    }

    @Override // un.c
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // un.c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @lm.f1(version = "1.1")
    public un.c compute() {
        un.c cVar = this.reflected;
        if (cVar != null) {
            return cVar;
        }
        un.c cVarComputeReflected = computeReflected();
        this.reflected = cVarComputeReflected;
        return cVarComputeReflected;
    }

    public abstract un.c computeReflected();

    @Override // un.b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @lm.f1(version = "1.1")
    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // un.c
    public String getName() {
        return this.name;
    }

    public un.h getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? l1.g(cls) : l1.d(cls);
    }

    @Override // un.c
    public List<un.n> getParameters() {
        return getReflected().getParameters();
    }

    @lm.f1(version = "1.1")
    public un.c getReflected() {
        un.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute;
        }
        throw new in.r();
    }

    @Override // un.c
    public un.s getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // un.c
    @lm.f1(version = "1.1")
    public List<un.t> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // un.c
    @lm.f1(version = "1.1")
    public un.w getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // un.c
    @lm.f1(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // un.c
    @lm.f1(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // un.c
    @lm.f1(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // un.c, un.i
    @lm.f1(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @lm.f1(version = "1.1")
    public q(Object obj) {
        this(obj, null, null, null, false);
    }

    @lm.f1(version = "1.4")
    public q(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }
}
