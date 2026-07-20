package g3;

import com.transsion.airtransfer.filetransfer.protos.CancelReceiveReply;
import com.transsion.airtransfer.filetransfer.protos.CancelReceiveRequest;
import com.transsion.airtransfer.filetransfer.protos.CancelSendReply;
import com.transsion.airtransfer.filetransfer.protos.CancelSendRequest;
import com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt;
import com.transsion.airtransfer.filetransfer.protos.HandshakeRequest;
import com.transsion.airtransfer.filetransfer.protos.Heartbeat;
import com.transsion.airtransfer.filetransfer.protos.HeartbeatKt;
import com.transsion.airtransfer.filetransfer.protos.ReceiveFinish;
import com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest;
import com.transsion.airtransfer.filetransfer.protos.SendFileReply;
import java.util.NoSuchElementException;
import jn.p;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.d1;
import lm.l2;
import nq.k;
import nq.k1;
import nq.o0;
import nq.s0;
import nq.t0;
import nq.z1;
import os.l;
import os.m;
import sq.i;
import vj.s1;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 3 HeartbeatKt.kt\ncom/transsion/airtransfer/filetransfer/protos/HeartbeatKtKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n48#2,4:125\n10#3:129\n1#4:130\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector\n*L\n43#1:125,4\n74#1:129\n74#1:130\n*E\n"})
public final class b implements z2.d, s0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public static final a f6389n = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public static final String f6390p = "GrpcClientConnector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final String f6391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s0 f6393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public vj.r1 f6394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m
    public FileMessageGrpcKt.FileMessageCoroutineStub f6395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final g f6396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6397g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public final o0 f6398i;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX INFO: renamed from: g3.b$b, reason: collision with other inner class name */
    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector", f = "GrpcClientConnector.kt", i = {0, 1}, l = {74, 79, 83}, m = "checkConnectState", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class C0153b extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C0153b(um.d<? super C0153b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.j(this);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector", f = "GrpcClientConnector.kt", i = {0}, l = {100, 101}, m = "reconnect", n = {"this"}, s = {"L$0"})
    public static final class c extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.k(this);
        }
    }

    @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$sendFileStream$1\n+ 2 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector\n*L\n1#1,124:1\n110#2,7:125\n110#2,7:132\n110#2,7:139\n110#2,7:146\n110#2,7:153\n110#2,7:160\n110#2,7:167\n110#2,7:174\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$sendFileStream$1\n*L\n62#1:125,7\n63#1:132,7\n64#1:139,7\n65#1:146,7\n66#1:153,7\n67#1:160,7\n68#1:167,7\n69#1:174,7\n*E\n"})
    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$sendFileStream$1", f = "GrpcClientConnector.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        int label;

        public static final class a extends n0 implements jn.l<sq.i<? extends SendFileInfoRequest>, sq.i<? extends SendFileInfoRequest>> {
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar) {
                super(1);
                this.this$0 = bVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ sq.i<? extends SendFileInfoRequest> invoke(sq.i<? extends SendFileInfoRequest> iVar) {
                return invoke2((sq.i<SendFileInfoRequest>) iVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final sq.i<SendFileInfoRequest> invoke2(@os.l sq.i<SendFileInfoRequest> iVar) {
                l0.p(iVar, "it");
                FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub = this.this$0.f6395e;
                if (fileMessageCoroutineStub != null) {
                    return FileMessageGrpcKt.FileMessageCoroutineStub.sendFileInfoStream$default(fileMessageCoroutineStub, iVar, null, 2, null);
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: g3.b$d$b, reason: collision with other inner class name */
        public static final class C0154b extends n0 implements jn.l<sq.i<? extends SendFileReply>, sq.i<? extends SendFileReply>> {
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0154b(b bVar) {
                super(1);
                this.this$0 = bVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ sq.i<? extends SendFileReply> invoke(sq.i<? extends SendFileReply> iVar) {
                return invoke2((sq.i<SendFileReply>) iVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final sq.i<SendFileReply> invoke2(@os.l sq.i<SendFileReply> iVar) {
                l0.p(iVar, "it");
                FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub = this.this$0.f6395e;
                if (fileMessageCoroutineStub != null) {
                    return FileMessageGrpcKt.FileMessageCoroutineStub.sendFileInfoReplyStream$default(fileMessageCoroutineStub, iVar, null, 2, null);
                }
                return null;
            }
        }

        public static final class c extends n0 implements jn.l<sq.i<? extends CancelSendRequest>, sq.i<? extends CancelSendRequest>> {
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar) {
                super(1);
                this.this$0 = bVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ sq.i<? extends CancelSendRequest> invoke(sq.i<? extends CancelSendRequest> iVar) {
                return invoke2((sq.i<CancelSendRequest>) iVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final sq.i<CancelSendRequest> invoke2(@os.l sq.i<CancelSendRequest> iVar) {
                l0.p(iVar, "it");
                FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub = this.this$0.f6395e;
                if (fileMessageCoroutineStub != null) {
                    return FileMessageGrpcKt.FileMessageCoroutineStub.cancelSendStream$default(fileMessageCoroutineStub, iVar, null, 2, null);
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: g3.b$d$d, reason: collision with other inner class name */
        public static final class C0155d extends n0 implements jn.l<sq.i<? extends CancelSendReply>, sq.i<? extends CancelSendReply>> {
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0155d(b bVar) {
                super(1);
                this.this$0 = bVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ sq.i<? extends CancelSendReply> invoke(sq.i<? extends CancelSendReply> iVar) {
                return invoke2((sq.i<CancelSendReply>) iVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final sq.i<CancelSendReply> invoke2(@os.l sq.i<CancelSendReply> iVar) {
                l0.p(iVar, "it");
                FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub = this.this$0.f6395e;
                if (fileMessageCoroutineStub != null) {
                    return FileMessageGrpcKt.FileMessageCoroutineStub.cancelSendReplyStream$default(fileMessageCoroutineStub, iVar, null, 2, null);
                }
                return null;
            }
        }

        public static final class e extends n0 implements jn.l<sq.i<? extends CancelReceiveRequest>, sq.i<? extends CancelReceiveRequest>> {
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(b bVar) {
                super(1);
                this.this$0 = bVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ sq.i<? extends CancelReceiveRequest> invoke(sq.i<? extends CancelReceiveRequest> iVar) {
                return invoke2((sq.i<CancelReceiveRequest>) iVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final sq.i<CancelReceiveRequest> invoke2(@os.l sq.i<CancelReceiveRequest> iVar) {
                l0.p(iVar, "it");
                FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub = this.this$0.f6395e;
                if (fileMessageCoroutineStub != null) {
                    return FileMessageGrpcKt.FileMessageCoroutineStub.cancelReceiveStream$default(fileMessageCoroutineStub, iVar, null, 2, null);
                }
                return null;
            }
        }

        public static final class f extends n0 implements jn.l<sq.i<? extends CancelReceiveReply>, sq.i<? extends CancelReceiveReply>> {
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(b bVar) {
                super(1);
                this.this$0 = bVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ sq.i<? extends CancelReceiveReply> invoke(sq.i<? extends CancelReceiveReply> iVar) {
                return invoke2((sq.i<CancelReceiveReply>) iVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final sq.i<CancelReceiveReply> invoke2(@os.l sq.i<CancelReceiveReply> iVar) {
                l0.p(iVar, "it");
                FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub = this.this$0.f6395e;
                if (fileMessageCoroutineStub != null) {
                    return FileMessageGrpcKt.FileMessageCoroutineStub.cancelReceiveReplyStream$default(fileMessageCoroutineStub, iVar, null, 2, null);
                }
                return null;
            }
        }

        public static final class g extends n0 implements jn.l<sq.i<? extends ReceiveFinish>, sq.i<? extends ReceiveFinish>> {
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(b bVar) {
                super(1);
                this.this$0 = bVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ sq.i<? extends ReceiveFinish> invoke(sq.i<? extends ReceiveFinish> iVar) {
                return invoke2((sq.i<ReceiveFinish>) iVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final sq.i<ReceiveFinish> invoke2(@os.l sq.i<ReceiveFinish> iVar) {
                l0.p(iVar, "it");
                FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub = this.this$0.f6395e;
                if (fileMessageCoroutineStub != null) {
                    return FileMessageGrpcKt.FileMessageCoroutineStub.receiveFinishStream$default(fileMessageCoroutineStub, iVar, null, 2, null);
                }
                return null;
            }
        }

        public static final class h extends n0 implements jn.l<sq.i<? extends HandshakeRequest>, sq.i<? extends HandshakeRequest>> {
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public h(b bVar) {
                super(1);
                this.this$0 = bVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ sq.i<? extends HandshakeRequest> invoke(sq.i<? extends HandshakeRequest> iVar) {
                return invoke2((sq.i<HandshakeRequest>) iVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final sq.i<HandshakeRequest> invoke2(@os.l sq.i<HandshakeRequest> iVar) {
                l0.p(iVar, "it");
                FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub = this.this$0.f6395e;
                if (fileMessageCoroutineStub != null) {
                    return FileMessageGrpcKt.FileMessageCoroutineStub.handshakeStream$default(fileMessageCoroutineStub, iVar, null, 2, null);
                }
                return null;
            }
        }

        @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n33#2:125\n32#2,3:128\n223#3,2:126\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n*L\n111#1:125\n111#1:128,3\n111#1:126,2\n*E\n"})
        @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$startStream$1", f = "GrpcClientConnector.kt", i = {}, l = {y5.a.f20718f0}, m = "invokeSuspend", n = {}, s = {})
        public static final class i extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public i(jn.l lVar, um.d dVar) {
                super(2, dVar);
                this.$block = lVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new i(this.$block, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    h3.b bVar = h3.b.f6969a;
                    for (Object obj2 : h3.b.f6971c) {
                        h3.a aVar2 = (h3.a) obj2;
                        if (l0.g(aVar2.f(), SendFileInfoRequest.class)) {
                            l0.n(obj2, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                            sq.i iVar = (sq.i) this.$block.invoke(aVar2.c());
                            if (iVar != null) {
                                this.label = 1;
                                if (aVar2.g(iVar, this) == aVar) {
                                    return aVar;
                                }
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((i) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n33#2:125\n32#2,3:128\n223#3,2:126\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n*L\n111#1:125\n111#1:128,3\n111#1:126,2\n*E\n"})
        @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$startStream$1", f = "GrpcClientConnector.kt", i = {}, l = {y5.a.f20718f0}, m = "invokeSuspend", n = {}, s = {})
        public static final class j extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public j(jn.l lVar, um.d dVar) {
                super(2, dVar);
                this.$block = lVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new j(this.$block, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    h3.b bVar = h3.b.f6969a;
                    for (Object obj2 : h3.b.f6971c) {
                        h3.a aVar2 = (h3.a) obj2;
                        if (l0.g(aVar2.f(), SendFileReply.class)) {
                            l0.n(obj2, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                            sq.i iVar = (sq.i) this.$block.invoke(aVar2.c());
                            if (iVar != null) {
                                this.label = 1;
                                if (aVar2.g(iVar, this) == aVar) {
                                    return aVar;
                                }
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((j) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n33#2:125\n32#2,3:128\n223#3,2:126\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n*L\n111#1:125\n111#1:128,3\n111#1:126,2\n*E\n"})
        @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$startStream$1", f = "GrpcClientConnector.kt", i = {}, l = {y5.a.f20718f0}, m = "invokeSuspend", n = {}, s = {})
        public static final class k extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public k(jn.l lVar, um.d dVar) {
                super(2, dVar);
                this.$block = lVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new k(this.$block, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    h3.b bVar = h3.b.f6969a;
                    for (Object obj2 : h3.b.f6971c) {
                        h3.a aVar2 = (h3.a) obj2;
                        if (l0.g(aVar2.f(), CancelSendRequest.class)) {
                            l0.n(obj2, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                            sq.i iVar = (sq.i) this.$block.invoke(aVar2.c());
                            if (iVar != null) {
                                this.label = 1;
                                if (aVar2.g(iVar, this) == aVar) {
                                    return aVar;
                                }
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((k) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n33#2:125\n32#2,3:128\n223#3,2:126\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n*L\n111#1:125\n111#1:128,3\n111#1:126,2\n*E\n"})
        @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$startStream$1", f = "GrpcClientConnector.kt", i = {}, l = {y5.a.f20718f0}, m = "invokeSuspend", n = {}, s = {})
        public static final class l extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public l(jn.l lVar, um.d dVar) {
                super(2, dVar);
                this.$block = lVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new l(this.$block, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    h3.b bVar = h3.b.f6969a;
                    for (Object obj2 : h3.b.f6971c) {
                        h3.a aVar2 = (h3.a) obj2;
                        if (l0.g(aVar2.f(), CancelSendReply.class)) {
                            l0.n(obj2, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                            sq.i iVar = (sq.i) this.$block.invoke(aVar2.c());
                            if (iVar != null) {
                                this.label = 1;
                                if (aVar2.g(iVar, this) == aVar) {
                                    return aVar;
                                }
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((l) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n33#2:125\n32#2,3:128\n223#3,2:126\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n*L\n111#1:125\n111#1:128,3\n111#1:126,2\n*E\n"})
        @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$startStream$1", f = "GrpcClientConnector.kt", i = {}, l = {y5.a.f20718f0}, m = "invokeSuspend", n = {}, s = {})
        public static final class m extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public m(jn.l lVar, um.d dVar) {
                super(2, dVar);
                this.$block = lVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new m(this.$block, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    h3.b bVar = h3.b.f6969a;
                    for (Object obj2 : h3.b.f6971c) {
                        h3.a aVar2 = (h3.a) obj2;
                        if (l0.g(aVar2.f(), CancelReceiveRequest.class)) {
                            l0.n(obj2, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                            sq.i iVar = (sq.i) this.$block.invoke(aVar2.c());
                            if (iVar != null) {
                                this.label = 1;
                                if (aVar2.g(iVar, this) == aVar) {
                                    return aVar;
                                }
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((m) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n33#2:125\n32#2,3:128\n223#3,2:126\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n*L\n111#1:125\n111#1:128,3\n111#1:126,2\n*E\n"})
        @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$startStream$1", f = "GrpcClientConnector.kt", i = {}, l = {y5.a.f20718f0}, m = "invokeSuspend", n = {}, s = {})
        public static final class n extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public n(jn.l lVar, um.d dVar) {
                super(2, dVar);
                this.$block = lVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new n(this.$block, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    h3.b bVar = h3.b.f6969a;
                    for (Object obj2 : h3.b.f6971c) {
                        h3.a aVar2 = (h3.a) obj2;
                        if (l0.g(aVar2.f(), CancelReceiveReply.class)) {
                            l0.n(obj2, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                            sq.i iVar = (sq.i) this.$block.invoke(aVar2.c());
                            if (iVar != null) {
                                this.label = 1;
                                if (aVar2.g(iVar, this) == aVar) {
                                    return aVar;
                                }
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((n) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n33#2:125\n32#2,3:128\n223#3,2:126\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n*L\n111#1:125\n111#1:128,3\n111#1:126,2\n*E\n"})
        @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$startStream$1", f = "GrpcClientConnector.kt", i = {}, l = {y5.a.f20718f0}, m = "invokeSuspend", n = {}, s = {})
        public static final class o extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public o(jn.l lVar, um.d dVar) {
                super(2, dVar);
                this.$block = lVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new o(this.$block, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    h3.b bVar = h3.b.f6969a;
                    for (Object obj2 : h3.b.f6971c) {
                        h3.a aVar2 = (h3.a) obj2;
                        if (l0.g(aVar2.f(), ReceiveFinish.class)) {
                            l0.n(obj2, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                            sq.i iVar = (sq.i) this.$block.invoke(aVar2.c());
                            if (iVar != null) {
                                this.label = 1;
                                if (aVar2.g(iVar, this) == aVar) {
                                    return aVar;
                                }
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((o) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n33#2:125\n32#2,3:128\n223#3,2:126\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n*L\n111#1:125\n111#1:128,3\n111#1:126,2\n*E\n"})
        @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$startStream$1", f = "GrpcClientConnector.kt", i = {}, l = {y5.a.f20718f0}, m = "invokeSuspend", n = {}, s = {})
        public static final class p extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public p(jn.l lVar, um.d dVar) {
                super(2, dVar);
                this.$block = lVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new p(this.$block, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    h3.b bVar = h3.b.f6969a;
                    for (Object obj2 : h3.b.f6971c) {
                        h3.a aVar2 = (h3.a) obj2;
                        if (l0.g(aVar2.f(), HandshakeRequest.class)) {
                            l0.n(obj2, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                            sq.i iVar = (sq.i) this.$block.invoke(aVar2.c());
                            if (iVar != null) {
                                this.label = 1;
                                if (aVar2.g(iVar, this) == aVar) {
                                    return aVar;
                                }
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((p) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        public d(um.d<? super d> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return b.this.new d(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                b bVar = b.this;
                this.label = 1;
                if (bVar.j(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            b bVar2 = b.this;
            nq.k.f(bVar2, bVar2.f6398i, null, new i(new a(bVar2), null), 2, null);
            b bVar3 = b.this;
            nq.k.f(bVar3, bVar3.f6398i, null, new j(new C0154b(bVar3), null), 2, null);
            b bVar4 = b.this;
            nq.k.f(bVar4, bVar4.f6398i, null, new k(new c(bVar4), null), 2, null);
            b bVar5 = b.this;
            nq.k.f(bVar5, bVar5.f6398i, null, new l(new C0155d(bVar5), null), 2, null);
            b bVar6 = b.this;
            nq.k.f(bVar6, bVar6.f6398i, null, new m(new e(bVar6), null), 2, null);
            b bVar7 = b.this;
            nq.k.f(bVar7, bVar7.f6398i, null, new n(new f(bVar7), null), 2, null);
            b bVar8 = b.this;
            nq.k.f(bVar8, bVar8.f6398i, null, new o(new g(bVar8), null), 2, null);
            b bVar9 = b.this;
            nq.k.f(bVar9, bVar9.f6398i, null, new p(new h(bVar9), null), 2, null);
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((d) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @r1({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector\n*L\n1#1,110:1\n44#2,3:111\n*E\n"})
    public static final class e extends um.a implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f6399a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(o0.b bVar, b bVar2) {
            super(bVar);
            this.f6399a = bVar2;
        }

        @Override // nq.o0
        public void g0(@l um.g gVar, @l Throwable th2) {
            j3.b.f8554a.d(b.f6390p, th2);
            this.f6399a.disconnect();
        }
    }

    @r1({"SMAP\nGrpcClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n33#2:125\n32#2,3:128\n223#3,2:126\n*S KotlinDebug\n*F\n+ 1 GrpcClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcClientConnector$startStream$1\n*L\n111#1:125\n111#1:128,3\n111#1:126,2\n*E\n"})
    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.grpc.GrpcClientConnector$startStream$1", f = "GrpcClientConnector.kt", i = {}, l = {y5.a.f20718f0}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends o implements p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ jn.l<i<? extends T>, i<T>> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(jn.l<? super i<? extends T>, ? extends i<? extends T>> lVar, um.d<? super f> dVar) {
            super(2, dVar);
            this.$block = lVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new f(this.$block, dVar);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                h3.b bVar = h3.b.f6969a;
                for (Object obj2 : h3.b.f6971c) {
                    h3.a aVar2 = (h3.a) obj2;
                    Class<?> clsF = aVar2.f();
                    l0.P();
                    if (l0.g(clsF, Object.class)) {
                        l0.n(obj2, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                        i iVar = (i) this.$block.invoke((i<? extends T>) aVar2.c());
                        if (iVar != null) {
                            this.label = 1;
                            if (aVar2.g(iVar, this) == aVar) {
                                return aVar;
                            }
                        }
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((f) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public b(@l String str, int i10) {
        l0.p(str, "serverIp");
        this.f6391a = str;
        this.f6392b = i10;
        this.f6393c = s2.d.a();
        this.f6396f = new g();
        this.f6398i = new e(o0.f11887j, this);
    }

    @Override // z2.d
    public void b() {
        vj.r1 r1VarB = s1.l(this.f6391a, this.f6392b).G().k(z1.b(k1.c())).b();
        this.f6394d = r1VarB;
        if (r1VarB != null) {
            this.f6395e = new FileMessageGrpcKt.FileMessageCoroutineStub(r1VarB, null, 2, null);
        }
        l();
        this.f6396f.start();
    }

    @Override // z2.d
    public void disconnect() {
        vj.r1 r1Var = this.f6394d;
        if (r1Var != null) {
            r1Var.s();
        }
        this.f6396f.stop();
        t0.f(this, null, 1, null);
    }

    @Override // nq.s0
    @l
    public um.g getCoroutineContext() {
        return this.f6393c.getCoroutineContext();
    }

    public final void i(boolean z10) {
        u2.b bVar = u2.b.f16175b;
        String simpleName = b.class.getSimpleName();
        l0.o(simpleName, "getSimpleName(...)");
        r2.p.b(bVar, new r2.f(simpleName, z10), null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x009c A[Catch: Exception -> 0x0044, TRY_LEAVE, TryCatch #0 {Exception -> 0x0044, blocks: (B:17:0x003f, B:22:0x004a, B:30:0x007b, B:32:0x007f, B:34:0x0092, B:36:0x0098, B:37:0x009c, B:25:0x0051, B:27:0x0055), top: B:45:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object j(um.d<? super l2> dVar) {
        C0153b c0153b;
        Heartbeat heartbeat;
        if (dVar instanceof C0153b) {
            c0153b = (C0153b) dVar;
            int i10 = c0153b.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0153b.label = i10 - Integer.MIN_VALUE;
            } else {
                c0153b = new C0153b(dVar);
            }
        } else {
            c0153b = new C0153b(dVar);
        }
        Object objSendHeartbeat$default = c0153b.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0153b.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    this = (b) c0153b.L$0;
                    d1.n(objSendHeartbeat$default);
                } else if (i11 == 2) {
                    d1.n(objSendHeartbeat$default);
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(objSendHeartbeat$default);
                }
                return l2.f10208a;
            }
            d1.n(objSendHeartbeat$default);
            FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub = this.f6395e;
            if (fileMessageCoroutineStub != null) {
                HeartbeatKt.Dsl.Companion companion = HeartbeatKt.Dsl.Companion;
                Heartbeat.Builder builderNewBuilder = Heartbeat.newBuilder();
                l0.o(builderNewBuilder, "newBuilder(...)");
                HeartbeatKt.Dsl dsl_create = companion._create(builderNewBuilder);
                dsl_create.setMsg(0);
                Heartbeat heartbeat_build = dsl_create._build();
                c0153b.L$0 = this;
                c0153b.label = 1;
                objSendHeartbeat$default = FileMessageGrpcKt.FileMessageCoroutineStub.sendHeartbeat$default(fileMessageCoroutineStub, heartbeat_build, null, c0153b, 2, null);
                if (objSendHeartbeat$default == aVar) {
                    return aVar;
                }
            } else {
                heartbeat = null;
            }
            j3.b.f8554a.e(f6390p, "sendFileInfo  finish " + heartbeat);
            if (heartbeat == null && heartbeat.getMsg() == 1) {
                this.i(true);
            } else {
                c0153b.L$0 = this;
                c0153b.label = 2;
                if (this.k(c0153b) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
            heartbeat = (Heartbeat) objSendHeartbeat$default;
            j3.b.f8554a.e(f6390p, "sendFileInfo  finish " + heartbeat);
            if (heartbeat == null) {
                c0153b.L$0 = this;
                c0153b.label = 2;
                if (this.k(c0153b) == aVar) {
                    return aVar;
                }
            } else {
                c0153b.L$0 = this;
                c0153b.label = 2;
                if (this.k(c0153b) == aVar) {
                    return aVar;
                }
            }
        } catch (Exception e10) {
            j3.b.f8554a.d(f6390p, e10);
            c0153b.L$0 = null;
            c0153b.label = 3;
            if (k(c0153b) == aVar) {
                return aVar;
            }
        }
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object k(um.d<? super l2> dVar) {
        c cVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                this = (b) cVar.L$0;
                d1.n(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
        d1.n(obj);
        int i12 = this.f6397g;
        if (i12 >= 10) {
            i(false);
            disconnect();
            return l2.f10208a;
        }
        this.f6397g = i12 + 1;
        j3.b.f8554a.e(f6390p, "checkConnectState: reconnectCount = " + this.f6397g);
        cVar.L$0 = this;
        cVar.label = 1;
        if (nq.d1.b(300L, cVar) == aVar) {
            return aVar;
        }
        cVar.L$0 = null;
        cVar.label = 2;
        if (this.j(cVar) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }

    public final nq.l2 l() {
        return k.f(this, null, null, new d(null), 3, null);
    }

    public final <T> void m(jn.l<? super i<? extends T>, ? extends i<? extends T>> lVar) {
        o0 o0Var = this.f6398i;
        l0.P();
        k.f(this, o0Var, null, new f(lVar, null), 2, null);
    }
}
