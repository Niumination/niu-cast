package ka;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f6812b = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6813c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6814a;

    static {
        System.getProperty("file.separator");
        f6813c = System.getProperty("line.separator");
    }

    public c(b bVar) {
        new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.f6814a = bVar;
    }

    public final void a(String str) {
        b(3, this.f6814a.f6808a, str);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:55:0x0106  */
    /* JADX WARN: Code duplicated, block: B:56:0x0118  */
    /* JADX WARN: Code duplicated, block: B:59:0x0125  */
    /* JADX WARN: Code duplicated, block: B:62:0x012d  */
    /* JADX WARN: Code duplicated, block: B:64:0x013a A[LOOP:0: B:63:0x0138->B:64:0x013a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x0154  */
    /* JADX WARN: Code duplicated, block: B:70:0x015f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0169  */
    /* JADX WARN: Code duplicated, block: B:76:0x017c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0184  */
    /* JADX WARN: Code duplicated, block: B:81:0x018b  */
    /* JADX WARN: Code duplicated, block: B:86:0x016d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x0106, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:62:0x012d, please report this as an issue */
    public final void b(int i8, String str, Object... objArr) {
        String[] strArr;
        String string;
        StringBuilder sb2;
        int length;
        int i9;
        Object obj;
        String string2;
        String str2;
        String str3;
        int length2;
        int i10;
        int i11;
        String strSubstring;
        String strSubstring2;
        StringBuilder sb3;
        int i12;
        Object obj2;
        boolean zIsLoggable = Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3);
        b bVar = this.f6814a;
        if (!zIsLoggable) {
            bVar.getClass();
            return;
        }
        int i13 = i8 & 15;
        bVar.getClass();
        if (i13 >= 2 || i13 >= 2) {
            boolean z2 = bVar.f6809b;
            int i14 = 1;
            String str4 = f6813c;
            if (z2 || bVar.f6810c) {
                StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
                String className = stackTraceElement.getClassName();
                String[] strArrSplit = className.split("\\.");
                if (strArrSplit.length > 0) {
                    className = strArrSplit[strArrSplit.length - 1];
                }
                if (className.contains("$")) {
                    className = className.split("\\$")[0];
                }
                if (bVar.f6809b) {
                    int length3 = str.length();
                    int i15 = 0;
                    while (true) {
                        if (i15 >= length3) {
                            str = className;
                            break;
                        } else if (!Character.isWhitespace(str.charAt(i15))) {
                            break;
                        } else {
                            i15++;
                        }
                    }
                }
                if (bVar.f6810c) {
                    String string3 = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                    strArr = new String[]{str, h0.a.B(string3, str4), h0.a.j(" [", string3, "]: ")};
                }
                string = "null";
                if (objArr.length == 1) {
                    obj2 = objArr[0];
                    if (obj2 != null) {
                        string = obj2.toString();
                    }
                } else {
                    sb2 = new StringBuilder();
                    length = objArr.length;
                    for (i9 = 0; i9 < length; i9++) {
                        obj = objArr[i9];
                        sb2.append("args[");
                        sb2.append(i9);
                        sb2.append("] = ");
                        if (obj == null) {
                            string2 = "null";
                        } else {
                            string2 = obj.toString();
                        }
                        sb2.append(string2);
                        sb2.append(str4);
                    }
                    string = sb2.toString();
                }
                if (i13 >= 2) {
                    str2 = strArr[0];
                    str3 = strArr[1];
                    if (bVar.f6810c) {
                        Log.println(i13, str2, "\n" + str3);
                    } else {
                        Log.println(i13, str2, " \n");
                    }
                    if (bVar.f6811d) {
                        Log.println(i13, str2, "|---------------------------------------------------------------------------------------------------");
                        if (bVar.f6811d) {
                            sb3 = new StringBuilder();
                            for (String str5 : string.split(str4)) {
                                sb3.append("| ");
                                sb3.append(str5);
                                sb3.append(str4);
                            }
                            string = sb3.toString();
                        }
                    }
                    length2 = string.length();
                    i10 = length2 / 4000;
                    if (i10 > 0) {
                        i11 = 4000;
                        Log.println(i13, str2, string.substring(0, 4000));
                        while (i14 < i10) {
                            int i16 = i11 + 4000;
                            strSubstring2 = string.substring(i11, i16);
                            if (bVar.f6811d) {
                                strSubstring2 = h0.a.i("| ", strSubstring2);
                            }
                            Log.println(i13, str2, strSubstring2);
                            i14++;
                            i11 = i16;
                        }
                        strSubstring = string.substring(i11, length2);
                        if (bVar.f6811d) {
                            strSubstring = h0.a.i("| ", strSubstring);
                        }
                        Log.println(i13, str2, strSubstring);
                    } else {
                        Log.println(i13, str2, string);
                    }
                    if (bVar.f6811d) {
                        Log.println(i13, str2, "|---------------------------------------------------------------------------------------------------");
                    }
                }
            }
            str = bVar.f6808a;
            strArr = new String[]{str, "", ": "};
            string = "null";
            if (objArr.length == 1) {
                obj2 = objArr[0];
                if (obj2 != null) {
                    string = obj2.toString();
                }
            } else {
                sb2 = new StringBuilder();
                length = objArr.length;
                while (i9 < length) {
                    obj = objArr[i9];
                    sb2.append("args[");
                    sb2.append(i9);
                    sb2.append("] = ");
                    if (obj == null) {
                        string2 = "null";
                    } else {
                        string2 = obj.toString();
                    }
                    sb2.append(string2);
                    sb2.append(str4);
                }
                string = sb2.toString();
            }
            if (i13 >= 2) {
                str2 = strArr[0];
                str3 = strArr[1];
                if (bVar.f6810c) {
                    Log.println(i13, str2, "\n" + str3);
                } else {
                    Log.println(i13, str2, " \n");
                }
                if (bVar.f6811d) {
                    Log.println(i13, str2, "|---------------------------------------------------------------------------------------------------");
                    if (bVar.f6811d) {
                        sb3 = new StringBuilder();
                        while (i12 < r6) {
                            sb3.append("| ");
                            sb3.append(str5);
                            sb3.append(str4);
                        }
                        string = sb3.toString();
                    }
                }
                length2 = string.length();
                i10 = length2 / 4000;
                if (i10 > 0) {
                    i11 = 4000;
                    Log.println(i13, str2, string.substring(0, 4000));
                    while (i14 < i10) {
                        int i17 = i11 + 4000;
                        strSubstring2 = string.substring(i11, i17);
                        if (bVar.f6811d) {
                            strSubstring2 = h0.a.i("| ", strSubstring2);
                        }
                        Log.println(i13, str2, strSubstring2);
                        i14++;
                        i11 = i17;
                    }
                    strSubstring = string.substring(i11, length2);
                    if (bVar.f6811d) {
                        strSubstring = h0.a.i("| ", strSubstring);
                    }
                    Log.println(i13, str2, strSubstring);
                } else {
                    Log.println(i13, str2, string);
                }
                if (bVar.f6811d) {
                    Log.println(i13, str2, "|---------------------------------------------------------------------------------------------------");
                }
            }
        }
    }
}
