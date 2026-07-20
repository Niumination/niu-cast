package d3;

import com.transsion.airtransfer.filetransfer.protos.CancelReceiveReply;
import com.transsion.airtransfer.filetransfer.protos.CancelReceiveReplyKt;
import com.transsion.airtransfer.filetransfer.protos.CancelReceiveRequest;
import com.transsion.airtransfer.filetransfer.protos.CancelReceiveRequestKt;
import com.transsion.airtransfer.filetransfer.protos.CancelSendReply;
import com.transsion.airtransfer.filetransfer.protos.CancelSendReplyKt;
import com.transsion.airtransfer.filetransfer.protos.CancelSendRequest;
import com.transsion.airtransfer.filetransfer.protos.CancelSendRequestKt;
import com.transsion.airtransfer.filetransfer.protos.HandshakeRequest;
import com.transsion.airtransfer.filetransfer.protos.HandshakeRequestKt;
import com.transsion.airtransfer.filetransfer.protos.ReceiveFinish;
import com.transsion.airtransfer.filetransfer.protos.ReceiveFinishKt;
import com.transsion.airtransfer.filetransfer.protos.ReplyState;
import com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest;
import com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequestKt;
import com.transsion.airtransfer.filetransfer.protos.SendFileReply;
import com.transsion.airtransfer.filetransfer.protos.SendFileReplyKt;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.r1;
import nm.k0;
import nm.z;
import os.l;
import r2.d;
import r2.e;
import r2.j;
import r2.k;
import r2.n;
import r2.o;
import r2.q;
import r2.t;
import r2.u;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nMessageDataConvert.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageDataConvert.kt\ncom/transsion/airtransfer/filetransfer/process/message/MessageDataConvertKt\n+ 2 CancelReceiveReplyKt.kt\ncom/transsion/airtransfer/filetransfer/protos/CancelReceiveReplyKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CancelSendReplyKt.kt\ncom/transsion/airtransfer/filetransfer/protos/CancelSendReplyKtKt\n+ 5 SendFileReplyKt.kt\ncom/transsion/airtransfer/filetransfer/protos/SendFileReplyKtKt\n+ 6 CancelReceiveRequestKt.kt\ncom/transsion/airtransfer/filetransfer/protos/CancelReceiveRequestKtKt\n+ 7 CancelSendRequestKt.kt\ncom/transsion/airtransfer/filetransfer/protos/CancelSendRequestKtKt\n+ 8 SendFileInfoRequestKt.kt\ncom/transsion/airtransfer/filetransfer/protos/SendFileInfoRequestKtKt\n+ 9 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 10 ReceiveFinishKt.kt\ncom/transsion/airtransfer/filetransfer/protos/ReceiveFinishKtKt\n+ 11 HandshakeRequestKt.kt\ncom/transsion/airtransfer/filetransfer/protos/HandshakeRequestKtKt\n*L\n1#1,140:1\n10#2:141\n1#3:142\n1#3:144\n1#3:146\n1#3:148\n1#3:150\n1#3:152\n1#3:158\n1#3:164\n10#4:143\n10#5:145\n10#6:147\n10#7:149\n10#8:151\n1549#9:153\n1620#9,3:154\n1549#9:159\n1620#9,3:160\n10#10:157\n10#11:163\n*S KotlinDebug\n*F\n+ 1 MessageDataConvert.kt\ncom/transsion/airtransfer/filetransfer/process/message/MessageDataConvertKt\n*L\n41#1:141\n41#1:142\n48#1:144\n54#1:146\n60#1:148\n64#1:150\n70#1:152\n105#1:158\n136#1:164\n48#1:143\n54#1:145\n60#1:147\n64#1:149\n70#1:151\n72#1:153\n72#1:154,3\n130#1:159\n130#1:160,3\n105#1:157\n136#1:163\n*E\n"})
public final class b {
    @l
    public static final j a(@l SendFileInfoRequest.FileInfo fileInfo) {
        l0.p(fileInfo, "<this>");
        long id2 = fileInfo.getId();
        String name = fileInfo.getName();
        l0.o(name, "getName(...)");
        long size = fileInfo.getSize();
        String md5 = fileInfo.getMd5();
        l0.o(md5, "getMd5(...)");
        return new j(id2, name, size, md5);
    }

    @l
    public static final CancelReceiveRequest b(@l o oVar) {
        l0.p(oVar, "<this>");
        CancelReceiveRequestKt.Dsl.Companion companion = CancelReceiveRequestKt.Dsl.Companion;
        CancelReceiveRequest.Builder builderNewBuilder = CancelReceiveRequest.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        CancelReceiveRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setTaskId(oVar.b());
        return dsl_create._build();
    }

    @l
    public static final CancelReceiveReply c(@l r2.c cVar) {
        l0.p(cVar, "<this>");
        CancelReceiveReplyKt.Dsl.Companion companion = CancelReceiveReplyKt.Dsl.Companion;
        CancelReceiveReply.Builder builderNewBuilder = CancelReceiveReply.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        CancelReceiveReplyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setTaskId(cVar.f14150h);
        dsl_create.setFileId(cVar.f14151i);
        dsl_create.setSentLength(cVar.f14152j);
        return dsl_create._build();
    }

    @l
    public static final CancelSendReply d(@l e eVar) {
        l0.p(eVar, "<this>");
        CancelSendReplyKt.Dsl.Companion companion = CancelSendReplyKt.Dsl.Companion;
        CancelSendReply.Builder builderNewBuilder = CancelSendReply.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        CancelSendReplyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setTaskId(eVar.f14156h);
        dsl_create.setState(eVar.f14157i ? ReplyState.REPLY_STATE_SUCCESS : ReplyState.REPLY_STATE_ERROR);
        return dsl_create._build();
    }

    @l
    public static final CancelSendRequest e(@l d dVar) {
        l0.p(dVar, "<this>");
        CancelSendRequestKt.Dsl.Companion companion = CancelSendRequestKt.Dsl.Companion;
        CancelSendRequest.Builder builderNewBuilder = CancelSendRequest.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        CancelSendRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setTaskId(dVar.f14153h);
        dsl_create.setFileId(dVar.f14154i);
        dsl_create.setSentLength(dVar.f14155j);
        return dsl_create._build();
    }

    @l
    public static final HandshakeRequest f(@l n nVar) {
        l0.p(nVar, "<this>");
        HandshakeRequestKt.Dsl.Companion companion = HandshakeRequestKt.Dsl.Companion;
        HandshakeRequest.Builder builderNewBuilder = HandshakeRequest.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        HandshakeRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setData(nVar.f14194h);
        return dsl_create._build();
    }

    @l
    public static final ReceiveFinish g(@l q qVar) {
        l0.p(qVar, "<this>");
        ReceiveFinishKt.Dsl.Companion companion = ReceiveFinishKt.Dsl.Companion;
        ReceiveFinish.Builder builderNewBuilder = ReceiveFinish.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        ReceiveFinishKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setTaskId(qVar.f14201h);
        return dsl_create._build();
    }

    @l
    public static final SendFileInfoRequest h(@l t tVar) {
        l0.p(tVar, "<this>");
        SendFileInfoRequestKt.Dsl.Companion companion = SendFileInfoRequestKt.Dsl.Companion;
        SendFileInfoRequest.Builder builderNewBuilder = SendFileInfoRequest.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        SendFileInfoRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setTaskId(tVar.f14204h);
        List<j> list = tVar.f14205i;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        for (j jVar : list) {
            arrayList.add(SendFileInfoRequest.FileInfo.newBuilder().setId(jVar.f14176a).setName(jVar.f14177b).setMd5(jVar.f14179d).setSize(jVar.f14178c).build());
        }
        dsl_create.addAllFiles(dsl_create.getFiles(), arrayList);
        String str = tVar.f14206j;
        if (str == null) {
            str = "";
        }
        dsl_create.setExtend(str);
        return dsl_create._build();
    }

    @l
    public static final SendFileReply i(@l u uVar) {
        l0.p(uVar, "<this>");
        SendFileReplyKt.Dsl.Companion companion = SendFileReplyKt.Dsl.Companion;
        SendFileReply.Builder builderNewBuilder = SendFileReply.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        SendFileReplyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setTaskId(uVar.f14207h);
        dsl_create.setIsAccept(uVar.f14208i);
        String str = uVar.f14209j;
        if (str == null) {
            str = "";
        }
        dsl_create.setExtend(str);
        return dsl_create._build();
    }

    @l
    public static final r2.b j(@l CancelReceiveRequest cancelReceiveRequest) {
        l0.p(cancelReceiveRequest, "<this>");
        return new r2.b(cancelReceiveRequest.getTaskId());
    }

    @l
    public static final r2.c k(@l CancelReceiveReply cancelReceiveReply) {
        l0.p(cancelReceiveReply, "<this>");
        return new r2.c(cancelReceiveReply.getTaskId(), cancelReceiveReply.getFileId(), cancelReceiveReply.getSentLength());
    }

    @l
    public static final d l(@l CancelSendRequest cancelSendRequest) {
        l0.p(cancelSendRequest, "<this>");
        return new d(cancelSendRequest.getTaskId(), cancelSendRequest.getFileId(), cancelSendRequest.getSentLength());
    }

    @l
    public static final e m(@l CancelSendReply cancelSendReply) {
        l0.p(cancelSendReply, "<this>");
        return new e(cancelSendReply.getTaskId(), true);
    }

    @l
    public static final n n(@l HandshakeRequest handshakeRequest) {
        l0.p(handshakeRequest, "<this>");
        String data = handshakeRequest.getData();
        l0.o(data, "getData(...)");
        return new n(data);
    }

    @l
    public static final q o(@l ReceiveFinish receiveFinish) {
        l0.p(receiveFinish, "<this>");
        return new q(receiveFinish.getTaskId());
    }

    @l
    public static final t p(@l SendFileInfoRequest sendFileInfoRequest) {
        l0.p(sendFileInfoRequest, "<this>");
        long taskId = sendFileInfoRequest.getTaskId();
        List<SendFileInfoRequest.FileInfo> filesList = sendFileInfoRequest.getFilesList();
        l0.o(filesList, "getFilesList(...)");
        List<SendFileInfoRequest.FileInfo> list = filesList;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        for (SendFileInfoRequest.FileInfo fileInfo : list) {
            l0.m(fileInfo);
            arrayList.add(a(fileInfo));
        }
        return new t(taskId, arrayList, sendFileInfoRequest.getExtend());
    }

    @l
    public static final u q(@l SendFileReply sendFileReply) {
        l0.p(sendFileReply, "<this>");
        return new u(sendFileReply.getTaskId(), sendFileReply.getIsAccept(), sendFileReply.getExtend());
    }

    @l
    public static final k r(@l t tVar) {
        l0.p(tVar, "<this>");
        return new k(tVar.f14204h, k0.INSTANCE, tVar.f14205i, tVar.f14206j, 0, 16, null);
    }
}
