package se;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import k3.lb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s2 extends SuspendLambda implements Function2 {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ Socket $socket;
    int label;
    final /* synthetic */ d3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(byte[] bArr, Socket socket, d3 d3Var, Continuation<? super s2> continuation) {
        super(2, continuation);
        this.$data = bArr;
        this.$socket = socket;
        this.this$0 = d3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new s2(this.$data, this.$socket, this.this$0, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00e5 A[Catch: Exception -> 0x0071, TryCatch #3 {Exception -> 0x0071, blocks: (B:5:0x0013, B:7:0x0036, B:10:0x0041, B:12:0x0062, B:14:0x0069, B:16:0x006d, B:44:0x00ce, B:46:0x00d2, B:47:0x00d5, B:32:0x009f, B:41:0x00c9, B:48:0x00d6, B:50:0x00e5, B:52:0x00f7, B:54:0x0105, B:56:0x0114, B:57:0x0124, B:59:0x013c, B:61:0x014a, B:13:0x0064, B:26:0x007a, B:28:0x0087, B:29:0x0096, B:31:0x009a, B:35:0x00a4, B:37:0x00b1, B:38:0x00c0, B:40:0x00c4), top: B:71:0x0013, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:56:0x0114 A[Catch: Exception -> 0x0071, EDGE_INSN: B:56:0x0114->B:65:0x0165 BREAK  A[LOOP:0: B:6:0x0034->B:63:0x015a], TryCatch #3 {Exception -> 0x0071, blocks: (B:5:0x0013, B:7:0x0036, B:10:0x0041, B:12:0x0062, B:14:0x0069, B:16:0x006d, B:44:0x00ce, B:46:0x00d2, B:47:0x00d5, B:32:0x009f, B:41:0x00c9, B:48:0x00d6, B:50:0x00e5, B:52:0x00f7, B:54:0x0105, B:56:0x0114, B:57:0x0124, B:59:0x013c, B:61:0x014a, B:13:0x0064, B:26:0x007a, B:28:0x0087, B:29:0x0096, B:31:0x009a, B:35:0x00a4, B:37:0x00b1, B:38:0x00c0, B:40:0x00c4), top: B:71:0x0013, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0124 A[Catch: Exception -> 0x0071, TryCatch #3 {Exception -> 0x0071, blocks: (B:5:0x0013, B:7:0x0036, B:10:0x0041, B:12:0x0062, B:14:0x0069, B:16:0x006d, B:44:0x00ce, B:46:0x00d2, B:47:0x00d5, B:32:0x009f, B:41:0x00c9, B:48:0x00d6, B:50:0x00e5, B:52:0x00f7, B:54:0x0105, B:56:0x0114, B:57:0x0124, B:59:0x013c, B:61:0x014a, B:13:0x0064, B:26:0x007a, B:28:0x0087, B:29:0x0096, B:31:0x009a, B:35:0x00a4, B:37:0x00b1, B:38:0x00c0, B:40:0x00c4), top: B:71:0x0013, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:56:0x0114, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:57:0x0124, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String tag;
        CountDownLatch countDownLatch;
        Boolean boolBoxBoolean;
        String tag2;
        CountDownLatch countDownLatch2;
        int i8 = 1;
        String tag3 = "NearLanTcpClient";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            HashMap map = i.f9786a;
            byte[][] bArrI = i.i(this.$data);
            OutputStream outputStream = this.$socket.getOutputStream();
            we.h.b("NearLanTcpClient", "sendPacketArray, size: " + bArrI.length);
            int length = bArrI.length;
            int i9 = 0;
            while (i9 < length) {
                byte[] bArr = bArrI[i9];
                if (bArr != null) {
                    String string = Arrays.toString(bArr);
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    we.h.b(tag3, "sendPacketArray, data: " + string);
                    byte[] bArr2 = bArrI[i9];
                    if (bArr2 != null) {
                        d3 d3Var = this.this$0;
                        try {
                            try {
                                outputStream.write(bArr2);
                                Unit unit = Unit.INSTANCE;
                                countDownLatch2 = d3Var.f9713l;
                                if (countDownLatch2 != null) {
                                    countDownLatch2.countDown();
                                }
                            } catch (Throwable th2) {
                                CountDownLatch countDownLatch3 = d3Var.f9713l;
                                if (countDownLatch3 != null) {
                                    countDownLatch3.countDown();
                                }
                                throw th2;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            Intrinsics.checkNotNullParameter(tag3, "tag");
                            Intrinsics.checkNotNullParameter("sendPacketArray, write exception", "mes");
                            if (lb.f6529c >= i8) {
                                Log.e(tag3, "TransConnect:sendPacketArray, write exception", e);
                            }
                            CountDownLatch countDownLatch4 = d3Var.f9713l;
                            if (countDownLatch4 != null) {
                                countDownLatch4.countDown();
                                Unit unit2 = Unit.INSTANCE;
                            }
                            countDownLatch2 = d3Var.f9713l;
                            if (countDownLatch2 == null) {
                                this.this$0.f9713l = new CountDownLatch(i8);
                                countDownLatch = this.this$0.f9713l;
                                if (countDownLatch != null) {
                                    boolBoxBoolean = Boxing.boxBoolean(countDownLatch.await(500L, TimeUnit.MILLISECONDS));
                                } else {
                                    boolBoxBoolean = null;
                                }
                                this.this$0.f9713l = null;
                                if (Intrinsics.areEqual(boolBoxBoolean, Boxing.boxBoolean(false))) {
                                    tag2 = tag3;
                                    Intrinsics.checkNotNullParameter(tag2, "tag");
                                    Intrinsics.checkNotNullParameter("sendPacketArray, send failed", "mes");
                                    if (lb.f6529c < 1) {
                                        break;
                                    }
                                    Log.e(tag2, "TransConnect:sendPacketArray, send failed", null);
                                    break;
                                }
                                tag = tag3;
                                we.h.b(tag, "sendPacketArray, result: " + boolBoxBoolean);
                                i9++;
                                tag3 = tag;
                                i8 = 1;
                            }
                            return Unit.INSTANCE;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            Intrinsics.checkNotNullParameter(tag3, "tag");
                            Intrinsics.checkNotNullParameter("sendPacketArray, write exception", "mes");
                            if (lb.f6529c >= i8) {
                                Log.e(tag3, "TransConnect:sendPacketArray, write exception", e4);
                            }
                            CountDownLatch countDownLatch5 = d3Var.f9713l;
                            if (countDownLatch5 != null) {
                                countDownLatch5.countDown();
                                Unit unit3 = Unit.INSTANCE;
                            }
                            countDownLatch2 = d3Var.f9713l;
                            if (countDownLatch2 != null) {
                            }
                            this.this$0.f9713l = new CountDownLatch(i8);
                            countDownLatch = this.this$0.f9713l;
                            if (countDownLatch != null) {
                                boolBoxBoolean = Boxing.boxBoolean(countDownLatch.await(500L, TimeUnit.MILLISECONDS));
                            } else {
                                boolBoxBoolean = null;
                            }
                            this.this$0.f9713l = null;
                            if (Intrinsics.areEqual(boolBoxBoolean, Boxing.boxBoolean(false))) {
                                tag2 = tag3;
                                Intrinsics.checkNotNullParameter(tag2, "tag");
                                Intrinsics.checkNotNullParameter("sendPacketArray, send failed", "mes");
                                if (lb.f6529c < 1) {
                                    break;
                                }
                                Log.e(tag2, "TransConnect:sendPacketArray, send failed", null);
                                break;
                                return Unit.INSTANCE;
                            }
                            tag = tag3;
                            we.h.b(tag, "sendPacketArray, result: " + boolBoxBoolean);
                            i9++;
                            tag3 = tag;
                            i8 = 1;
                        }
                    }
                    this.this$0.f9713l = new CountDownLatch(i8);
                    countDownLatch = this.this$0.f9713l;
                    if (countDownLatch != null) {
                        boolBoxBoolean = Boxing.boxBoolean(countDownLatch.await(500L, TimeUnit.MILLISECONDS));
                    } else {
                        boolBoxBoolean = null;
                    }
                    this.this$0.f9713l = null;
                    if (Intrinsics.areEqual(boolBoxBoolean, Boxing.boxBoolean(false))) {
                        tag2 = tag3;
                        Intrinsics.checkNotNullParameter(tag2, "tag");
                        Intrinsics.checkNotNullParameter("sendPacketArray, send failed", "mes");
                        if (lb.f6529c < 1) {
                            break;
                        }
                        Log.e(tag2, "TransConnect:sendPacketArray, send failed", null);
                        break;
                    }
                    tag = tag3;
                    we.h.b(tag, "sendPacketArray, result: " + boolBoxBoolean);
                } else {
                    tag = tag3;
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    Intrinsics.checkNotNullParameter("sendPacketArray is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e(tag, "TransConnect:sendPacketArray is null", null);
                    }
                }
                i9++;
                tag3 = tag;
                i8 = 1;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((s2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
