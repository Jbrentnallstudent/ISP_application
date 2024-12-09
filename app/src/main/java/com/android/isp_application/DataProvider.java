package com.android.isp_application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DataProvider {
    public static HashMap<String, List<String>> getInfo() {
        HashMap<String, List<String>> HeaderDetails = new HashMap<String, List<String>>();
        List<String> ChildDetails1 = new ArrayList<>();
        ChildDetails1.add("This is Children 11");
        ChildDetails1.add("This is Children 12");
        ChildDetails1.add("This is Children 13");
        ChildDetails1.add("This is Children 14");
        ChildDetails1.add("This is Children 15");
        List<String> ChildDetails2 = new ArrayList<>();
        ChildDetails2.add("This is Children 21");
        ChildDetails2.add("This is Children 22");
        ChildDetails2.add("This is Children 23");
        ChildDetails2.add("This is Children 24");
        ChildDetails2.add("This is Children 25");
        List<String> ChildDetails3 = new ArrayList<>();
        ChildDetails3.add("This is Children 31");
        ChildDetails3.add("This is Children 32");
        ChildDetails3.add("This is Children 33");
        ChildDetails3.add("This is Children 34");
        ChildDetails3.add("This is Children 35");
        List<String> ChildDetails4 = new ArrayList<>();
        ChildDetails4.add("This is Children 41");
        ChildDetails4.add("This is Children 42");
        ChildDetails4.add("This is Children 43");
        ChildDetails4.add("This is Children 44");
        ChildDetails4.add("This is Children 45");
        List<String> ChildDetails5 = new ArrayList<>();
        ChildDetails5.add("This is Children 51");
        ChildDetails5.add("This is Children 52");
        ChildDetails5.add("This is Children 53");
        ChildDetails5.add("This is Children 54");
        ChildDetails5.add("This is Children 55");

        HeaderDetails.put("Header 1", ChildDetails1);
        HeaderDetails.put("Header 2", ChildDetails2);
        HeaderDetails.put("Header 3", ChildDetails3);
        HeaderDetails.put("Header 4", ChildDetails4);
        HeaderDetails.put("Header 5", ChildDetails5);

        return HeaderDetails;

    }
}
