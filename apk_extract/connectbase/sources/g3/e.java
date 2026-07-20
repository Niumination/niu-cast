package g3;

import kn.n0;
import kn.r1;
import kn.w;
import lm.l2;
import os.m;
import r2.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nGrpcDataSender.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcDataSender.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcDataSender\n+ 2 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n*L\n1#1,32:1\n45#2,2:33\n*S KotlinDebug\n*F\n+ 1 GrpcDataSender.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcDataSender\n*L\n30#1:33,2\n*E\n"})
public final class e extends f3.b<l<?>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f6402c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final String f6403d = "GrpcDataSender";

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public static final class b extends n0 implements jn.a<l2> {
        final /* synthetic */ l<?> $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l<?> lVar) {
            super(0);
            this.$data = lVar;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            jn.a<l2> aVar = this.$data.f14200c;
            if (aVar != null) {
                aVar.invoke();
            }
        }
    }

    @Override // f3.b
    @m
    public Object f(@os.l um.d<? super l<?>> dVar) {
        u2.b bVar = u2.b.f16175b;
        return bVar.g(l.class).b(new Integer(1), dVar);
    }

    @Override // z2.b
    @m
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object b(@os.l l<?> lVar, @os.l um.d<? super l2> dVar) {
        j3.b.f8554a.e(f6403d, "write data " + lVar.f14192g);
        Object objG = h3.b.f6969a.g(lVar.f14192g, new b(lVar), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }
}
