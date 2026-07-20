package d3;

import com.transsion.airtransfer.filetransfer.protos.CancelReceiveReply;
import com.transsion.airtransfer.filetransfer.protos.CancelReceiveRequest;
import com.transsion.airtransfer.filetransfer.protos.CancelSendReply;
import com.transsion.airtransfer.filetransfer.protos.CancelSendRequest;
import com.transsion.airtransfer.filetransfer.protos.HandshakeRequest;
import com.transsion.airtransfer.filetransfer.protos.ReceiveFinish;
import com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest;
import com.transsion.airtransfer.filetransfer.protos.SendFileReply;
import kn.l0;
import lm.i0;
import r2.d;
import r2.e;
import r2.l;
import r2.m;
import r2.n;
import r2.q;
import r2.t;
import r2.u;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements y2.a<m, l<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f3522a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f3523b = "MessageCodec";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y2.a
    @os.m
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m a(@os.l l<?> lVar) {
        l0.p(lVar, "data");
        T t10 = lVar.f14192g;
        j3.b.f8554a.e(f3523b, "receive data type : " + lVar.f14198a + " data:" + lVar.f14192g);
        if (t10 instanceof SendFileInfoRequest) {
            return b.p((SendFileInfoRequest) t10);
        }
        if (t10 instanceof SendFileReply) {
            return b.q((SendFileReply) t10);
        }
        if (t10 instanceof CancelReceiveRequest) {
            return b.j((CancelReceiveRequest) t10);
        }
        if (t10 instanceof CancelSendRequest) {
            return b.l((CancelSendRequest) t10);
        }
        if (t10 instanceof CancelReceiveReply) {
            return b.k((CancelReceiveReply) t10);
        }
        if (t10 instanceof CancelSendReply) {
            return b.m((CancelSendReply) t10);
        }
        if (t10 instanceof ReceiveFinish) {
            return b.o((ReceiveFinish) t10);
        }
        if (t10 instanceof HandshakeRequest) {
            return b.n((HandshakeRequest) t10);
        }
        return null;
    }

    @Override // y2.a
    @os.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public l<?> b(@os.l m mVar) {
        Object objF;
        l0.p(mVar, "data");
        j3.b.f8554a.e(f3523b, "send data type : " + mVar.c() + " data:" + mVar);
        if (mVar instanceof t) {
            objF = b.h((t) mVar);
        } else if (mVar instanceof d) {
            objF = b.e((d) mVar);
        } else if (mVar instanceof r2.b) {
            objF = b.b(mVar);
        } else if (mVar instanceof u) {
            objF = b.i((u) mVar);
        } else if (mVar instanceof e) {
            objF = b.d((e) mVar);
        } else if (mVar instanceof r2.c) {
            objF = b.c((r2.c) mVar);
        } else if (mVar instanceof q) {
            objF = b.g((q) mVar);
        } else {
            if (!(mVar instanceof n)) {
                throw new i0();
            }
            objF = b.f((n) mVar);
        }
        return new l<>(objF);
    }
}
