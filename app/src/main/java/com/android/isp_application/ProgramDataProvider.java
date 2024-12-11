package com.android.isp_application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ProgramDataProvider {
    public static HashMap<String, List<String>> getInfo() {
        HashMap<String, List<String>> HeaderDetails = new HashMap<String, List<String>>();
        List<String> ChildDetails1 = new ArrayList<>();
        ChildDetails1.add("Course ID: BU2270\nCourse Name: HVAC\nCourse Details: This course is designed to introduce the student to building heating, ventilation, and air conditioning (HVAC) systems.\nLecture Hours: 4\nLab Hours: 3\nTotal Credits: 5");
        ChildDetails1.add("Course ID: CG3230\nCourse Name: Procurement & Contract Administration\nCourse Details: This course examines the fundamentals of economics, types of businesses, and the administrative process as it relates to design construction projects.\nLecture Hours: 5\nLab Hours: 0\nTotal Credits: 5");
        ChildDetails1.add("Course ID: LW1610\nCourse Name: Management & Construction Law\nCourse Details: This is a course dealing with management principles, professional relationships, and various laws applicable to the design and construction industry.\nLecture Hours: 2\nLab Hours: 0\nTotal Credits: 2");
        List<String> ChildDetails2 = new ArrayList<>();
        ChildDetails2.add("Course ID: CA2500\nCourse Name: Highway Technology\nCourse Details: This course enables the learner to plan and design highway transportation systems according to local standards.\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails2.add("Course ID: DR1250\nCourse Name: CADD Drawings\nCourse Details: Through participation through this course, learners will acquire skills in the use of Revit and Civil 3D by producing working drawings for small commercial building and site development. \nLecture Hours: 1\nLab Hours: 4\nTotal Credits: 2");
        ChildDetails2.add("Course ID: WA1160\nCourse Name: Fluid Mechanics\nCourse Details:This course will provide the learner with a knowledge of the principles of fluid mechanics and knowledge to solve practical applied problems.\nLecture Hours: 4\tLab Hours: 0\nTotal Credits: 4");
        List<String> ChildDetails3 = new ArrayList<>();
        ChildDetails3.add("Course ID: AE3130\nCourse Name: Active Circuit Applications\nCourse Details: The purpose of this course is to provide the learner with an understanding of the operation of integrated circuit amplifier circuits, active filters, and switching power supplies.\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails3.add("Course ID: DP3200\nCourse Name: Embedded Controller Applications\nCourse Details: The course will reveal why microcontrollers exist in so many products today. \nLecture Hours: 2\nLab Hours: 3\nTotal Credits: 3");
        ChildDetails3.add("Course ID: CP3490\nCourse Name: Software Engineering\nCourse Details: The course introduces learners to the principles of software engineering, object oriented modeling and analysis of large software systems using unified modelling language (UML) and different phases of software life cycle.\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        List<String> ChildDetails4 = new ArrayList<>();
        ChildDetails4.add("Course ID: MP2210\nCourse Name: Power Harmonics and Controls\nCourse Details: The first part of this introductory course covers sources of, and problems with, power systems harmonics.\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails4.add("Course ID: PE3101\nCourse Name: Electrical Facility Design I\nCourse Details: This is an advanced course intended to introduce students to the broad field of electrical facility design. \nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails4.add("Course ID: MP3250\nCourse Name: Emergency Standby Systems and Alternate Energy Sources\nCourse Details: This course is designed to study emergency standby systems and alternative energy sources.\nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        List<String> ChildDetails5 = new ArrayList<>();
        ChildDetails5.add("Course ID: SP1835\nCourse Name: Applied Statistics and Quality Control\nCourse Details: This course integrates the application  of statistical process control with the control of quality for a product or service. \nLecture Hours: 3\nLab Hours: 2\nTotal Credits: 4");
        ChildDetails5.add("Course ID: TD3140\nCourse Name: Heat Transfer\nCourse Details: This is an introductory course in heat transfer which is designed to familiarize the student with the subject.\nLecture Hours: 3\nLab Hours: 1\nTotal Credits: 3");
        ChildDetails5.add("Course ID: CF3100\nCourse Name: Mechanics of Solids: Dynamics\nCourse Details: This course expands on previously studied concepts of Statics specifically Newton’s 1st Law introducing Newton’s 2nd Law, kinematics, work-energy concepts, as well as relative motion and vibration.\nLecture Hours: 3\nLab Hours: 1\nTotal Credits: 3");

        HeaderDetails.put("Architectural", ChildDetails1);
        HeaderDetails.put("Civil", ChildDetails2);
        HeaderDetails.put("Computing Systems", ChildDetails3);
        HeaderDetails.put("Electrical (Power)", ChildDetails4);
        HeaderDetails.put("Mechanical", ChildDetails5);

        return HeaderDetails;

    }
}
