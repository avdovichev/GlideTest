package com.example.glidetest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
