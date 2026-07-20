package uf;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m3.e6;
import m3.f6;
import qg.y0;
import zf.j0;
import zf.n0;
import zf.x;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f10421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f10423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10424d;
    public final /* synthetic */ Function1 e;

    public /* synthetic */ a(x xVar, String str, Integer num, String str2, Function1 function1) {
        this.f10421a = xVar;
        this.f10422b = str;
        this.f10423c = num;
        this.f10424d = str2;
        this.e = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        vf.c webSocket = (vf.c) obj;
        Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
        webSocket.getClass();
        x xVar = this.f10421a;
        Intrinsics.checkNotNullParameter(xVar, "<set-?>");
        webSocket.f10558b = xVar;
        zg.a aVar = vf.e.f10566a;
        y0 block = new y0(13);
        Intrinsics.checkNotNullParameter(webSocket, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        j0 j0Var = webSocket.f10557a;
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        n0 n0Var = n0.f11524c;
        n0 value = f6.a("ws");
        j0Var.getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        j0Var.f11512d = value;
        String str = this.f10422b;
        if (str != null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            j0Var.f11509a = str;
        }
        Integer num = this.f10423c;
        if (num != null) {
            j0Var.f(num.intValue());
        }
        String str2 = this.f10424d;
        if (str2 != null) {
            e6.d(j0Var, str2);
        }
        block.invoke(j0Var);
        this.e.invoke(webSocket);
        return Unit.INSTANCE;
    }
}
