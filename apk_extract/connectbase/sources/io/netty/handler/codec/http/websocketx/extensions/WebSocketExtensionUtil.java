package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.AsciiString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketExtensionUtil {
    private static final String EXTENSION_SEPARATOR = ",";
    private static final Pattern PARAMETER = Pattern.compile("^([^=]+)(=[\\\"]?([^\\\"]+)[\\\"]?)?$");
    private static final char PARAMETER_EQUAL = '=';
    private static final String PARAMETER_SEPARATOR = ";";

    private WebSocketExtensionUtil() {
    }

    public static String computeMergeExtensionsHeaderValue(String str, List<WebSocketExtensionData> list) {
        WebSocketExtensionData webSocketExtensionData;
        for (WebSocketExtensionData webSocketExtensionData2 : str != null ? extractExtensions(str) : Collections.emptyList()) {
            int i10 = 0;
            while (true) {
                if (i10 >= list.size()) {
                    webSocketExtensionData = null;
                    break;
                }
                webSocketExtensionData = list.get(i10);
                if (webSocketExtensionData.name().equals(webSocketExtensionData2.name())) {
                    break;
                }
                i10++;
            }
            if (webSocketExtensionData == null) {
                list.add(webSocketExtensionData2);
            } else {
                HashMap map = new HashMap(webSocketExtensionData.parameters());
                map.putAll(webSocketExtensionData2.parameters());
                list.set(i10, new WebSocketExtensionData(webSocketExtensionData.name(), map));
            }
        }
        StringBuilder sb2 = new StringBuilder(150);
        for (WebSocketExtensionData webSocketExtensionData3 : list) {
            sb2.append(webSocketExtensionData3.name());
            for (Map.Entry<String, String> entry : webSocketExtensionData3.parameters().entrySet()) {
                sb2.append(PARAMETER_SEPARATOR);
                sb2.append(entry.getKey());
                if (entry.getValue() != null) {
                    sb2.append('=');
                    sb2.append(entry.getValue());
                }
            }
            sb2.append(",");
        }
        if (!list.isEmpty()) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.HashMap] */
    public static List<WebSocketExtensionData> extractExtensions(String str) {
        ?? EmptyMap;
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(PARAMETER_SEPARATOR);
            String strTrim = strArrSplit2[0].trim();
            if (strArrSplit2.length > 1) {
                EmptyMap = new HashMap(strArrSplit2.length - 1);
                for (int i10 = 1; i10 < strArrSplit2.length; i10++) {
                    Matcher matcher = PARAMETER.matcher(strArrSplit2[i10].trim());
                    if (matcher.matches() && matcher.group(1) != null) {
                        EmptyMap.put(matcher.group(1), matcher.group(3));
                    }
                }
            } else {
                EmptyMap = Collections.emptyMap();
            }
            arrayList.add(new WebSocketExtensionData(strTrim, EmptyMap));
        }
        return arrayList;
    }

    public static boolean isWebsocketUpgrade(HttpHeaders httpHeaders) {
        AsciiString asciiString = HttpHeaderNames.UPGRADE;
        return httpHeaders.contains(asciiString) && httpHeaders.containsValue(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE, true) && httpHeaders.contains((CharSequence) asciiString, (CharSequence) HttpHeaderValues.WEBSOCKET, true);
    }
}
