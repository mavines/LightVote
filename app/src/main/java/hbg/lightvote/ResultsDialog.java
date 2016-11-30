package hbg.lightvote;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by MasonVines on 11/29/2016.
 */

public class ResultsDialog extends DialogFragment {
    private int greenVotes;
    private int yellowVotes;
    private int redVotes;

    public void setResults(int greenVotes, int yellowVotes, int redVotes){
        this.greenVotes = greenVotes;
        this.yellowVotes = yellowVotes;
        this.redVotes = redVotes;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.results_title)
                .setItems(buildResults(), null)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }

    private CharSequence[] buildResults(){

        CharSequence[] results = new CharSequence[4];
        results[0] = "Green Votes: " + greenVotes;
        results[1] = "Yellow Votes: " + yellowVotes;
        results[2] = "Red Votes: " + redVotes;
        results[3] = "Score: " + getScore();

        return results;
    }

    private int getScore(){
        int totalVotes = greenVotes + yellowVotes + redVotes;
        if(totalVotes == 0){
            return 0;
        }

        return ((greenVotes * 100) + (yellowVotes * 50))/(greenVotes + yellowVotes + redVotes);
    }
}
