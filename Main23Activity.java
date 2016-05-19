package com.example.sony.customtoast;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.LogRecord;

public class Main23Activity extends AppCompatActivity {
    Button b1, b2,btn3;
    ProgressDialog pbar;
    EditText et;
    private int pbstat = 0;
    private android.os.Handler pbHandler = new Handler();
    private long fsize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);
        b1= (Button)findViewById(R.id.button1);
        b2= (Button)findViewById(R.id.button4);
        btn3=(Button)findViewById(R.id.button2);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        et=(EditText)findViewById(R.id.et1);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             doDownload(et.getText().toString(),"*.*");
                pbar = new ProgressDialog(v.getContext());
                pbar.setCancelable(true);
                pbar.setMessage("Downloading...");
                pbar.setIndeterminate(false);
                pbar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pbar.setProgress(0);
                pbar.setMax(100);
                pbar.setCancelable(true);
                pbar.show();
                pbstat = 0;
                fsize = 0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (pbstat < 100) {
                            pbstat = doOperation();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pbHandler.post(new Runnable() {

                                @Override
                                public void run() {
                                    pbar.setProgress(pbstat);
                                }
                            });
                        }
                        if (pbstat >= 100) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pbar.dismiss();
                        }
                    }
                }).start();
            }
        });
    }



    public int doOperation() {

        while (fsize <= 10000) {
            fsize++;
            if (fsize == 1000) {
                return 10;
            } else if (fsize == 2000) {
                return 20;
            } else if (fsize == 3000) {
                return 30;
            } else if (fsize == 4000) {
                return 40;
            }else if (fsize == 5000) {
                return 50;
            } else if (fsize == 6000) {
                return 60;
            }else if (fsize == 7000) {
                return 70;
            }else if (fsize == 8000) {
                return 80;
            }else if (fsize == 9000) {
                return 90;
            } else {
                return 100;


            }
        }//end of while
        return 100;
    }//end of doOperation

                public void openFolder ()
                {
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                            + "/sdcard/Content2/");
                    intent.setDataAndType(uri, "*/*");
                    //startActivity(Intent.createChooser(intent,"Open folder"));
                    Intent chooser = Intent.createChooser(intent, "Open folder");

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(chooser);
                    }

                }

          /*  public void sendMessage(View view) {
                Intent intent = new Intent(Main23Activity.this, Main22Activity.class);
                startActivity(intent);
            }*/
    public void sendMessage12(View view) {
        Intent intent = new Intent(Main23Activity.this, Main24Activity.class);
        startActivity(intent);
    }


    protected void doDownload(final String urlLink, final String fileName) {
        Thread dx =new  Thread() {

            public void run() {
                File root = android.os.Environment.getExternalStorageDirectory();
                File dir = new File (root.getAbsolutePath() + "/Content2/");
                if(dir.exists()==false) {
                    dir.mkdirs();
                }
                //Save the path as a string value

                try {
                    URL url = new URL(urlLink);
                    Log.i("FILE_NAME", "File name is "+fileName);
                    Log.i("FILE_URLLINK", "File URL is "+url);
                    URLConnection connection = url.openConnection();
                    connection.connect();
                    // this will be useful so that you can show a typical 0-100% progress bar
                    int fileLength = connection.getContentLength();

                    // download the filex
                    InputStream input = new BufferedInputStream(url.openStream(),8192);
                    OutputStream output = new FileOutputStream(dir+"/"+fileName);

                    byte data[] = new byte[1024];
                    long total = 0;
                    int count;
                    while ((count = input.read(data)) != -1) {
                        total += count;
                        Bundle rd=new Bundle();
                        rd.putInt("Progress",(int)(total*100/fileLength));
                        output.write(data, 0, count);
                    }

                    output.flush();
                    output.close();
                    input.close();
                }catch (Exception e) {
                    e.printStackTrace();
                    Log.i("ERROR ON DOWNLOADING", "ERROR IS" +e);
                }
                Bundle rd=new Bundle();
                rd.putInt("Progress",100);


            }
        };
        dx.start();
        }



    }

