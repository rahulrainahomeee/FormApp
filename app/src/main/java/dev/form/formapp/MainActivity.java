package dev.form.formapp;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtName, txtContact, txtCity, txtComment;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (EditText)findViewById(R.id.et_name);
        txtContact = (EditText)findViewById(R.id.et_contact);
        txtCity = (EditText)findViewById(R.id.et_city);
        txtComment = (EditText)findViewById(R.id.et_comment);
        btnShare = (Button)findViewById(R.id.btn_share);
        btnShare.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch(id)
        {
            case R.id.action_attach:

                //Pick new file using intent.
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivityForResult(intent, 1);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK)
                {
                    String FilePath = data.getData().getPath();
                    Toast.makeText(MainActivity.this, FilePath, Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }


}