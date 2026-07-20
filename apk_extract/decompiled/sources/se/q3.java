package se;

import android.os.Message;
import android.util.Log;
import java.nio.channels.ClosedChannelException;
import k3.lb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q3 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ t3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q3(t3 t3Var, Continuation<? super q3> continuation) {
        super(2, continuation);
        this.this$0 = t3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        q3 q3Var = new q3(this.this$0, continuation);
        q3Var.L$0 = obj;
        return q3Var;
    }

    /* JADX WARN: Code duplicated, block: B:138:0x038b  */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00e9 A[Catch: Exception -> 0x01ba, ClosedChannelException -> 0x01bd, TRY_LEAVE, TryCatch #13 {ClosedChannelException -> 0x01bd, Exception -> 0x01ba, blocks: (B:46:0x00e5, B:48:0x00e9, B:95:0x01d4, B:97:0x01da, B:99:0x01ea, B:120:0x02bb, B:122:0x02c1, B:124:0x02d1, B:125:0x02e1, B:105:0x0235, B:107:0x023b, B:109:0x024b, B:115:0x0293, B:117:0x0299, B:119:0x02a9, B:74:0x019a, B:76:0x019e, B:78:0x01a9, B:79:0x01b9, B:60:0x012b, B:62:0x012f, B:64:0x013a, B:69:0x017a, B:71:0x017e, B:73:0x0189, B:21:0x005b, B:23:0x006a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:59:0x011b A[Catch: all -> 0x00f3, TRY_LEAVE, TryCatch #8 {all -> 0x00f3, blocks: (B:45:0x00ca, B:57:0x00fb, B:59:0x011b, B:66:0x014c, B:68:0x016a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:62:0x012f A[Catch: Exception -> 0x01ba, ClosedChannelException -> 0x01bd, TryCatch #13 {ClosedChannelException -> 0x01bd, Exception -> 0x01ba, blocks: (B:46:0x00e5, B:48:0x00e9, B:95:0x01d4, B:97:0x01da, B:99:0x01ea, B:120:0x02bb, B:122:0x02c1, B:124:0x02d1, B:125:0x02e1, B:105:0x0235, B:107:0x023b, B:109:0x024b, B:115:0x0293, B:117:0x0299, B:119:0x02a9, B:74:0x019a, B:76:0x019e, B:78:0x01a9, B:79:0x01b9, B:60:0x012b, B:62:0x012f, B:64:0x013a, B:69:0x017a, B:71:0x017e, B:73:0x0189, B:21:0x005b, B:23:0x006a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:64:0x013a A[Catch: Exception -> 0x01ba, ClosedChannelException -> 0x01bd, TRY_LEAVE, TryCatch #13 {ClosedChannelException -> 0x01bd, Exception -> 0x01ba, blocks: (B:46:0x00e5, B:48:0x00e9, B:95:0x01d4, B:97:0x01da, B:99:0x01ea, B:120:0x02bb, B:122:0x02c1, B:124:0x02d1, B:125:0x02e1, B:105:0x0235, B:107:0x023b, B:109:0x024b, B:115:0x0293, B:117:0x0299, B:119:0x02a9, B:74:0x019a, B:76:0x019e, B:78:0x01a9, B:79:0x01b9, B:60:0x012b, B:62:0x012f, B:64:0x013a, B:69:0x017a, B:71:0x017e, B:73:0x0189, B:21:0x005b, B:23:0x006a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:68:0x016a A[Catch: all -> 0x00f3, TRY_LEAVE, TryCatch #8 {all -> 0x00f3, blocks: (B:45:0x00ca, B:57:0x00fb, B:59:0x011b, B:66:0x014c, B:68:0x016a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:71:0x017e A[Catch: Exception -> 0x01ba, ClosedChannelException -> 0x01bd, TryCatch #13 {ClosedChannelException -> 0x01bd, Exception -> 0x01ba, blocks: (B:46:0x00e5, B:48:0x00e9, B:95:0x01d4, B:97:0x01da, B:99:0x01ea, B:120:0x02bb, B:122:0x02c1, B:124:0x02d1, B:125:0x02e1, B:105:0x0235, B:107:0x023b, B:109:0x024b, B:115:0x0293, B:117:0x0299, B:119:0x02a9, B:74:0x019a, B:76:0x019e, B:78:0x01a9, B:79:0x01b9, B:60:0x012b, B:62:0x012f, B:64:0x013a, B:69:0x017a, B:71:0x017e, B:73:0x0189, B:21:0x005b, B:23:0x006a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0189 A[Catch: Exception -> 0x01ba, ClosedChannelException -> 0x01bd, TryCatch #13 {ClosedChannelException -> 0x01bd, Exception -> 0x01ba, blocks: (B:46:0x00e5, B:48:0x00e9, B:95:0x01d4, B:97:0x01da, B:99:0x01ea, B:120:0x02bb, B:122:0x02c1, B:124:0x02d1, B:125:0x02e1, B:105:0x0235, B:107:0x023b, B:109:0x024b, B:115:0x0293, B:117:0x0299, B:119:0x02a9, B:74:0x019a, B:76:0x019e, B:78:0x01a9, B:79:0x01b9, B:60:0x012b, B:62:0x012f, B:64:0x013a, B:69:0x017a, B:71:0x017e, B:73:0x0189, B:21:0x005b, B:23:0x006a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:76:0x019e A[Catch: Exception -> 0x01ba, ClosedChannelException -> 0x01bd, TryCatch #13 {ClosedChannelException -> 0x01bd, Exception -> 0x01ba, blocks: (B:46:0x00e5, B:48:0x00e9, B:95:0x01d4, B:97:0x01da, B:99:0x01ea, B:120:0x02bb, B:122:0x02c1, B:124:0x02d1, B:125:0x02e1, B:105:0x0235, B:107:0x023b, B:109:0x024b, B:115:0x0293, B:117:0x0299, B:119:0x02a9, B:74:0x019a, B:76:0x019e, B:78:0x01a9, B:79:0x01b9, B:60:0x012b, B:62:0x012f, B:64:0x013a, B:69:0x017a, B:71:0x017e, B:73:0x0189, B:21:0x005b, B:23:0x006a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01a9 A[Catch: Exception -> 0x01ba, ClosedChannelException -> 0x01bd, TryCatch #13 {ClosedChannelException -> 0x01bd, Exception -> 0x01ba, blocks: (B:46:0x00e5, B:48:0x00e9, B:95:0x01d4, B:97:0x01da, B:99:0x01ea, B:120:0x02bb, B:122:0x02c1, B:124:0x02d1, B:125:0x02e1, B:105:0x0235, B:107:0x023b, B:109:0x024b, B:115:0x0293, B:117:0x0299, B:119:0x02a9, B:74:0x019a, B:76:0x019e, B:78:0x01a9, B:79:0x01b9, B:60:0x012b, B:62:0x012f, B:64:0x013a, B:69:0x017a, B:71:0x017e, B:73:0x0189, B:21:0x005b, B:23:0x006a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01c6 A[Catch: all -> 0x01cb, Exception -> 0x01ce, ClosedChannelException -> 0x01d0, TRY_LEAVE, TryCatch #17 {ClosedChannelException -> 0x01d0, Exception -> 0x01ce, blocks: (B:84:0x01c0, B:86:0x01c6), top: B:143:0x01c0, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:97:0x01da A[Catch: Exception -> 0x01ba, ClosedChannelException -> 0x01bd, DONT_GENERATE, TryCatch #13 {ClosedChannelException -> 0x01bd, Exception -> 0x01ba, blocks: (B:46:0x00e5, B:48:0x00e9, B:95:0x01d4, B:97:0x01da, B:99:0x01ea, B:120:0x02bb, B:122:0x02c1, B:124:0x02d1, B:125:0x02e1, B:105:0x0235, B:107:0x023b, B:109:0x024b, B:115:0x0293, B:117:0x0299, B:119:0x02a9, B:74:0x019a, B:76:0x019e, B:78:0x01a9, B:79:0x01b9, B:60:0x012b, B:62:0x012f, B:64:0x013a, B:69:0x017a, B:71:0x017e, B:73:0x0189, B:21:0x005b, B:23:0x006a), top: B:146:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01ea A[Catch: Exception -> 0x01ba, ClosedChannelException -> 0x01bd, DONT_GENERATE, TRY_LEAVE, TryCatch #13 {ClosedChannelException -> 0x01bd, Exception -> 0x01ba, blocks: (B:46:0x00e5, B:48:0x00e9, B:95:0x01d4, B:97:0x01da, B:99:0x01ea, B:120:0x02bb, B:122:0x02c1, B:124:0x02d1, B:125:0x02e1, B:105:0x0235, B:107:0x023b, B:109:0x024b, B:115:0x0293, B:117:0x0299, B:119:0x02a9, B:74:0x019a, B:76:0x019e, B:78:0x01a9, B:79:0x01b9, B:60:0x012b, B:62:0x012f, B:64:0x013a, B:69:0x017a, B:71:0x017e, B:73:0x0189, B:21:0x005b, B:23:0x006a), top: B:146:0x001f }] */
    /* JADX WARN: Instruction removed from duplicated block: B:59:0x011b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:64:0x013a, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x016a, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x0189, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:78:0x01a9, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24, types: [se.t3] */
    /* JADX WARN: Type inference failed for: r3v27, types: [se.t3] */
    /* JADX WARN: Type inference failed for: r3v67, types: [se.t3] */
    /* JADX WARN: Type inference failed for: r3v77, types: [se.t3] */
    /* JADX WARN: Type inference failed for: r3v9, types: [se.t3] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v34, types: [se.t3] */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object, se.t3] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        String mes;
        ?? r7;
        Object objR0;
        String mes2;
        String mes3;
        boolean z2;
        boolean z3;
        qg.p0 p0Var;
        boolean z5;
        int i8;
        int i9;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r10 = this.label;
        try {
            try {
                try {
                    try {
                        try {
                            if (r10 == 0) {
                                ResultKt.throwOnFailure(obj);
                                li.g0 g0Var = (li.g0) this.L$0;
                                try {
                                    try {
                                        t3 t3Var = this.this$0;
                                        try {
                                            t3Var.e = qg.h.d(g0Var, new n3(t3Var, 0));
                                            qg.p0 p0Var2 = this.this$0.e;
                                            if (p0Var2 != null) {
                                                p0Var2.f(false);
                                                r7 = this.this$0;
                                                try {
                                                    r7.f = true;
                                                    int i10 = r7.f10000a;
                                                    if (i10 == 0 || i10 == 80) {
                                                        ng.p pVar = p0Var2.f9102n;
                                                        this.L$0 = p0Var2;
                                                        this.L$1 = r7;
                                                        this.label = 1;
                                                        objR0 = pVar.f8263d.r0(this);
                                                        r7 = r7;
                                                        if (objR0 == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                    } else {
                                                        r10 = r7;
                                                        int i11 = r10.f10000a;
                                                        r10.f10004g.r(i11, i11);
                                                        we.h.h("WebSocketKtorServer", "WebSocket server started on port " + r10.f10000a);
                                                        if (!r10.f) {
                                                            we.h.c("WebSocketKtorServer", "WebSocket server start failed", null);
                                                        }
                                                    }
                                                } catch (ClosedChannelException e) {
                                                    e = e;
                                                    r10 = r7;
                                                    r10.f = false;
                                                    mes3 = "WebSocket start connection closed: " + e;
                                                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                                    Intrinsics.checkNotNullParameter(mes3, "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("WebSocketKtorServer", "TransConnect:" + mes3, null);
                                                    }
                                                    if (!r10.f) {
                                                        Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                                        Intrinsics.checkNotNullParameter("WebSocket server start failed", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed", null);
                                                        }
                                                    }
                                                    p0Var = this.this$0.e;
                                                    if (p0Var != null) {
                                                        p0Var.f(true);
                                                    } else {
                                                        p0Var = null;
                                                    }
                                                    if (!z5) {
                                                        return p0Var;
                                                    }
                                                    if (i8 >= i9) {
                                                        return p0Var;
                                                    }
                                                    return p0Var;
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    r10 = r7;
                                                    e.printStackTrace();
                                                    r10.f = false;
                                                    mes2 = "WebSocket server start failed: " + e;
                                                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                                    Intrinsics.checkNotNullParameter(mes2, "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("WebSocketKtorServer", "TransConnect:" + mes2, null);
                                                    }
                                                    if (!r10.f) {
                                                        Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                                        Intrinsics.checkNotNullParameter("WebSocket server start failed", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed", null);
                                                        }
                                                    }
                                                    p0Var = this.this$0.e;
                                                    if (p0Var != null) {
                                                        p0Var.f(true);
                                                    } else {
                                                        p0Var = null;
                                                    }
                                                    if (!z5) {
                                                        return p0Var;
                                                    }
                                                    if (i8 >= i9) {
                                                        return p0Var;
                                                    }
                                                    return p0Var;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    r10 = r7;
                                                    if (!r10.f) {
                                                        Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                                        Intrinsics.checkNotNullParameter("WebSocket server start failed", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed", null);
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            }
                                            p0Var = this.this$0.e;
                                            if (p0Var != null) {
                                                p0Var.f(true);
                                            } else {
                                                p0Var = null;
                                            }
                                            if (!z5) {
                                                return p0Var;
                                            }
                                            if (i8 >= i9) {
                                                return p0Var;
                                            }
                                            return p0Var;
                                        } catch (ClosedChannelException e10) {
                                            e = e10;
                                            str = "Server stopped";
                                            this.this$0.f = false;
                                            t3 t3Var2 = this.this$0;
                                            t3Var2.f10001b.clear();
                                            com.welink.protocol.nfbd.p pVar2 = t3Var2.f10004g;
                                            pVar2.getClass();
                                            we.h.h("NearLanTcpServer", "ServerSocket closed");
                                            Message messageD = pVar2.d();
                                            messageD.what = 24581;
                                            pVar2.i(messageD);
                                            we.h.h("NearLanTcpServer", str);
                                            Message messageD2 = pVar2.d();
                                            messageD2.what = 24577;
                                            pVar2.i(messageD2);
                                            this.this$0.getClass();
                                            mes = "WebSocket server start failed: " + e;
                                            Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                            Intrinsics.checkNotNullParameter(mes, "mes");
                                            if (lb.f6529c >= 1) {
                                                h0.a.x("TransConnect:", mes, "WebSocketKtorServer", null);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    } catch (ClosedChannelException e11) {
                                        e = e11;
                                        str = "Server stopped";
                                        this.this$0.f = false;
                                        t3 t3Var3 = this.this$0;
                                        t3Var3.f10001b.clear();
                                        com.welink.protocol.nfbd.p pVar3 = t3Var3.f10004g;
                                        pVar3.getClass();
                                        we.h.h("NearLanTcpServer", "ServerSocket closed");
                                        Message messageD3 = pVar3.d();
                                        messageD3.what = 24581;
                                        pVar3.i(messageD3);
                                        we.h.h("NearLanTcpServer", str);
                                        Message messageD4 = pVar3.d();
                                        messageD4.what = 24577;
                                        pVar3.i(messageD4);
                                        this.this$0.getClass();
                                        mes = "WebSocket server start failed: " + e;
                                        Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                        Intrinsics.checkNotNullParameter(mes, "mes");
                                        if (lb.f6529c >= 1) {
                                            h0.a.x("TransConnect:", mes, "WebSocketKtorServer", null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    e.printStackTrace();
                                    this.this$0.f = false;
                                    t3 t3Var4 = this.this$0;
                                    t3Var4.f10001b.clear();
                                    com.welink.protocol.nfbd.p pVar4 = t3Var4.f10004g;
                                    pVar4.getClass();
                                    we.h.h("NearLanTcpServer", "ServerSocket closed");
                                    Message messageD5 = pVar4.d();
                                    messageD5.what = 24581;
                                    pVar4.i(messageD5);
                                    we.h.h("NearLanTcpServer", "Server stopped");
                                    Message messageD6 = pVar4.d();
                                    messageD6.what = 24577;
                                    pVar4.i(messageD6);
                                    this.this$0.getClass();
                                    String mes4 = "WebSocket server start failed: " + e;
                                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                    Intrinsics.checkNotNullParameter(mes4, "mes");
                                    if (lb.f6529c >= 1) {
                                        h0.a.x("TransConnect:", mes4, "WebSocketKtorServer", null);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            if (r10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            r10 = (t3) this.L$1;
                            try {
                                ResultKt.throwOnFailure(obj);
                                r7 = r10;
                                objR0 = obj;
                            } catch (ClosedChannelException e13) {
                                e = e13;
                                r10.f = false;
                                mes3 = "WebSocket start connection closed: " + e;
                                Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                Intrinsics.checkNotNullParameter(mes3, "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("WebSocketKtorServer", "TransConnect:" + mes3, null);
                                }
                                if (!r10.f) {
                                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                    Intrinsics.checkNotNullParameter("WebSocket server start failed", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed", null);
                                    }
                                }
                                p0Var = this.this$0.e;
                                if (p0Var != null) {
                                    p0Var.f(true);
                                } else {
                                    p0Var = null;
                                }
                                if (!z5) {
                                    return p0Var;
                                }
                                if (i8 >= i9) {
                                    return p0Var;
                                }
                                return p0Var;
                            } catch (Exception e14) {
                                e = e14;
                                e.printStackTrace();
                                r10.f = false;
                                mes2 = "WebSocket server start failed: " + e;
                                Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                Intrinsics.checkNotNullParameter(mes2, "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("WebSocketKtorServer", "TransConnect:" + mes2, null);
                                }
                                if (!r10.f) {
                                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                    Intrinsics.checkNotNullParameter("WebSocket server start failed", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed", null);
                                    }
                                }
                                p0Var = this.this$0.e;
                                if (p0Var != null) {
                                    p0Var.f(true);
                                } else {
                                    p0Var = null;
                                }
                                if (!z5) {
                                    return p0Var;
                                }
                                if (i8 >= i9) {
                                    return p0Var;
                                }
                                return p0Var;
                            } catch (Throwable th3) {
                                th = th3;
                                if (!r10.f) {
                                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                    Intrinsics.checkNotNullParameter("WebSocket server start failed", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed", null);
                                    }
                                }
                                throw th;
                            }
                            int i12 = r10.f10000a;
                            r10.f10004g.r(i12, i12);
                            we.h.h("WebSocketKtorServer", "WebSocket server started on port " + r10.f10000a);
                            if (!r10.f) {
                                we.h.c("WebSocketKtorServer", "WebSocket server start failed", null);
                            }
                        } catch (ClosedChannelException e15) {
                            e = e15;
                            r10.f = false;
                            mes3 = "WebSocket start connection closed: " + e;
                            Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                            Intrinsics.checkNotNullParameter(mes3, "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("WebSocketKtorServer", "TransConnect:" + mes3, null);
                            }
                            if (!r10.f) {
                                Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                Intrinsics.checkNotNullParameter("WebSocket server start failed", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed", null);
                                }
                            }
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            r10.f = false;
                            mes2 = "WebSocket server start failed: " + e;
                            Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                            Intrinsics.checkNotNullParameter(mes2, "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("WebSocketKtorServer", "TransConnect:" + mes2, null);
                            }
                            if (!r10.f) {
                                Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                                Intrinsics.checkNotNullParameter("WebSocket server start failed", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed", null);
                                }
                            }
                        }
                        p0Var = this.this$0.e;
                        if (p0Var != null) {
                            p0Var.f(true);
                        } else {
                            p0Var = null;
                        }
                        if (!z5) {
                            return p0Var;
                        }
                        if (i8 >= i9) {
                            return p0Var;
                        }
                        return p0Var;
                    } finally {
                        if (!this.this$0.f) {
                            this.this$0.getClass();
                            Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                            Intrinsics.checkNotNullParameter("WebSocket server start failed finally", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed finally", null);
                            }
                        }
                    }
                } catch (ClosedChannelException e17) {
                    this.this$0.f = false;
                    this.this$0.getClass();
                    String mes5 = "WebSocket server start failed: " + e17;
                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                    Intrinsics.checkNotNullParameter(mes5, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("WebSocketKtorServer", "TransConnect:" + mes5, null);
                    }
                    Unit unit = Unit.INSTANCE;
                    if (z3) {
                        return unit;
                    }
                } catch (Exception e18) {
                    e18.printStackTrace();
                    this.this$0.f = false;
                    this.this$0.getClass();
                    String mes6 = "WebSocket server start failed: " + e18;
                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                    Intrinsics.checkNotNullParameter(mes6, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("WebSocketKtorServer", "TransConnect:" + mes6, null);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    if (z2) {
                        return unit2;
                    }
                }
                for (qg.r0 r0Var : (Iterable) objR0) {
                    r7.f10000a = r0Var.getPort();
                    we.h.h("WebSocketKtorServer", "WebSocket server started on port " + r0Var.getPort());
                }
                r10 = r7;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (ClosedChannelException e19) {
            e = e19;
        } catch (Exception e20) {
            e = e20;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<Object> continuation) {
        return ((q3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
