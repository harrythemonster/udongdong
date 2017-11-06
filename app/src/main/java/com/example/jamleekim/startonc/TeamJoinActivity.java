package com.example.jamleekim.startonc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class TeamJoinActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText teamName;
    private EditText teamRegion;
    private Switch submitcheck;
    private Button submit;
    private Button cancel;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_join);

        teamName = (EditText) findViewById(R.id.teamName);
        teamRegion = (EditText) findViewById(R.id.teamRegion);
        submitcheck = (Switch) findViewById(R.id.submitcheck);
        submit = (Button) findViewById(R.id.submit);
        cancel = (Button) findViewById(R.id.cancel);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //팀명 입력 확인
                if(teamName.getText().toString().length()==0) {
                    Toast.makeText(TeamJoinActivity.this,"팀명을 입력하세요!", Toast.LENGTH_SHORT).show();
                    teamName.requestFocus();
                    return;
                }

                // 팀 지역 입력 확인

                if(teamRegion.getText().toString().length()==0) {
                    Toast.makeText(TeamJoinActivity.this,"지역을 입력하세요!", Toast.LENGTH_SHORT).show();
                    teamRegion.requestFocus();
                    return;
                }
            }
        });

        Button b1 = (Button) findViewById(R.id.homebutton);
        Button b2 = (Button) findViewById(R.id.teambutton);
        Button b3 = (Button) findViewById(R.id.leaguebutton);
        Button b4 = (Button) findViewById(R.id.lockerbutton);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homebutton:
                Intent i1 = new Intent(this, HomeActivity.class);
                startActivity(i1);
                finish();
                break;
            case R.id.teambutton:
                Intent i2 = new Intent(this, TeamActivity.class);
                startActivity(i2);
                finish();
                break;
            case R.id.leaguebutton:
                Intent i3 = new Intent(this, LeagueActivity.class);
                startActivity(i3);
                finish();
                break;
            case R.id.lockerbutton:
                Intent i4 = new Intent(this, LockerActivity.class);
                startActivity(i4);
                finish();
                break;
        }
    }
    private long lastTimeBackPressed; // 뒤로가기 버튼이 터치된 시간.
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-lastTimeBackPressed < 1000){
            finish();
            return;
        }
        Toast.makeText(this,"'뒤로'버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_LONG).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }

}
