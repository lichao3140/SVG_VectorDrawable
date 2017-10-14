package com.lqh.lichao.svg_vectordrawable;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void anim(View view) {
        ImageView imageView = (ImageView) view;
        Drawable drawable = imageView.getDrawable();
        ((Animatable)drawable).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            switchToLPlus();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchToLPlus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(new Intent(MainActivity.this, LPlusActivity.class));
        } else {
            Toast.makeText(MainActivity.this, "系统版本不支持L plus", Toast.LENGTH_LONG).show();
        }
    }
}
