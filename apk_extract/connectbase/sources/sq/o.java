package sq;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o {

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", i = {0}, l = {26}, m = "toCollection", n = {RtspHeaders.Values.DESTINATION}, s = {"L$0"})
    public static final class a<T, C extends Collection<? super T>> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return o.a(null, null, this);
        }
    }

    public static final class b<T> implements j {

        /* JADX INFO: Incorrect field signature: TC; */
        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f15316a;

        /* JADX WARN: Incorrect types in method signature: (TC;)V */
        public b(Collection collection) {
            this.f15316a = collection;
        }

        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            this.f15316a.add(t10);
            return l2.f10208a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T, C extends Collection<? super T>> Object a(@os.l i<? extends T> iVar, @os.l C c10, @os.l um.d<? super C> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Collection collection = (Collection) aVar.L$0;
            d1.n(obj);
            return collection;
        }
        d1.n(obj);
        j<? super Object> bVar = new b<>(c10);
        aVar.L$0 = c10;
        aVar.label = 1;
        return iVar.a(bVar, aVar) == aVar2 ? aVar2 : c10;
    }

    @os.m
    public static final <T> Object b(@os.l i<? extends T> iVar, @os.l List<T> list, @os.l um.d<? super List<? extends T>> dVar) {
        return a(iVar, list, dVar);
    }

    public static Object c(i iVar, List list, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = new ArrayList();
        }
        return a(iVar, list, dVar);
    }

    @os.m
    public static final <T> Object d(@os.l i<? extends T> iVar, @os.l Set<T> set, @os.l um.d<? super Set<? extends T>> dVar) {
        return a(iVar, set, dVar);
    }

    public static Object e(i iVar, Set set, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            set = new LinkedHashSet();
        }
        return a(iVar, set, dVar);
    }
}
