package com.example.sunrin.sunrin1228;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * Created by chojeaho on 2016-01-04.
 */
public class XmlParser {
    XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
    XmlPullParser xmlPullParser = XmlPullParser();

    parser.setInput(inputStream,null);

    String thumnail = "";
    int height;
    int width;

    int event = parser.getEventType();
    while (event != XmlPullParser.END_DOCUMENT)
    {
        String name = parser.getName();
        switch (event)
        {
            case XmlPullParser.START_TAG:
                if (name.equals("thumbnail"))
                {
                    thumbnail = parser.nextText();
                } else if(name.equals("sizeheight"))
        }
    }
}
