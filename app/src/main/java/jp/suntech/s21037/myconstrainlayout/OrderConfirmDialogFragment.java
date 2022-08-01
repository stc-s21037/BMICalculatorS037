package jp.suntech.s21037.myconstrainlayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.dialog_title);

        builder.setMessage(R.string.dialog_msg);

        builder.setPositiveButton(R.string.dialog_btn_ok,new DialogButtonClickListener());

        AlertDialog dialog = builder.create();

        return dialog;

    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {


        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }


}
