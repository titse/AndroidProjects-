package com.hfad.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }
    //Call onSendMessage when the button is clicked
    public void onSendMessage(View view){
        //get the text that is in Edit Text
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        //Intent intent  = new Intent(this, ReceiveMessageActivity.class);
        //create an intent then add the text to the intent. EXTRA_MESSAGE IS
       // intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);

        //Instead of creating an intent that's explicity for RecievingMessageActivity, we're creating
        // an intent that uses a send action
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        //Start activity Recieve MessageActivity
       // startActivity(intent);

        //get the chooser Title
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle); //DISPLAY chooser dialog
        startActivity(chosenIntent); //start actiivty that user selected
    }
}
