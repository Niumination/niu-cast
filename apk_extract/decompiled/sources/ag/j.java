package ag;

import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__StringsKt;
import m3.z5;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements cg.b, li.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cg.n f770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ni.c0 f771c;

    /* JADX WARN: Code duplicated, block: B:14:0x0058  */
    /* JADX WARN: Code duplicated, block: B:19:0x0061  */
    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    public j(CoroutineContext coroutineContext, jh.o input, String contentType, Long l4, long j8) throws IOException {
        char c9;
        int i8;
        char c10;
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(input, "channel");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.f769a = coroutineContext;
        xi.a aVar = m0.f773a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (!StringsKt__StringsKt.startsWith((CharSequence) contentType, (CharSequence) "multipart/", true)) {
            throw new IOException("Failed to parse multipart: Content-Type should be multipart/* but it is " + ((Object) contentType));
        }
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        int length = contentType.length();
        int i9 = 0;
        char c11 = 0;
        int i10 = 0;
        while (true) {
            c9 = 2;
            if (i9 >= length) {
                i8 = -1;
                i9 = -1;
                break;
            }
            char cCharAt = contentType.charAt(i9);
            if (c11 != 0) {
                if (c11 == 1) {
                    if (cCharAt != '=') {
                        if (cCharAt != ';') {
                            if (cCharAt != ',') {
                                if (cCharAt != ' ') {
                                    if (i10 == 0 && StringsKt__StringsKt.startsWith((CharSequence) contentType, (CharSequence) "boundary=", i9, true)) {
                                        i8 = -1;
                                        break;
                                    }
                                    i10++;
                                } else {
                                    continue;
                                }
                            } else {
                                c11 = 0;
                            }
                        } else {
                            i10 = 0;
                        }
                    } else {
                        c11 = 2;
                    }
                } else if (c11 != 2) {
                    if (c11 != 3) {
                        if (c11 == 4) {
                            c11 = 3;
                        }
                    } else if (cCharAt == '\"') {
                        c11 = 1;
                        i10 = 0;
                    } else if (cCharAt == '\\') {
                        c11 = 4;
                    }
                } else if (cCharAt == '\"') {
                    c11 = 3;
                } else if (cCharAt == ',') {
                    c11 = 0;
                } else if (cCharAt == ';') {
                    c11 = 1;
                    i10 = 0;
                }
            } else if (cCharAt == ';') {
                c11 = 1;
                i10 = 0;
            }
            i9++;
        }
        if (i9 == i8) {
            throw new IOException("Failed to parse multipart: Content-Type's boundary parameter is missing");
        }
        int i11 = i9 + 9;
        ByteBuffer buffer = ByteBuffer.allocate(74);
        Intrinsics.checkNotNullExpressionValue(buffer, "allocate(...)");
        buffer.put((byte) 13);
        buffer.put((byte) 10);
        buffer.put((byte) 45);
        buffer.put((byte) 45);
        int length2 = contentType.length();
        char c12 = 0;
        while (i11 < length2) {
            char cCharAt2 = contentType.charAt(i11);
            int i12 = 65535 & cCharAt2;
            if (i12 > 127) {
                StringBuilder sb2 = new StringBuilder("Failed to parse multipart: wrong boundary byte 0x");
                String string = Integer.toString(i12, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                sb2.append(string);
                sb2.append(" - should be 7bit character");
                throw new IOException(sb2.toString());
            }
            if (c12 != 0) {
                if (c12 != 1) {
                    if (c12 != c9) {
                        if (c12 == 3) {
                            if (!buffer.hasRemaining()) {
                                throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
                            }
                            buffer.put((byte) i12);
                            c12 = c9;
                        }
                    } else if (cCharAt2 == '\\') {
                        c12 = 3;
                    } else if (cCharAt2 == '\"') {
                        break;
                    } else {
                        if (!buffer.hasRemaining()) {
                            throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
                        }
                        buffer.put((byte) i12);
                    }
                } else if (cCharAt2 == ' ' || cCharAt2 == ',' || cCharAt2 == ';') {
                    break;
                } else {
                    if (!buffer.hasRemaining()) {
                        throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
                    }
                    buffer.put((byte) i12);
                }
                c10 = ';';
            } else if (cCharAt2 == ' ') {
                c10 = ';';
            } else if (cCharAt2 == '\"') {
                c10 = ';';
                c12 = 2;
            } else {
                if (cCharAt2 == ',') {
                    break;
                }
                c10 = ';';
                if (cCharAt2 == ';') {
                    break;
                }
                buffer.put((byte) i12);
                c12 = 1;
            }
            i11++;
            c9 = 2;
        }
        buffer.flip();
        if (buffer.remaining() == 4) {
            throw new IOException("Empty multipart boundary is not allowed");
        }
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iRemaining = buffer.remaining();
        byte[] bArr = new byte[iRemaining];
        buffer.mark();
        buffer.get(bArr);
        buffer.reset();
        this.f771c = ni.b0.b(this, null, new i0(input, new xi.a(bArr, 0, iRemaining), j8, l4, null), 3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(g0 g0Var, ContinuationImpl continuationImpl) {
        f fVar;
        if (continuationImpl instanceof f) {
            fVar = (f) continuationImpl;
            int i8 = fVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                fVar.label = i8 - Integer.MIN_VALUE;
            } else {
                fVar = new f(this, continuationImpl);
            }
        } else {
            fVar = new f(this, continuationImpl);
        }
        Object objB = fVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = fVar.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(objB);
                if (!(g0Var instanceof f0)) {
                    g0Var.a();
                    return null;
                }
                fVar.L$0 = g0Var;
                fVar.label = 1;
                objB = b((f0) g0Var, fVar);
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objB);
            }
            return (cg.n) objB;
        } catch (Throwable th2) {
            g0Var.a();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r2v1, types: [ag.e] */
    public final Object b(final f0 f0Var, ContinuationImpl continuationImpl) throws Throwable {
        g gVar;
        zf.e eVar;
        final f0 f0Var2;
        v vVar;
        wi.k kVar;
        final int i8 = 1;
        final int i9 = 2;
        if (continuationImpl instanceof g) {
            gVar = (g) continuationImpl;
            int i10 = gVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                gVar.label = i10 - Integer.MIN_VALUE;
            } else {
                gVar = new g(this, continuationImpl);
            }
        } else {
            gVar = new g(this, continuationImpl);
        }
        Object objR0 = gVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = gVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                f0Var = (f0) gVar.L$0;
                ResultKt.throwOnFailure(objR0);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                vVar = (v) gVar.L$1;
                f0Var2 = (f0) gVar.L$0;
                ResultKt.throwOnFailure(objR0);
            }
            kVar = (wi.k) objR0;
            try {
                Intrinsics.checkNotNullParameter(kVar, "<this>");
                final int i12 = 0;
                cg.m mVar = new cg.m(wi.p.b(kVar), new Function0() { // from class: ag.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() throws Throwable {
                        switch (i12) {
                            case 0:
                                f0Var2.a();
                                return Unit.INSTANCE;
                            case 1:
                                return f0Var2.f768b;
                            default:
                                f0Var2.a();
                                return Unit.INSTANCE;
                        }
                    }
                }, new d(vVar));
                AutoCloseableKt.closeFinally(kVar, null);
                return mVar;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    AutoCloseableKt.closeFinally(kVar, th2);
                    throw th3;
                }
            }
        }
        ResultKt.throwOnFailure(objR0);
        li.r rVar = f0Var.f767a;
        gVar.L$0 = f0Var;
        gVar.label = 1;
        objR0 = rVar.r0(gVar);
        if (objR0 == coroutine_suspended) {
            return coroutine_suspended;
        }
        v vVar2 = (v) objR0;
        bg.b bVarB = vVar2.b("Content-Disposition");
        if (bVarB != null) {
            int i13 = zf.e.f11497d;
            String value = bVarB.toString();
            Intrinsics.checkNotNullParameter(value, "value");
            zf.n nVar = (zf.n) CollectionsKt.last(z5.a(value));
            eVar = new zf.e(nVar.f11521a, nVar.f11522b);
        } else {
            eVar = null;
        }
        String strH = eVar != null ? eVar.h("filename") : null;
        jh.k kVar2 = f0Var.f768b;
        if (strH != null) {
            Function0 provider = new Function0() { // from class: ag.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() throws Throwable {
                    switch (i8) {
                        case 0:
                            f0Var.a();
                            return Unit.INSTANCE;
                        case 1:
                            return f0Var.f768b;
                        default:
                            f0Var.a();
                            return Unit.INSTANCE;
                    }
                }
            };
            Function0 dispose = new Function0() { // from class: ag.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() throws Throwable {
                    switch (i9) {
                        case 0:
                            f0Var.a();
                            return Unit.INSTANCE;
                        case 1:
                            return f0Var.f768b;
                        default:
                            f0Var.a();
                            return Unit.INSTANCE;
                    }
                }
            };
            d partHeaders = new d(vVar2);
            Intrinsics.checkNotNullParameter(provider, "provider");
            Intrinsics.checkNotNullParameter(dispose, "dispose");
            Intrinsics.checkNotNullParameter(partHeaders, "partHeaders");
            cg.l lVar = new cg.l(dispose, partHeaders);
            zf.e eVar2 = (zf.e) lVar.f1680c.getValue();
            if (eVar2 != null) {
                eVar2.h("filename");
            }
            return lVar;
        }
        gVar.L$0 = f0Var;
        gVar.L$1 = vVar2;
        gVar.label = 2;
        Object objL = jh.g0.l(kVar2, gVar);
        if (objL == coroutine_suspended) {
            return coroutine_suspended;
        }
        f0Var2 = f0Var;
        vVar = vVar2;
        objR0 = objL;
        kVar = (wi.k) objR0;
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        final int i14 = 0;
        cg.m mVar2 = new cg.m(wi.p.b(kVar), new Function0() { // from class: ag.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                switch (i14) {
                    case 0:
                        f0Var2.a();
                        return Unit.INSTANCE;
                    case 1:
                        return f0Var2.f768b;
                    default:
                        f0Var2.a();
                        return Unit.INSTANCE;
                }
            }
        }, new d(vVar));
        AutoCloseableKt.closeFinally(kVar, null);
        return mVar2;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    /* JADX WARN: Code duplicated, block: B:23:0x0063 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0074  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006d -> B:28:0x0070). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:30:0x0074
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object d(kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ag.h
            if (r0 == 0) goto L13
            r0 = r6
            ag.h r0 = (ag.h) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ag.h r0 = new ag.h
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L64
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$0
            ag.j r5 = (ag.j) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L70
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            cg.n r6 = r5.f770b
            if (r6 == 0) goto L48
            kotlin.jvm.functions.Function0 r6 = r6.f1678a
            r6.invoke()
        L48:
            ni.c0 r6 = r5.f771c
            ni.m r6 = r6.f8323d
            java.lang.Object r6 = r6.F()
            java.lang.Object r6 = ni.u.b(r6)
            ag.g0 r6 = (ag.g0) r6
            if (r6 != 0) goto L65
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r5.e(r0)
            if (r6 != r1) goto L64
            return r1
        L64:
            return r6
        L65:
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.a(r6, r0)
            if (r6 != r1) goto L70
            return r1
        L70:
            cg.n r6 = (cg.n) r6
            if (r6 == 0) goto L48
            r5.f770b = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.j.d(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0051 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x005e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0063 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005c -> B:27:0x005f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object e(kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ag.i
            if (r0 == 0) goto L13
            r0 = r6
            ag.i r0 = (ag.i) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ag.i r0 = new ag.i
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            ag.j r5 = (ag.j) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: ni.w -> L64
            goto L5f
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.L$0
            ag.j r5 = (ag.j) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: ni.w -> L64
            goto L52
        L40:
            kotlin.ResultKt.throwOnFailure(r6)
        L43:
            ni.c0 r6 = r5.f771c     // Catch: ni.w -> L64
            r0.L$0 = r5     // Catch: ni.w -> L64
            r0.label = r4     // Catch: ni.w -> L64
            ni.m r6 = r6.f8323d     // Catch: ni.w -> L64
            java.lang.Object r6 = r6.j(r0)     // Catch: ni.w -> L64
            if (r6 != r1) goto L52
            return r1
        L52:
            ag.g0 r6 = (ag.g0) r6     // Catch: ni.w -> L64
            r0.L$0 = r5     // Catch: ni.w -> L64
            r0.label = r3     // Catch: ni.w -> L64
            java.lang.Object r6 = r5.a(r6, r0)     // Catch: ni.w -> L64
            if (r6 != r1) goto L5f
            return r1
        L5f:
            cg.n r6 = (cg.n) r6     // Catch: ni.w -> L64
            if (r6 == 0) goto L43
            return r6
        L64:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.j.e(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f769a;
    }
}
