package com.example.shravan.cieattportal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class StudentMarksPage extends Fragment {
    ImageButton checkAttButton, t1Button, t2Button, t3Button;
    TextView testText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View testsPageView = inflater.inflate(R.layout.fragment_student_tests_page, container, false);
        return testsPageView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkAttButton = (ImageButton) getActivity().findViewById(R.id.checkAttShortcutButton);
        t1Button = (ImageButton) getActivity().findViewById(R.id.test1Button);
        t2Button = (ImageButton) getActivity().findViewById(R.id.test2Button);
        t3Button = (ImageButton) getActivity().findViewById(R.id.test3Button);
        testText = (TextView) getActivity().findViewById(R.id.testText);

        checkAttButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((StudentPortal) getActivity()).ToAttendancePage();
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
    }
}
