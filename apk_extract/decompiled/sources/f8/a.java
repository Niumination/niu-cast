package f8;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.iotcardsdk.bean.DeviceType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mg.a0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile a f4992j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f4993a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4996d;
    public String e;
    public String f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f4999i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4997g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4998h = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4994b = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public a() throws Throwable {
        String processName;
        Exception e;
        String str = "";
        this.e = "";
        this.f = "";
        this.f4993a = new ConcurrentHashMap();
        this.f4996d = 86400000L;
        StringBuilder sb2 = new StringBuilder("gslb_");
        Context context = c.f5001b;
        ObjectLogUtils objectLogUtils = e.f5006a;
        ?? r7 = 0;
        r7 = 0;
        FileInputStream fileInputStream = null;
        try {
            processName = Application.getProcessName();
        } catch (Exception e4) {
            e4.printStackTrace();
            processName = null;
        }
        sb2.append(TextUtils.isEmpty(processName) ? context.getPackageName() : processName);
        String string = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(c.f5001b.getFilesDir().getPath());
        String strN = h0.a.n(sb3, File.separator, string);
        this.f4999i = strN;
        File file = new File(strN);
        ObjectLogUtils objectLogUtils2 = e.f5006a;
        try {
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[fileInputStream2.available()];
                        fileInputStream2.read(bArr);
                        String str2 = new String(bArr);
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        str = str2;
                        r7 = str2;
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream = fileInputStream2;
                        e.f5006a.e(Log.getStackTraceString(e));
                        str = str;
                        r7 = fileInputStream;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                str = str;
                                r7 = fileInputStream;
                            } catch (IOException unused2) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r7 = fileInputStream2;
                        if (r7 != 0) {
                            try {
                                r7.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } else {
                    str = str;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
        String[] strArrSplit = str.split("&");
        if (strArrSplit.length >= 4) {
            try {
                String str3 = strArrSplit[0];
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
                if (str3 != null && str3.length() != 0) {
                    for (String str4 : str3.split(",")) {
                        String[] strArrSplit2 = str4.split("#");
                        if (strArrSplit2.length == 2) {
                            concurrentHashMap.put(strArrSplit2[0], strArrSplit2[1]);
                        }
                    }
                }
                this.f4993a = concurrentHashMap;
                this.e = strArrSplit[1];
                this.f4996d = Long.parseLong(strArrSplit[2]);
                this.f4995c = Long.parseLong(strArrSplit[3]);
                this.f = strArrSplit[4];
            } catch (Throwable unused4) {
            }
        }
        if (this.f4993a.size() == 0) {
            this.f4993a.put("dsu.shalltry.com", "blank");
            this.f4993a.put("dsc.shalltry.com", "blank");
            this.f4993a.put("api.twibida.com", "blank");
        }
        a();
    }

    public static a c() {
        if (f4992j == null) {
            synchronized (a.class) {
                try {
                    if (f4992j == null) {
                        f4992j = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f4992j;
    }

    public static boolean d(String str) {
        return (TextUtils.isEmpty(str) || str.equals("blank")) ? false : true;
    }

    public final void a() {
        f fVar;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(this.f4997g - jCurrentTimeMillis) > 86400000) {
            this.f4998h = 0L;
        }
        long j8 = this.f4995c;
        if (j8 <= 0 || Math.abs(jCurrentTimeMillis - j8) <= this.f4996d) {
            return;
        }
        long j10 = this.f4998h;
        if (j10 == 0) {
            this.f4997g = jCurrentTimeMillis;
        }
        if (j10 < 4 && (fVar = c.f5000a) != null) {
            fVar.c();
            if (!fVar.f5008a.hasMessages(DeviceType.INFRARED_TV_BOX)) {
                fVar.f5008a.sendEmptyMessageDelayed(DeviceType.INFRARED_TV_BOX, 100L);
            }
        }
        this.f4998h++;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f4993a.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    public final void e() {
        ArrayList<d> arrayList = this.f4994b;
        try {
            for (d dVar : arrayList) {
                dVar.getClass();
                b bVar = dVar.f5003b;
                if (bVar != null) {
                    boolean z2 = false;
                    for (String str : dVar.f5002a) {
                        if (!TextUtils.isEmpty(str) && !d((String) this.f4993a.get(str))) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        bVar.onInitFail();
                    } else if (!TextUtils.isEmpty(this.f)) {
                        bVar.onInitSuccess(new HashMap(this.f4993a));
                    }
                } else {
                    String str2 = dVar.f5004c;
                    if (str2 != null && dVar.f5005d != null) {
                        String strA = e.a(str2);
                        String str3 = (String) this.f4993a.get(strA);
                        if (d(str3)) {
                            str2.replace(strA, str3);
                        }
                    }
                }
            }
            arrayList.clear();
        } catch (Exception e) {
            e.printStackTrace();
            for (d dVar2 : arrayList) {
                dVar2.getClass();
                b bVar2 = dVar2.f5003b;
                if (bVar2 != null) {
                    bVar2.onInitFail();
                } else if (dVar2.f5004c != null) {
                    a0 a0Var = dVar2.f5005d;
                }
            }
            arrayList.clear();
        }
    }

    public final void f() {
        ArrayList<d> arrayList = this.f4994b;
        try {
            ArrayList arrayList2 = new ArrayList();
            for (d dVar : arrayList) {
                dVar.getClass();
                if (dVar.f5003b != null) {
                    arrayList2.add(dVar);
                } else if (dVar.f5004c != null) {
                    a0 a0Var = dVar.f5005d;
                }
            }
            arrayList.clear();
            arrayList.addAll(arrayList2);
        } catch (Exception e) {
            e.printStackTrace();
            for (d dVar2 : arrayList) {
                dVar2.getClass();
                b bVar = dVar2.f5003b;
                if (bVar != null) {
                    bVar.onInitFail();
                } else if (dVar2.f5004c != null) {
                    a0 a0Var2 = dVar2.f5005d;
                }
            }
            arrayList.clear();
        }
    }

    public final void g() throws Throwable {
        String string;
        StringBuilder sb2 = new StringBuilder();
        ConcurrentHashMap concurrentHashMap = this.f4993a;
        ObjectLogUtils objectLogUtils = e.f5006a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            string = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                sb3.append((String) entry.getKey());
                sb3.append("#");
                sb3.append((String) entry.getValue());
                sb3.append(",");
            }
            string = sb3.toString();
        }
        sb2.append(string);
        sb2.append("&");
        sb2.append(this.e);
        sb2.append("&");
        sb2.append(this.f4996d);
        sb2.append("&");
        sb2.append(this.f4995c);
        sb2.append("&");
        sb2.append(this.f);
        String string2 = sb2.toString();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.f4999i);
                    try {
                        fileOutputStream2.write(string2.getBytes());
                        fileOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        e.f5006a.e(Log.getStackTraceString(e));
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (IOException unused2) {
        }
    }
}
