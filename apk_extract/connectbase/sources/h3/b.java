package h3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import jn.p;
import kn.l0;
import kn.r1;
import lm.d1;
import lm.l2;
import os.l;
import os.m;
import sq.i;
import um.d;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nGrpcMessageChannelManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,63:1\n223#2,2:64\n223#2,2:66\n1855#2,2:73\n288#2,2:76\n1855#2,2:78\n55#3,5:68\n62#3:75\n*S KotlinDebug\n*F\n+ 1 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n*L\n27#1:64,2\n33#1:66,2\n40#1:73,2\n50#1:76,2\n58#1:78,2\n39#1:68,5\n39#1:75\n*E\n"})
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f6970b = "GrpcMessageChannelManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final b f6969a = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final CopyOnWriteArrayList<h3.a<?>> f6971c = new CopyOnWriteArrayList<>();

    @f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager$receiveMsg$2$1$1", f = "GrpcMessageChannelManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends o implements p<Object, d<? super Object>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public a(d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            a aVar = new a(dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, d<? super Object> dVar) {
            return invoke2(obj, (d<Object>) dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return this.L$0;
        }

        @m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@m Object obj, @m d<Object> dVar) {
            return ((a) create(obj, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object h(b bVar, Object obj, jn.a aVar, d dVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        return bVar.g(obj, aVar, dVar);
    }

    public final void b(@l h3.a<?> aVar) {
        l0.p(aVar, "channel");
        f6971c.add(aVar);
    }

    public final void c() {
        Iterator<T> it = f6971c.iterator();
        while (it.hasNext()) {
            ((h3.a) it.next()).j();
        }
        f6971c.clear();
    }

    public final <T> h3.a<T> d() {
        for (T t10 : f6971c) {
            h3.a<T> aVar = (h3.a) t10;
            Class<?> clsF = aVar.f();
            l0.P();
            if (l0.g(clsF, Object.class)) {
                l0.n(t10, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final <T> i<T> e(i<? extends T> iVar) {
        l0.p(iVar, "requests");
        for (T t10 : f6971c) {
            h3.a aVar = (h3.a) t10;
            Class<?> clsF = aVar.f();
            l0.P();
            if (l0.g(clsF, Object.class)) {
                l0.n(t10, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar.e(iVar);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @m
    public final Object f(@l d<Object> dVar) {
        yq.l lVar = new yq.l(dVar.getContext());
        Iterator<T> it = f6971c.iterator();
        while (it.hasNext()) {
            lVar.e(((h3.a) it.next()).f6964b.x(), new a(null));
        }
        return yq.l.z(lVar, dVar);
    }

    @m
    public final <T> Object g(T t10, @m jn.a<l2> aVar, @l d<? super l2> dVar) {
        T next;
        Object objH;
        if (t10 == null) {
            return l2.f10208a;
        }
        Iterator<T> it = f6971c.iterator();
        do {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
        } while (!l0.g(((h3.a) next).f(), t10.getClass()));
        h3.a aVar2 = next instanceof h3.a ? next : null;
        j3.b.f8554a.e(f6970b, "sendMsg grpcMessageChannel  " + aVar2 + "  " + t10);
        return (aVar2 == null || (objH = aVar2.h(t10, aVar, dVar)) != wm.a.COROUTINE_SUSPENDED) ? l2.f10208a : objH;
    }
}
