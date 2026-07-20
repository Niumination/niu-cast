package v2;

import com.transsion.airtransfer.filetransfer.protos.CancelReceiveReply;
import com.transsion.airtransfer.filetransfer.protos.CancelReceiveRequest;
import com.transsion.airtransfer.filetransfer.protos.CancelSendReply;
import com.transsion.airtransfer.filetransfer.protos.CancelSendRequest;
import com.transsion.airtransfer.filetransfer.protos.HandshakeRequest;
import com.transsion.airtransfer.filetransfer.protos.ReceiveFinish;
import com.transsion.airtransfer.filetransfer.protos.SendFileInfoRequest;
import com.transsion.airtransfer.filetransfer.protos.SendFileReply;
import kn.r1;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nTransmissionModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransmissionModule.kt\ncom/transsion/airtransfer/filetransfer/di/TransmissionModule\n+ 2 GrpcMessageChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannel$Factory\n*L\n1#1,45:1\n97#2:46\n97#2:47\n97#2:48\n97#2:49\n97#2:50\n97#2:51\n97#2:52\n97#2:53\n*S KotlinDebug\n*F\n+ 1 TransmissionModule.kt\ncom/transsion/airtransfer/filetransfer/di/TransmissionModule\n*L\n36#1:46\n37#1:47\n38#1:48\n39#1:49\n40#1:50\n41#1:51\n42#1:52\n43#1:53\n*E\n"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final c f16501a = new c();

    @r1({"SMAP\nGrpcMessageChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcMessageChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannel$Factory$create$1\n*L\n1#1,104:1\n*E\n"})
    public static final class a extends h3.a<SendFileInfoRequest> {
        @Override // h3.a
        @l
        public Class<?> f() {
            return SendFileInfoRequest.class;
        }
    }

    @r1({"SMAP\nGrpcMessageChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcMessageChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannel$Factory$create$1\n*L\n1#1,104:1\n*E\n"})
    public static final class b extends h3.a<SendFileReply> {
        @Override // h3.a
        @l
        public Class<?> f() {
            return SendFileReply.class;
        }
    }

    /* JADX INFO: renamed from: v2.c$c, reason: collision with other inner class name */
    @r1({"SMAP\nGrpcMessageChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcMessageChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannel$Factory$create$1\n*L\n1#1,104:1\n*E\n"})
    public static final class C0445c extends h3.a<CancelSendRequest> {
        @Override // h3.a
        @l
        public Class<?> f() {
            return CancelSendRequest.class;
        }
    }

    @r1({"SMAP\nGrpcMessageChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcMessageChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannel$Factory$create$1\n*L\n1#1,104:1\n*E\n"})
    public static final class d extends h3.a<CancelSendReply> {
        @Override // h3.a
        @l
        public Class<?> f() {
            return CancelSendReply.class;
        }
    }

    @r1({"SMAP\nGrpcMessageChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcMessageChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannel$Factory$create$1\n*L\n1#1,104:1\n*E\n"})
    public static final class e extends h3.a<CancelReceiveRequest> {
        @Override // h3.a
        @l
        public Class<?> f() {
            return CancelReceiveRequest.class;
        }
    }

    @r1({"SMAP\nGrpcMessageChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcMessageChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannel$Factory$create$1\n*L\n1#1,104:1\n*E\n"})
    public static final class f extends h3.a<CancelReceiveReply> {
        @Override // h3.a
        @l
        public Class<?> f() {
            return CancelReceiveReply.class;
        }
    }

    @r1({"SMAP\nGrpcMessageChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcMessageChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannel$Factory$create$1\n*L\n1#1,104:1\n*E\n"})
    public static final class g extends h3.a<ReceiveFinish> {
        @Override // h3.a
        @l
        public Class<?> f() {
            return ReceiveFinish.class;
        }
    }

    @r1({"SMAP\nGrpcMessageChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcMessageChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/channel/GrpcMessageChannel$Factory$create$1\n*L\n1#1,104:1\n*E\n"})
    public static final class h extends h3.a<HandshakeRequest> {
        @Override // h3.a
        @l
        public Class<?> f() {
            return HandshakeRequest.class;
        }
    }

    public final void a() {
        b();
    }

    public final void b() {
        e3.a aVar = e3.a.f4044a;
        aVar.a(new i3.b());
        aVar.a(new g3.c());
    }

    public final void c() {
        h3.b bVar = h3.b.f6969a;
        h3.a.b bVar2 = h3.a.b.f6967a;
        bVar.b(new a());
        bVar.b(new b());
        bVar.b(new C0445c());
        bVar.b(new d());
        bVar.b(new e());
        bVar.b(new f());
        bVar.b(new g());
        bVar.b(new h());
    }
}
