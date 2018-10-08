package com.example.admin.tablayout2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;

class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolderClass> {
    Context context;
    String[] arr;
    String[] numbers;
    int[] img;
    public RecycleAdapter(Context context, String[] arr, String[] numbers,int[] img) {
        this.context=context;
        this.arr=arr;
        this.numbers=numbers;
        this.img=img;
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_list_view, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolderClass viewHolderClass, final int i) {
        viewHolderClass.name1.setText(arr[i]);
        viewHolderClass.image.setImageResource(img[i]);
        viewHolderClass.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermission()){
                    Intent i2=new Intent(Intent.ACTION_CALL);
                    i2.setData(Uri.parse("tel"+numbers[i]));
                    context.startActivity(i2);
                }
                else {
                    requestPermissions();
                    Toast.makeText(context,"not given",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions((Activity) context,new String[]
                {android.Manifest.permission.CALL_PHONE, android.Manifest.permission.CAMERA},100);
    }

    private boolean checkPermission() {
        int call= ContextCompat.checkSelfPermission(context,CALL_PHONE);
        if (call== PackageManager.PERMISSION_GRANTED) {
            return true;
        }else {
            return false;

        }

    }
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {

            case 100:

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED

                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {



                    Log.e("value", "Permission Granted, Now you can use local drive .");

                } else {

                    Log.e("value", "Permission Denied, You cannot use local drive .");

                }

                break;

        }
    }


    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView  name1;
        ImageView image;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            name1=itemView.findViewById(R.id.txt1);
            image=itemView.findViewById(R.id.image1);
        }
    }
}
