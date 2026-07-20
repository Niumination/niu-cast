package com.transsion.airtransfer.filetransfer.protos;

import ak.b;
import ak.c;
import ak.d;
import ak.g;
import ak.l;
import ak.m;
import bk.a;
import q1.s1;
import vj.e;
import vj.f;
import vj.t2;
import vj.w1;
import vj.w2;

/* JADX INFO: loaded from: classes2.dex */
@a
public final class FileMessageGrpc {
    private static final int METHODID_CANCEL_RECEIVE = 2;
    private static final int METHODID_CANCEL_RECEIVE_REPLY_STREAM = 8;
    private static final int METHODID_CANCEL_RECEIVE_STREAM = 6;
    private static final int METHODID_CANCEL_SEND = 1;
    private static final int METHODID_CANCEL_SEND_REPLY_STREAM = 9;
    private static final int METHODID_CANCEL_SEND_STREAM = 5;
    private static final int METHODID_HANDSHAKE_STREAM = 11;
    private static final int METHODID_RECEIVE_FINISH_STREAM = 10;
    private static final int METHODID_SEND_FILE_INFO = 0;
    private static final int METHODID_SEND_FILE_INFO_REPLY_STREAM = 7;
    private static final int METHODID_SEND_FILE_INFO_STREAM = 4;
    private static final int METHODID_SEND_HEARTBEAT = 3;
    public static final String SERVICE_NAME = "filetransfer.FileMessage";
    private static volatile w1<CancelReceiveRequest, CancelReceiveReply> getCancelReceiveMethod;
    private static volatile w1<CancelReceiveReply, CancelReceiveReply> getCancelReceiveReplyStreamMethod;
    private static volatile w1<CancelReceiveRequest, CancelReceiveRequest> getCancelReceiveStreamMethod;
    private static volatile w1<CancelSendRequest, Reply> getCancelSendMethod;
    private static volatile w1<CancelSendReply, CancelSendReply> getCancelSendReplyStreamMethod;
    private static volatile w1<CancelSendRequest, CancelSendRequest> getCancelSendStreamMethod;
    private static volatile w1<HandshakeRequest, HandshakeRequest> getHandshakeStreamMethod;
    private static volatile w1<ReceiveFinish, ReceiveFinish> getReceiveFinishStreamMethod;
    private static volatile w1<SendFileInfoRequest, SendFileReply> getSendFileInfoMethod;
    private static volatile w1<SendFileReply, SendFileReply> getSendFileInfoReplyStreamMethod;
    private static volatile w1<SendFileInfoRequest, SendFileInfoRequest> getSendFileInfoStreamMethod;
    private static volatile w1<Heartbeat, Heartbeat> getSendHeartbeatMethod;
    private static volatile w2 serviceDescriptor;

    public interface AsyncService {
        default void cancelReceive(CancelReceiveRequest cancelReceiveRequest, m<CancelReceiveReply> mVar) {
            l.f(FileMessageGrpc.getCancelReceiveMethod(), mVar);
        }

        default m<CancelReceiveReply> cancelReceiveReplyStream(m<CancelReceiveReply> mVar) {
            return l.e(FileMessageGrpc.getCancelReceiveReplyStreamMethod(), mVar);
        }

        default m<CancelReceiveRequest> cancelReceiveStream(m<CancelReceiveRequest> mVar) {
            return l.e(FileMessageGrpc.getCancelReceiveStreamMethod(), mVar);
        }

        default void cancelSend(CancelSendRequest cancelSendRequest, m<Reply> mVar) {
            l.f(FileMessageGrpc.getCancelSendMethod(), mVar);
        }

        default m<CancelSendReply> cancelSendReplyStream(m<CancelSendReply> mVar) {
            return l.e(FileMessageGrpc.getCancelSendReplyStreamMethod(), mVar);
        }

        default m<CancelSendRequest> cancelSendStream(m<CancelSendRequest> mVar) {
            return l.e(FileMessageGrpc.getCancelSendStreamMethod(), mVar);
        }

        default m<HandshakeRequest> handshakeStream(m<HandshakeRequest> mVar) {
            return l.e(FileMessageGrpc.getHandshakeStreamMethod(), mVar);
        }

        default m<ReceiveFinish> receiveFinishStream(m<ReceiveFinish> mVar) {
            return l.e(FileMessageGrpc.getReceiveFinishStreamMethod(), mVar);
        }

        default void sendFileInfo(SendFileInfoRequest sendFileInfoRequest, m<SendFileReply> mVar) {
            l.f(FileMessageGrpc.getSendFileInfoMethod(), mVar);
        }

        default m<SendFileReply> sendFileInfoReplyStream(m<SendFileReply> mVar) {
            return l.e(FileMessageGrpc.getSendFileInfoReplyStreamMethod(), mVar);
        }

        default m<SendFileInfoRequest> sendFileInfoStream(m<SendFileInfoRequest> mVar) {
            return l.e(FileMessageGrpc.getSendFileInfoStreamMethod(), mVar);
        }

        default void sendHeartbeat(Heartbeat heartbeat, m<Heartbeat> mVar) {
            l.f(FileMessageGrpc.getSendHeartbeatMethod(), mVar);
        }
    }

    public static final class FileMessageBlockingStub extends b<FileMessageBlockingStub> {
        private FileMessageBlockingStub(f fVar, e eVar) {
            super(fVar, eVar);
        }

        public CancelReceiveReply cancelReceive(CancelReceiveRequest cancelReceiveRequest) {
            return (CancelReceiveReply) g.j(getChannel(), FileMessageGrpc.getCancelReceiveMethod(), getCallOptions(), cancelReceiveRequest);
        }

        public Reply cancelSend(CancelSendRequest cancelSendRequest) {
            return (Reply) g.j(getChannel(), FileMessageGrpc.getCancelSendMethod(), getCallOptions(), cancelSendRequest);
        }

        public SendFileReply sendFileInfo(SendFileInfoRequest sendFileInfoRequest) {
            return (SendFileReply) g.j(getChannel(), FileMessageGrpc.getSendFileInfoMethod(), getCallOptions(), sendFileInfoRequest);
        }

        public Heartbeat sendHeartbeat(Heartbeat heartbeat) {
            return (Heartbeat) g.j(getChannel(), FileMessageGrpc.getSendHeartbeatMethod(), getCallOptions(), heartbeat);
        }

        @Override // ak.d
        public FileMessageBlockingStub build(f fVar, e eVar) {
            return new FileMessageBlockingStub(fVar, eVar);
        }
    }

    public static final class FileMessageFutureStub extends c<FileMessageFutureStub> {
        private FileMessageFutureStub(f fVar, e eVar) {
            super(fVar, eVar);
        }

        public s1<CancelReceiveReply> cancelReceive(CancelReceiveRequest cancelReceiveRequest) {
            return g.m(getChannel().g(FileMessageGrpc.getCancelReceiveMethod(), getCallOptions()), cancelReceiveRequest);
        }

        public s1<Reply> cancelSend(CancelSendRequest cancelSendRequest) {
            return g.m(getChannel().g(FileMessageGrpc.getCancelSendMethod(), getCallOptions()), cancelSendRequest);
        }

        public s1<SendFileReply> sendFileInfo(SendFileInfoRequest sendFileInfoRequest) {
            return g.m(getChannel().g(FileMessageGrpc.getSendFileInfoMethod(), getCallOptions()), sendFileInfoRequest);
        }

        public s1<Heartbeat> sendHeartbeat(Heartbeat heartbeat) {
            return g.m(getChannel().g(FileMessageGrpc.getSendHeartbeatMethod(), getCallOptions()), heartbeat);
        }

        @Override // ak.d
        public FileMessageFutureStub build(f fVar, e eVar) {
            return new FileMessageFutureStub(fVar, eVar);
        }
    }

    public static abstract class FileMessageImplBase implements vj.c, AsyncService {
        @Override // vj.c
        public final t2 bindService() {
            return FileMessageGrpc.bindService(this);
        }
    }

    public static final class FileMessageStub extends ak.a<FileMessageStub> {
        private FileMessageStub(f fVar, e eVar) {
            super(fVar, eVar);
        }

        public void cancelReceive(CancelReceiveRequest cancelReceiveRequest, m<CancelReceiveReply> mVar) {
            g.e(getChannel().g(FileMessageGrpc.getCancelReceiveMethod(), getCallOptions()), cancelReceiveRequest, mVar);
        }

        public m<CancelReceiveReply> cancelReceiveReplyStream(m<CancelReceiveReply> mVar) {
            return g.a(getChannel().g(FileMessageGrpc.getCancelReceiveReplyStreamMethod(), getCallOptions()), mVar);
        }

        public m<CancelReceiveRequest> cancelReceiveStream(m<CancelReceiveRequest> mVar) {
            return g.a(getChannel().g(FileMessageGrpc.getCancelReceiveStreamMethod(), getCallOptions()), mVar);
        }

        public void cancelSend(CancelSendRequest cancelSendRequest, m<Reply> mVar) {
            g.e(getChannel().g(FileMessageGrpc.getCancelSendMethod(), getCallOptions()), cancelSendRequest, mVar);
        }

        public m<CancelSendReply> cancelSendReplyStream(m<CancelSendReply> mVar) {
            return g.a(getChannel().g(FileMessageGrpc.getCancelSendReplyStreamMethod(), getCallOptions()), mVar);
        }

        public m<CancelSendRequest> cancelSendStream(m<CancelSendRequest> mVar) {
            return g.a(getChannel().g(FileMessageGrpc.getCancelSendStreamMethod(), getCallOptions()), mVar);
        }

        public m<HandshakeRequest> handshakeStream(m<HandshakeRequest> mVar) {
            return g.a(getChannel().g(FileMessageGrpc.getHandshakeStreamMethod(), getCallOptions()), mVar);
        }

        public m<ReceiveFinish> receiveFinishStream(m<ReceiveFinish> mVar) {
            return g.a(getChannel().g(FileMessageGrpc.getReceiveFinishStreamMethod(), getCallOptions()), mVar);
        }

        public void sendFileInfo(SendFileInfoRequest sendFileInfoRequest, m<SendFileReply> mVar) {
            g.e(getChannel().g(FileMessageGrpc.getSendFileInfoMethod(), getCallOptions()), sendFileInfoRequest, mVar);
        }

        public m<SendFileReply> sendFileInfoReplyStream(m<SendFileReply> mVar) {
            return g.a(getChannel().g(FileMessageGrpc.getSendFileInfoReplyStreamMethod(), getCallOptions()), mVar);
        }

        public m<SendFileInfoRequest> sendFileInfoStream(m<SendFileInfoRequest> mVar) {
            return g.a(getChannel().g(FileMessageGrpc.getSendFileInfoStreamMethod(), getCallOptions()), mVar);
        }

        public void sendHeartbeat(Heartbeat heartbeat, m<Heartbeat> mVar) {
            g.e(getChannel().g(FileMessageGrpc.getSendHeartbeatMethod(), getCallOptions()), heartbeat, mVar);
        }

        @Override // ak.d
        public FileMessageStub build(f fVar, e eVar) {
            return new FileMessageStub(fVar, eVar);
        }
    }

    private FileMessageGrpc() {
    }

    public static final t2 bindService(AsyncService asyncService) {
        return new t2.b(getServiceDescriptor()).a(getSendFileInfoMethod(), l.d(new MethodHandlers(asyncService, 0))).a(getCancelSendMethod(), l.d(new MethodHandlers(asyncService, 1))).a(getCancelReceiveMethod(), l.d(new MethodHandlers(asyncService, 2))).a(getSendHeartbeatMethod(), l.d(new MethodHandlers(asyncService, 3))).a(getSendFileInfoStreamMethod(), l.a(new MethodHandlers(asyncService, 4))).a(getCancelSendStreamMethod(), l.a(new MethodHandlers(asyncService, 5))).a(getCancelReceiveStreamMethod(), l.a(new MethodHandlers(asyncService, 6))).a(getSendFileInfoReplyStreamMethod(), l.a(new MethodHandlers(asyncService, 7))).a(getCancelReceiveReplyStreamMethod(), l.a(new MethodHandlers(asyncService, 8))).a(getCancelSendReplyStreamMethod(), l.a(new MethodHandlers(asyncService, 9))).a(getReceiveFinishStreamMethod(), l.a(new MethodHandlers(asyncService, 10))).a(getHandshakeStreamMethod(), l.a(new MethodHandlers(asyncService, 11))).c();
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/CancelReceive", methodType = w1.d.UNARY, requestType = CancelReceiveRequest.class, responseType = CancelReceiveReply.class)
    public static w1<CancelReceiveRequest, CancelReceiveReply> getCancelReceiveMethod() {
        w1<CancelReceiveRequest, CancelReceiveReply> w1VarA = getCancelReceiveMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getCancelReceiveMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.UNARY;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "CancelReceive");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(CancelReceiveRequest.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(CancelReceiveReply.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getCancelReceiveMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/CancelReceiveReplyStream", methodType = w1.d.BIDI_STREAMING, requestType = CancelReceiveReply.class, responseType = CancelReceiveReply.class)
    public static w1<CancelReceiveReply, CancelReceiveReply> getCancelReceiveReplyStreamMethod() {
        w1<CancelReceiveReply, CancelReceiveReply> w1VarA = getCancelReceiveReplyStreamMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getCancelReceiveReplyStreamMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.BIDI_STREAMING;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "CancelReceiveReplyStream");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(CancelReceiveReply.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(CancelReceiveReply.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getCancelReceiveReplyStreamMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/CancelReceiveStream", methodType = w1.d.BIDI_STREAMING, requestType = CancelReceiveRequest.class, responseType = CancelReceiveRequest.class)
    public static w1<CancelReceiveRequest, CancelReceiveRequest> getCancelReceiveStreamMethod() {
        w1<CancelReceiveRequest, CancelReceiveRequest> w1VarA = getCancelReceiveStreamMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getCancelReceiveStreamMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.BIDI_STREAMING;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "CancelReceiveStream");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(CancelReceiveRequest.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(CancelReceiveRequest.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getCancelReceiveStreamMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/CancelSend", methodType = w1.d.UNARY, requestType = CancelSendRequest.class, responseType = Reply.class)
    public static w1<CancelSendRequest, Reply> getCancelSendMethod() {
        w1<CancelSendRequest, Reply> w1VarA = getCancelSendMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getCancelSendMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.UNARY;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "CancelSend");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(CancelSendRequest.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(Reply.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getCancelSendMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/CancelSendReplyStream", methodType = w1.d.BIDI_STREAMING, requestType = CancelSendReply.class, responseType = CancelSendReply.class)
    public static w1<CancelSendReply, CancelSendReply> getCancelSendReplyStreamMethod() {
        w1<CancelSendReply, CancelSendReply> w1VarA = getCancelSendReplyStreamMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getCancelSendReplyStreamMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.BIDI_STREAMING;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "CancelSendReplyStream");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(CancelSendReply.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(CancelSendReply.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getCancelSendReplyStreamMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/CancelSendStream", methodType = w1.d.BIDI_STREAMING, requestType = CancelSendRequest.class, responseType = CancelSendRequest.class)
    public static w1<CancelSendRequest, CancelSendRequest> getCancelSendStreamMethod() {
        w1<CancelSendRequest, CancelSendRequest> w1VarA = getCancelSendStreamMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getCancelSendStreamMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.BIDI_STREAMING;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "CancelSendStream");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(CancelSendRequest.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(CancelSendRequest.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getCancelSendStreamMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/HandshakeStream", methodType = w1.d.BIDI_STREAMING, requestType = HandshakeRequest.class, responseType = HandshakeRequest.class)
    public static w1<HandshakeRequest, HandshakeRequest> getHandshakeStreamMethod() {
        w1<HandshakeRequest, HandshakeRequest> w1VarA = getHandshakeStreamMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getHandshakeStreamMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.BIDI_STREAMING;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "HandshakeStream");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(HandshakeRequest.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(HandshakeRequest.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getHandshakeStreamMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/ReceiveFinishStream", methodType = w1.d.BIDI_STREAMING, requestType = ReceiveFinish.class, responseType = ReceiveFinish.class)
    public static w1<ReceiveFinish, ReceiveFinish> getReceiveFinishStreamMethod() {
        w1<ReceiveFinish, ReceiveFinish> w1VarA = getReceiveFinishStreamMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getReceiveFinishStreamMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.BIDI_STREAMING;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "ReceiveFinishStream");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(ReceiveFinish.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(ReceiveFinish.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getReceiveFinishStreamMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/SendFileInfo", methodType = w1.d.UNARY, requestType = SendFileInfoRequest.class, responseType = SendFileReply.class)
    public static w1<SendFileInfoRequest, SendFileReply> getSendFileInfoMethod() {
        w1<SendFileInfoRequest, SendFileReply> w1VarA = getSendFileInfoMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getSendFileInfoMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.UNARY;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "SendFileInfo");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(SendFileInfoRequest.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(SendFileReply.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getSendFileInfoMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/SendFileInfoReplyStream", methodType = w1.d.BIDI_STREAMING, requestType = SendFileReply.class, responseType = SendFileReply.class)
    public static w1<SendFileReply, SendFileReply> getSendFileInfoReplyStreamMethod() {
        w1<SendFileReply, SendFileReply> w1VarA = getSendFileInfoReplyStreamMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getSendFileInfoReplyStreamMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.BIDI_STREAMING;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "SendFileInfoReplyStream");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(SendFileReply.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(SendFileReply.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getSendFileInfoReplyStreamMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/SendFileInfoStream", methodType = w1.d.BIDI_STREAMING, requestType = SendFileInfoRequest.class, responseType = SendFileInfoRequest.class)
    public static w1<SendFileInfoRequest, SendFileInfoRequest> getSendFileInfoStreamMethod() {
        w1<SendFileInfoRequest, SendFileInfoRequest> w1VarA = getSendFileInfoStreamMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getSendFileInfoStreamMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.BIDI_STREAMING;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "SendFileInfoStream");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(SendFileInfoRequest.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(SendFileInfoRequest.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getSendFileInfoStreamMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    @bk.b(fullMethodName = "filetransfer.FileMessage/sendHeartbeat", methodType = w1.d.UNARY, requestType = Heartbeat.class, responseType = Heartbeat.class)
    public static w1<Heartbeat, Heartbeat> getSendHeartbeatMethod() {
        w1<Heartbeat, Heartbeat> w1VarA = getSendHeartbeatMethod;
        if (w1VarA == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w1VarA = getSendHeartbeatMethod;
                    if (w1VarA == null) {
                        w1.b bVarP = w1.p();
                        bVarP.f17492c = w1.d.UNARY;
                        bVarP.f17493d = w1.d("filetransfer.FileMessage", "sendHeartbeat");
                        bVarP.f17497h = true;
                        bVarP.f17490a = zj.b.b(Heartbeat.getDefaultInstance());
                        bVarP.f17491b = zj.b.b(Heartbeat.getDefaultInstance());
                        w1VarA = bVarP.a();
                        getSendHeartbeatMethod = w1VarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w1VarA;
    }

    public static w2 getServiceDescriptor() {
        w2 w2Var = serviceDescriptor;
        if (w2Var == null) {
            synchronized (FileMessageGrpc.class) {
                try {
                    w2Var = serviceDescriptor;
                    if (w2Var == null) {
                        w2.b bVarF = new w2.b("filetransfer.FileMessage").f(getSendFileInfoMethod()).f(getCancelSendMethod()).f(getCancelReceiveMethod()).f(getSendHeartbeatMethod()).f(getSendFileInfoStreamMethod()).f(getCancelSendStreamMethod()).f(getCancelReceiveStreamMethod()).f(getSendFileInfoReplyStreamMethod()).f(getCancelReceiveReplyStreamMethod()).f(getCancelSendReplyStreamMethod()).f(getReceiveFinishStreamMethod()).f(getHandshakeStreamMethod());
                        bVarF.getClass();
                        w2 w2Var2 = new w2(bVarF);
                        serviceDescriptor = w2Var2;
                        w2Var = w2Var2;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return w2Var;
    }

    public static FileMessageBlockingStub newBlockingStub(f fVar) {
        return (FileMessageBlockingStub) b.newStub(new d.a<FileMessageBlockingStub>() { // from class: com.transsion.airtransfer.filetransfer.protos.FileMessageGrpc.2
            @Override // ak.d.a
            public FileMessageBlockingStub newStub(f fVar2, e eVar) {
                return new FileMessageBlockingStub(fVar2, eVar);
            }
        }, fVar);
    }

    public static FileMessageFutureStub newFutureStub(f fVar) {
        return (FileMessageFutureStub) c.newStub(new d.a<FileMessageFutureStub>() { // from class: com.transsion.airtransfer.filetransfer.protos.FileMessageGrpc.3
            @Override // ak.d.a
            public FileMessageFutureStub newStub(f fVar2, e eVar) {
                return new FileMessageFutureStub(fVar2, eVar);
            }
        }, fVar);
    }

    public static FileMessageStub newStub(f fVar) {
        return (FileMessageStub) ak.a.newStub(new d.a<FileMessageStub>() { // from class: com.transsion.airtransfer.filetransfer.protos.FileMessageGrpc.1
            @Override // ak.d.a
            public FileMessageStub newStub(f fVar2, e eVar) {
                return new FileMessageStub(fVar2, eVar);
            }
        }, fVar);
    }

    public static final class MethodHandlers<Req, Resp> implements l.h<Req, Resp>, l.e<Req, Resp>, l.b<Req, Resp>, l.a<Req, Resp> {
        private final int methodId;
        private final AsyncService serviceImpl;

        public MethodHandlers(AsyncService asyncService, int i10) {
            this.serviceImpl = asyncService;
            this.methodId = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ak.l.h, ak.l.i
        public void invoke(Req req, m<Resp> mVar) {
            int i10 = this.methodId;
            if (i10 == 0) {
                this.serviceImpl.sendFileInfo((SendFileInfoRequest) req, mVar);
                return;
            }
            if (i10 == 1) {
                this.serviceImpl.cancelSend((CancelSendRequest) req, mVar);
            } else if (i10 == 2) {
                this.serviceImpl.cancelReceive((CancelReceiveRequest) req, mVar);
            } else {
                if (i10 != 3) {
                    throw new AssertionError();
                }
                this.serviceImpl.sendHeartbeat((Heartbeat) req, mVar);
            }
        }

        @Override // ak.l.b, ak.l.f
        public m<Req> invoke(m<Resp> mVar) {
            switch (this.methodId) {
                case 4:
                    return (m<Req>) this.serviceImpl.sendFileInfoStream(mVar);
                case 5:
                    return (m<Req>) this.serviceImpl.cancelSendStream(mVar);
                case 6:
                    return (m<Req>) this.serviceImpl.cancelReceiveStream(mVar);
                case 7:
                    return (m<Req>) this.serviceImpl.sendFileInfoReplyStream(mVar);
                case 8:
                    return (m<Req>) this.serviceImpl.cancelReceiveReplyStream(mVar);
                case 9:
                    return (m<Req>) this.serviceImpl.cancelSendReplyStream(mVar);
                case 10:
                    return (m<Req>) this.serviceImpl.receiveFinishStream(mVar);
                case 11:
                    return (m<Req>) this.serviceImpl.handshakeStream(mVar);
                default:
                    throw new AssertionError();
            }
        }
    }
}
