package vanoosterum.joram_pset1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(hasFocus){
            // match image visibility with checkbox state upon changing orientation
            GridLayout checkboxes = (GridLayout) findViewById(R.id.layoutCheckboxes);
            int boxcount = checkboxes.getChildCount();

            for (int i = 0; i < boxcount; i++) {
                toggleItem(checkboxes.getChildAt(i));
            }
        }
    }

        public void toggleItem(View view) {
            boolean checked = ((CheckBox) view).isChecked();

            int itemId = getResources().getIdentifier("imageView" + view.getTag(), "id", getPackageName());
            ImageView item = (ImageView) findViewById(itemId);

            if (checked) {
                item.setVisibility(View.VISIBLE);
            }
            else {
                item.setVisibility(View.INVISIBLE);
            }
        }
}
