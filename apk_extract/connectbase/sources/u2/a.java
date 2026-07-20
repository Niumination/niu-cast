package u2;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kn.l0;
import kn.r1;
import kn.w;
import lm.l2;
import os.l;
import os.m;
import pq.f0;
import pq.o;
import um.d;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nChannelDataQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelDataQueue.kt\ncom/transsion/airtransfer/filetransfer/databus/ChannelDataQueue\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n372#2,7:60\n1855#3,2:67\n*S KotlinDebug\n*F\n+ 1 ChannelDataQueue.kt\ncom/transsion/airtransfer/filetransfer/databus/ChannelDataQueue\n*L\n28#1:60,7\n40#1:67,2\n*E\n"})
public abstract class a<T> implements w2.a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final C0427a f16170b = new C0427a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16171c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Map<Integer, pq.l<T>> f16172a = new LinkedHashMap();

    /* JADX INFO: renamed from: u2.a$a, reason: collision with other inner class name */
    public static final class C0427a {
        public C0427a() {
        }

        public C0427a(w wVar) {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final b f16173a = new b();

        /* JADX INFO: renamed from: u2.a$b$a, reason: collision with other inner class name */
        public static final class C0428a extends a<T> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Class<T> f16174d;

            public C0428a(Class<T> cls) {
                this.f16174d = cls;
            }

            @Override // w2.a
            @l
            public Type getType() {
                return this.f16174d;
            }
        }

        @l
        public final <T> a<T> a(@l Class<T> cls) {
            l0.p(cls, NotificationCompat.CATEGORY_MESSAGE);
            return new C0428a(cls);
        }
    }

    public static /* synthetic */ <T> Object d(a<T> aVar, Integer num, d<? super T> dVar) {
        return aVar.c(num).n(dVar);
    }

    public static <T> Object e(a<T> aVar, T t10, Integer num, d<? super l2> dVar) {
        Object objL = aVar.c(num).L(t10, dVar);
        return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
    }

    @Override // w2.a
    @m
    public Object a(T t10, @m Integer num, @l d<? super l2> dVar) {
        return e(this, t10, num, dVar);
    }

    @Override // w2.a
    @m
    public Object b(@m Integer num, @l d<? super T> dVar) {
        return d(this, num, dVar);
    }

    @l
    public final pq.l<T> c(@m Integer num) {
        int iIntValue = num != null ? num.intValue() : 0;
        Map<Integer, pq.l<T>> map = this.f16172a;
        Integer numValueOf = Integer.valueOf(iIntValue);
        pq.l<T> lVarD = map.get(numValueOf);
        if (lVarD == null) {
            lVarD = o.d(0, null, null, 7, null);
            map.put(numValueOf, lVarD);
        }
        pq.l<T> lVar = lVarD;
        this.f16172a.put(Integer.valueOf(iIntValue), lVar);
        return lVar;
    }

    @Override // w2.a
    public void clear() {
        Iterator<T> it = this.f16172a.values().iterator();
        while (it.hasNext()) {
            try {
                f0.a.b((pq.l) it.next(), null, 1, null);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        this.f16172a.clear();
    }
}
