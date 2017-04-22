package com.example.shravan.cieattportal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TeacherMarksPage extends Fragment {
    ImageButton uploadAttButton, t1Button, t2Button, t3Button;
    Button selectCSVButton, uploadButton;
    TextView testText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View marksPageView = inflater.inflate(R.layout.fragment_teacher_marks_page, container, false);
        return marksPageView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        uploadAttButton = (ImageButton) getActivity().findViewById(R.id.teacherAttShortcutButton);
        t1Button = (ImageButton) getActivity().findViewById(R.id.teacherTest1Button);
        t2Button = (ImageButton) getActivity().findViewById(R.id.teacherTest2Button);
        t3Button = (ImageButton) getActivity().findViewById(R.id.teacherTest3Button);
        selectCSVButton = (Button) getActivity().findViewById(R.id.selectFileButton);
        uploadButton = (Button) getActivity().findViewById(R.id.teacherUploadButton);
        testText = (TextView) getActivity().findViewById(R.id.teacherTestText);

        uploadAttButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TeacherPortal) getActivity()).ToAttendancePage();
            }
        });

        t1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add functionality for test buttons.
                testText.setText("Test 1");
            }
        });

        t2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add functionality for test buttons.
                testText.setText("Test 2");
            }
        });

        t3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add functionality for test buttons.
                testText.setText("Test 3");
            }
        });

        selectCSVButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add functionality for upload buttons.
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add functionality for upload buttons.
            }
        });
    }
}
