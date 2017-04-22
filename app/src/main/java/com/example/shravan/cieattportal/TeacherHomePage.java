package com.example.shravan.cieattportal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class TeacherHomePage extends Fragment {
    String teacherName = "";
    TextView teacherNameText;

    ImageButton testsButton, attButton, settingsButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homePageView = inflater.inflate(R.layout.fragment_teacher_home_page, container, false);
        teacherName = getArguments().getString("teacher_name_key");
        return homePageView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teacherNameText = (TextView) getActivity().findViewById(R.id.teacherNameText);
        testsButton = (ImageButton) getActivity().findViewById(R.id.teacherTestMarksShortcutButton);
        attButton = (ImageButton) getActivity().findViewById(R.id.teacherAttendanceShortcutButton);
        settingsButton = (ImageButton) getActivity().findViewById(R.id.teacherSettingsShortcutButton);

        if (teacherName == "")
            teacherNameText.setText("Teacher");
        else
            teacherNameText.setText(teacherName);

        testsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TeacherPortal) getActivity()).ToMarksPage();
            }
        });

        attButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TeacherPortal) getActivity()).ToAttendancePage();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TeacherPortal) getActivity()).ToSettingsPage();
            }
        });
    }
}
