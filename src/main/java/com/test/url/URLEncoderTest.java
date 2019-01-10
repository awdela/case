package com.test.url;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class URLEncoderTest {

	public static void main(String args[]) {
        try {
        } catch (Exception e) {
            System.out.println(e);
        }
	}

    public static URL loadResource(String resource, ClassLoader classLoader) throws IOException {
        List<URL> urls = loadResources(resource, classLoader);
        if (urls.size() > 0) {
            return urls.get(0);
        }
        return null;
    }

    public static List<URL> loadResources(String resource, ClassLoader classLoader) throws IOException {
        List<URL> urls = new ArrayList<URL>();
        Enumeration<URL> urlElem = classLoader.getResources(resource);
        while (urlElem.hasMoreElements()) {
            URL url = urlElem.nextElement();
            if (!urls.contains(url)) {
                urls.add(url);
            }
        }
        urlElem = classLoader.getResources("/" + resource);
        while (urlElem.hasMoreElements()) {
            URL url = urlElem.nextElement();
            if (!urls.contains(url)) {
                urls.add(url);
            }
        }
        return urls;
    }
}
