package oh;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicReference;
import k3.bc;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import m3.n6;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 implements li.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jh.o f8512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f8513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0 f8515d;
    public final v e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final df.m f8516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ni.m f8517i;

    public r0(jh.o byteChannel, CoroutineContext coroutineContext, long j8, nh.d pool) {
        Intrinsics.checkNotNullParameter(byteChannel, "byteChannel");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.f8512a = byteChannel;
        this.f8513b = coroutineContext;
        this.f8514c = j8;
        this.f8515d = l0.HEADER;
        this.e = new v();
        this.f8516h = new df.m();
        this.f8517i = bc.a(8, 6, null);
        li.l0.o(this, new li.f0("ws-reader"), li.j0.ATOMIC, new q0(pool, this, null));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0069  */
    /* JADX WARN: Code duplicated, block: B:26:0x0075  */
    /* JADX WARN: Code duplicated, block: B:27:0x007a  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0087 -> B:13:0x0036). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(oh.r0 r6, java.nio.ByteBuffer r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r6.getClass()
            boolean r0 = r8 instanceof oh.p0
            if (r0 == 0) goto L16
            r0 = r8
            oh.p0 r0 = (oh.p0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            oh.p0 r0 = new oh.p0
            r0.<init>(r6, r8)
        L1b:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            oh.r0 r7 = (oh.r0) r7
            kotlin.ResultKt.throwOnFailure(r8)
        L36:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L8a
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L42:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            oh.r0 r7 = (oh.r0) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6c
        L4e:
            kotlin.ResultKt.throwOnFailure(r8)
            r7.clear()
        L54:
            oh.l0 r8 = r6.f8515d
            oh.l0 r2 = oh.l0.CLOSED
            if (r8 == r2) goto L8e
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            jh.o r8 = r6.f8512a
            java.lang.Object r8 = jh.i0.a(r8, r7, r0)
            if (r8 != r1) goto L69
            goto L90
        L69:
            r5 = r7
            r7 = r6
            r6 = r5
        L6c:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r2 = -1
            if (r8 != r2) goto L7a
            oh.l0 r6 = oh.l0.CLOSED
            r7.f8515d = r6
            goto L8e
        L7a:
            r6.flip()
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = r7.d(r6, r0)
            if (r8 != r1) goto L36
            goto L90
        L8a:
            r7.compact()
            goto L54
        L8e:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.r0.a(oh.r0, java.nio.ByteBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(ContinuationImpl continuationImpl) {
        n0 n0Var;
        if (continuationImpl instanceof n0) {
            n0Var = (n0) continuationImpl;
            int i8 = n0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                n0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                n0Var = new n0(this, continuationImpl);
            }
        } else {
            n0Var = new n0(this, continuationImpl);
        }
        Object obj = n0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = n0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            df.m mVar = this.f8516h;
            if (mVar.f4459c <= 0) {
                v vVar = this.e;
                this.f8515d = vVar.a() == y.CLOSE ? l0.CLOSED : l0.HEADER;
                boolean z2 = vVar.f8524b;
                y yVarA = vVar.a();
                Integer num = vVar.f8531k;
                ByteBuffer byteBuffer = (ByteBuffer) mVar.f4460d;
                Intrinsics.checkNotNull(byteBuffer);
                byteBuffer.flip();
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                if (num != null) {
                    ByteBuffer maskBuffer = (ByteBuffer) mVar.f4458b;
                    maskBuffer.clear();
                    maskBuffer.asIntBuffer().put(num.intValue());
                    maskBuffer.clear();
                    Intrinsics.checkNotNull(byteBufferSlice);
                    Intrinsics.checkNotNullExpressionValue(maskBuffer, "maskBuffer");
                    u0.f(byteBufferSlice, maskBuffer);
                }
                mVar.f4460d = null;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBufferSlice.asReadOnlyBuffer();
                Intrinsics.checkNotNullExpressionValue(byteBufferAsReadOnlyBuffer, "run(...)");
                Intrinsics.checkNotNullParameter(byteBufferAsReadOnlyBuffer, "<this>");
                byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.remaining()];
                byteBufferAsReadOnlyBuffer.get(bArr);
                s sVarA = u0.a(z2, yVarA, bArr, vVar.f8525c, vVar.f8526d, vVar.e);
                n0Var.L$0 = this;
                n0Var.label = 1;
                if (this.f8517i.r(sVarA, n0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i9 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = (r0) n0Var.L$0;
        ResultKt.throwOnFailure(obj);
        v vVar2 = this.e;
        AtomicReference atomicReference = vVar2.f8523a;
        if (!atomicReference.compareAndSet(t.BODY, t.HEADER0)) {
            throw new IllegalStateException("It should be state BODY but it is " + atomicReference.get());
        }
        vVar2.f8527g = 0;
        vVar2.f8530j = 0L;
        vVar2.f8529i = 0;
        vVar2.f8531k = null;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:72:0x014f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object d(ByteBuffer byteBuffer, ContinuationImpl continuationImpl) throws f0, w {
        o0 o0Var;
        r0 r0Var;
        ByteBuffer bb2;
        AtomicReference atomicReference;
        long j8;
        if (continuationImpl instanceof o0) {
            o0Var = (o0) continuationImpl;
            int i8 = o0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                o0Var.label = i8 - Integer.MIN_VALUE;
                r0Var = this;
            } else {
                r0Var = this;
                o0Var = new o0(r0Var, continuationImpl);
            }
        } else {
            r0Var = this;
            o0Var = new o0(r0Var, continuationImpl);
        }
        Object obj = o0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = o0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            bb2 = byteBuffer;
        } else {
            if (i9 != 1 && i9 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ByteBuffer byteBuffer2 = (ByteBuffer) o0Var.L$1;
            r0 r0Var2 = (r0) o0Var.L$0;
            ResultKt.throwOnFailure(obj);
            bb2 = byteBuffer2;
            r0Var = r0Var2;
        }
        while (bb2.hasRemaining()) {
            int i10 = m0.$EnumSwitchMapping$0[r0Var.f8515d.ordinal()];
            df.m mVar = r0Var.f8516h;
            if (i10 == 1) {
                v vVar = r0Var.e;
                vVar.getClass();
                Intrinsics.checkNotNullParameter(bb2, "bb");
                if (!Intrinsics.areEqual(bb2.order(), ByteOrder.BIG_ENDIAN)) {
                    throw new IllegalArgumentException(("Buffer order should be BIG_ENDIAN but it is " + bb2.order()).toString());
                }
                while (true) {
                    atomicReference = vVar.f8523a;
                    Object obj2 = atomicReference.get();
                    Intrinsics.checkNotNull(obj2);
                    int i11 = u.$EnumSwitchMapping$0[((t) obj2).ordinal()];
                    int i12 = 8;
                    if (i11 != 1) {
                        if (i11 == 2) {
                            int iRemaining = bb2.remaining();
                            int i13 = vVar.f8529i;
                            if (iRemaining < i13) {
                                break;
                            }
                            if (i13 == 2) {
                                j8 = ((long) bb2.getShort()) & 65535;
                            } else {
                                if (i13 != 8) {
                                    throw new IllegalStateException();
                                }
                                j8 = bb2.getLong();
                            }
                            vVar.f8530j = j8;
                            atomicReference.set(vVar.f ? t.MASK_KEY : t.BODY);
                        } else {
                            if (i11 != 3) {
                                if (i11 == 4) {
                                    break;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            if (bb2.remaining() < 4) {
                                break;
                            }
                            vVar.f8531k = Integer.valueOf(bb2.getInt());
                            atomicReference.set(t.BODY);
                        }
                    } else {
                        if (bb2.remaining() < 2) {
                            break;
                        }
                        byte b9 = bb2.get();
                        byte b10 = bb2.get();
                        vVar.f8524b = (b9 & ByteCompanionObject.MIN_VALUE) != 0;
                        vVar.f8525c = (b9 & 64) != 0;
                        vVar.f8526d = (b9 & 32) != 0;
                        vVar.e = (b9 & 16) != 0;
                        int i14 = b9 & 15;
                        vVar.f8527g = i14;
                        if (i14 == 0 && vVar.f8528h == 0) {
                            throw new f0("Can't continue finished frames");
                        }
                        if (i14 == 0) {
                            vVar.f8527g = vVar.f8528h;
                        } else if (vVar.f8528h != 0 && !vVar.a().getControlFrame()) {
                            throw new f0("Can't start new data frame before finishing previous one");
                        }
                        if (!vVar.a().getControlFrame()) {
                            vVar.f8528h = vVar.f8524b ? 0 : vVar.f8527g;
                        } else if (!vVar.f8524b) {
                            throw new f0("control frames can't be fragmented");
                        }
                        vVar.f = (b10 & ByteCompanionObject.MIN_VALUE) != 0;
                        int i15 = b10 & ByteCompanionObject.MAX_VALUE;
                        if (vVar.a().getControlFrame() && i15 > 125) {
                            throw new f0("control frames can't be larger than 125 bytes");
                        }
                        if (i15 == 126) {
                            i12 = 2;
                        } else if (i15 != 127) {
                            i12 = 0;
                        }
                        vVar.f8529i = i12;
                        vVar.f8530j = i12 == 0 ? i15 : 0L;
                        if (i12 > 0) {
                            atomicReference.set(t.LENGTH);
                        } else if (vVar.f) {
                            atomicReference.set(t.MASK_KEY);
                        } else {
                            atomicReference.set(t.BODY);
                        }
                    }
                }
                if (atomicReference.get() != t.BODY) {
                    return Unit.INSTANCE;
                }
                r0Var.f8515d = l0.BODY;
                long j10 = vVar.f8530j;
                if (j10 > 2147483647L || j10 > r0Var.f8514c) {
                    throw new w(vVar.f8530j);
                }
                int i16 = (int) j10;
                mVar.getClass();
                Intrinsics.checkNotNullParameter(bb2, "bb");
                if (mVar.f4459c != 0) {
                    throw new IllegalStateException("remaining should be 0");
                }
                mVar.f4459c = i16;
                ByteBuffer byteBuffer3 = (ByteBuffer) mVar.f4460d;
                if (byteBuffer3 != null) {
                    Intrinsics.checkNotNull(byteBuffer3);
                    if (byteBuffer3.capacity() < i16) {
                        mVar.f4460d = ByteBuffer.allocate(i16);
                    }
                } else {
                    mVar.f4460d = ByteBuffer.allocate(i16);
                }
                ByteBuffer byteBuffer4 = (ByteBuffer) mVar.f4460d;
                Intrinsics.checkNotNull(byteBuffer4);
                byteBuffer4.clear();
                Intrinsics.checkNotNullParameter(bb2, "bb");
                int i17 = mVar.f4459c;
                ByteBuffer byteBuffer5 = (ByteBuffer) mVar.f4460d;
                Intrinsics.checkNotNull(byteBuffer5);
                mVar.f4459c = i17 - n6.a(bb2, byteBuffer5, mVar.f4459c);
                o0Var.L$0 = r0Var;
                o0Var.L$1 = bb2;
                o0Var.label = 1;
                if (r0Var.b(o0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 2) {
                    if (i10 == 3) {
                        return Unit.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                mVar.getClass();
                Intrinsics.checkNotNullParameter(bb2, "bb");
                int i18 = mVar.f4459c;
                ByteBuffer byteBuffer6 = (ByteBuffer) mVar.f4460d;
                Intrinsics.checkNotNull(byteBuffer6);
                mVar.f4459c = i18 - n6.a(bb2, byteBuffer6, mVar.f4459c);
                o0Var.L$0 = r0Var;
                o0Var.L$1 = bb2;
                o0Var.label = 2;
                if (r0Var.b(o0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f8513b;
    }
}
