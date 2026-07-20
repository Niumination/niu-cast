package f6;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5877c = "SharedPreferencesUtil";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5879e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f5880f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5881g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f5882h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f5883i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f5887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f5888b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<String, h> f5878d = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<String> f5884j = new HashSet(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f5885k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Context f5886l = null;

    public h(String str) {
        Context context = f5886l;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            this.f5887a = sharedPreferences;
            if (sharedPreferences != null) {
                this.f5888b = sharedPreferences.edit();
            }
        }
    }

    public static void a(@NonNull Context context) {
        f5886l = context;
    }

    public static synchronized h j(String str) {
        h hVar;
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("please make sure you have valid file name");
        }
        hVar = f5878d.get(str);
        if (hVar == null) {
            hVar = new h(str);
            f5878d.put(str, hVar);
        }
        return hVar;
    }

    public void A(String str, long j10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putLong(str, j10);
        this.f5888b.apply();
    }

    public void B(String str, long j10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putLong(str, j10);
        this.f5888b.commit();
    }

    /* JADX INFO: Removed unreachable split cross block B:39:0x0066 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public void C(String str, Serializable serializable) throws Throwable {
        if (serializable == null || TextUtils.isEmpty(str) || this.f5888b == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r10 = 0;
        ObjectOutputStream objectOutputStream = null;
        r10 = 0;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    objectOutputStream2.writeObject(null);
                    String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0), "UTF-8");
                    SharedPreferences.Editor editor = this.f5888b;
                    editor.putString(str, str2);
                    this.f5888b.apply();
                    byteArrayOutputStream.close();
                    objectOutputStream2.close();
                    r10 = editor;
                } catch (IOException e10) {
                    e = e10;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                    byteArrayOutputStream.close();
                    r10 = objectOutputStream;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                        r10 = objectOutputStream;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r10 = objectOutputStream2;
                    try {
                        byteArrayOutputStream.close();
                        if (r10 != 0) {
                            r10.close();
                        }
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e12) {
                e = e12;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:39:0x0066 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public void D(String str, Serializable serializable) throws Throwable {
        if (serializable == null || TextUtils.isEmpty(str) || this.f5888b == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r10 = 0;
        ObjectOutputStream objectOutputStream = null;
        r10 = 0;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    objectOutputStream2.writeObject(null);
                    String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0), "UTF-8");
                    SharedPreferences.Editor editor = this.f5888b;
                    editor.putString(str, str2);
                    this.f5888b.commit();
                    byteArrayOutputStream.close();
                    objectOutputStream2.close();
                    r10 = editor;
                } catch (IOException e10) {
                    e = e10;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                    byteArrayOutputStream.close();
                    r10 = objectOutputStream;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                        r10 = objectOutputStream;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r10 = objectOutputStream2;
                    try {
                        byteArrayOutputStream.close();
                        if (r10 != 0) {
                            r10.close();
                        }
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e12) {
                e = e12;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        }
    }

    public void E(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putString(str, str2);
        this.f5888b.apply();
    }

    public void F(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putString(str, str2);
        this.f5888b.commit();
    }

    public void G(String str, Set<String> set) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putStringSet(str, set);
        this.f5888b.apply();
    }

    public void H(String str, Set<String> set) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putStringSet(str, set);
        this.f5888b.commit();
    }

    public void I(String str) {
        SharedPreferences.Editor editor = this.f5888b;
        if (editor != null) {
            editor.remove(str);
            this.f5888b.apply();
        }
    }

    public void J(String str) {
        SharedPreferences.Editor editor = this.f5888b;
        if (editor != null) {
            editor.remove(str);
            this.f5888b.commit();
        }
    }

    public void b() {
        SharedPreferences.Editor editor = this.f5888b;
        if (editor != null) {
            editor.clear();
            this.f5888b.apply();
        }
    }

    public void c() {
        SharedPreferences.Editor editor = this.f5888b;
        if (editor != null) {
            editor.clear();
            this.f5888b.commit();
        }
    }

    public boolean d(String str) {
        SharedPreferences sharedPreferences = this.f5887a;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        return false;
    }

    public Map<String, ?> e() {
        SharedPreferences sharedPreferences = this.f5887a;
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return null;
    }

    public boolean f(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.f5887a) == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    public boolean g(String str, boolean z10) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f5887a) == null) ? z10 : sharedPreferences.getBoolean(str, z10);
    }

    public float h(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        return i(str, 0.0f);
    }

    public float i(String str, float f10) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f5887a) == null) ? f10 : sharedPreferences.getFloat(str, f10);
    }

    public int k(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return l(str, 0);
    }

    public int l(String str, int i10) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f5887a) == null) ? i10 : sharedPreferences.getInt(str, i10);
    }

    public long m(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.f5887a) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    public long n(String str, long j10) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f5887a) == null) ? j10 : sharedPreferences.getLong(str, j10);
    }

    public Object o(String str) {
        Object obj = f5885k;
        return !TextUtils.isEmpty(str) ? p(str, obj) : obj;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0075 A[Catch: IOException -> 0x0071, TRY_LEAVE, TryCatch #5 {IOException -> 0x0071, blocks: (B:37:0x006d, B:41:0x0075), top: B:51:0x006d }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public Object p(String str, Object obj) throws Throwable {
        Exception e10;
        if (!TextUtils.isEmpty(str)) {
            ?? byteArrayInputStream = "";
            ?? e11 = r(str, "");
            try {
                try {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(Base64.decode(e11.getBytes("UTF-8"), 0));
                        try {
                            e11 = new ObjectInputStream(byteArrayInputStream);
                            try {
                                obj = e11.readObject();
                                e11.close();
                                byteArrayInputStream.close();
                                if (obj != null) {
                                    try {
                                        byteArrayInputStream.close();
                                        e11.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                    }
                                    return obj;
                                }
                                byteArrayInputStream.close();
                                e11.close();
                            } catch (Exception e13) {
                                e10 = e13;
                                e10.printStackTrace();
                                if (byteArrayInputStream != 0) {
                                    byteArrayInputStream.close();
                                }
                                if (e11 != 0) {
                                    e11.close();
                                }
                            }
                        } catch (Exception e14) {
                            e10 = e14;
                            e11 = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            e11 = 0;
                            if (byteArrayInputStream != 0) {
                                try {
                                    byteArrayInputStream.close();
                                    if (e11 != 0) {
                                        e11.close();
                                    }
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                    throw th;
                                }
                            } else if (e11 != 0) {
                                e11.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e16) {
                    byteArrayInputStream = 0;
                    e10 = e16;
                    e11 = 0;
                } catch (Throwable th4) {
                    byteArrayInputStream = 0;
                    th = th4;
                    e11 = 0;
                }
            } catch (IOException e17) {
                e11 = e17;
                e11.printStackTrace();
            }
        }
        return obj;
    }

    public String q(String str) {
        return !TextUtils.isEmpty(str) ? r(str, "") : "";
    }

    public String r(String str, String str2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f5887a) == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public Set<String> s(String str) {
        SharedPreferences sharedPreferences;
        Set<String> set = f5884j;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f5887a) == null) ? set : sharedPreferences.getStringSet(str, null);
    }

    public Set<String> t(String str, Set<String> set) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f5887a) == null) ? set : sharedPreferences.getStringSet(str, set);
    }

    public void u(String str, boolean z10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putBoolean(str, z10);
        this.f5888b.apply();
    }

    public void v(String str, boolean z10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putBoolean(str, z10);
        this.f5888b.commit();
    }

    public void w(String str, float f10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putFloat(str, f10);
        this.f5888b.apply();
    }

    public void x(String str, float f10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putFloat(str, f10);
        this.f5888b.commit();
    }

    public void y(String str, int i10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putInt(str, i10);
        this.f5888b.apply();
    }

    public void z(String str, int i10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f5888b) == null) {
            return;
        }
        editor.putInt(str, i10);
        this.f5888b.commit();
    }
}
