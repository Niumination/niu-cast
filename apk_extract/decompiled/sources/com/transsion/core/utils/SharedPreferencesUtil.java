package com.transsion.core.utils;

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
public class SharedPreferencesUtil {
    private static final boolean DEFAULT_BOOLEAN = false;
    private static final float DEFAULT_FLOAT = 0.0f;
    private static final int DEFAULT_INT = 0;
    private static final long DEFAULT_LONG = 0;
    private static final String DEFAULT_STRING = "";
    private static final String TAG = "SharedPreferencesUtil";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPreferences;
    private static Map<String, SharedPreferencesUtil> sharePreferBank = new HashMap();
    private static final Set<String> DEFAULT_STRING_SET = new HashSet(0);
    private static final Object DEFAULT_OBJECT = null;
    private static Context mContext = null;

    private SharedPreferencesUtil(String str) {
        Context context = mContext;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            this.mSharedPreferences = sharedPreferences;
            if (sharedPreferences != null) {
                this.mEditor = sharedPreferences.edit();
            }
        }
    }

    public static void bindApplication(@NonNull Context context) {
        mContext = context;
    }

    public static synchronized SharedPreferencesUtil getInstance(String str) {
        SharedPreferencesUtil sharedPreferencesUtil;
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("please make sure you have valid file name");
        }
        sharedPreferencesUtil = sharePreferBank.get(str);
        if (sharedPreferencesUtil == null) {
            sharedPreferencesUtil = new SharedPreferencesUtil(str);
            sharePreferBank.put(str, sharedPreferencesUtil);
        }
        return sharedPreferencesUtil;
    }

    public void clear() {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.clear();
            this.mEditor.apply();
        }
    }

    public void clearImmediately() {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.clear();
            this.mEditor.commit();
        }
    }

    public boolean contains(String str) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        return false;
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return null;
    }

    public boolean getBoolean(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.mSharedPreferences) == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    public float getFloat(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        return getFloat(str, 0.0f);
    }

    public int getInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return getInt(str, 0);
    }

    public long getLong(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.mSharedPreferences) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    public Object getObject(String str) {
        Object obj = DEFAULT_OBJECT;
        return !TextUtils.isEmpty(str) ? getObject(str, obj) : obj;
    }

    public String getString(String str) {
        return !TextUtils.isEmpty(str) ? getString(str, "") : "";
    }

    public Set<String> getStringSet(String str) {
        SharedPreferences sharedPreferences;
        Set<String> set = DEFAULT_STRING_SET;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.mSharedPreferences) == null) ? set : sharedPreferences.getStringSet(str, null);
    }

    public void putBoolean(String str, boolean z2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putBoolean(str, z2);
        this.mEditor.apply();
    }

    public void putBooleanImmediately(String str, boolean z2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putBoolean(str, z2);
        this.mEditor.commit();
    }

    public void putFloat(String str, float f) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putFloat(str, f);
        this.mEditor.apply();
    }

    public void putFloatImmediately(String str, float f) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putFloat(str, f);
        this.mEditor.commit();
    }

    public void putInt(String str, int i8) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putInt(str, i8);
        this.mEditor.apply();
    }

    public void putIntImmediately(String str, int i8) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putInt(str, i8);
        this.mEditor.commit();
    }

    public void putLong(String str, long j8) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putLong(str, j8);
        this.mEditor.apply();
    }

    public void putLongImmediately(String str, long j8) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putLong(str, j8);
        this.mEditor.commit();
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
    public void putObject(String str, Serializable serializable) throws Throwable {
        if (serializable == null || TextUtils.isEmpty(str) || this.mEditor == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r7 = 0;
        ObjectOutputStream objectOutputStream = null;
        r7 = 0;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    objectOutputStream2.writeObject(null);
                    String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0), "UTF-8");
                    SharedPreferences.Editor editor = this.mEditor;
                    editor.putString(str, str2);
                    this.mEditor.apply();
                    byteArrayOutputStream.close();
                    objectOutputStream2.close();
                    r7 = editor;
                } catch (IOException e) {
                    e = e;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                    byteArrayOutputStream.close();
                    r7 = objectOutputStream;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                        r7 = objectOutputStream;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r7 = objectOutputStream2;
                    try {
                        byteArrayOutputStream.close();
                        if (r7 != 0) {
                            r7.close();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
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
    public void putObjectImmediately(String str, Serializable serializable) throws Throwable {
        if (serializable == null || TextUtils.isEmpty(str) || this.mEditor == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r7 = 0;
        ObjectOutputStream objectOutputStream = null;
        r7 = 0;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    objectOutputStream2.writeObject(null);
                    String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0), "UTF-8");
                    SharedPreferences.Editor editor = this.mEditor;
                    editor.putString(str, str2);
                    this.mEditor.commit();
                    byteArrayOutputStream.close();
                    objectOutputStream2.close();
                    r7 = editor;
                } catch (IOException e) {
                    e = e;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                    byteArrayOutputStream.close();
                    r7 = objectOutputStream;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                        r7 = objectOutputStream;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r7 = objectOutputStream2;
                    try {
                        byteArrayOutputStream.close();
                        if (r7 != 0) {
                            r7.close();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public void putString(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putString(str, str2);
        this.mEditor.apply();
    }

    public void putStringImmediately(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putString(str, str2);
        this.mEditor.commit();
    }

    public void putStringSet(String str, Set<String> set) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putStringSet(str, set);
        this.mEditor.apply();
    }

    public void putStringSetImmediately(String str, Set<String> set) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.mEditor) == null) {
            return;
        }
        editor.putStringSet(str, set);
        this.mEditor.commit();
    }

    public void remove(String str) {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.remove(str);
            this.mEditor.apply();
        }
    }

    public void removeImmediately(String str) {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.remove(str);
            this.mEditor.commit();
        }
    }

    public float getFloat(String str, float f) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.mSharedPreferences) == null) ? f : sharedPreferences.getFloat(str, f);
    }

    public int getInt(String str, int i8) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.mSharedPreferences) == null) ? i8 : sharedPreferences.getInt(str, i8);
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.mSharedPreferences) == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public boolean getBoolean(String str, boolean z2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.mSharedPreferences) == null) ? z2 : sharedPreferences.getBoolean(str, z2);
    }

    public long getLong(String str, long j8) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.mSharedPreferences) == null) ? j8 : sharedPreferences.getLong(str, j8);
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
    public Object getObject(String str, Object obj) throws Throwable {
        Exception e;
        if (!TextUtils.isEmpty(str)) {
            ?? byteArrayInputStream = "";
            ?? e4 = getString(str, "");
            try {
                try {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(Base64.decode(e4.getBytes("UTF-8"), 0));
                        try {
                            e4 = new ObjectInputStream(byteArrayInputStream);
                            try {
                                obj = e4.readObject();
                                e4.close();
                                byteArrayInputStream.close();
                                if (obj != null) {
                                    try {
                                        byteArrayInputStream.close();
                                        e4.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                    return obj;
                                }
                                byteArrayInputStream.close();
                                e4.close();
                            } catch (Exception e11) {
                                e = e11;
                                e.printStackTrace();
                                if (byteArrayInputStream != 0) {
                                    byteArrayInputStream.close();
                                }
                                if (e4 != 0) {
                                    e4.close();
                                }
                            }
                        } catch (Exception e12) {
                            e = e12;
                            e4 = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            e4 = 0;
                            if (byteArrayInputStream != 0) {
                                try {
                                    byteArrayInputStream.close();
                                    if (e4 != 0) {
                                        e4.close();
                                    }
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                    throw th;
                                }
                            } else if (e4 != 0) {
                                e4.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e14) {
                    byteArrayInputStream = 0;
                    e = e14;
                    e4 = 0;
                } catch (Throwable th4) {
                    byteArrayInputStream = 0;
                    th = th4;
                    e4 = 0;
                }
            } catch (IOException e15) {
                e4 = e15;
                e4.printStackTrace();
            }
        }
        return obj;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.mSharedPreferences) == null) ? set : sharedPreferences.getStringSet(str, set);
    }
}
