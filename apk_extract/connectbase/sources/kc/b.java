package kc;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.usage.ITranAppUsageStatsCallback;
import com.transsion.hubsdk.app.usage.ITranUsageStatsManager;
import com.transsion.hubsdk.app.usage.TranAppUsage;
import com.transsion.hubsdk.app.usage.TranBatteryUsage;
import com.transsion.hubsdk.app.usage.TranUidConsumer;
import com.transsion.hubsdk.app.usage.TranUsageStats;
import j9.c;
import j9.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements df.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9170d = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranUsageStatsManager f9171a = ITranUsageStatsManager.Stub.asInterface(TranServiceManager.getServiceIBinder("usagestats"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranUsageStats f9172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ITranAppUsageStatsCallback f9173c;

    public class a extends ITranAppUsageStatsCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.b f9174a;

        public a(e.b bVar) {
            this.f9174a = bVar;
        }

        public void a(ComponentName componentName, int i10, int i11, int i12, ComponentName componentName2) {
            if (this.f9174a != null) {
                dc.e.f(b.f9170d, "onReportEvent component = " + componentName + ", userId = " + i10 + ", eventType = " + i11 + ", instanceId = " + i12 + ", taskRoot = " + componentName2);
                this.f9174a.a(componentName, i10, i11, i12, componentName2);
            }
        }
    }

    @Override // df.b
    public long a() {
        try {
            ITranUsageStatsManager iTranUsageStatsManager = this.f9171a;
            if (iTranUsageStatsManager != null) {
                return iTranUsageStatsManager.getLastFullChargeTime();
            }
            return 0L;
        } catch (RemoteException e10) {
            j7.b.a("getLastFullChargeTime failed: ", e10, f9170d);
            return 0L;
        }
    }

    @Override // df.b
    public int b(UsageStats usageStats) {
        return k().getAppLaunchCount(usageStats);
    }

    @Override // df.b
    public UsageEvents c(long j10, long j11, int i10, String str, String str2) {
        ITranUsageStatsManager iTranUsageStatsManager = this.f9171a;
        if (iTranUsageStatsManager == null) {
            return null;
        }
        try {
            return iTranUsageStatsManager.queryEventsForPackageForUser(j10, j11, i10, str, str2);
        } catch (RemoteException e10) {
            dc.e.n(f9170d, "queryEventsForPackageForUser e = " + e10);
            return null;
        }
    }

    @Override // df.b
    public void d(e.b bVar) {
        if (this.f9173c != null) {
            dc.e.c(f9170d, "registerTranAppUsageStatsCallback fail,  reason : repeat register !!! ");
            return;
        }
        a aVar = new a(bVar);
        this.f9173c = aVar;
        l(aVar);
    }

    @Override // df.b
    public Bundle e() {
        try {
            ITranUsageStatsManager iTranUsageStatsManager = this.f9171a;
            if (iTranUsageStatsManager != null) {
                return iTranUsageStatsManager.getUidPackageMap();
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getUidPackageMap failed: ", e10, f9170d);
            return null;
        }
    }

    @Override // df.b
    public List<j9.b> f(long j10) {
        try {
            if (this.f9171a != null) {
                ArrayList arrayList = new ArrayList();
                for (TranBatteryUsage tranBatteryUsage : this.f9171a.getBatteryLevelWithTime(j10).getList()) {
                    arrayList.add(new j9.b(tranBatteryUsage.mTimeStamp, tranBatteryUsage.mBatteryLevel, tranBatteryUsage.mScreenOnTime));
                }
                return arrayList;
            }
        } catch (RemoteException e10) {
            j7.b.a("getAppUsageWithtime failed: ", e10, f9170d);
        }
        return Collections.emptyList();
    }

    @Override // df.b
    public UsageEvents g(long j10, long j11, int i10, String str) {
        try {
            ITranUsageStatsManager iTranUsageStatsManager = this.f9171a;
            if (iTranUsageStatsManager != null) {
                return iTranUsageStatsManager.queryEventsForUser(j10, j11, i10, str);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("queryEventsForUser failed: ", e10, f9170d);
            return null;
        }
    }

    @Override // df.b
    public List<j9.a> h(long j10) {
        try {
            if (this.f9171a != null) {
                ArrayList arrayList = new ArrayList();
                for (TranAppUsage tranAppUsage : this.f9171a.getAppUsageWithtime(j10).getList()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (TranUidConsumer tranUidConsumer : tranAppUsage.getUidConsumer()) {
                        arrayList2.add(new c(tranUidConsumer.mUid, tranUidConsumer.mForeground, tranUidConsumer.mBackground, tranUidConsumer.mConsumer));
                    }
                    arrayList.add(new j9.a(tranAppUsage.mTimeStamp, tranAppUsage.mIsReset, arrayList2));
                }
                return arrayList;
            }
        } catch (RemoteException e10) {
            j7.b.a("getAppUsageWithtime failed: ", e10, f9170d);
        }
        return Collections.emptyList();
    }

    @Override // df.b
    public void i() {
        try {
            dc.e.f(f9170d, "unRegisterTranAppUsageStatsCallback pid = " + Process.myPid());
            ITranUsageStatsManager iTranUsageStatsManager = this.f9171a;
            if (iTranUsageStatsManager != null) {
                iTranUsageStatsManager.unRegisterTranAppUsageStatsCallback();
            }
            this.f9173c = null;
        } catch (RemoteException e10) {
            dc.e.c(f9170d, "unRegisterTranAppUsageStatsCallback fail re = " + e10);
            throw e10.rethrowFromSystemServer();
        }
    }

    public final TranUsageStats k() {
        if (this.f9172b == null) {
            this.f9172b = new TranUsageStats();
        }
        return this.f9172b;
    }

    public final void l(ITranAppUsageStatsCallback iTranAppUsageStatsCallback) {
        try {
            dc.e.f(f9170d, "registerTranAppUsageStatsCallback callback = " + iTranAppUsageStatsCallback);
            ITranUsageStatsManager iTranUsageStatsManager = this.f9171a;
            if (iTranUsageStatsManager != null) {
                iTranUsageStatsManager.registerTranAppUsageStatsCallback(iTranAppUsageStatsCallback);
            }
        } catch (RemoteException e10) {
            dc.e.c(f9170d, "registerTranAppUsageStatsCallback fail re = " + e10);
            throw e10.rethrowFromSystemServer();
        }
    }

    @VisibleForTesting
    public void m(ITranUsageStatsManager iTranUsageStatsManager) {
        this.f9171a = iTranUsageStatsManager;
    }
}
