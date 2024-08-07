package com.example.appcompactactivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn;
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOnClick();
            }
        });
        Log.i("my tag", "oncreate");
        Toast.makeText(this, "oncreate", Toast.LENGTH_SHORT).show();
    }
     private void btnOnClick() {
         Intent intent = new Intent(this, MainActivity2.class);
         startActivity(intent);
     }

     @Override
             protected void onRestart(){
        super.onRestart();
        Log.i("my tag","onrestart");
        Toast.makeText( this,"onrestart",Toast.LENGTH_SHORT).show();
     }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("my tag","onpause");
        Toast.makeText(this,"onpause",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("my tag","onstart");
        Toast.makeText(this,"onstart",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("my tag","ondestroy");
        Toast.makeText(this,"ondestroy",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("my tag","onstop");
        Toast.makeText(this,"onstop",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("my tag","onresume");
        Toast.makeText(this,"onresume",Toast.LENGTH_SHORT).show();
    }

}
