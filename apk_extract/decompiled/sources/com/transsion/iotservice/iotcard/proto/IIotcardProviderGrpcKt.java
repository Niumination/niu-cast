package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import bf.a;
import bf.b;
import bf.d0;
import bf.e;
import bf.m;
import bf.u;
import j3.x;
import k3.b1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oi.b0;
import oi.h;
import oi.j;
import ze.f;
import ze.g;
import ze.g2;
import ze.l2;
import ze.m2;
import ze.p1;
import ze.q1;
import ze.q2;
import ze.r1;
import ze.r2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\f8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\f8G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\f8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000e0\f8G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010R\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\f8G¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010R\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e0\f8G¢\u0006\u0006\u001a\u0004\b%\u0010\u0010¨\u0006)"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IIotcardProviderGrpcKt;", "", "<init>", "()V", "", "SERVICE_NAME", "Ljava/lang/String;", "Lze/m2;", "getServiceDescriptor", "()Lze/m2;", "getServiceDescriptor$annotations", "serviceDescriptor", "Lze/r1;", "Lcom/transsion/iotservice/iotcard/proto/IotcardBean;", "Lcom/transsion/iotservice/iotcard/proto/Empty;", "getRegisterDeviceMethod", "()Lze/r1;", "registerDeviceMethod", "Lcom/transsion/iotservice/iotcard/proto/IotcardList;", "getRegisterDeviceListMethod", "registerDeviceListMethod", "getUnregisterDeviceMethod", "unregisterDeviceMethod", "getUnRegisterDeviceListMethod", "unRegisterDeviceListMethod", "getUpdateDeviceMethod", "updateDeviceMethod", "getUpdateDeviceListMethod", "updateDeviceListMethod", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMap;", "getInitAppDevicesMethod", "initAppDevicesMethod", "Lcom/transsion/iotservice/iotcard/proto/PackageName;", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickAction;", "getSwitchClickMethod", "switchClickMethod", "Lcom/transsion/iotservice/iotcard/proto/Port;", "getInitPortMethod", "initPortMethod", "IIotcardProviderCoroutineImplBase", "IIotcardProviderCoroutineStub", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IIotcardProviderGrpcKt {
    public static final IIotcardProviderGrpcKt INSTANCE = new IIotcardProviderGrpcKt();
    public static final String SERVICE_NAME = "IIotcardProvider";

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\nJ\u001b\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\nJ\u001b\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\rJ#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0007\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase;", "Lbf/a;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "Lcom/transsion/iotservice/iotcard/proto/IotcardBean;", "request", "Lcom/transsion/iotservice/iotcard/proto/Empty;", "registerDevice", "(Lcom/transsion/iotservice/iotcard/proto/IotcardBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/transsion/iotservice/iotcard/proto/IotcardList;", "registerDeviceList", "(Lcom/transsion/iotservice/iotcard/proto/IotcardList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterDevice", "unRegisterDeviceList", "updateDevice", "updateDeviceList", "Loi/h;", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMap;", "requests", "initAppDevices", "(Loi/h;)Loi/h;", "Lcom/transsion/iotservice/iotcard/proto/PackageName;", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickAction;", "switchClick", "(Lcom/transsion/iotservice/iotcard/proto/PackageName;)Loi/h;", "Lcom/transsion/iotservice/iotcard/proto/Port;", "initPort", "(Lcom/transsion/iotservice/iotcard/proto/Port;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lze/l2;", "bindService", "()Lze/l2;", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static abstract class IIotcardProviderCoroutineImplBase extends a {
        /* JADX WARN: Multi-variable type inference failed */
        public IIotcardProviderCoroutineImplBase() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Object initPort$suspendImpl(IIotcardProviderCoroutineImplBase iIotcardProviderCoroutineImplBase, Port port, Continuation<? super Empty> continuation) throws r2 {
            throw new r2(q2.f11409l.h("Method IIotcardProvider.initPort is unimplemented"));
        }

        public static /* synthetic */ Object registerDevice$suspendImpl(IIotcardProviderCoroutineImplBase iIotcardProviderCoroutineImplBase, IotcardBean iotcardBean, Continuation<? super Empty> continuation) throws r2 {
            throw new r2(q2.f11409l.h("Method IIotcardProvider.RegisterDevice is unimplemented"));
        }

        public static /* synthetic */ Object registerDeviceList$suspendImpl(IIotcardProviderCoroutineImplBase iIotcardProviderCoroutineImplBase, IotcardList iotcardList, Continuation<? super Empty> continuation) throws r2 {
            throw new r2(q2.f11409l.h("Method IIotcardProvider.RegisterDeviceList is unimplemented"));
        }

        public static /* synthetic */ Object unRegisterDeviceList$suspendImpl(IIotcardProviderCoroutineImplBase iIotcardProviderCoroutineImplBase, IotcardList iotcardList, Continuation<? super Empty> continuation) throws r2 {
            throw new r2(q2.f11409l.h("Method IIotcardProvider.UnRegisterDeviceList is unimplemented"));
        }

        public static /* synthetic */ Object unregisterDevice$suspendImpl(IIotcardProviderCoroutineImplBase iIotcardProviderCoroutineImplBase, IotcardBean iotcardBean, Continuation<? super Empty> continuation) throws r2 {
            throw new r2(q2.f11409l.h("Method IIotcardProvider.UnregisterDevice is unimplemented"));
        }

        public static /* synthetic */ Object updateDevice$suspendImpl(IIotcardProviderCoroutineImplBase iIotcardProviderCoroutineImplBase, IotcardBean iotcardBean, Continuation<? super Empty> continuation) throws r2 {
            throw new r2(q2.f11409l.h("Method IIotcardProvider.UpdateDevice is unimplemented"));
        }

        public static /* synthetic */ Object updateDeviceList$suspendImpl(IIotcardProviderCoroutineImplBase iIotcardProviderCoroutineImplBase, IotcardList iotcardList, Continuation<? super Empty> continuation) throws r2 {
            throw new r2(q2.f11409l.h("Method IIotcardProvider.UpdateDeviceList is unimplemented"));
        }

        public final l2 bindService() {
            u6.a aVar = new u6.a(IIotcardProviderGrpc.getServiceDescriptor());
            CoroutineContext context = getContext();
            r1 registerDeviceMethod = IIotcardProviderGrpc.getRegisterDeviceMethod();
            Intrinsics.checkNotNullExpressionValue(registerDeviceMethod, "getRegisterDeviceMethod()");
            aVar.v(b1.a(context, registerDeviceMethod, new IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$1(this)));
            CoroutineContext context2 = getContext();
            r1 registerDeviceListMethod = IIotcardProviderGrpc.getRegisterDeviceListMethod();
            Intrinsics.checkNotNullExpressionValue(registerDeviceListMethod, "getRegisterDeviceListMethod()");
            aVar.v(b1.a(context2, registerDeviceListMethod, new IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$2(this)));
            CoroutineContext context3 = getContext();
            r1 unregisterDeviceMethod = IIotcardProviderGrpc.getUnregisterDeviceMethod();
            Intrinsics.checkNotNullExpressionValue(unregisterDeviceMethod, "getUnregisterDeviceMethod()");
            aVar.v(b1.a(context3, unregisterDeviceMethod, new IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$3(this)));
            CoroutineContext context4 = getContext();
            r1 unRegisterDeviceListMethod = IIotcardProviderGrpc.getUnRegisterDeviceListMethod();
            Intrinsics.checkNotNullExpressionValue(unRegisterDeviceListMethod, "getUnRegisterDeviceListMethod()");
            aVar.v(b1.a(context4, unRegisterDeviceListMethod, new IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$4(this)));
            CoroutineContext context5 = getContext();
            r1 updateDeviceMethod = IIotcardProviderGrpc.getUpdateDeviceMethod();
            Intrinsics.checkNotNullExpressionValue(updateDeviceMethod, "getUpdateDeviceMethod()");
            aVar.v(b1.a(context5, updateDeviceMethod, new IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$5(this)));
            CoroutineContext context6 = getContext();
            r1 updateDeviceListMethod = IIotcardProviderGrpc.getUpdateDeviceListMethod();
            Intrinsics.checkNotNullExpressionValue(updateDeviceListMethod, "getUpdateDeviceListMethod()");
            aVar.v(b1.a(context6, updateDeviceListMethod, new IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$6(this)));
            CoroutineContext context7 = getContext();
            r1 descriptor = IIotcardProviderGrpc.getInitAppDevicesMethod();
            Intrinsics.checkNotNullExpressionValue(descriptor, "getInitAppDevicesMethod()");
            IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$7 implementation = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$7(this);
            Intrinsics.checkNotNullParameter(context7, "context");
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(implementation, "implementation");
            if (descriptor.f11422a != q1.BIDI_STREAMING) {
                throw new IllegalArgumentException(("Expected a bidi streaming method descriptor but got " + descriptor).toString());
            }
            g2 g2Var = new g2(descriptor, new u(0, context7, implementation));
            Intrinsics.checkNotNullExpressionValue(g2Var, "create(\n      descriptor…xt, implementation)\n    )");
            aVar.v(g2Var);
            CoroutineContext context8 = getContext();
            r1 descriptor2 = IIotcardProviderGrpc.getSwitchClickMethod();
            Intrinsics.checkNotNullExpressionValue(descriptor2, "getSwitchClickMethod()");
            IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$8 implementation2 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$8(this);
            Intrinsics.checkNotNullParameter(context8, "context");
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(implementation2, "implementation");
            if (descriptor2.f11422a != q1.SERVER_STREAMING) {
                throw new IllegalArgumentException(("Expected a server streaming method descriptor but got " + descriptor2).toString());
            }
            g2 g2Var2 = new g2(descriptor2, new u(0, context8, new d0(descriptor2, implementation2)));
            Intrinsics.checkNotNullExpressionValue(g2Var2, "create(\n      descriptor…xt, implementation)\n    )");
            aVar.v(g2Var2);
            CoroutineContext context9 = getContext();
            r1 initPortMethod = IIotcardProviderGrpc.getInitPortMethod();
            Intrinsics.checkNotNullExpressionValue(initPortMethod, "getInitPortMethod()");
            aVar.v(b1.a(context9, initPortMethod, new IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$9(this)));
            l2 l2VarW = aVar.w();
            Intrinsics.checkNotNullExpressionValue(l2VarW, "builder(getServiceDescri…::initPort\n    )).build()");
            return l2VarW;
        }

        public h initAppDevices(h requests) throws r2 {
            Intrinsics.checkNotNullParameter(requests, "requests");
            throw new r2(q2.f11409l.h("Method IIotcardProvider.initAppDevices is unimplemented"));
        }

        public Object initPort(Port port, Continuation<? super Empty> continuation) {
            return initPort$suspendImpl(this, port, continuation);
        }

        public Object registerDevice(IotcardBean iotcardBean, Continuation<? super Empty> continuation) {
            return registerDevice$suspendImpl(this, iotcardBean, continuation);
        }

        public Object registerDeviceList(IotcardList iotcardList, Continuation<? super Empty> continuation) {
            return registerDeviceList$suspendImpl(this, iotcardList, continuation);
        }

        public h switchClick(PackageName request) throws r2 {
            Intrinsics.checkNotNullParameter(request, "request");
            throw new r2(q2.f11409l.h("Method IIotcardProvider.SwitchClick is unimplemented"));
        }

        public Object unRegisterDeviceList(IotcardList iotcardList, Continuation<? super Empty> continuation) {
            return unRegisterDeviceList$suspendImpl(this, iotcardList, continuation);
        }

        public Object unregisterDevice(IotcardBean iotcardBean, Continuation<? super Empty> continuation) {
            return unregisterDevice$suspendImpl(this, iotcardBean, continuation);
        }

        public Object updateDevice(IotcardBean iotcardBean, Continuation<? super Empty> continuation) {
            return updateDevice$suspendImpl(this, iotcardBean, continuation);
        }

        public Object updateDeviceList(IotcardList iotcardList, Continuation<? super Empty> continuation) {
            return updateDeviceList$suspendImpl(this, iotcardList, continuation);
        }

        public /* synthetic */ IIotcardProviderCoroutineImplBase(CoroutineContext coroutineContext, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IIotcardProviderCoroutineImplBase(CoroutineContext coroutineContext) {
            super(coroutineContext);
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0010J%\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013J%\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0010J%\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013J+\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\u0006\u0010\u000b\u001a\u00020\u001d2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J%\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020!2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub;", "Lbf/b;", "Lze/g;", "channel", "Lze/f;", "callOptions", "<init>", "(Lze/g;Lze/f;)V", "build", "(Lze/g;Lze/f;)Lcom/transsion/iotservice/iotcard/proto/IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub;", "Lcom/transsion/iotservice/iotcard/proto/IotcardBean;", "request", "Lze/p1;", "headers", "Lcom/transsion/iotservice/iotcard/proto/Empty;", "registerDevice", "(Lcom/transsion/iotservice/iotcard/proto/IotcardBean;Lze/p1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/transsion/iotservice/iotcard/proto/IotcardList;", "registerDeviceList", "(Lcom/transsion/iotservice/iotcard/proto/IotcardList;Lze/p1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterDevice", "unRegisterDeviceList", "updateDevice", "updateDeviceList", "Loi/h;", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMap;", "requests", "initAppDevices", "(Loi/h;Lze/p1;)Loi/h;", "Lcom/transsion/iotservice/iotcard/proto/PackageName;", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickAction;", "switchClick", "(Lcom/transsion/iotservice/iotcard/proto/PackageName;Lze/p1;)Loi/h;", "Lcom/transsion/iotservice/iotcard/proto/Port;", "initPort", "(Lcom/transsion/iotservice/iotcard/proto/Port;Lze/p1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class IIotcardProviderCoroutineStub extends b {
        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public IIotcardProviderCoroutineStub(g channel) {
            this(channel, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(channel, "channel");
        }

        public static h initAppDevices$default(IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, h hVar, p1 p1Var, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                p1Var = new p1();
            }
            return iIotcardProviderCoroutineStub.initAppDevices(hVar, p1Var);
        }

        public static Object initPort$default(IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, Port port, p1 p1Var, Continuation continuation, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                p1Var = new p1();
            }
            return iIotcardProviderCoroutineStub.initPort(port, p1Var, continuation);
        }

        public static Object registerDevice$default(IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, IotcardBean iotcardBean, p1 p1Var, Continuation continuation, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                p1Var = new p1();
            }
            return iIotcardProviderCoroutineStub.registerDevice(iotcardBean, p1Var, continuation);
        }

        public static Object registerDeviceList$default(IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, IotcardList iotcardList, p1 p1Var, Continuation continuation, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                p1Var = new p1();
            }
            return iIotcardProviderCoroutineStub.registerDeviceList(iotcardList, p1Var, continuation);
        }

        public static h switchClick$default(IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, PackageName packageName, p1 p1Var, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                p1Var = new p1();
            }
            return iIotcardProviderCoroutineStub.switchClick(packageName, p1Var);
        }

        public static Object unRegisterDeviceList$default(IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, IotcardList iotcardList, p1 p1Var, Continuation continuation, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                p1Var = new p1();
            }
            return iIotcardProviderCoroutineStub.unRegisterDeviceList(iotcardList, p1Var, continuation);
        }

        public static Object unregisterDevice$default(IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, IotcardBean iotcardBean, p1 p1Var, Continuation continuation, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                p1Var = new p1();
            }
            return iIotcardProviderCoroutineStub.unregisterDevice(iotcardBean, p1Var, continuation);
        }

        public static Object updateDevice$default(IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, IotcardBean iotcardBean, p1 p1Var, Continuation continuation, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                p1Var = new p1();
            }
            return iIotcardProviderCoroutineStub.updateDevice(iotcardBean, p1Var, continuation);
        }

        public static Object updateDeviceList$default(IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, IotcardList iotcardList, p1 p1Var, Continuation continuation, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                p1Var = new p1();
            }
            return iIotcardProviderCoroutineStub.updateDeviceList(iotcardList, p1Var, continuation);
        }

        public final h initAppDevices(h requests, p1 headers) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            Intrinsics.checkNotNullParameter(headers, "headers");
            g channel = getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "channel");
            r1 method = IIotcardProviderGrpc.getInitAppDevicesMethod();
            Intrinsics.checkNotNullExpressionValue(method, "getInitAppDevicesMethod()");
            f callOptions = getCallOptions();
            Intrinsics.checkNotNullExpressionValue(callOptions, "callOptions");
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(requests, "requests");
            Intrinsics.checkNotNullParameter(callOptions, "callOptions");
            Intrinsics.checkNotNullParameter(headers, "headers");
            if (method.f11422a == q1.BIDI_STREAMING) {
                return new b0(new m(channel, method, callOptions, headers, new e(requests), null));
            }
            throw new IllegalStateException(("Expected a bidi streaming method, but got " + method).toString());
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object initPort(Port port, p1 p1Var, Continuation<? super Empty> continuation) {
            IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1 iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1;
            if (continuation instanceof IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1) {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1 = (IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1) continuation;
                int i8 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1.label;
                if ((i8 & Integer.MIN_VALUE) != 0) {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1.label = i8 - Integer.MIN_VALUE;
                } else {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1(this, continuation);
                }
            } else {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1(this, continuation);
            }
            Object objJ = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i9 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1.label;
            if (i9 == 0) {
                ResultKt.throwOnFailure(objJ);
                g channel = getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "channel");
                r1 initPortMethod = IIotcardProviderGrpc.getInitPortMethod();
                Intrinsics.checkNotNullExpressionValue(initPortMethod, "getInitPortMethod()");
                f callOptions = getCallOptions();
                Intrinsics.checkNotNullExpressionValue(callOptions, "callOptions");
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1.label = 1;
                if (initPortMethod.f11422a != q1.UNARY) {
                    throw new IllegalArgumentException(("Expected a unary RPC method, but got " + initPortMethod).toString());
                }
                objJ = j.j(x.a(new b0(new m(channel, initPortMethod, callOptions, p1Var, new bf.f(port), null)), initPortMethod), iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$initPort$1);
                if (objJ == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objJ);
            }
            Intrinsics.checkNotNullExpressionValue(objJ, "unaryRpc(\n      channel,…ions,\n      headers\n    )");
            return objJ;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object registerDevice(IotcardBean iotcardBean, p1 p1Var, Continuation<? super Empty> continuation) {
            IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1 iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1;
            if (continuation instanceof IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1) {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1 = (IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1) continuation;
                int i8 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1.label;
                if ((i8 & Integer.MIN_VALUE) != 0) {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1.label = i8 - Integer.MIN_VALUE;
                } else {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1(this, continuation);
                }
            } else {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1(this, continuation);
            }
            Object objJ = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i9 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1.label;
            if (i9 == 0) {
                ResultKt.throwOnFailure(objJ);
                g channel = getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "channel");
                r1 registerDeviceMethod = IIotcardProviderGrpc.getRegisterDeviceMethod();
                Intrinsics.checkNotNullExpressionValue(registerDeviceMethod, "getRegisterDeviceMethod()");
                f callOptions = getCallOptions();
                Intrinsics.checkNotNullExpressionValue(callOptions, "callOptions");
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1.label = 1;
                if (registerDeviceMethod.f11422a != q1.UNARY) {
                    throw new IllegalArgumentException(("Expected a unary RPC method, but got " + registerDeviceMethod).toString());
                }
                objJ = j.j(x.a(new b0(new m(channel, registerDeviceMethod, callOptions, p1Var, new bf.f(iotcardBean), null)), registerDeviceMethod), iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDevice$1);
                if (objJ == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objJ);
            }
            Intrinsics.checkNotNullExpressionValue(objJ, "unaryRpc(\n      channel,…ions,\n      headers\n    )");
            return objJ;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object registerDeviceList(IotcardList iotcardList, p1 p1Var, Continuation<? super Empty> continuation) {
            IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1 iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1;
            if (continuation instanceof IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1) {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1 = (IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1) continuation;
                int i8 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1.label;
                if ((i8 & Integer.MIN_VALUE) != 0) {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1.label = i8 - Integer.MIN_VALUE;
                } else {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1(this, continuation);
                }
            } else {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1(this, continuation);
            }
            Object objJ = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i9 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1.label;
            if (i9 == 0) {
                ResultKt.throwOnFailure(objJ);
                g channel = getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "channel");
                r1 registerDeviceListMethod = IIotcardProviderGrpc.getRegisterDeviceListMethod();
                Intrinsics.checkNotNullExpressionValue(registerDeviceListMethod, "getRegisterDeviceListMethod()");
                f callOptions = getCallOptions();
                Intrinsics.checkNotNullExpressionValue(callOptions, "callOptions");
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1.label = 1;
                if (registerDeviceListMethod.f11422a != q1.UNARY) {
                    throw new IllegalArgumentException(("Expected a unary RPC method, but got " + registerDeviceListMethod).toString());
                }
                objJ = j.j(x.a(new b0(new m(channel, registerDeviceListMethod, callOptions, p1Var, new bf.f(iotcardList), null)), registerDeviceListMethod), iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1);
                if (objJ == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objJ);
            }
            Intrinsics.checkNotNullExpressionValue(objJ, "unaryRpc(\n      channel,…ions,\n      headers\n    )");
            return objJ;
        }

        public final h switchClick(PackageName request, p1 headers) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(headers, "headers");
            g channel = getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "channel");
            r1 method = IIotcardProviderGrpc.getSwitchClickMethod();
            Intrinsics.checkNotNullExpressionValue(method, "getSwitchClickMethod()");
            f callOptions = getCallOptions();
            Intrinsics.checkNotNullExpressionValue(callOptions, "callOptions");
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(callOptions, "callOptions");
            Intrinsics.checkNotNullParameter(headers, "headers");
            if (method.f11422a == q1.SERVER_STREAMING) {
                return new b0(new m(channel, method, callOptions, headers, new bf.f(request), null));
            }
            throw new IllegalArgumentException(("Expected a server streaming RPC method, but got " + method).toString());
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object unRegisterDeviceList(IotcardList iotcardList, p1 p1Var, Continuation<? super Empty> continuation) {
            IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1 iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1;
            if (continuation instanceof IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1) {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1 = (IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1) continuation;
                int i8 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1.label;
                if ((i8 & Integer.MIN_VALUE) != 0) {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1.label = i8 - Integer.MIN_VALUE;
                } else {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1(this, continuation);
                }
            } else {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1(this, continuation);
            }
            Object objJ = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i9 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1.label;
            if (i9 == 0) {
                ResultKt.throwOnFailure(objJ);
                g channel = getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "channel");
                r1 unRegisterDeviceListMethod = IIotcardProviderGrpc.getUnRegisterDeviceListMethod();
                Intrinsics.checkNotNullExpressionValue(unRegisterDeviceListMethod, "getUnRegisterDeviceListMethod()");
                f callOptions = getCallOptions();
                Intrinsics.checkNotNullExpressionValue(callOptions, "callOptions");
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1.label = 1;
                if (unRegisterDeviceListMethod.f11422a != q1.UNARY) {
                    throw new IllegalArgumentException(("Expected a unary RPC method, but got " + unRegisterDeviceListMethod).toString());
                }
                objJ = j.j(x.a(new b0(new m(channel, unRegisterDeviceListMethod, callOptions, p1Var, new bf.f(iotcardList), null)), unRegisterDeviceListMethod), iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unRegisterDeviceList$1);
                if (objJ == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objJ);
            }
            Intrinsics.checkNotNullExpressionValue(objJ, "unaryRpc(\n      channel,…ions,\n      headers\n    )");
            return objJ;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object unregisterDevice(IotcardBean iotcardBean, p1 p1Var, Continuation<? super Empty> continuation) {
            IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1 iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1;
            if (continuation instanceof IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1) {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1 = (IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1) continuation;
                int i8 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1.label;
                if ((i8 & Integer.MIN_VALUE) != 0) {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1.label = i8 - Integer.MIN_VALUE;
                } else {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1(this, continuation);
                }
            } else {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1(this, continuation);
            }
            Object objJ = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i9 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1.label;
            if (i9 == 0) {
                ResultKt.throwOnFailure(objJ);
                g channel = getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "channel");
                r1 unregisterDeviceMethod = IIotcardProviderGrpc.getUnregisterDeviceMethod();
                Intrinsics.checkNotNullExpressionValue(unregisterDeviceMethod, "getUnregisterDeviceMethod()");
                f callOptions = getCallOptions();
                Intrinsics.checkNotNullExpressionValue(callOptions, "callOptions");
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1.label = 1;
                if (unregisterDeviceMethod.f11422a != q1.UNARY) {
                    throw new IllegalArgumentException(("Expected a unary RPC method, but got " + unregisterDeviceMethod).toString());
                }
                objJ = j.j(x.a(new b0(new m(channel, unregisterDeviceMethod, callOptions, p1Var, new bf.f(iotcardBean), null)), unregisterDeviceMethod), iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$unregisterDevice$1);
                if (objJ == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objJ);
            }
            Intrinsics.checkNotNullExpressionValue(objJ, "unaryRpc(\n      channel,…ions,\n      headers\n    )");
            return objJ;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object updateDevice(IotcardBean iotcardBean, p1 p1Var, Continuation<? super Empty> continuation) {
            IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1 iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1;
            if (continuation instanceof IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1) {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1 = (IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1) continuation;
                int i8 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1.label;
                if ((i8 & Integer.MIN_VALUE) != 0) {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1.label = i8 - Integer.MIN_VALUE;
                } else {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1(this, continuation);
                }
            } else {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1(this, continuation);
            }
            Object objJ = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i9 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1.label;
            if (i9 == 0) {
                ResultKt.throwOnFailure(objJ);
                g channel = getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "channel");
                r1 updateDeviceMethod = IIotcardProviderGrpc.getUpdateDeviceMethod();
                Intrinsics.checkNotNullExpressionValue(updateDeviceMethod, "getUpdateDeviceMethod()");
                f callOptions = getCallOptions();
                Intrinsics.checkNotNullExpressionValue(callOptions, "callOptions");
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1.label = 1;
                if (updateDeviceMethod.f11422a != q1.UNARY) {
                    throw new IllegalArgumentException(("Expected a unary RPC method, but got " + updateDeviceMethod).toString());
                }
                objJ = j.j(x.a(new b0(new m(channel, updateDeviceMethod, callOptions, p1Var, new bf.f(iotcardBean), null)), updateDeviceMethod), iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDevice$1);
                if (objJ == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objJ);
            }
            Intrinsics.checkNotNullExpressionValue(objJ, "unaryRpc(\n      channel,…ions,\n      headers\n    )");
            return objJ;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object updateDeviceList(IotcardList iotcardList, p1 p1Var, Continuation<? super Empty> continuation) {
            IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1 iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1;
            if (continuation instanceof IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1) {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1 = (IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1) continuation;
                int i8 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1.label;
                if ((i8 & Integer.MIN_VALUE) != 0) {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1.label = i8 - Integer.MIN_VALUE;
                } else {
                    iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1(this, continuation);
                }
            } else {
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1 = new IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1(this, continuation);
            }
            Object objJ = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i9 = iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1.label;
            if (i9 == 0) {
                ResultKt.throwOnFailure(objJ);
                g channel = getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "channel");
                r1 updateDeviceListMethod = IIotcardProviderGrpc.getUpdateDeviceListMethod();
                Intrinsics.checkNotNullExpressionValue(updateDeviceListMethod, "getUpdateDeviceListMethod()");
                f callOptions = getCallOptions();
                Intrinsics.checkNotNullExpressionValue(callOptions, "callOptions");
                iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1.label = 1;
                if (updateDeviceListMethod.f11422a != q1.UNARY) {
                    throw new IllegalArgumentException(("Expected a unary RPC method, but got " + updateDeviceListMethod).toString());
                }
                objJ = j.j(x.a(new b0(new m(channel, updateDeviceListMethod, callOptions, p1Var, new bf.f(iotcardList), null)), updateDeviceListMethod), iIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$updateDeviceList$1);
                if (objJ == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objJ);
            }
            Intrinsics.checkNotNullExpressionValue(objJ, "unaryRpc(\n      channel,…ions,\n      headers\n    )");
            return objJ;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public IIotcardProviderCoroutineStub(g channel, f callOptions) {
            super(channel, callOptions);
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(callOptions, "callOptions");
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(callOptions, "callOptions");
        }

        @Override // hf.e
        public IIotcardProviderCoroutineStub build(g channel, f callOptions) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(callOptions, "callOptions");
            return new IIotcardProviderCoroutineStub(channel, callOptions);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ IIotcardProviderCoroutineStub(g gVar, f DEFAULT, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i8 & 2) != 0) {
                DEFAULT = f.f11346i;
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
            }
            this(gVar, DEFAULT);
        }
    }

    private IIotcardProviderGrpcKt() {
    }

    @JvmStatic
    public static final r1 getInitAppDevicesMethod() {
        r1 initAppDevicesMethod = IIotcardProviderGrpc.getInitAppDevicesMethod();
        Intrinsics.checkNotNullExpressionValue(initAppDevicesMethod, "getInitAppDevicesMethod()");
        return initAppDevicesMethod;
    }

    @JvmStatic
    public static final r1 getInitPortMethod() {
        r1 initPortMethod = IIotcardProviderGrpc.getInitPortMethod();
        Intrinsics.checkNotNullExpressionValue(initPortMethod, "getInitPortMethod()");
        return initPortMethod;
    }

    @JvmStatic
    public static final r1 getRegisterDeviceListMethod() {
        r1 registerDeviceListMethod = IIotcardProviderGrpc.getRegisterDeviceListMethod();
        Intrinsics.checkNotNullExpressionValue(registerDeviceListMethod, "getRegisterDeviceListMethod()");
        return registerDeviceListMethod;
    }

    @JvmStatic
    public static final r1 getRegisterDeviceMethod() {
        r1 registerDeviceMethod = IIotcardProviderGrpc.getRegisterDeviceMethod();
        Intrinsics.checkNotNullExpressionValue(registerDeviceMethod, "getRegisterDeviceMethod()");
        return registerDeviceMethod;
    }

    public static final m2 getServiceDescriptor() {
        m2 serviceDescriptor = IIotcardProviderGrpc.getServiceDescriptor();
        Intrinsics.checkNotNullExpressionValue(serviceDescriptor, "getServiceDescriptor()");
        return serviceDescriptor;
    }

    @JvmStatic
    public static /* synthetic */ void getServiceDescriptor$annotations() {
    }

    @JvmStatic
    public static final r1 getSwitchClickMethod() {
        r1 switchClickMethod = IIotcardProviderGrpc.getSwitchClickMethod();
        Intrinsics.checkNotNullExpressionValue(switchClickMethod, "getSwitchClickMethod()");
        return switchClickMethod;
    }

    @JvmStatic
    public static final r1 getUnRegisterDeviceListMethod() {
        r1 unRegisterDeviceListMethod = IIotcardProviderGrpc.getUnRegisterDeviceListMethod();
        Intrinsics.checkNotNullExpressionValue(unRegisterDeviceListMethod, "getUnRegisterDeviceListMethod()");
        return unRegisterDeviceListMethod;
    }

    @JvmStatic
    public static final r1 getUnregisterDeviceMethod() {
        r1 unregisterDeviceMethod = IIotcardProviderGrpc.getUnregisterDeviceMethod();
        Intrinsics.checkNotNullExpressionValue(unregisterDeviceMethod, "getUnregisterDeviceMethod()");
        return unregisterDeviceMethod;
    }

    @JvmStatic
    public static final r1 getUpdateDeviceListMethod() {
        r1 updateDeviceListMethod = IIotcardProviderGrpc.getUpdateDeviceListMethod();
        Intrinsics.checkNotNullExpressionValue(updateDeviceListMethod, "getUpdateDeviceListMethod()");
        return updateDeviceListMethod;
    }

    @JvmStatic
    public static final r1 getUpdateDeviceMethod() {
        r1 updateDeviceMethod = IIotcardProviderGrpc.getUpdateDeviceMethod();
        Intrinsics.checkNotNullExpressionValue(updateDeviceMethod, "getUpdateDeviceMethod()");
        return updateDeviceMethod;
    }
}
