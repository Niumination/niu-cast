package com.transsion.iotservice.iotcard.proto;

import com.google.protobuf.ExtensionRegistryLite;
import hf.a;
import hf.b;
import hf.c;
import hf.h;
import hf.k;
import hf.l;
import hf.m;
import hf.n;
import hf.p;
import hf.r;
import hf.s;
import hf.u;
import hf.v;
import java.util.Iterator;
import java.util.logging.Logger;
import k3.b9;
import k3.v8;
import mg.a0;
import tj.x;
import ze.d;
import ze.f;
import ze.g;
import ze.j;
import ze.l2;
import ze.m2;
import ze.p1;
import ze.q1;
import ze.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class IIotcardProviderGrpc {
    private static final int METHODID_INIT_APP_DEVICES = 8;
    private static final int METHODID_INIT_PORT = 7;
    private static final int METHODID_REGISTER_DEVICE = 0;
    private static final int METHODID_REGISTER_DEVICE_LIST = 1;
    private static final int METHODID_SWITCH_CLICK = 6;
    private static final int METHODID_UNREGISTER_DEVICE = 2;
    private static final int METHODID_UN_REGISTER_DEVICE_LIST = 3;
    private static final int METHODID_UPDATE_DEVICE = 4;
    private static final int METHODID_UPDATE_DEVICE_LIST = 5;
    public static final String SERVICE_NAME = "IIotcardProvider";
    private static volatile r1 getInitAppDevicesMethod;
    private static volatile r1 getInitPortMethod;
    private static volatile r1 getRegisterDeviceListMethod;
    private static volatile r1 getRegisterDeviceMethod;
    private static volatile r1 getSwitchClickMethod;
    private static volatile r1 getUnRegisterDeviceListMethod;
    private static volatile r1 getUnregisterDeviceMethod;
    private static volatile r1 getUpdateDeviceListMethod;
    private static volatile r1 getUpdateDeviceMethod;
    private static volatile m2 serviceDescriptor;

    public interface AsyncService {
        default v initAppDevices(v vVar) {
            b9.b(IIotcardProviderGrpc.getInitAppDevicesMethod(), vVar);
            return new a0();
        }

        default void initPort(Port port, v vVar) {
            b9.b(IIotcardProviderGrpc.getInitPortMethod(), vVar);
        }

        default void registerDevice(IotcardBean iotcardBean, v vVar) {
            b9.b(IIotcardProviderGrpc.getRegisterDeviceMethod(), vVar);
        }

        default void registerDeviceList(IotcardList iotcardList, v vVar) {
            b9.b(IIotcardProviderGrpc.getRegisterDeviceListMethod(), vVar);
        }

        default void switchClick(PackageName packageName, v vVar) {
            b9.b(IIotcardProviderGrpc.getSwitchClickMethod(), vVar);
        }

        default void unRegisterDeviceList(IotcardList iotcardList, v vVar) {
            b9.b(IIotcardProviderGrpc.getUnRegisterDeviceListMethod(), vVar);
        }

        default void unregisterDevice(IotcardBean iotcardBean, v vVar) {
            b9.b(IIotcardProviderGrpc.getUnregisterDeviceMethod(), vVar);
        }

        default void updateDevice(IotcardBean iotcardBean, v vVar) {
            b9.b(IIotcardProviderGrpc.getUpdateDeviceMethod(), vVar);
        }

        default void updateDeviceList(IotcardList iotcardList, v vVar) {
            b9.b(IIotcardProviderGrpc.getUpdateDeviceListMethod(), vVar);
        }
    }

    public static final class IIotcardProviderBlockingStub extends b {
        private IIotcardProviderBlockingStub(g gVar, f fVar) {
            super(gVar, fVar);
        }

        public Empty initPort(Port port) {
            return (Empty) n.c(getChannel(), IIotcardProviderGrpc.getInitPortMethod(), getCallOptions(), port);
        }

        public Empty registerDevice(IotcardBean iotcardBean) {
            return (Empty) n.c(getChannel(), IIotcardProviderGrpc.getRegisterDeviceMethod(), getCallOptions(), iotcardBean);
        }

        public Empty registerDeviceList(IotcardList iotcardList) {
            return (Empty) n.c(getChannel(), IIotcardProviderGrpc.getRegisterDeviceListMethod(), getCallOptions(), iotcardList);
        }

        public Iterator<SwitchClickAction> switchClick(PackageName packageName) {
            g channel = getChannel();
            r1 switchClickMethod = IIotcardProviderGrpc.getSwitchClickMethod();
            f callOptions = getCallOptions();
            Logger logger = n.f5317a;
            m mVar = new m();
            d dVarB = f.b(callOptions.e(n.f5319c, l.BLOCKING));
            dVarB.f11336b = mVar;
            j jVarE = channel.e(switchClickMethod, new f(dVarB));
            hf.g gVar = new hf.g(jVarE, mVar);
            n.b(jVarE, packageName, (hf.f) gVar.f5304d);
            return gVar;
        }

        public Empty unRegisterDeviceList(IotcardList iotcardList) {
            return (Empty) n.c(getChannel(), IIotcardProviderGrpc.getUnRegisterDeviceListMethod(), getCallOptions(), iotcardList);
        }

        public Empty unregisterDevice(IotcardBean iotcardBean) {
            return (Empty) n.c(getChannel(), IIotcardProviderGrpc.getUnregisterDeviceMethod(), getCallOptions(), iotcardBean);
        }

        public Empty updateDevice(IotcardBean iotcardBean) {
            return (Empty) n.c(getChannel(), IIotcardProviderGrpc.getUpdateDeviceMethod(), getCallOptions(), iotcardBean);
        }

        public Empty updateDeviceList(IotcardList iotcardList) {
            return (Empty) n.c(getChannel(), IIotcardProviderGrpc.getUpdateDeviceListMethod(), getCallOptions(), iotcardList);
        }

        @Override // hf.e
        public IIotcardProviderBlockingStub build(g gVar, f fVar) {
            return new IIotcardProviderBlockingStub(gVar, fVar);
        }
    }

    public static final class IIotcardProviderFutureStub extends c {
        private IIotcardProviderFutureStub(g gVar, f fVar) {
            super(gVar, fVar);
        }

        public m4.l initPort(Port port) {
            return n.e(getChannel().e(IIotcardProviderGrpc.getInitPortMethod(), getCallOptions()), port);
        }

        public m4.l registerDevice(IotcardBean iotcardBean) {
            return n.e(getChannel().e(IIotcardProviderGrpc.getRegisterDeviceMethod(), getCallOptions()), iotcardBean);
        }

        public m4.l registerDeviceList(IotcardList iotcardList) {
            return n.e(getChannel().e(IIotcardProviderGrpc.getRegisterDeviceListMethod(), getCallOptions()), iotcardList);
        }

        public m4.l unRegisterDeviceList(IotcardList iotcardList) {
            return n.e(getChannel().e(IIotcardProviderGrpc.getUnRegisterDeviceListMethod(), getCallOptions()), iotcardList);
        }

        public m4.l unregisterDevice(IotcardBean iotcardBean) {
            return n.e(getChannel().e(IIotcardProviderGrpc.getUnregisterDeviceMethod(), getCallOptions()), iotcardBean);
        }

        public m4.l updateDevice(IotcardBean iotcardBean) {
            return n.e(getChannel().e(IIotcardProviderGrpc.getUpdateDeviceMethod(), getCallOptions()), iotcardBean);
        }

        public m4.l updateDeviceList(IotcardList iotcardList) {
            return n.e(getChannel().e(IIotcardProviderGrpc.getUpdateDeviceListMethod(), getCallOptions()), iotcardList);
        }

        @Override // hf.e
        public IIotcardProviderFutureStub build(g gVar, f fVar) {
            return new IIotcardProviderFutureStub(gVar, fVar);
        }
    }

    public static abstract class IIotcardProviderImplBase implements AsyncService {
        public final l2 bindService() {
            return IIotcardProviderGrpc.bindService(this);
        }
    }

    public static final class IIotcardProviderStub extends a {
        private IIotcardProviderStub(g gVar, f fVar) {
            super(gVar, fVar);
        }

        public v initAppDevices(v vVar) {
            j jVarE = getChannel().e(IIotcardProviderGrpc.getInitAppDevicesMethod(), getCallOptions());
            Logger logger = n.f5317a;
            v8.i(vVar, "responseObserver");
            h hVar = new h(jVarE, true);
            k kVar = new k(vVar, hVar);
            jVarE.f(kVar, new p1());
            kVar.n();
            return hVar;
        }

        public void initPort(Port port, v vVar) {
            n.a(getChannel().e(IIotcardProviderGrpc.getInitPortMethod(), getCallOptions()), port, vVar);
        }

        public void registerDevice(IotcardBean iotcardBean, v vVar) {
            n.a(getChannel().e(IIotcardProviderGrpc.getRegisterDeviceMethod(), getCallOptions()), iotcardBean, vVar);
        }

        public void registerDeviceList(IotcardList iotcardList, v vVar) {
            n.a(getChannel().e(IIotcardProviderGrpc.getRegisterDeviceListMethod(), getCallOptions()), iotcardList, vVar);
        }

        public void switchClick(PackageName packageName, v vVar) {
            j jVarE = getChannel().e(IIotcardProviderGrpc.getSwitchClickMethod(), getCallOptions());
            Logger logger = n.f5317a;
            v8.i(vVar, "responseObserver");
            n.b(jVarE, packageName, new k(vVar, new h(jVarE, true)));
        }

        public void unRegisterDeviceList(IotcardList iotcardList, v vVar) {
            n.a(getChannel().e(IIotcardProviderGrpc.getUnRegisterDeviceListMethod(), getCallOptions()), iotcardList, vVar);
        }

        public void unregisterDevice(IotcardBean iotcardBean, v vVar) {
            n.a(getChannel().e(IIotcardProviderGrpc.getUnregisterDeviceMethod(), getCallOptions()), iotcardBean, vVar);
        }

        public void updateDevice(IotcardBean iotcardBean, v vVar) {
            n.a(getChannel().e(IIotcardProviderGrpc.getUpdateDeviceMethod(), getCallOptions()), iotcardBean, vVar);
        }

        public void updateDeviceList(IotcardList iotcardList, v vVar) {
            n.a(getChannel().e(IIotcardProviderGrpc.getUpdateDeviceListMethod(), getCallOptions()), iotcardList, vVar);
        }

        @Override // hf.e
        public IIotcardProviderStub build(g gVar, f fVar) {
            return new IIotcardProviderStub(gVar, fVar);
        }
    }

    private IIotcardProviderGrpc() {
    }

    public static final l2 bindService(AsyncService asyncService) {
        u6.a aVar = new u6.a(getServiceDescriptor());
        aVar.u(getRegisterDeviceMethod(), b9.a(new MethodHandlers(asyncService, 0)));
        aVar.u(getRegisterDeviceListMethod(), b9.a(new MethodHandlers(asyncService, 1)));
        aVar.u(getUnregisterDeviceMethod(), b9.a(new MethodHandlers(asyncService, 2)));
        aVar.u(getUnRegisterDeviceListMethod(), b9.a(new MethodHandlers(asyncService, 3)));
        aVar.u(getUpdateDeviceMethod(), b9.a(new MethodHandlers(asyncService, 4)));
        aVar.u(getUpdateDeviceListMethod(), b9.a(new MethodHandlers(asyncService, 5)));
        aVar.u(getInitAppDevicesMethod(), new x(new MethodHandlers(asyncService, 8)));
        aVar.u(getSwitchClickMethod(), new u(new MethodHandlers(asyncService, 6), true));
        aVar.u(getInitPortMethod(), b9.a(new MethodHandlers(asyncService, 7)));
        return aVar.w();
    }

    public static r1 getInitAppDevicesMethod() {
        r1 r1VarH = getInitAppDevicesMethod;
        if (r1VarH == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    r1VarH = getInitAppDevicesMethod;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.BIDI_STREAMING;
                        bVarB.e = r1.a("IIotcardProvider", "initAppDevices");
                        bVarB.f4714a = true;
                        IotcardListMap defaultInstance = IotcardListMap.getDefaultInstance();
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(defaultInstance);
                        bVarB.f4716c = new gf.b(Empty.getDefaultInstance());
                        r1VarH = bVarB.h();
                        getInitAppDevicesMethod = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }

    public static r1 getInitPortMethod() {
        r1 r1VarH = getInitPortMethod;
        if (r1VarH == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    r1VarH = getInitPortMethod;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.UNARY;
                        bVarB.e = r1.a("IIotcardProvider", "initPort");
                        bVarB.f4714a = true;
                        Port defaultInstance = Port.getDefaultInstance();
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(defaultInstance);
                        bVarB.f4716c = new gf.b(Empty.getDefaultInstance());
                        r1VarH = bVarB.h();
                        getInitPortMethod = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }

    public static r1 getRegisterDeviceListMethod() {
        r1 r1VarH = getRegisterDeviceListMethod;
        if (r1VarH == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    r1VarH = getRegisterDeviceListMethod;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.UNARY;
                        bVarB.e = r1.a("IIotcardProvider", "RegisterDeviceList");
                        bVarB.f4714a = true;
                        IotcardList defaultInstance = IotcardList.getDefaultInstance();
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(defaultInstance);
                        bVarB.f4716c = new gf.b(Empty.getDefaultInstance());
                        r1VarH = bVarB.h();
                        getRegisterDeviceListMethod = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }

    public static r1 getRegisterDeviceMethod() {
        r1 r1VarH = getRegisterDeviceMethod;
        if (r1VarH == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    r1VarH = getRegisterDeviceMethod;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.UNARY;
                        bVarB.e = r1.a("IIotcardProvider", "RegisterDevice");
                        bVarB.f4714a = true;
                        IotcardBean defaultInstance = IotcardBean.getDefaultInstance();
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(defaultInstance);
                        bVarB.f4716c = new gf.b(Empty.getDefaultInstance());
                        r1VarH = bVarB.h();
                        getRegisterDeviceMethod = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }

    public static m2 getServiceDescriptor() {
        m2 m2Var = serviceDescriptor;
        if (m2Var == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    m2Var = serviceDescriptor;
                    if (m2Var == null) {
                        tc.d dVarA = m2.a("IIotcardProvider");
                        dVarA.f(getRegisterDeviceMethod());
                        dVarA.f(getRegisterDeviceListMethod());
                        dVarA.f(getUnregisterDeviceMethod());
                        dVarA.f(getUnRegisterDeviceListMethod());
                        dVarA.f(getUpdateDeviceMethod());
                        dVarA.f(getUpdateDeviceListMethod());
                        dVarA.f(getInitAppDevicesMethod());
                        dVarA.f(getSwitchClickMethod());
                        dVarA.f(getInitPortMethod());
                        m2 m2Var2 = new m2(dVarA);
                        serviceDescriptor = m2Var2;
                        m2Var = m2Var2;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return m2Var;
    }

    public static r1 getSwitchClickMethod() {
        r1 r1VarH = getSwitchClickMethod;
        if (r1VarH == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    r1VarH = getSwitchClickMethod;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.SERVER_STREAMING;
                        bVarB.e = r1.a("IIotcardProvider", "SwitchClick");
                        bVarB.f4714a = true;
                        PackageName defaultInstance = PackageName.getDefaultInstance();
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(defaultInstance);
                        bVarB.f4716c = new gf.b(SwitchClickAction.getDefaultInstance());
                        r1VarH = bVarB.h();
                        getSwitchClickMethod = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }

    public static r1 getUnRegisterDeviceListMethod() {
        r1 r1VarH = getUnRegisterDeviceListMethod;
        if (r1VarH == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    r1VarH = getUnRegisterDeviceListMethod;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.UNARY;
                        bVarB.e = r1.a("IIotcardProvider", "UnRegisterDeviceList");
                        bVarB.f4714a = true;
                        IotcardList defaultInstance = IotcardList.getDefaultInstance();
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(defaultInstance);
                        bVarB.f4716c = new gf.b(Empty.getDefaultInstance());
                        r1VarH = bVarB.h();
                        getUnRegisterDeviceListMethod = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }

    public static r1 getUnregisterDeviceMethod() {
        r1 r1VarH = getUnregisterDeviceMethod;
        if (r1VarH == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    r1VarH = getUnregisterDeviceMethod;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.UNARY;
                        bVarB.e = r1.a("IIotcardProvider", "UnregisterDevice");
                        bVarB.f4714a = true;
                        IotcardBean defaultInstance = IotcardBean.getDefaultInstance();
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(defaultInstance);
                        bVarB.f4716c = new gf.b(Empty.getDefaultInstance());
                        r1VarH = bVarB.h();
                        getUnregisterDeviceMethod = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }

    public static r1 getUpdateDeviceListMethod() {
        r1 r1VarH = getUpdateDeviceListMethod;
        if (r1VarH == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    r1VarH = getUpdateDeviceListMethod;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.UNARY;
                        bVarB.e = r1.a("IIotcardProvider", "UpdateDeviceList");
                        bVarB.f4714a = true;
                        IotcardList defaultInstance = IotcardList.getDefaultInstance();
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(defaultInstance);
                        bVarB.f4716c = new gf.b(Empty.getDefaultInstance());
                        r1VarH = bVarB.h();
                        getUpdateDeviceListMethod = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }

    public static r1 getUpdateDeviceMethod() {
        r1 r1VarH = getUpdateDeviceMethod;
        if (r1VarH == null) {
            synchronized (IIotcardProviderGrpc.class) {
                try {
                    r1VarH = getUpdateDeviceMethod;
                    if (r1VarH == null) {
                        e8.b bVarB = r1.b();
                        bVarB.f4717d = q1.UNARY;
                        bVarB.e = r1.a("IIotcardProvider", "UpdateDevice");
                        bVarB.f4714a = true;
                        IotcardBean defaultInstance = IotcardBean.getDefaultInstance();
                        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
                        bVarB.f4715b = new gf.b(defaultInstance);
                        bVarB.f4716c = new gf.b(Empty.getDefaultInstance());
                        r1VarH = bVarB.h();
                        getUpdateDeviceMethod = r1VarH;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return r1VarH;
    }

    public static IIotcardProviderBlockingStub newBlockingStub(g gVar) {
        return (IIotcardProviderBlockingStub) b.newStub(new hf.d() { // from class: com.transsion.iotservice.iotcard.proto.IIotcardProviderGrpc.2
            @Override // hf.d
            public IIotcardProviderBlockingStub newStub(g gVar2, f fVar) {
                return new IIotcardProviderBlockingStub(gVar2, fVar);
            }
        }, gVar);
    }

    public static IIotcardProviderFutureStub newFutureStub(g gVar) {
        return (IIotcardProviderFutureStub) c.newStub(new hf.d() { // from class: com.transsion.iotservice.iotcard.proto.IIotcardProviderGrpc.3
            @Override // hf.d
            public IIotcardProviderFutureStub newStub(g gVar2, f fVar) {
                return new IIotcardProviderFutureStub(gVar2, fVar);
            }
        }, gVar);
    }

    public static IIotcardProviderStub newStub(g gVar) {
        return (IIotcardProviderStub) a.newStub(new hf.d() { // from class: com.transsion.iotservice.iotcard.proto.IIotcardProviderGrpc.1
            @Override // hf.d
            public IIotcardProviderStub newStub(g gVar2, f fVar) {
                return new IIotcardProviderStub(gVar2, fVar);
            }
        }, gVar);
    }

    public static final class MethodHandlers<Req, Resp> implements r, s, p {
        private final int methodId;
        private final AsyncService serviceImpl;

        public MethodHandlers(AsyncService asyncService, int i8) {
            this.serviceImpl = asyncService;
            this.methodId = i8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // hf.s
        public void invoke(Req req, v vVar) {
            switch (this.methodId) {
                case 0:
                    this.serviceImpl.registerDevice((IotcardBean) req, vVar);
                    return;
                case 1:
                    this.serviceImpl.registerDeviceList((IotcardList) req, vVar);
                    return;
                case 2:
                    this.serviceImpl.unregisterDevice((IotcardBean) req, vVar);
                    return;
                case 3:
                    this.serviceImpl.unRegisterDeviceList((IotcardList) req, vVar);
                    return;
                case 4:
                    this.serviceImpl.updateDevice((IotcardBean) req, vVar);
                    return;
                case 5:
                    this.serviceImpl.updateDeviceList((IotcardList) req, vVar);
                    return;
                case 6:
                    this.serviceImpl.switchClick((PackageName) req, vVar);
                    return;
                case 7:
                    this.serviceImpl.initPort((Port) req, vVar);
                    return;
                default:
                    throw new AssertionError();
            }
        }

        @Override // hf.p
        public v invoke(v vVar) {
            if (this.methodId == 8) {
                return this.serviceImpl.initAppDevices(vVar);
            }
            throw new AssertionError();
        }
    }
}
