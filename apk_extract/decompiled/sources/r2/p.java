package r2;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzj;

/* JADX INFO: loaded from: classes.dex */
public final class p implements q3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f9354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f9356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9357d;
    public final long e;

    public p(c cVar, int i8, a aVar, long j8, long j10) {
        this.f9354a = cVar;
        this.f9355b = i8;
        this.f9356c = aVar;
        this.f9357d = j8;
        this.e = j10;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0031 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0032 A[RETURN] */
    public static ConnectionTelemetryConfiguration b(l lVar, com.google.android.gms.common.internal.a aVar, int i8) {
        zzj zzjVar = aVar.f1892w;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar == null ? null : zzjVar.f1911d;
        if (connectionTelemetryConfiguration != null && connectionTelemetryConfiguration.f1844b) {
            int[] iArr = connectionTelemetryConfiguration.f1846d;
            int i9 = 0;
            if (iArr == null) {
                int[] iArr2 = connectionTelemetryConfiguration.f1847h;
                if (iArr2 != null) {
                    int length = iArr2.length;
                    while (i9 < length) {
                        if (iArr2[i9] != i8) {
                            i9++;
                        }
                    }
                }
                if (lVar.f9349m < connectionTelemetryConfiguration.e) {
                    return connectionTelemetryConfiguration;
                }
                return null;
            }
            int length2 = iArr.length;
            while (i9 < length2) {
                if (iArr[i9] == i8) {
                    if (lVar.f9349m < connectionTelemetryConfiguration.e) {
                        return connectionTelemetryConfiguration;
                    }
                    return null;
                }
                i9++;
            }
        }
        return null;
    }

    @Override // q3.b
    public final void a(q3.f fVar) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long jCurrentTimeMillis;
        long j8;
        int iElapsedRealtime;
        if (this.f9354a.a()) {
            RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) u2.e.b().f10334a;
            if (rootTelemetryConfiguration == null || rootTelemetryConfiguration.f1870b) {
                l lVar = (l) this.f9354a.f9331l.get(this.f9356c);
                if (lVar != null) {
                    q2.c cVar = lVar.f9341c;
                    if (cVar instanceof com.google.android.gms.common.internal.a) {
                        com.google.android.gms.common.internal.a aVar = (com.google.android.gms.common.internal.a) cVar;
                        boolean z2 = this.f9357d > 0;
                        int i13 = aVar.f1888r;
                        if (rootTelemetryConfiguration != null) {
                            z2 &= rootTelemetryConfiguration.f1871c;
                            int i14 = rootTelemetryConfiguration.f1872d;
                            int i15 = rootTelemetryConfiguration.e;
                            i8 = rootTelemetryConfiguration.f1869a;
                            if (aVar.f1892w != null && !aVar.a()) {
                                ConnectionTelemetryConfiguration connectionTelemetryConfigurationB = b(lVar, aVar, this.f9355b);
                                if (connectionTelemetryConfigurationB == null) {
                                    return;
                                }
                                boolean z3 = connectionTelemetryConfigurationB.f1845c && this.f9357d > 0;
                                i15 = connectionTelemetryConfigurationB.e;
                                z2 = z3;
                            }
                            i10 = i14;
                            i9 = i15;
                        } else {
                            i8 = 0;
                            i9 = 100;
                            i10 = 5000;
                        }
                        c cVar2 = this.f9354a;
                        if (fVar.d()) {
                            i11 = 0;
                            i12 = 0;
                        } else {
                            if (((q3.k) fVar).f8960d) {
                                i11 = 100;
                            } else {
                                Exception excA = fVar.a();
                                if (excA instanceof q2.d) {
                                    Status status = ((q2.d) excA).getStatus();
                                    int i16 = status.f1819b;
                                    ConnectionResult connectionResult = status.e;
                                    i12 = connectionResult == null ? -1 : connectionResult.f1798b;
                                    i11 = i16;
                                } else {
                                    i11 = 101;
                                }
                            }
                            i12 = -1;
                        }
                        if (z2) {
                            long j10 = this.f9357d;
                            jCurrentTimeMillis = System.currentTimeMillis();
                            j8 = j10;
                            iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.e);
                        } else {
                            jCurrentTimeMillis = 0;
                            j8 = 0;
                            iElapsedRealtime = -1;
                        }
                        h3.e eVar = cVar2.f9334o;
                        eVar.sendMessage(eVar.obtainMessage(18, new q(new MethodInvocation(this.f9355b, i11, i12, j8, jCurrentTimeMillis, null, null, i13, iElapsedRealtime), i8, i10, i9)));
                    }
                }
            }
        }
    }
}
