package com.transsion.airtransfer.filetransfer.protos;

import in.n;
import kn.l0;
import kn.w;
import lm.d1;
import os.l;
import os.m;
import um.d;
import um.g;
import vj.e;
import vj.f;
import vj.t2;
import vj.v1;
import vj.w1;
import vj.w2;
import vj.y2;
import vj.z2;
import xj.a;
import xj.b;
import xj.c;
import xj.i;
import xj.j;

/* JADX INFO: loaded from: classes2.dex */
public final class FileMessageGrpcKt {

    @l
    public static final FileMessageGrpcKt INSTANCE = new FileMessageGrpcKt();

    @l
    public static final String SERVICE_NAME = "filetransfer.FileMessage";

    public static abstract class FileMessageCoroutineImplBase extends a {
        /* JADX WARN: Multi-variable type inference failed */
        public FileMessageCoroutineImplBase() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Object cancelReceive$suspendImpl(FileMessageCoroutineImplBase fileMessageCoroutineImplBase, CancelReceiveRequest cancelReceiveRequest, d<? super CancelReceiveReply> dVar) throws z2 {
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.CancelReceive is unimplemented"));
        }

        public static /* synthetic */ Object cancelSend$suspendImpl(FileMessageCoroutineImplBase fileMessageCoroutineImplBase, CancelSendRequest cancelSendRequest, d<? super Reply> dVar) throws z2 {
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.CancelSend is unimplemented"));
        }

        public static /* synthetic */ Object sendFileInfo$suspendImpl(FileMessageCoroutineImplBase fileMessageCoroutineImplBase, SendFileInfoRequest sendFileInfoRequest, d<? super SendFileReply> dVar) throws z2 {
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.SendFileInfo is unimplemented"));
        }

        public static /* synthetic */ Object sendHeartbeat$suspendImpl(FileMessageCoroutineImplBase fileMessageCoroutineImplBase, Heartbeat heartbeat, d<? super Heartbeat> dVar) throws z2 {
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.sendHeartbeat is unimplemented"));
        }

        @Override // vj.c
        @l
        public final t2 bindService() {
            t2.b bVar = new t2.b(FileMessageGrpc.getServiceDescriptor());
            i iVar = i.f20264a;
            g context = getContext();
            w1<SendFileInfoRequest, SendFileReply> sendFileInfoMethod = FileMessageGrpc.getSendFileInfoMethod();
            l0.o(sendFileInfoMethod, "getSendFileInfoMethod(...)");
            t2.b bVarB = bVar.b(iVar.i(context, sendFileInfoMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$1(this)));
            g context2 = getContext();
            w1<CancelSendRequest, Reply> cancelSendMethod = FileMessageGrpc.getCancelSendMethod();
            l0.o(cancelSendMethod, "getCancelSendMethod(...)");
            t2.b bVarB2 = bVarB.b(iVar.i(context2, cancelSendMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$2(this)));
            g context3 = getContext();
            w1<CancelReceiveRequest, CancelReceiveReply> cancelReceiveMethod = FileMessageGrpc.getCancelReceiveMethod();
            l0.o(cancelReceiveMethod, "getCancelReceiveMethod(...)");
            t2.b bVarB3 = bVarB2.b(iVar.i(context3, cancelReceiveMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$3(this)));
            g context4 = getContext();
            w1<Heartbeat, Heartbeat> sendHeartbeatMethod = FileMessageGrpc.getSendHeartbeatMethod();
            l0.o(sendHeartbeatMethod, "getSendHeartbeatMethod(...)");
            t2.b bVarB4 = bVarB3.b(iVar.i(context4, sendHeartbeatMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$4(this)));
            g context5 = getContext();
            w1<SendFileInfoRequest, SendFileInfoRequest> sendFileInfoStreamMethod = FileMessageGrpc.getSendFileInfoStreamMethod();
            l0.o(sendFileInfoStreamMethod, "getSendFileInfoStreamMethod(...)");
            t2.b bVarB5 = bVarB4.b(iVar.b(context5, sendFileInfoStreamMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$5(this)));
            g context6 = getContext();
            w1<CancelSendRequest, CancelSendRequest> cancelSendStreamMethod = FileMessageGrpc.getCancelSendStreamMethod();
            l0.o(cancelSendStreamMethod, "getCancelSendStreamMethod(...)");
            t2.b bVarB6 = bVarB5.b(iVar.b(context6, cancelSendStreamMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$6(this)));
            g context7 = getContext();
            w1<CancelReceiveRequest, CancelReceiveRequest> cancelReceiveStreamMethod = FileMessageGrpc.getCancelReceiveStreamMethod();
            l0.o(cancelReceiveStreamMethod, "getCancelReceiveStreamMethod(...)");
            t2.b bVarB7 = bVarB6.b(iVar.b(context7, cancelReceiveStreamMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$7(this)));
            g context8 = getContext();
            w1<SendFileReply, SendFileReply> sendFileInfoReplyStreamMethod = FileMessageGrpc.getSendFileInfoReplyStreamMethod();
            l0.o(sendFileInfoReplyStreamMethod, "getSendFileInfoReplyStreamMethod(...)");
            t2.b bVarB8 = bVarB7.b(iVar.b(context8, sendFileInfoReplyStreamMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$8(this)));
            g context9 = getContext();
            w1<CancelReceiveReply, CancelReceiveReply> cancelReceiveReplyStreamMethod = FileMessageGrpc.getCancelReceiveReplyStreamMethod();
            l0.o(cancelReceiveReplyStreamMethod, "getCancelReceiveReplyStreamMethod(...)");
            t2.b bVarB9 = bVarB8.b(iVar.b(context9, cancelReceiveReplyStreamMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$9(this)));
            g context10 = getContext();
            w1<CancelSendReply, CancelSendReply> cancelSendReplyStreamMethod = FileMessageGrpc.getCancelSendReplyStreamMethod();
            l0.o(cancelSendReplyStreamMethod, "getCancelSendReplyStreamMethod(...)");
            t2.b bVarB10 = bVarB9.b(iVar.b(context10, cancelSendReplyStreamMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$10(this)));
            g context11 = getContext();
            w1<ReceiveFinish, ReceiveFinish> receiveFinishStreamMethod = FileMessageGrpc.getReceiveFinishStreamMethod();
            l0.o(receiveFinishStreamMethod, "getReceiveFinishStreamMethod(...)");
            t2.b bVarB11 = bVarB10.b(iVar.b(context11, receiveFinishStreamMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$11(this)));
            g context12 = getContext();
            w1<HandshakeRequest, HandshakeRequest> handshakeStreamMethod = FileMessageGrpc.getHandshakeStreamMethod();
            l0.o(handshakeStreamMethod, "getHandshakeStreamMethod(...)");
            t2 t2VarC = bVarB11.b(iVar.b(context12, handshakeStreamMethod, new FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$12(this))).c();
            l0.o(t2VarC, "build(...)");
            return t2VarC;
        }

        @m
        public Object cancelReceive(@l CancelReceiveRequest cancelReceiveRequest, @l d<? super CancelReceiveReply> dVar) {
            return cancelReceive$suspendImpl(this, cancelReceiveRequest, dVar);
        }

        @l
        public sq.i<CancelReceiveReply> cancelReceiveReplyStream(@l sq.i<CancelReceiveReply> iVar) throws z2 {
            l0.p(iVar, "requests");
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.CancelReceiveReplyStream is unimplemented"));
        }

        @l
        public sq.i<CancelReceiveRequest> cancelReceiveStream(@l sq.i<CancelReceiveRequest> iVar) throws z2 {
            l0.p(iVar, "requests");
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.CancelReceiveStream is unimplemented"));
        }

        @m
        public Object cancelSend(@l CancelSendRequest cancelSendRequest, @l d<? super Reply> dVar) {
            return cancelSend$suspendImpl(this, cancelSendRequest, dVar);
        }

        @l
        public sq.i<CancelSendReply> cancelSendReplyStream(@l sq.i<CancelSendReply> iVar) throws z2 {
            l0.p(iVar, "requests");
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.CancelSendReplyStream is unimplemented"));
        }

        @l
        public sq.i<CancelSendRequest> cancelSendStream(@l sq.i<CancelSendRequest> iVar) throws z2 {
            l0.p(iVar, "requests");
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.CancelSendStream is unimplemented"));
        }

        @l
        public sq.i<HandshakeRequest> handshakeStream(@l sq.i<HandshakeRequest> iVar) throws z2 {
            l0.p(iVar, "requests");
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.HandshakeStream is unimplemented"));
        }

        @l
        public sq.i<ReceiveFinish> receiveFinishStream(@l sq.i<ReceiveFinish> iVar) throws z2 {
            l0.p(iVar, "requests");
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.ReceiveFinishStream is unimplemented"));
        }

        @m
        public Object sendFileInfo(@l SendFileInfoRequest sendFileInfoRequest, @l d<? super SendFileReply> dVar) {
            return sendFileInfo$suspendImpl(this, sendFileInfoRequest, dVar);
        }

        @l
        public sq.i<SendFileReply> sendFileInfoReplyStream(@l sq.i<SendFileReply> iVar) throws z2 {
            l0.p(iVar, "requests");
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.SendFileInfoReplyStream is unimplemented"));
        }

        @l
        public sq.i<SendFileInfoRequest> sendFileInfoStream(@l sq.i<SendFileInfoRequest> iVar) throws z2 {
            l0.p(iVar, "requests");
            throw new z2(y2.f17561r.u("Method filetransfer.FileMessage.SendFileInfoStream is unimplemented"));
        }

        @m
        public Object sendHeartbeat(@l Heartbeat heartbeat, @l d<? super Heartbeat> dVar) {
            return sendHeartbeat$suspendImpl(this, heartbeat, dVar);
        }

        public /* synthetic */ FileMessageCoroutineImplBase(g gVar, int i10, w wVar) {
            this((i10 & 1) != 0 ? um.i.INSTANCE : gVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileMessageCoroutineImplBase(@l g gVar) {
            super(gVar);
            l0.p(gVar, "coroutineContext");
        }
    }

    @j(FileMessageGrpc.class)
    public static final class FileMessageCoroutineStub extends b<FileMessageCoroutineStub> {
        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        @in.j
        public FileMessageCoroutineStub(@l f fVar) {
            this(fVar, null, 2, 0 == true ? 1 : 0);
            l0.p(fVar, "channel");
        }

        public static Object cancelReceive$default(FileMessageCoroutineStub fileMessageCoroutineStub, CancelReceiveRequest cancelReceiveRequest, v1 v1Var, d dVar, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.cancelReceive(cancelReceiveRequest, v1Var, dVar);
        }

        public static sq.i cancelReceiveReplyStream$default(FileMessageCoroutineStub fileMessageCoroutineStub, sq.i iVar, v1 v1Var, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.cancelReceiveReplyStream(iVar, v1Var);
        }

        public static sq.i cancelReceiveStream$default(FileMessageCoroutineStub fileMessageCoroutineStub, sq.i iVar, v1 v1Var, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.cancelReceiveStream(iVar, v1Var);
        }

        public static Object cancelSend$default(FileMessageCoroutineStub fileMessageCoroutineStub, CancelSendRequest cancelSendRequest, v1 v1Var, d dVar, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.cancelSend(cancelSendRequest, v1Var, dVar);
        }

        public static sq.i cancelSendReplyStream$default(FileMessageCoroutineStub fileMessageCoroutineStub, sq.i iVar, v1 v1Var, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.cancelSendReplyStream(iVar, v1Var);
        }

        public static sq.i cancelSendStream$default(FileMessageCoroutineStub fileMessageCoroutineStub, sq.i iVar, v1 v1Var, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.cancelSendStream(iVar, v1Var);
        }

        public static sq.i handshakeStream$default(FileMessageCoroutineStub fileMessageCoroutineStub, sq.i iVar, v1 v1Var, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.handshakeStream(iVar, v1Var);
        }

        public static sq.i receiveFinishStream$default(FileMessageCoroutineStub fileMessageCoroutineStub, sq.i iVar, v1 v1Var, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.receiveFinishStream(iVar, v1Var);
        }

        public static Object sendFileInfo$default(FileMessageCoroutineStub fileMessageCoroutineStub, SendFileInfoRequest sendFileInfoRequest, v1 v1Var, d dVar, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.sendFileInfo(sendFileInfoRequest, v1Var, dVar);
        }

        public static sq.i sendFileInfoReplyStream$default(FileMessageCoroutineStub fileMessageCoroutineStub, sq.i iVar, v1 v1Var, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.sendFileInfoReplyStream(iVar, v1Var);
        }

        public static sq.i sendFileInfoStream$default(FileMessageCoroutineStub fileMessageCoroutineStub, sq.i iVar, v1 v1Var, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.sendFileInfoStream(iVar, v1Var);
        }

        public static Object sendHeartbeat$default(FileMessageCoroutineStub fileMessageCoroutineStub, Heartbeat heartbeat, v1 v1Var, d dVar, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                v1Var = new v1();
            }
            return fileMessageCoroutineStub.sendHeartbeat(heartbeat, v1Var, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0014  */
        @m
        public final Object cancelReceive(@l CancelReceiveRequest cancelReceiveRequest, @l v1 v1Var, @l d<? super CancelReceiveReply> dVar) {
            FileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1 fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1;
            if (dVar instanceof FileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1) {
                fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1 = (FileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1) dVar;
                int i10 = fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1 = new FileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1(this, dVar);
                }
            } else {
                fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1 = new FileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1(this, dVar);
            }
            FileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1 fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$2 = fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$1;
            Object objP = fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$2.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$2.label;
            if (i11 == 0) {
                d1.n(objP);
                c cVar = c.f20243a;
                f channel = getChannel();
                l0.o(channel, "getChannel(...)");
                w1<CancelReceiveRequest, CancelReceiveReply> cancelReceiveMethod = FileMessageGrpc.getCancelReceiveMethod();
                l0.o(cancelReceiveMethod, "getCancelReceiveMethod(...)");
                e callOptions = getCallOptions();
                l0.o(callOptions, "getCallOptions(...)");
                fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$2.label = 1;
                objP = cVar.p(channel, cancelReceiveMethod, cancelReceiveRequest, callOptions, v1Var, fileMessageGrpcKt$FileMessageCoroutineStub$cancelReceive$2);
                if (objP == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objP);
            }
            l0.o(objP, "unaryRpc(...)");
            return objP;
        }

        @l
        public final sq.i<CancelReceiveReply> cancelReceiveReplyStream(@l sq.i<CancelReceiveReply> iVar, @l v1 v1Var) {
            l0.p(iVar, "requests");
            l0.p(v1Var, "headers");
            c cVar = c.f20243a;
            f channel = getChannel();
            l0.o(channel, "getChannel(...)");
            w1<CancelReceiveReply, CancelReceiveReply> cancelReceiveReplyStreamMethod = FileMessageGrpc.getCancelReceiveReplyStreamMethod();
            l0.o(cancelReceiveReplyStreamMethod, "getCancelReceiveReplyStreamMethod(...)");
            e callOptions = getCallOptions();
            l0.o(callOptions, "getCallOptions(...)");
            return cVar.b(channel, cancelReceiveReplyStreamMethod, iVar, callOptions, v1Var);
        }

        @l
        public final sq.i<CancelReceiveRequest> cancelReceiveStream(@l sq.i<CancelReceiveRequest> iVar, @l v1 v1Var) {
            l0.p(iVar, "requests");
            l0.p(v1Var, "headers");
            c cVar = c.f20243a;
            f channel = getChannel();
            l0.o(channel, "getChannel(...)");
            w1<CancelReceiveRequest, CancelReceiveRequest> cancelReceiveStreamMethod = FileMessageGrpc.getCancelReceiveStreamMethod();
            l0.o(cancelReceiveStreamMethod, "getCancelReceiveStreamMethod(...)");
            e callOptions = getCallOptions();
            l0.o(callOptions, "getCallOptions(...)");
            return cVar.b(channel, cancelReceiveStreamMethod, iVar, callOptions, v1Var);
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0014  */
        @m
        public final Object cancelSend(@l CancelSendRequest cancelSendRequest, @l v1 v1Var, @l d<? super Reply> dVar) {
            FileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1 fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1;
            if (dVar instanceof FileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1) {
                fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1 = (FileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1) dVar;
                int i10 = fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1 = new FileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1(this, dVar);
                }
            } else {
                fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1 = new FileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1(this, dVar);
            }
            FileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1 fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$2 = fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$1;
            Object objP = fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$2.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$2.label;
            if (i11 == 0) {
                d1.n(objP);
                c cVar = c.f20243a;
                f channel = getChannel();
                l0.o(channel, "getChannel(...)");
                w1<CancelSendRequest, Reply> cancelSendMethod = FileMessageGrpc.getCancelSendMethod();
                l0.o(cancelSendMethod, "getCancelSendMethod(...)");
                e callOptions = getCallOptions();
                l0.o(callOptions, "getCallOptions(...)");
                fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$2.label = 1;
                objP = cVar.p(channel, cancelSendMethod, cancelSendRequest, callOptions, v1Var, fileMessageGrpcKt$FileMessageCoroutineStub$cancelSend$2);
                if (objP == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objP);
            }
            l0.o(objP, "unaryRpc(...)");
            return objP;
        }

        @l
        public final sq.i<CancelSendReply> cancelSendReplyStream(@l sq.i<CancelSendReply> iVar, @l v1 v1Var) {
            l0.p(iVar, "requests");
            l0.p(v1Var, "headers");
            c cVar = c.f20243a;
            f channel = getChannel();
            l0.o(channel, "getChannel(...)");
            w1<CancelSendReply, CancelSendReply> cancelSendReplyStreamMethod = FileMessageGrpc.getCancelSendReplyStreamMethod();
            l0.o(cancelSendReplyStreamMethod, "getCancelSendReplyStreamMethod(...)");
            e callOptions = getCallOptions();
            l0.o(callOptions, "getCallOptions(...)");
            return cVar.b(channel, cancelSendReplyStreamMethod, iVar, callOptions, v1Var);
        }

        @l
        public final sq.i<CancelSendRequest> cancelSendStream(@l sq.i<CancelSendRequest> iVar, @l v1 v1Var) {
            l0.p(iVar, "requests");
            l0.p(v1Var, "headers");
            c cVar = c.f20243a;
            f channel = getChannel();
            l0.o(channel, "getChannel(...)");
            w1<CancelSendRequest, CancelSendRequest> cancelSendStreamMethod = FileMessageGrpc.getCancelSendStreamMethod();
            l0.o(cancelSendStreamMethod, "getCancelSendStreamMethod(...)");
            e callOptions = getCallOptions();
            l0.o(callOptions, "getCallOptions(...)");
            return cVar.b(channel, cancelSendStreamMethod, iVar, callOptions, v1Var);
        }

        @l
        public final sq.i<HandshakeRequest> handshakeStream(@l sq.i<HandshakeRequest> iVar, @l v1 v1Var) {
            l0.p(iVar, "requests");
            l0.p(v1Var, "headers");
            c cVar = c.f20243a;
            f channel = getChannel();
            l0.o(channel, "getChannel(...)");
            w1<HandshakeRequest, HandshakeRequest> handshakeStreamMethod = FileMessageGrpc.getHandshakeStreamMethod();
            l0.o(handshakeStreamMethod, "getHandshakeStreamMethod(...)");
            e callOptions = getCallOptions();
            l0.o(callOptions, "getCallOptions(...)");
            return cVar.b(channel, handshakeStreamMethod, iVar, callOptions, v1Var);
        }

        @l
        public final sq.i<ReceiveFinish> receiveFinishStream(@l sq.i<ReceiveFinish> iVar, @l v1 v1Var) {
            l0.p(iVar, "requests");
            l0.p(v1Var, "headers");
            c cVar = c.f20243a;
            f channel = getChannel();
            l0.o(channel, "getChannel(...)");
            w1<ReceiveFinish, ReceiveFinish> receiveFinishStreamMethod = FileMessageGrpc.getReceiveFinishStreamMethod();
            l0.o(receiveFinishStreamMethod, "getReceiveFinishStreamMethod(...)");
            e callOptions = getCallOptions();
            l0.o(callOptions, "getCallOptions(...)");
            return cVar.b(channel, receiveFinishStreamMethod, iVar, callOptions, v1Var);
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0014  */
        @m
        public final Object sendFileInfo(@l SendFileInfoRequest sendFileInfoRequest, @l v1 v1Var, @l d<? super SendFileReply> dVar) {
            FileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1 fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1;
            if (dVar instanceof FileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1) {
                fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1 = (FileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1) dVar;
                int i10 = fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1 = new FileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1(this, dVar);
                }
            } else {
                fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1 = new FileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1(this, dVar);
            }
            FileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1 fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$2 = fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1;
            Object objP = fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$2.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$2.label;
            if (i11 == 0) {
                d1.n(objP);
                c cVar = c.f20243a;
                f channel = getChannel();
                l0.o(channel, "getChannel(...)");
                w1<SendFileInfoRequest, SendFileReply> sendFileInfoMethod = FileMessageGrpc.getSendFileInfoMethod();
                l0.o(sendFileInfoMethod, "getSendFileInfoMethod(...)");
                e callOptions = getCallOptions();
                l0.o(callOptions, "getCallOptions(...)");
                fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$2.label = 1;
                objP = cVar.p(channel, sendFileInfoMethod, sendFileInfoRequest, callOptions, v1Var, fileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$2);
                if (objP == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objP);
            }
            l0.o(objP, "unaryRpc(...)");
            return objP;
        }

        @l
        public final sq.i<SendFileReply> sendFileInfoReplyStream(@l sq.i<SendFileReply> iVar, @l v1 v1Var) {
            l0.p(iVar, "requests");
            l0.p(v1Var, "headers");
            c cVar = c.f20243a;
            f channel = getChannel();
            l0.o(channel, "getChannel(...)");
            w1<SendFileReply, SendFileReply> sendFileInfoReplyStreamMethod = FileMessageGrpc.getSendFileInfoReplyStreamMethod();
            l0.o(sendFileInfoReplyStreamMethod, "getSendFileInfoReplyStreamMethod(...)");
            e callOptions = getCallOptions();
            l0.o(callOptions, "getCallOptions(...)");
            return cVar.b(channel, sendFileInfoReplyStreamMethod, iVar, callOptions, v1Var);
        }

        @l
        public final sq.i<SendFileInfoRequest> sendFileInfoStream(@l sq.i<SendFileInfoRequest> iVar, @l v1 v1Var) {
            l0.p(iVar, "requests");
            l0.p(v1Var, "headers");
            c cVar = c.f20243a;
            f channel = getChannel();
            l0.o(channel, "getChannel(...)");
            w1<SendFileInfoRequest, SendFileInfoRequest> sendFileInfoStreamMethod = FileMessageGrpc.getSendFileInfoStreamMethod();
            l0.o(sendFileInfoStreamMethod, "getSendFileInfoStreamMethod(...)");
            e callOptions = getCallOptions();
            l0.o(callOptions, "getCallOptions(...)");
            return cVar.b(channel, sendFileInfoStreamMethod, iVar, callOptions, v1Var);
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0014  */
        @m
        public final Object sendHeartbeat(@l Heartbeat heartbeat, @l v1 v1Var, @l d<? super Heartbeat> dVar) {
            FileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1 fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1;
            if (dVar instanceof FileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1) {
                fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1 = (FileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1) dVar;
                int i10 = fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1 = new FileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1(this, dVar);
                }
            } else {
                fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1 = new FileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1(this, dVar);
            }
            FileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1 fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$2 = fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$1;
            Object objP = fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$2.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$2.label;
            if (i11 == 0) {
                d1.n(objP);
                c cVar = c.f20243a;
                f channel = getChannel();
                l0.o(channel, "getChannel(...)");
                w1<Heartbeat, Heartbeat> sendHeartbeatMethod = FileMessageGrpc.getSendHeartbeatMethod();
                l0.o(sendHeartbeatMethod, "getSendHeartbeatMethod(...)");
                e callOptions = getCallOptions();
                l0.o(callOptions, "getCallOptions(...)");
                fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$2.label = 1;
                objP = cVar.p(channel, sendHeartbeatMethod, heartbeat, callOptions, v1Var, fileMessageGrpcKt$FileMessageCoroutineStub$sendHeartbeat$2);
                if (objP == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objP);
            }
            l0.o(objP, "unaryRpc(...)");
            return objP;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ FileMessageCoroutineStub(f fVar, e eVar, int i10, w wVar) {
            if ((i10 & 2) != 0) {
                eVar = e.f17085l;
                l0.o(eVar, "DEFAULT");
            }
            this(fVar, eVar);
        }

        @Override // ak.d
        @l
        public FileMessageCoroutineStub build(@l f fVar, @l e eVar) {
            l0.p(fVar, "channel");
            l0.p(eVar, "callOptions");
            return new FileMessageCoroutineStub(fVar, eVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @in.j
        public FileMessageCoroutineStub(@l f fVar, @l e eVar) {
            super(fVar, eVar);
            l0.p(fVar, "channel");
            l0.p(eVar, "callOptions");
        }
    }

    private FileMessageGrpcKt() {
    }

    @n
    @l
    public static final w1<CancelReceiveRequest, CancelReceiveReply> getCancelReceiveMethod() {
        w1<CancelReceiveRequest, CancelReceiveReply> cancelReceiveMethod = FileMessageGrpc.getCancelReceiveMethod();
        l0.o(cancelReceiveMethod, "getCancelReceiveMethod(...)");
        return cancelReceiveMethod;
    }

    @n
    @l
    public static final w1<CancelReceiveReply, CancelReceiveReply> getCancelReceiveReplyStreamMethod() {
        w1<CancelReceiveReply, CancelReceiveReply> cancelReceiveReplyStreamMethod = FileMessageGrpc.getCancelReceiveReplyStreamMethod();
        l0.o(cancelReceiveReplyStreamMethod, "getCancelReceiveReplyStreamMethod(...)");
        return cancelReceiveReplyStreamMethod;
    }

    @n
    @l
    public static final w1<CancelReceiveRequest, CancelReceiveRequest> getCancelReceiveStreamMethod() {
        w1<CancelReceiveRequest, CancelReceiveRequest> cancelReceiveStreamMethod = FileMessageGrpc.getCancelReceiveStreamMethod();
        l0.o(cancelReceiveStreamMethod, "getCancelReceiveStreamMethod(...)");
        return cancelReceiveStreamMethod;
    }

    @n
    @l
    public static final w1<CancelSendRequest, Reply> getCancelSendMethod() {
        w1<CancelSendRequest, Reply> cancelSendMethod = FileMessageGrpc.getCancelSendMethod();
        l0.o(cancelSendMethod, "getCancelSendMethod(...)");
        return cancelSendMethod;
    }

    @n
    @l
    public static final w1<CancelSendReply, CancelSendReply> getCancelSendReplyStreamMethod() {
        w1<CancelSendReply, CancelSendReply> cancelSendReplyStreamMethod = FileMessageGrpc.getCancelSendReplyStreamMethod();
        l0.o(cancelSendReplyStreamMethod, "getCancelSendReplyStreamMethod(...)");
        return cancelSendReplyStreamMethod;
    }

    @n
    @l
    public static final w1<CancelSendRequest, CancelSendRequest> getCancelSendStreamMethod() {
        w1<CancelSendRequest, CancelSendRequest> cancelSendStreamMethod = FileMessageGrpc.getCancelSendStreamMethod();
        l0.o(cancelSendStreamMethod, "getCancelSendStreamMethod(...)");
        return cancelSendStreamMethod;
    }

    @n
    @l
    public static final w1<HandshakeRequest, HandshakeRequest> getHandshakeStreamMethod() {
        w1<HandshakeRequest, HandshakeRequest> handshakeStreamMethod = FileMessageGrpc.getHandshakeStreamMethod();
        l0.o(handshakeStreamMethod, "getHandshakeStreamMethod(...)");
        return handshakeStreamMethod;
    }

    @n
    @l
    public static final w1<ReceiveFinish, ReceiveFinish> getReceiveFinishStreamMethod() {
        w1<ReceiveFinish, ReceiveFinish> receiveFinishStreamMethod = FileMessageGrpc.getReceiveFinishStreamMethod();
        l0.o(receiveFinishStreamMethod, "getReceiveFinishStreamMethod(...)");
        return receiveFinishStreamMethod;
    }

    @n
    @l
    public static final w1<SendFileInfoRequest, SendFileReply> getSendFileInfoMethod() {
        w1<SendFileInfoRequest, SendFileReply> sendFileInfoMethod = FileMessageGrpc.getSendFileInfoMethod();
        l0.o(sendFileInfoMethod, "getSendFileInfoMethod(...)");
        return sendFileInfoMethod;
    }

    @n
    @l
    public static final w1<SendFileReply, SendFileReply> getSendFileInfoReplyStreamMethod() {
        w1<SendFileReply, SendFileReply> sendFileInfoReplyStreamMethod = FileMessageGrpc.getSendFileInfoReplyStreamMethod();
        l0.o(sendFileInfoReplyStreamMethod, "getSendFileInfoReplyStreamMethod(...)");
        return sendFileInfoReplyStreamMethod;
    }

    @n
    @l
    public static final w1<SendFileInfoRequest, SendFileInfoRequest> getSendFileInfoStreamMethod() {
        w1<SendFileInfoRequest, SendFileInfoRequest> sendFileInfoStreamMethod = FileMessageGrpc.getSendFileInfoStreamMethod();
        l0.o(sendFileInfoStreamMethod, "getSendFileInfoStreamMethod(...)");
        return sendFileInfoStreamMethod;
    }

    @n
    @l
    public static final w1<Heartbeat, Heartbeat> getSendHeartbeatMethod() {
        w1<Heartbeat, Heartbeat> sendHeartbeatMethod = FileMessageGrpc.getSendHeartbeatMethod();
        l0.o(sendHeartbeatMethod, "getSendHeartbeatMethod(...)");
        return sendHeartbeatMethod;
    }

    @l
    public static final w2 getServiceDescriptor() {
        w2 serviceDescriptor = FileMessageGrpc.getServiceDescriptor();
        l0.o(serviceDescriptor, "getServiceDescriptor(...)");
        return serviceDescriptor;
    }

    @n
    public static /* synthetic */ void getServiceDescriptor$annotations() {
    }
}
