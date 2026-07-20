package yg;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jh.j0;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import li.a0;
import li.f0;
import li.l0;
import li.o1;
import li.p1;
import ng.x;
import oh.i0;
import oh.u0;
import zf.s;
import zf.t;
import zf.v;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends cg.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f0 f11208d = new f0("raw-ws-handler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f11209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f11210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f11211c;

    public n(xg.r call, String str, boolean z2, h handle) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.f11209a = handle;
        vg.c cVarG = call.g();
        String[] strArr = v.f11551a;
        String nonce = m3.k.b(cVarG, "Sec-WebSocket-Key");
        bd.b bVar = q.f11216h;
        q qVar = (q) mg.e.c(call.e);
        this.f11210b = qVar;
        zf.q qVar2 = zf.r.f11536a;
        s sVar = new s();
        sVar.d("Upgrade", "websocket");
        sVar.d("Connection", "Upgrade");
        if (nonce != null) {
            Intrinsics.checkNotNullParameter(nonce, "nonce");
            byte[] bytes = lh.a.i(StringsKt__StringsKt.trim((CharSequence) nonce).toString() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11", Charsets.ISO_8859_1);
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bytes);
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
            sVar.d("Sec-WebSocket-Accept", zg.b.a(bArrDigest));
        }
        if (str != null) {
            sVar.d("Sec-WebSocket-Protocol", str);
        }
        if (z2) {
            String strB = m3.k.b(call.g(), "Sec-WebSocket-Extensions");
            if (strB != null) {
                u0.d(strB);
            } else {
                CollectionsKt.emptyList();
            }
            ArrayList arrayListD = qVar.f11222d.d();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayListD.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
            if (!arrayList.isEmpty()) {
                sVar.d("Sec-WebSocket-Extensions", CollectionsKt___CollectionsKt.joinToString$default(arrayList, ";", null, null, 0, null, null, 62, null));
            }
            listEmptyList = arrayList2;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        call.f10987d.e(q.f11218j, listEmptyList);
        this.f11211c = sVar.o();
    }

    @Override // cg.j
    public final zf.r c() {
        return this.f11211c;
    }

    @Override // cg.h
    public final CoroutineContext.Element e(jh.o input, j0 output, a0 a0Var, x xVar) {
        long j8 = this.f11210b.f11221c;
        CoroutineContext coroutineContext = xVar.get$context();
        o1 o1Var = o1.f7483a;
        CoroutineContext coroutineContext2 = (p1) coroutineContext.get(o1Var);
        if (coroutineContext2 == null) {
            coroutineContext2 = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext3 = a0Var.plus(coroutineContext2);
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext3, "coroutineContext");
        i0 i0Var = new i0(input, output, j8, false, coroutineContext3);
        l0.p(i0Var, f11208d, null, new m(this, i0Var, null), 2);
        CoroutineContext.Element element = i0Var.f8489b.get(o1Var);
        Intrinsics.checkNotNull(element);
        return element;
    }
}
