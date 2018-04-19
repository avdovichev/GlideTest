package com.example.glidetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.content_view);
        final AppCompatTextView positionView = findViewById(R.id.position_view);

        final GridLayoutManager mLayoutManager = new GridLayoutManager(this, 4);
        final TestAdapter adapter = new TestAdapter(this, new TestAdapter.PositionListener() {
            @Override
            public void onPositionChange(int position) {
                positionView.setText(String.valueOf(position));
            }
        });

        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
