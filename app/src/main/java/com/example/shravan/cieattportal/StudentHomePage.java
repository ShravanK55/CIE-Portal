package com.example.shravan.cieattportal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class StudentHomePage extends Fragment {
    String studentName = "";
    TextView studentNameText;

    ImageButton testsButton, attButton, settingsButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homePageView = inflater.inflate(R.layout.fragment_student_home_page, container, false);
        studentName = getArguments().getString("student_name_key");
        return homePageView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        studentNameText = (TextView) getActivity().findViewById(R.id.studentNameText);
        testsButton = (ImageButton) getActivity().findViewById(R.id.testMarksShortcutButton);
        attButton = (ImageButton) getActivity().findViewById(R.id.attendanceShortcutButton);
        settingsButton = (ImageButton) getActivity().findViewById(R.id.settingsShortcutButton);

        if (studentName == "")
            studentNameText.setText("Student");
        else
            studentNameText.setText(studentName);

        testsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((StudentPortal) getActivity()).ToTestsPage();
            }
        });

        attButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((StudentPortal) getActivity()).ToAttendancePage();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((StudentPortal) getActivity()).ToSettingsPage();
            }
        });
    }
}
