package hbg.lightvote;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int greenVotes;
    private int yellowVotes;
    private int redVotes;
    private TextView voteCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearData();
        initializeButtons();
        voteCounter = (TextView)findViewById(R.id.vote_counter);
        updateVoteDisplay();
    }

    private void initializeButtons() {
        FloatingActionButton clearButton = (FloatingActionButton) findViewById(R.id.fab_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearData();
                updateVoteDisplay();
                Toast.makeText(getApplicationContext(), R.string.clear_toast, Toast.LENGTH_SHORT).show();
            }
        });

        final FloatingActionButton resultsButton = (FloatingActionButton) findViewById(R.id.fab_results);
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultsDialog resultsDialog = new ResultsDialog();
                resultsDialog.setResults(greenVotes, yellowVotes, redVotes);
                resultsDialog.show(getFragmentManager(), "results");
            }
        });

        Button greenButton = (Button) findViewById(R.id.green_button);
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greenVotes++;
                updateVoteDisplay();
                Toast.makeText(getApplicationContext(), R.string.vote_toast, Toast.LENGTH_SHORT).show();
            }
        });

        Button yellowButton = (Button) findViewById(R.id.yellow_button);
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yellowVotes++;
                updateVoteDisplay();
                Toast.makeText(getApplicationContext(), R.string.vote_toast, Toast.LENGTH_SHORT).show();
            }
        });

        Button redButton = (Button) findViewById(R.id.red_button);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redVotes++;
                updateVoteDisplay();
                Toast.makeText(getApplicationContext(), R.string.vote_toast, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateVoteDisplay(){
        voteCounter.setText(""+ (greenVotes + yellowVotes + redVotes));
    }

    private void clearData(){
        greenVotes = 0;
        yellowVotes = 0;
        redVotes = 0;
    }
}
