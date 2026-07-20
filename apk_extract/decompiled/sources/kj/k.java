package kj;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends gj.a {
    public final /* synthetic */ int e;
    public final /* synthetic */ n f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f6924g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(String str, n nVar, Object obj, int i8) {
        super(str, true);
        this.e = i8;
        this.f = nVar;
        this.f6924g = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [T, kj.e0] */
    @Override // gj.a
    public final long a() {
        T t3;
        int i8 = 0;
        switch (this.e) {
            case 0:
                s sVar = this.f.f6928b;
                sVar.f6936a.a(sVar, (e0) ((Ref.ObjectRef) this.f6924g).element);
                return -1L;
            default:
                n nVar = this.f;
                e0 settings = (e0) this.f6924g;
                nVar.getClass();
                Intrinsics.checkNotNullParameter(settings, "settings");
                Ref.LongRef longRef = new Ref.LongRef();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                synchronized (nVar.f6928b.f6954y) {
                    synchronized (nVar.f6928b) {
                        try {
                            e0 e0Var = nVar.f6928b.f6949s;
                            ?? e0Var2 = new e0();
                            e0Var2.b(e0Var);
                            e0Var2.b(settings);
                            Unit unit = Unit.INSTANCE;
                            objectRef2.element = e0Var2;
                            long jA = ((long) e0Var2.a()) - ((long) e0Var.a());
                            longRef.element = jA;
                            if (jA == 0 || nVar.f6928b.f6937b.isEmpty()) {
                                t3 = 0;
                            } else {
                                Object[] array = nVar.f6928b.f6937b.values().toArray(new a0[0]);
                                if (array == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                                t3 = (a0[]) array;
                            }
                            objectRef.element = t3;
                            s sVar2 = nVar.f6928b;
                            e0 e0Var3 = (e0) objectRef2.element;
                            sVar2.getClass();
                            Intrinsics.checkNotNullParameter(e0Var3, "<set-?>");
                            sVar2.f6949s = e0Var3;
                            nVar.f6928b.f6944l.c(new k(nVar.f6928b.f6938c + " onSettings", nVar, objectRef2, i8), 0L);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    try {
                        nVar.f6928b.f6954y.a((e0) objectRef2.element);
                    } catch (IOException e) {
                        nVar.f6928b.c(e);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    break;
                }
                a0[] a0VarArr = (a0[]) objectRef.element;
                if (a0VarArr != null) {
                    Intrinsics.checkNotNull(a0VarArr);
                    int length = a0VarArr.length;
                    while (i8 < length) {
                        a0 a0Var = a0VarArr[i8];
                        synchronized (a0Var) {
                            long j8 = longRef.element;
                            a0Var.f6878d += j8;
                            if (j8 > 0) {
                                a0Var.notifyAll();
                            }
                            Unit unit3 = Unit.INSTANCE;
                        }
                        i8++;
                    }
                }
                return -1L;
        }
    }
}
