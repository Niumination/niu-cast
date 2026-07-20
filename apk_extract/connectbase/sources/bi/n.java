package bi;

import io.netty.util.internal.StringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Reader f884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f886d;

    public n(Reader reader) {
        this.f884b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f886d = false;
        this.f883a = 0;
    }

    public l a(String str) {
        StringBuilder sbA = k.a.a(str);
        sbA.append(toString());
        return new l(sbA.toString());
    }

    public String b(char c10) throws l {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            char cF = f();
            if (cF == 0 || cF == '\n' || cF == '\r') {
                break;
            }
            if (cF == '\\') {
                char cF2 = f();
                if (cF2 == 'b') {
                    sb2.append('\b');
                } else if (cF2 == 'f') {
                    sb2.append('\f');
                } else if (cF2 == 'n') {
                    sb2.append('\n');
                } else if (cF2 == 'r') {
                    sb2.append(StringUtil.CARRIAGE_RETURN);
                } else if (cF2 == 'x') {
                    sb2.append((char) Integer.parseInt(c(2), 16));
                } else if (cF2 == 't') {
                    sb2.append('\t');
                } else if (cF2 != 'u') {
                    sb2.append(cF2);
                } else {
                    sb2.append((char) Integer.parseInt(c(4), 16));
                }
            } else {
                if (cF == c10) {
                    return sb2.toString();
                }
                sb2.append(cF);
            }
        }
        throw a("Unterminated string");
    }

    public String c(int i10) throws l {
        if (i10 == 0) {
            return "";
        }
        char[] cArr = new char[i10];
        int i11 = 0;
        if (this.f886d) {
            this.f886d = false;
            cArr[0] = this.f885c;
            i11 = 1;
        }
        while (i11 < i10) {
            try {
                int i12 = this.f884b.read(cArr, i11, i10 - i11);
                if (i12 == -1) {
                    break;
                }
                i11 += i12;
            } catch (IOException e10) {
                throw new l(e10);
            }
        }
        this.f883a += i11;
        if (i11 < i10) {
            throw a("Substring bounds error");
        }
        this.f885c = cArr[i10 - 1];
        return new String(cArr);
    }

    public void d() throws l {
        int i10;
        if (this.f886d || (i10 = this.f883a) <= 0) {
            throw new l("Stepping back two steps is not supported");
        }
        this.f883a = i10 - 1;
        this.f886d = true;
    }

    public final void e(Map<String, Object> map, String str, Object obj) {
        if (str != null) {
            if (map.containsKey(str)) {
                throw new l(n.a.a("Duplicate key \"", str, "\""));
            }
            map.put(str, obj);
        }
    }

    public char f() throws l {
        if (this.f886d) {
            this.f886d = false;
            char c10 = this.f885c;
            if (c10 != 0) {
                this.f883a++;
            }
            return c10;
        }
        try {
            int i10 = this.f884b.read();
            if (i10 <= 0) {
                this.f885c = (char) 0;
                return (char) 0;
            }
            this.f883a++;
            char c11 = (char) i10;
            this.f885c = c11;
            return c11;
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public final boolean g(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (!Character.isDigit(cCharAt) && cCharAt != '-' && cCharAt != '.' && cCharAt != '+' && cCharAt != 'e' && cCharAt != 'E') {
                return false;
            }
        }
        return true;
    }

    public char h() throws l {
        char cF;
        do {
            cF = f();
            if (cF == 0) {
                break;
            }
        } while (cF <= ' ');
        return cF;
    }

    public final Object i(String str) {
        if (str.equals("")) {
            return str;
        }
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (str.equalsIgnoreCase(d6.a.E)) {
            return null;
        }
        return g(str) ? new o(str) : str;
    }

    public Object j() throws l {
        char cH = h();
        if (cH != '\"') {
            if (cH != '[') {
                if (cH == '{') {
                    d();
                    return l();
                }
                if (cH != '\'') {
                    if (cH != '(') {
                        StringBuilder sb2 = new StringBuilder();
                        while (cH >= ' ' && ",:]}/\\\"[{;=#".indexOf(cH) < 0) {
                            sb2.append(cH);
                            cH = f();
                        }
                        d();
                        String strTrim = sb2.toString().trim();
                        if (strTrim.equals("")) {
                            throw a("Missing value");
                        }
                        return i(strTrim);
                    }
                }
            }
            d();
            return k();
        }
        return b(cH);
    }

    public List<Object> k() {
        char c10;
        char cH;
        ArrayList arrayList = new ArrayList();
        char cH2 = h();
        if (cH2 == '[') {
            c10 = ']';
        } else {
            if (cH2 != '(') {
                throw a("A JSONArray text must start with '['");
            }
            c10 = ')';
        }
        if (h() == ']') {
            return arrayList;
        }
        d();
        while (true) {
            if (h() == ',') {
                d();
                arrayList.add(null);
            } else {
                d();
                arrayList.add(j());
            }
            cH = h();
            if (cH != ')') {
                if (cH != ',' && cH != ';') {
                    if (cH == ']') {
                        break;
                    }
                    throw a("Expected a ',' or ']'");
                }
                if (h() == ']') {
                    return arrayList;
                }
                d();
            } else {
                break;
            }
        }
        if (c10 == cH) {
            return arrayList;
        }
        throw a("Expected a '" + c10 + "'");
    }

    public final Map<String, Object> l() {
        HashMap map = new HashMap();
        if (h() != '{') {
            throw a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char cH = h();
            if (cH == 0) {
                throw a("A JSONObject text must end with '}'");
            }
            if (cH == '}') {
                return map;
            }
            d();
            String string = j().toString();
            char cH2 = h();
            if (cH2 == '=') {
                if (f() != '>') {
                    d();
                }
            } else if (cH2 != ':') {
                throw a("Expected a ':' after a key");
            }
            e(map, string, j());
            char cH3 = h();
            if (cH3 != ',' && cH3 != ';') {
                if (cH3 == '}') {
                    return map;
                }
                throw a("Expected a ',' or '}'");
            }
            if (h() == '}') {
                return map;
            }
            d();
        }
    }

    public String toString() {
        return " at character " + this.f883a;
    }

    public n(String str) {
        this(new StringReader(str));
    }
}
