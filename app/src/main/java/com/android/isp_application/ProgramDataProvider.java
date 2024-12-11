package com.android.isp_application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ProgramDataProvider {
    public static HashMap<String, List<String>> getInfo() {
        HashMap<String, List<String>> HeaderDetails = new HashMap<String, List<String>>();
        List<String> ChildDetails1 = new ArrayList<>();
        ChildDetails1.add("Course ID: BU2270\nCourse Name: HVAC\nLecture Hours: 4\nLab Hours: 3\nTotal Credits: 5");
        ChildDetails1.add("Course ID: CG3230\nCourse Name: Procurement & Contract Administration\nLecture Hours: 5\nLab Hours: 0\nTotal Credits: 5");
        ChildDetails1.add("Course ID: LW1610\nCourse Name: Management & Construction Law\nLecture Hours: 2\nLab Hours: 0\nTotal Credits: 2");
        List<String> ChildDetails2 = new ArrayList<>();
        ChildDetails2.add("Course ID: CA2500\nCourse Name: Highway Technology\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails2.add("Course ID: DR1250\nCourse Name: CADD Drawings\nLecture Hours: 1\nLab Hours: 4\nTotal Credits: 2");
        ChildDetails2.add("Course ID: WA1160\nCourse Name: Fluid Mechanics\nLecture Hours: 4\tLab Hours: 0\nTotal Credits: 4");
        List<String> ChildDetails3 = new ArrayList<>();
        ChildDetails3.add("Course ID: AE3130\nCourse Name: Active Circuit Applications\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails3.add("Course ID: DP3200\nCourse Name: Embedded Controller Applications\nLecture Hours: 2\nLab Hours: 3\nTotal Credits: 3");
        ChildDetails3.add("Course ID: CP3490\nCourse Name: Software Engineering\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        List<String> ChildDetails4 = new ArrayList<>();
        ChildDetails4.add("Course ID: MP2210\nCourse Name: Power Harmonics and Controls\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails4.add("Course ID: PE3101\nCourse Name: Electrical Facility Design I\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails4.add("Course ID: MP3250\nCourse Name: Emergency Standby Systems and Alternate Energy Sources\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        List<String> ChildDetails5 = new ArrayList<>();
        ChildDetails5.add("Course ID: SP1835\nCourse Name: Applied Statistics and Quality Control\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails5.add("Course ID: TD3140\nCourse Name: Heat Transfer\nLecture Hours: 3\nLab Hours: 1\nTotal Credits: 3");
        ChildDetails5.add("Course ID: CF3100\nCourse Name: Mechanics of Solids: Dynamics\nLecture Hours: 3\nLab Hours: 1\nTotal Credits: 3");

        HeaderDetails.put("Architectural", ChildDetails1);
        HeaderDetails.put("Civil", ChildDetails2);
        HeaderDetails.put("Computing Systems", ChildDetails3);
        HeaderDetails.put("Electrical (Power)", ChildDetails4);
        HeaderDetails.put("Mechanical", ChildDetails5);

        return HeaderDetails;

    }
}
