package ze;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends y implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z f11426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y f11427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f11428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a8.a f11429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Throwable f11430l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ScheduledFuture f11431m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11432n;

    /* JADX WARN: Illegal instructions before constructor call */
    public s(y yVar) {
        y1 y1Var = yVar.f11475b;
        super(yVar, y1Var);
        this.f11426h = yVar.l();
        this.f11427i = new y(this, y1Var);
    }

    @Override // ze.y
    public final void a(t tVar, m4.k kVar) {
        y.h(kVar, "executor");
        s(new v(kVar, tVar, this));
    }

    @Override // ze.y
    public final y c() {
        return this.f11427i.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        t(null);
    }

    @Override // ze.y
    public final Throwable g() {
        if (m()) {
            return this.f11430l;
        }
        return null;
    }

    @Override // ze.y
    public final void k(y yVar) {
        this.f11427i.k(yVar);
    }

    @Override // ze.y
    public final z l() {
        return this.f11426h;
    }

    @Override // ze.y
    public final boolean m() {
        synchronized (this) {
            try {
                if (this.f11432n) {
                    return true;
                }
                if (!super.m()) {
                    return false;
                }
                t(super.g());
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ze.y
    public final void o(t tVar) {
        w(tVar, this);
    }

    public final void s(v vVar) {
        synchronized (this) {
            try {
                if (m()) {
                    vVar.a();
                } else {
                    ArrayList arrayList = this.f11428j;
                    if (arrayList == null) {
                        ArrayList arrayList2 = new ArrayList();
                        this.f11428j = arrayList2;
                        arrayList2.add(vVar);
                        s sVar = this.f11474a;
                        if (sVar != null) {
                            a8.a aVar = new a8.a(this, 21);
                            this.f11429k = aVar;
                            sVar.s(new v(u.INSTANCE, aVar, this));
                        }
                    } else {
                        arrayList.add(vVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void t(Throwable th2) {
        boolean z2;
        ScheduledFuture scheduledFuture;
        synchronized (this) {
            try {
                if (this.f11432n) {
                    z2 = false;
                    scheduledFuture = null;
                } else {
                    z2 = true;
                    this.f11432n = true;
                    scheduledFuture = this.f11431m;
                    if (scheduledFuture != null) {
                        this.f11431m = null;
                    } else {
                        scheduledFuture = null;
                    }
                    this.f11430l = th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        if (z2) {
            synchronized (this) {
                try {
                    ArrayList<v> arrayList = this.f11428j;
                    if (arrayList != null) {
                        t tVar = this.f11429k;
                        this.f11429k = null;
                        this.f11428j = null;
                        for (v vVar : arrayList) {
                            if (vVar.f11450c == this) {
                                vVar.a();
                            }
                        }
                        for (v vVar2 : arrayList) {
                            if (vVar2.f11450c != this) {
                                vVar2.a();
                            }
                        }
                        s sVar = this.f11474a;
                        if (sVar != null) {
                            sVar.w(tVar, sVar);
                        }
                    }
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void w(t tVar, y yVar) {
        synchronized (this) {
            try {
                ArrayList arrayList = this.f11428j;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        v vVar = (v) this.f11428j.get(size);
                        if (vVar.f11449b == tVar && vVar.f11450c == yVar) {
                            this.f11428j.remove(size);
                            break;
                        }
                    }
                    if (this.f11428j.isEmpty()) {
                        s sVar = this.f11474a;
                        if (sVar != null) {
                            sVar.w(this.f11429k, sVar);
                        }
                        this.f11429k = null;
                        this.f11428j = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public s(y yVar, z zVar) {
        y1 y1Var = yVar.f11475b;
        super(yVar, y1Var);
        this.f11426h = zVar;
        this.f11427i = new y(this, y1Var);
    }
}
