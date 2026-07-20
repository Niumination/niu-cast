package pq;

import java.lang.reflect.InvocationTargetException;
import kn.l1;
import kn.r1;
import lm.l2;
import nq.b4;
import vq.h1;
import vq.l0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nConflatedBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 5 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,119:1\n548#2,5:120\n514#2,6:125\n514#2,6:212\n548#2,5:218\n244#3:131\n269#3,10:132\n280#3,68:143\n3038#4:142\n269#5:211\n*S KotlinDebug\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n*L\n41#1:120,5\n53#1:125,6\n106#1:212,6\n109#1:218,5\n80#1:131\n80#1:132,10\n80#1:143,68\n80#1:142\n80#1:211\n*E\n"})
public class y<E> extends j<E> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f13316x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public final i f13317y;

    public /* synthetic */ y(int i10, i iVar, jn.l lVar, int i11, kn.w wVar) {
        this(i10, iVar, (i11 & 4) != 0 ? null : lVar);
    }

    public static /* synthetic */ <E> Object I1(y<E> yVar, E e10, um.d<? super l2> dVar) throws Throwable {
        h1 h1VarD;
        Object objM1 = yVar.M1(e10, true);
        if (!(objM1 instanceof p.a)) {
            return l2.f10208a;
        }
        p.f(objM1);
        jn.l<E, l2> lVar = yVar.f13258b;
        if (lVar == null || (h1VarD = l0.d(lVar, e10, null, 2, null)) == null) {
            throw yVar.o0();
        }
        lm.p.a(h1VarD, yVar.o0());
        throw h1VarD;
    }

    public static <E> Object J1(y<E> yVar, E e10, um.d<? super Boolean> dVar) {
        Object objM1 = yVar.M1(e10, true);
        if (objM1 instanceof p.c) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override // pq.j
    public boolean A0() {
        return this.f13317y == i.DROP_OLDEST;
    }

    public final Object K1(E e10, boolean z10) throws IllegalAccessException, InvocationTargetException {
        jn.l<E, l2> lVar;
        h1 h1VarD;
        Object objW = super.w(e10);
        if (p.m(objW) || (objW instanceof p.a)) {
            return objW;
        }
        if (z10 && (lVar = this.f13258b) != null && (h1VarD = l0.d(lVar, e10, null, 2, null)) != null) {
            throw h1VarD;
        }
        p.b bVar = p.f13308b;
        l2 l2Var = l2.f10208a;
        bVar.getClass();
        return p.c(l2Var);
    }

    @Override // pq.j, pq.g0
    @os.m
    public Object L(E e10, @os.l um.d<? super l2> dVar) {
        return I1(this, e10, dVar);
    }

    public final Object L1(E e10) throws IllegalAccessException, InvocationTargetException {
        q<E> qVar;
        Object obj = k.f13271f;
        q<E> qVar2 = (q) j.f13252i.get(this);
        while (true) {
            long andIncrement = j.f13248d.getAndIncrement(this);
            long j10 = andIncrement & k.G;
            boolean zV0 = v0(andIncrement, false);
            int i10 = k.f13267b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (qVar2.f17877c != j11) {
                q<E> qVarD0 = d0(j11, qVar2);
                if (qVarD0 != null) {
                    qVar = qVarD0;
                } else if (zV0) {
                    break;
                }
            } else {
                qVar = qVar2;
            }
            int iD1 = D1(qVar, i11, e10, j10, obj, zV0);
            if (iD1 == 0) {
                qVar.b();
                p.b bVar = p.f13308b;
                l2 l2Var = l2.f10208a;
                bVar.getClass();
                return p.c(l2Var);
            }
            if (iD1 == 1) {
                p.b bVar2 = p.f13308b;
                l2 l2Var2 = l2.f10208a;
                bVar2.getClass();
                return p.c(l2Var2);
            }
            if (iD1 == 2) {
                if (zV0) {
                    qVar.r();
                    break;
                }
                b4 b4Var = obj instanceof b4 ? (b4) obj : null;
                if (b4Var != null) {
                    U0(b4Var, qVar, i11);
                }
                Z((qVar.f17877c * ((long) i10)) + ((long) i11));
                p.b bVar3 = p.f13308b;
                l2 l2Var3 = l2.f10208a;
                bVar3.getClass();
                return p.c(l2Var3);
            }
            if (iD1 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iD1 == 4) {
                if (j10 >= j.f13249e.get(this)) {
                    break;
                }
                qVar.b();
                break;
            }
            if (iD1 == 5) {
                qVar.b();
            }
            qVar2 = qVar;
        }
        return p.f13308b.a(o0());
    }

    public final Object M1(E e10, boolean z10) {
        return this.f13317y == i.DROP_LATEST ? K1(e10, z10) : L1(e10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pq.j
    public void h1(@os.l yq.m<?> mVar, @os.m Object obj) {
        Object objW = w(obj);
        if (!(objW instanceof p.c)) {
            mVar.f(l2.f10208a);
        } else {
            if (!(objW instanceof p.a)) {
                throw new IllegalStateException("unreachable");
            }
            p.f(objW);
            mVar.f(k.z());
        }
    }

    @Override // pq.j
    @os.m
    public Object n1(E e10, @os.l um.d<? super Boolean> dVar) {
        return J1(this, e10, dVar);
    }

    @Override // pq.j
    public boolean u1() {
        return false;
    }

    @Override // pq.j, pq.g0
    @os.l
    public Object w(E e10) {
        return M1(e10, false);
    }

    public y(int i10, @os.l i iVar, @os.m jn.l<? super E, l2> lVar) {
        super(i10, lVar);
        this.f13316x = i10;
        this.f13317y = iVar;
        if (iVar != i.SUSPEND) {
            if (i10 < 1) {
                throw new IllegalArgumentException(k.b.a("Buffered channel capacity must be at least 1, but ", i10, " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + l1.d(j.class).w() + " instead").toString());
        }
    }
}
