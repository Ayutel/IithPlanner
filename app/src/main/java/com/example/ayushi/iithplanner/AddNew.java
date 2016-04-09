package com.example.ayushi.iithplanner;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class AddNew extends AppCompatActivity implements View.OnClickListener
{
    public static final int REQUEST_CAPTURE=1;
    ImageView bImage;
    Spinner s,sDepartment;
    String abc,xyz;
    Button bCapture,bAdd;
    EditText etCourseName, etYear,etName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        etCourseName = (EditText) findViewById(R.id.etCourseName);
        etName= (EditText) findViewById(R.id.etName);
        etYear = (EditText) findViewById(R.id.etYear);
        bImage=(ImageView)findViewById(R.id.bImage);
        bCapture = (Button) findViewById(R.id.bCapture);
        bAdd = (Button) findViewById(R.id.bAdd);
        s=(Spinner)findViewById((R.id.AorTspinner));
        sDepartment=(Spinner)findViewById((R.id.sDepartment));
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                abc= (String) parent.getItemAtPosition(pos);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                abc= (String) parent.getItemAtPosition(0);

            }
        });
        sDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                xyz=(String)parent.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                xyz=(String)parent.getItemAtPosition(0);

            }
        });
        if(!hasCamera())
        {
            System.out.println("YOUR SHIT DONT HAVE CAMERA!!!!!!!");
            bCapture.setEnabled(false);
        }

        assert bCapture != null;
        bCapture.setOnClickListener(this);

        assert bAdd != null;
        bAdd.setOnClickListener(this);
    }
    public boolean hasCamera()
    {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }
    public void launchCamera(View v)
    {
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,REQUEST_CAPTURE);
        System.out.println("LAUNCHING!!!!!!!");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CAPTURE && resultCode==RESULT_OK)
        {
            System.out.println("BITMAP BHI HO RAHA HAI");

            Bundle extras=data.getExtras();
            Bitmap photo=(Bitmap) extras.get("data");
            bImage.setImageBitmap(photo);
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bCapture:

                //launchCamera(v);
                String name=etName.getText().toString();
                String AoT=abc;
                String dept=xyz;
                String year=etYear.getText().toString();
                String courseName=etCourseName.getText().toString();

                System.out.println("Name:"+name);
                System.out.println("AoT:"+AoT);
                System.out.println("dept:"+dept);
                System.out.println("Year:  "+year);
                System.out.println("Course Name: "+courseName);
                break;

            case R.id.bAdd:

               /* String name=etName.getText().toString();
                String AoT=abc;
                String dept=xyz;
                String year=etYear.getText().toString();
                String courseName=etCourseName.getText().toString();

                System.out.println("Name:"+name);
                System.out.println("AoT:"+AoT);
                System.out.println("dept:"+dept);
                System.out.println("Year:  "+year);
                System.out.println("Course Name: "+courseName);*/




                //startActivity(new Intent(this,Login.class));
                break;
        }
    }
}
