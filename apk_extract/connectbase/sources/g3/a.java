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
import kn.l0;
import kn.r1;
import os.l;
import os.m;
import sq.i;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFileMessageService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileMessageService.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/FileMessageService\n+ 2 GrpcMessageChannelManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannelManager\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 HeartbeatKt.kt\ncom/transsion/airtransfer/filetransfer/protos/HeartbeatKtKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n27#2:62\n26#2,3:65\n27#2:68\n26#2,3:71\n27#2:74\n26#2,3:77\n27#2:80\n26#2,3:83\n27#2:86\n26#2,3:89\n27#2:92\n26#2,3:95\n27#2:98\n26#2,3:101\n27#2:104\n26#2,3:107\n223#3,2:63\n223#3,2:69\n223#3,2:75\n223#3,2:81\n223#3,2:87\n223#3,2:93\n223#3,2:99\n223#3,2:105\n10#4:110\n1#5:111\n*S KotlinDebug\n*F\n+ 1 FileMessageService.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/FileMessageService\n*L\n26#1:62\n26#1:65,3\n30#1:68\n30#1:71,3\n34#1:74\n34#1:77,3\n38#1:80\n38#1:83,3\n42#1:86\n42#1:89,3\n46#1:92\n46#1:95,3\n50#1:98\n50#1:101,3\n54#1:104\n54#1:107,3\n26#1:63,2\n30#1:69,2\n34#1:75,2\n38#1:81,2\n42#1:87,2\n46#1:93,2\n50#1:99,2\n54#1:105,2\n58#1:110\n58#1:111\n*E\n"})
public final class a extends FileMessageGrpcKt.FileMessageCoroutineImplBase {
    public a() {
        super(null, 1, null);
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt.FileMessageCoroutineImplBase
    @l
    public i<CancelReceiveReply> cancelReceiveReplyStream(@l i<CancelReceiveReply> iVar) {
        l0.p(iVar, "requests");
        h3.b bVar = h3.b.f6969a;
        for (Object obj : h3.b.f6971c) {
            h3.a aVar = (h3.a) obj;
            if (l0.g(aVar.f(), CancelReceiveReply.class)) {
                l0.n(obj, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar.e(iVar);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt.FileMessageCoroutineImplBase
    @l
    public i<CancelReceiveRequest> cancelReceiveStream(@l i<CancelReceiveRequest> iVar) {
        l0.p(iVar, "requests");
        h3.b bVar = h3.b.f6969a;
        for (Object obj : h3.b.f6971c) {
            h3.a aVar = (h3.a) obj;
            if (l0.g(aVar.f(), CancelReceiveRequest.class)) {
                l0.n(obj, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar.e(iVar);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt.FileMessageCoroutineImplBase
    @l
    public i<CancelSendReply> cancelSendReplyStream(@l i<CancelSendReply> iVar) {
        l0.p(iVar, "requests");
        h3.b bVar = h3.b.f6969a;
        for (Object obj : h3.b.f6971c) {
            h3.a aVar = (h3.a) obj;
            if (l0.g(aVar.f(), CancelSendReply.class)) {
                l0.n(obj, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar.e(iVar);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt.FileMessageCoroutineImplBase
    @l
    public i<CancelSendRequest> cancelSendStream(@l i<CancelSendRequest> iVar) {
        l0.p(iVar, "requests");
        h3.b bVar = h3.b.f6969a;
        for (Object obj : h3.b.f6971c) {
            h3.a aVar = (h3.a) obj;
            if (l0.g(aVar.f(), CancelSendRequest.class)) {
                l0.n(obj, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar.e(iVar);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt.FileMessageCoroutineImplBase
    @l
    public i<HandshakeRequest> handshakeStream(@l i<HandshakeRequest> iVar) {
        l0.p(iVar, "requests");
        h3.b bVar = h3.b.f6969a;
        for (Object obj : h3.b.f6971c) {
            h3.a aVar = (h3.a) obj;
            if (l0.g(aVar.f(), HandshakeRequest.class)) {
                l0.n(obj, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar.e(iVar);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt.FileMessageCoroutineImplBase
    @l
    public i<ReceiveFinish> receiveFinishStream(@l i<ReceiveFinish> iVar) {
        l0.p(iVar, "requests");
        h3.b bVar = h3.b.f6969a;
        for (Object obj : h3.b.f6971c) {
            h3.a aVar = (h3.a) obj;
            if (l0.g(aVar.f(), ReceiveFinish.class)) {
                l0.n(obj, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar.e(iVar);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt.FileMessageCoroutineImplBase
    @l
    public i<SendFileReply> sendFileInfoReplyStream(@l i<SendFileReply> iVar) {
        l0.p(iVar, "requests");
        h3.b bVar = h3.b.f6969a;
        for (Object obj : h3.b.f6971c) {
            h3.a aVar = (h3.a) obj;
            if (l0.g(aVar.f(), SendFileReply.class)) {
                l0.n(obj, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar.e(iVar);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt.FileMessageCoroutineImplBase
    @l
    public i<SendFileInfoRequest> sendFileInfoStream(@l i<SendFileInfoRequest> iVar) {
        l0.p(iVar, "requests");
        h3.b bVar = h3.b.f6969a;
        for (Object obj : h3.b.f6971c) {
            h3.a aVar = (h3.a) obj;
            if (l0.g(aVar.f(), SendFileInfoRequest.class)) {
                l0.n(obj, "null cannot be cast to non-null type com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannel<T of com.transsion.airtransfer.filetransfer.transmission.grpc.channel.GrpcMessageChannelManager.getChannel>");
                return aVar.e(iVar);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt.FileMessageCoroutineImplBase
    @m
    public Object sendHeartbeat(@l Heartbeat heartbeat, @l um.d<? super Heartbeat> dVar) {
        HeartbeatKt.Dsl.Companion companion = HeartbeatKt.Dsl.Companion;
        Heartbeat.Builder builderNewBuilder = Heartbeat.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        HeartbeatKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setMsg(1);
        return dsl_create._build();
    }
}
