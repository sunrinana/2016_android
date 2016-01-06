package com.example.sunrin.sunrin1230;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Sunrin on 2015-12-30.
 */
public class XmlParser {

    private InputStream inputStream;
    private ArrayList<Data> datas = new ArrayList<>();

    public XmlParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    ArrayList<Data> parser() throws XmlPullParserException, IOException {
        XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = xmlPullParserFactory.newPullParser();

        parser.setInput(inputStream, null);

        String thumbnail = "";
        int height = 0;
        int width = 0;

        int event = parser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT) {
            String name = parser.getName();
            switch (event) {
                case XmlPullParser.START_TAG:
                    if (name.equals("thumbnail")) {
                        thumbnail = parser.nextText();
                    } else if (name.equals("sizeheight")) {
                        height = Integer.parseInt(parser.nextText());
                    } else if (name.equals("sizewidth")) {
                        width = Integer.parseInt(parser.nextText());
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if (name.equals("item")) {
                        datas.add(new Data(thumbnail, height, width));
                    }
                    break;
            }
            event = parser.next();
        }
        return datas;
    }
}
